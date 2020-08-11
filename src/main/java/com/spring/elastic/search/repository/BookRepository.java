package com.spring.elastic.search.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.spring.elastic.search.model.Book;

public interface BookRepository extends ElasticsearchRepository<Book, String>{

	public List<Book> findByBookLanguage(String bookLanguage);
	
	public Book findBookByCriterias(String name,String genre,String bookLanguage);

}
