package com.yse.dev.book.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.yse.dev.book.entity.Book;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BookReadResponseDTO {

	private Integer bookId;
	private String title;
	private Integer price;
	private LocalDateTime insertDateTime;
	private List<BookLogReadResponseDTO> bookLogs;
	
	public BookReadResponseDTO fromBook(Book book) {
		
		this.bookId = book.getBookId();
		this.title = book.getTitle();
		this.price = book.getPrice();
		this.insertDateTime = book.getInsertDateTime();
		this.bookLogs = book.getBookLogList().stream().map(bookLog -> BookLogReadResponseDTO.BookLogFactory(bookLog)).collect(Collectors.toList());
		
		return this;
	}
	
	public static BookReadResponseDTO BookFactory(Book book) {
		
		BookReadResponseDTO bookReadResponseDTO = new BookReadResponseDTO();
		bookReadResponseDTO.fromBook(book);
		
		return bookReadResponseDTO;
	}
	
}
