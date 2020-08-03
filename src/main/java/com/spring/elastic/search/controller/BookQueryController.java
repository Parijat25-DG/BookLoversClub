package com.spring.elastic.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.elastic.search.model.Book;
import com.spring.elastic.search.service.QueryDSLService;

@RestController
public class BookQueryController {
	
	@Autowired
	private QueryDSLService service;
	
	@GetMapping("/searchByMultiField/{bookGenre}/{bookLanguage}")
	public List<Book> searchByMultiField(@PathVariable String bookGenre, @PathVariable String bookLanguage) {
		return service.searchMultiField(bookGenre, bookLanguage);
	}
	
	@GetMapping("/customSearchByAuthor/{author}")
	public List<Book> customSearchByField(@PathVariable String author) {
		return service.getBookSearchData(author);
	}
	
	@GetMapping("/doMultiMatchSearch/{text}")
	public List<Book> doMultiMatchSearch(@PathVariable String text) {
		return service.multiMatchQuery(text);
	}
	
}
