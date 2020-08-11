package com.spring.elastic.search.dto;

public class ResponseDto {
	
	private String bookingId;
	private int clubMembershipCost;
	private int bookOrderCost;
	private String bookDeliveryDate;
	private int libraryMembershipCost;
	private String bookReturnDate;
	private String message;
	
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public int getClubMembershipCost() {
		return clubMembershipCost;
	}
	public void setClubMembershipCost(int clubMembershipCost) {
		this.clubMembershipCost = clubMembershipCost;
	}
	public int getBookOrderCost() {
		return bookOrderCost;
	}
	public void setBookOrderCost(int bookOrderCost) {
		this.bookOrderCost = bookOrderCost;
	}
	public String getBookDeliveryDate() {
		return bookDeliveryDate;
	}
	public void setBookDeliveryDate(String bookDeliveryDate) {
		this.bookDeliveryDate = bookDeliveryDate;
	}
	public int getLibraryMembershipCost() {
		return libraryMembershipCost;
	}
	public void setLibraryMembershipCost(int libraryMembershipCost) {
		this.libraryMembershipCost = libraryMembershipCost;
	}
	public String getBookReturnDate() {
		return bookReturnDate;
	}
	public void setBookReturnDate(String bookReturnDate) {
		this.bookReturnDate = bookReturnDate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
