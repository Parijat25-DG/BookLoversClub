package com.spring.elastic.search.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.spring.elastic.search.model.BookShop;

public interface BookShopRepository extends ElasticsearchRepository<BookShop, String>{

	public List<BookShop> findByRating(int rating);

}
