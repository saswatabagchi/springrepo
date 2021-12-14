package com.learnkafka.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Book {
    public Integer getBookId() {
		return bookId;
	}
	public Book setBookId(Integer bookId) {
		this.bookId = bookId;
		return this;
	}
	public String getBookName() {
		return bookName;
	}
	public Book setBookName(String bookName) {
		this.bookName = bookName;
		return this;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public Book setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
		return this;
	}
	@NotNull
    private Integer bookId;
    @NotBlank
    private String bookName;
    @NotBlank
    private String bookAuthor;
   static  public Book builder() {
        return new Book();
    }
}
