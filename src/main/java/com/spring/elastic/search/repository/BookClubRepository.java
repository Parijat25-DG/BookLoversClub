package com.spring.elastic.search.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.spring.elastic.search.model.BookClub;

public interface BookClubRepository extends ElasticsearchRepository<BookClub, String>{

	public List<BookClub> findByDateAndTime(String date,String time);

}
