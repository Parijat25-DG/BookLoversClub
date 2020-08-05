package com.spring.elastic.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.elastic.search.model.Reader;
import com.spring.elastic.search.util.ApiUtil;

@RestController
public class ReaderController {
	
	@Autowired
	private ApiUtil apiUtil;
	
	@PostMapping("/register/reader")
	public Long registerTraveller(@RequestBody Reader reader) {
		return apiUtil.registerReader(reader);
	}
	
	@GetMapping("/retrieve/{email}")
	public Reader retriveTraveller(@PathVariable String email) {
		return apiUtil.retrieveByEmail(email);
	}

}
