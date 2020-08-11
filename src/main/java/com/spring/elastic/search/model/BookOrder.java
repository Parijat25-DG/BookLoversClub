package com.spring.elastic.search.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="library",type="bookOrder",shards=2)
public class BookOrder {

	@Id
	private String id;
	private String category;
	private String clubBookingId;
	private String storeBookingId;
	private List<String> shopBookingIds;
	private long readerId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getClubBookingId() {
		return clubBookingId;
	}
	public void setClubBookingId(String clubBookingId) {
		this.clubBookingId = clubBookingId;
	}
	public String getStoreBookingId() {
		return storeBookingId;
	}
	public void setStoreBookingId(String storeBookingId) {
		this.storeBookingId = storeBookingId;
	}
	public List<String> getShopBookingIds() {
		return shopBookingIds;
	}
	public void setShopBookingIds(List<String> shopBookingIds) {
		this.shopBookingIds = shopBookingIds;
	}
	public long getReaderId() {
		return readerId;
	}
	public void setReaderId(long readerId) {
		this.readerId = readerId;
	}
}
