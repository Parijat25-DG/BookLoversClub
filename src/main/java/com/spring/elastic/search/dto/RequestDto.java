package com.spring.elastic.search.dto;

import java.util.List;

public class RequestDto {
	
	private long readerId;
	private List<BookDto> books;
	private boolean joinBookClub;
	private boolean borrowBook;
	private boolean buyBook;
	private int expectedRating;
	private String requestedClubDate;
	private String requestedClubTime;
	
	public long getReaderId() {
		return readerId;
	}
	public void setReaderId(long readerId) {
		this.readerId = readerId;
	}
	public boolean isJoinBookClub() {
		return joinBookClub;
	}
	public void setJoinBookClub(boolean joinBookClub) {
		this.joinBookClub = joinBookClub;
	}
	public boolean isBorrowBook() {
		return borrowBook;
	}
	public void setBorrowBook(boolean borrowBook) {
		this.borrowBook = borrowBook;
	}
	public boolean isBuyBook() {
		return buyBook;
	}
	public void setBuyBook(boolean buyBook) {
		this.buyBook = buyBook;
	}
	public int getExpectedRating() {
		return expectedRating;
	}
	public void setExpectedRating(int expectedRating) {
		this.expectedRating = expectedRating;
	}
	public String getRequestedClubDate() {
		return requestedClubDate;
	}
	public void setRequestedClubDate(String requestedClubDate) {
		this.requestedClubDate = requestedClubDate;
	}
	public String getRequestedClubTime() {
		return requestedClubTime;
	}
	public void setRequestedClubTime(String requestedClubTime) {
		this.requestedClubTime = requestedClubTime;
	}
	public List<BookDto> getBooks() {
		return books;
	}
	public void setBooks(List<BookDto> books) {
		this.books = books;
	}
	

}
