package com.yse.dev.book.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.yse.dev.book.entity.Book;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class BookEditDTO {

	@NonNull
	@Positive
	private Integer bookId;
	
	@NonNull
	@NotBlank
	private String title;
	
	@NonNull
	@Min(1000)
	private Integer price;
	
	public Book fill(Book book) {
		book.setTitle(this.title);
		book.setPrice(this.price);
		
		return book;
	}
}
