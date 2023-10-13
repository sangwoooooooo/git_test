package com.yse.dev.book.dto;

import lombok.Getter;

@Getter
public class BookListResponseDTO {
	private Integer bookId;
	private String title;
	
	public BookListResponseDTO(Integer bookId, String title) {
		this.bookId = bookId;
		this.title = title;
	}
}
