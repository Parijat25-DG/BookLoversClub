package com.spring.elastic.search.service;

import java.util.List;

import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.spring.elastic.search.model.Book;

@Service
public class QueryDSLService {
	
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	public List<Book> searchMultiField(String genre, String language) {
		QueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("bookGenre", genre))
				.must(QueryBuilders.matchQuery("bookLanguage", language));
		NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder().withQuery(query).build();
		List<Book> books = elasticsearchTemplate.queryForList(nativeSearchQuery, Book.class);
		return books;
	}
	
	public List<Book> getBookSearchData(String input) {
		String search = ".*"+input+".*";
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withFilter(QueryBuilders.regexpQuery("author", search)).build();
		List<Book> books = elasticsearchTemplate.queryForList(searchQuery, Book.class);
		return books;
	}
	
	public List<Book> multiMatchQuery(String text) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.multiMatchQuery(text).field("bookName").field("bookDesc")
				.field("author").type(MultiMatchQueryBuilder.Type.BEST_FIELDS)).build();
		List<Book> books = elasticsearchTemplate.queryForList(searchQuery, Book.class);
		return books;
	}

}
