package com.spring.elastic.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.elastic.search.dto.RequestDto;
import com.spring.elastic.search.dto.ResponseDto;
import com.spring.elastic.search.model.Book;
import com.spring.elastic.search.repository.BookRepository;
import com.spring.elastic.search.service.BookActivityService;

@RestController
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookActivityService bookActivityService;
	
	@PostMapping("/saveBook")
	public void saveBook(@RequestBody Book book) {
		bookRepository.save(book);
	}
	
	@GetMapping("/findAllBooks")
	public Iterable<Book> findAllBooks() {
		return bookRepository.findAll();
	}
	
	@GetMapping("/findByBookLanguage/{bookLanguage}")
	public List<Book> findByBookLanguage(@PathVariable String bookLanguage) {
		return bookRepository.findByBookLanguage(bookLanguage);
	}
	
	@PostMapping("/saveOrder")
	public ResponseDto saveBook(@RequestBody RequestDto request) {
		ResponseDto responseDto = null;
		if(request.isJoinBookClub()) {
			return bookActivityService.subscribeToBookClub(request);
		} else if(request.isBorrowBook()) {
			return bookActivityService.borrowFromBookStore(request);
		} else if(request.isBuyBook()) {
			return bookActivityService.buyFromBookShop(request);
		} else {
			responseDto = new ResponseDto();
			responseDto.setMessage("Invalid Category. Order unsuccessful");
			return responseDto;
		}

	}

}
