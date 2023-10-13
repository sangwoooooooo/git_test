package com.yse.dev.book.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;
	
	@Column(length = 200)
	private String title;
	
	private Integer price;
	
	@CreationTimestamp
	private LocalDateTime insertDateTime;
	
	@OneToMany(mappedBy="book", fetch=FetchType.LAZY)  
	@Builder.Default  
	private List<BookLog> bookLogList = new ArrayList();
}
