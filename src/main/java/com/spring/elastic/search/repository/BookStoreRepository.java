package com.spring.elastic.search.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.spring.elastic.search.model.BookStore;

public interface BookStoreRepository extends ElasticsearchRepository<BookStore, String>{

	public List<BookStore> findByBookStatus(String bookStatus);

}
