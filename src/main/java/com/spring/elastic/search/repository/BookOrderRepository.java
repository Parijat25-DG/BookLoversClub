package com.spring.elastic.search.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.spring.elastic.search.model.BookOrder;

public interface BookOrderRepository extends ElasticsearchRepository<BookOrder, String>{

}
