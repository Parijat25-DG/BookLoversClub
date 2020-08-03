package com.spring.elastic.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.elastic.search.model.Book;
import com.spring.elastic.search.repository.BookRepository;

@RestController
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
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

}
