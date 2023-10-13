package com.yse.dev.book.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookLogId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id")
	private Book book;
	
	@Column(columnDefinition = "TEXT")
	private String comment;
	
	private Integer page;
	
	@CreationTimestamp
	private LocalDateTime insertDateTime;
	
}
