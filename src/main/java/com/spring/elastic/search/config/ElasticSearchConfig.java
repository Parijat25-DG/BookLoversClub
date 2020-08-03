package com.spring.elastic.search.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.spring.elastic.search.repository")
public class ElasticSearchConfig {

}
