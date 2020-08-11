package com.spring.elastic.search.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.elastic.search.dto.BookDto;
import com.spring.elastic.search.dto.RequestDto;
import com.spring.elastic.search.dto.ResponseDto;
import com.spring.elastic.search.model.Book;
import com.spring.elastic.search.model.BookClub;
import com.spring.elastic.search.model.BookOrder;
import com.spring.elastic.search.model.BookShop;
import com.spring.elastic.search.model.BookStore;
import com.spring.elastic.search.repository.BookClubRepository;
import com.spring.elastic.search.repository.BookOrderRepository;
import com.spring.elastic.search.repository.BookRepository;
import com.spring.elastic.search.repository.BookShopRepository;
import com.spring.elastic.search.repository.BookStoreRepository;

@Service
public class BookActivityService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookClubRepository bookClubRepository;

	@Autowired
	private BookOrderRepository bookOrderRepository;

	@Autowired
	private BookStoreRepository bookStoreRepository;

	@Autowired
	private BookShopRepository bookShopRepository;

	public ResponseDto subscribeToBookClub(RequestDto request) {
		Book book = this.retrieveBookDetails(request.getBooks().get(0).getBookName(),
				request.getBooks().get(0).getBookGenre(), request.getBooks().get(0).getBookLanguage());

		List<BookClub> books = bookClubRepository.findByDateAndTime(request.getRequestedClubDate(),
				request.getRequestedClubTime());
		ResponseDto response = null;
		for (BookClub bookClub : books) {
			if (bookClub.getBookId().equalsIgnoreCase(book.getId()) && bookClub.getSeatsAvailable() > 0
					&& bookClub.getDate().equalsIgnoreCase(request.getRequestedClubDate())
					&& bookClub.getTiming().equalsIgnoreCase(request.getRequestedClubTime())) {

				BookOrder bookOrder = new BookOrder();
				bookOrder.setCategory("BOOK_CLUB");
				bookOrder.setClubBookingId(bookClub.getId());
				bookOrder.setReaderId(request.getReaderId());
				BookOrder savedOrder = bookOrderRepository.save(bookOrder);

				response = new ResponseDto();
				response.setBookingId(savedOrder.getId());
				response.setClubMembershipCost(bookClub.getCost());
				response.setMessage("Subscribed to Book Club successfully");
				break;
			}
		}
		return response;
	}

	public ResponseDto borrowFromBookStore(RequestDto request) {
		Book book = this.retrieveBookDetails(request.getBooks().get(0).getBookName(),
				request.getBooks().get(0).getBookGenre(), request.getBooks().get(0).getBookLanguage());

		List<BookStore> booksInStore = bookStoreRepository.findByBookStatus("Available");
		ResponseDto response = null;
		for (BookStore bookInStore : booksInStore) {
			if (bookInStore.getBookId().equalsIgnoreCase(book.getId())) {

				BookOrder bookOrder = new BookOrder();
				bookOrder.setCategory("BOOK_STORE");
				bookOrder.setStoreBookingId(bookInStore.getId());
				bookOrder.setReaderId(request.getReaderId());
				BookOrder savedOrder = bookOrderRepository.save(bookOrder);

				response = new ResponseDto();
				response.setBookingId(savedOrder.getId());
				response.setLibraryMembershipCost(bookInStore.getJoiningCost());
				response.setMessage("Borrowed from Book Store successfully");
				break;
			}
		}
		return response;
	}

	public ResponseDto buyFromBookShop(RequestDto request) {
		BookOrder bookOrder = new BookOrder();
		List<String> shopBookingIds = new ArrayList<>();
		int bookPrice = 0;
		for (BookDto bookDto : request.getBooks()) {
			Book book = this.retrieveBookDetails(bookDto.getBookName(), bookDto.getBookGenre(), bookDto.getBookLanguage());

			List<BookShop> booksInShop = bookShopRepository.findByRating(request.getExpectedRating());
			for (BookShop bookInShop : booksInShop) {
				if (bookInShop.getCopiesAvailable() > 0 
						&& bookInShop.getBookId().equalsIgnoreCase(book.getId())) {
					shopBookingIds.add(bookInShop.getId());
					bookPrice = bookPrice + book.getPrice();
				}
			}
			
		}
		bookOrder.setCategory("BOOK_SHOP");
		bookOrder.setShopBookingIds(shopBookingIds);
		bookOrder.setReaderId(request.getReaderId());
		BookOrder savedOrder = bookOrderRepository.save(bookOrder);

		ResponseDto response = new ResponseDto();
		response.setBookingId(savedOrder.getId());
		response.setBookOrderCost(bookPrice);
		response.setMessage("Borrowed from Book Store successfully");
		return response;
	}

	private Book retrieveBookDetails(String name, String genre, String language) {
		return bookRepository.findBookByCriterias(name, genre, language);
	}

}
