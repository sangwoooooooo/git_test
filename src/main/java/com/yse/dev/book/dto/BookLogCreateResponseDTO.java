package com.yse.dev.book.dto;

import com.yse.dev.book.entity.BookLog;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BookLogCreateResponseDTO {
	private Integer bookLogId;
	private Integer bookId;
	private String comment;
	private Integer page;
	
	public BookLogCreateResponseDTO fromBookLog(BookLog bookLog) {
		this.bookLogId = bookLog.getBookLogId();
		this.bookId = bookLog.getBook().getBookId();
		this.comment = bookLog.getComment();
		this.page = bookLog.getPage();
		
		return this;
	}

	public static BookLogCreateResponseDTO BookLogFactory(BookLog bookLog) {
		BookLogCreateResponseDTO bookLogCreateResponseDTO = new BookLogCreateResponseDTO();
		bookLogCreateResponseDTO.fromBookLog(bookLog);
		
		return bookLogCreateResponseDTO;
	}
}
