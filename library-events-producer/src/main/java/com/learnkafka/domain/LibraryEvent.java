package com.learnkafka.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LibraryEvent {

    public Integer getLibraryEventId() {
		return libraryEventId;
	}
	public LibraryEvent setLibraryEventId(Integer libraryEventId) {
		this.libraryEventId = libraryEventId;
		return this;
	}
	public LibraryEventType getLibraryEventType() {
		return libraryEventType;
	}
	public void setLibraryEventType(LibraryEventType libraryEventType) {
		this.libraryEventType = libraryEventType;
	}
	public Book getBook() {
		return book;
	}
	public LibraryEvent setBook(Book book) {
		
		this.book = book;
		return this;
	}
	private Integer libraryEventId;
    private LibraryEventType libraryEventType;
    @NotNull
    @Valid
    private Book book;
    public static LibraryEvent builder() {
    	return new LibraryEvent();
    }

}
