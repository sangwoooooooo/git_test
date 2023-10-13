package com.yse.dev.book.service;

import org.springframework.stereotype.Service;

import com.yse.dev.book.dto.BookLogCreateDTO;
import com.yse.dev.book.dto.BookLogCreateResponseDTO;
import com.yse.dev.book.entity.Book;
import com.yse.dev.book.entity.BookLog;
import com.yse.dev.book.entity.BookLogRepository;
import com.yse.dev.book.entity.BookRepository;

@Service
public class BookLogService {
	private BookRepository bookRepository;
	private BookLogRepository bookLogRepository;
	
	public BookLogService(BookRepository bookRepository, BookLogRepository bookLogRepository) {
		this.bookRepository = bookRepository;
		this.bookLogRepository = bookLogRepository;
	}
	
	public BookLogCreateResponseDTO insert(BookLogCreateDTO bookLogCreateDTO) {
		Book book = this.bookRepository.findById(bookLogCreateDTO.getBookId()).orElseThrow();
		
		BookLog bookLog = BookLog.builder().book(book).comment(bookLogCreateDTO.getComment()).page(bookLogCreateDTO.getPage()).build();
		
		bookLog = this.bookLogRepository.save(bookLog);
		
		return BookLogCreateResponseDTO.BookLogFactory(bookLog);
	}
}
