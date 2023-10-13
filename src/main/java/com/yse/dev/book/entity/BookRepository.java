package com.yse.dev.book.entity;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

	public List<Book> findByTitleContains(String title, Pageable pageable);
}
