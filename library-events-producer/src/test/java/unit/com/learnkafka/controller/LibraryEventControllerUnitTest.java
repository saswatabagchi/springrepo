package com.learnkafka.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnkafka.domain.Book;
import com.learnkafka.domain.LibraryEvent;
import com.learnkafka.producer.LibraryEventProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LibraryEventsController.class)
@AutoConfigureMockMvc
public class LibraryEventControllerUnitTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @MockBean
    LibraryEventProducer libraryEventProducer;

    @Test
    void postLibraryEvent() throws Exception {
        //given
        Book book = Book.builder().setBookId(1).setBookAuthor("saswata").setBookName("kamasutra");
               



        LibraryEvent libraryEvent = LibraryEvent.builder()
                .setLibraryEventId(null)
                .setBook(book);


        String json = objectMapper.writeValueAsString(libraryEvent);
        when(libraryEventProducer.sendLibraryEvent_Approach2(isA(LibraryEvent.class))).thenReturn(null);

        //expect
        mockMvc.perform(post("/v1/libraryevent")
        .content(json)
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

    @Test
    void postLibraryEvent_4xx() throws Exception {
        //given

    	Book book = Book.builder().setBookId(0).setBookAuthor("saswata").setBookName("kamasutra");

    	LibraryEvent libraryEvent = LibraryEvent.builder()
                .setLibraryEventId(null)
                .setBook(book);

        String json = objectMapper.writeValueAsString(libraryEvent);
        when(libraryEventProducer.sendLibraryEvent_Approach2(isA(LibraryEvent.class))).thenReturn(null);
        //expect
        String expectedErrorMessage = "book.bookAuthor - must not be blank, book.bookId - must not be null";
        mockMvc.perform(post("/v1/libraryevent")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
        .andExpect(content().string(expectedErrorMessage));

    }

    @Test
    void updateLibraryEvent() throws Exception {

        //given
    	Book book = Book.builder().setBookId(1).setBookAuthor("saswata").setBookName("kamasutra");

        LibraryEvent libraryEvent = LibraryEvent.builder()
                .setLibraryEventId(null)
                .setBook(book);
        String json = objectMapper.writeValueAsString(libraryEvent);
        when(libraryEventProducer.sendLibraryEvent_Approach2(isA(LibraryEvent.class))).thenReturn(null);

        //expect
        mockMvc.perform(
                put("/v1/libraryevent")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void updateLibraryEvent_withNullLibraryEventId() throws Exception {

        //given
    	Book book = Book.builder().setBookId(null).setBookAuthor("saswata").setBookName("kamasutra");
        LibraryEvent libraryEvent = LibraryEvent.builder()
                .setLibraryEventId(null)
                .setBook(book);

        String json = objectMapper.writeValueAsString(libraryEvent);
        when(libraryEventProducer.sendLibraryEvent_Approach2(isA(LibraryEvent.class))).thenReturn(null);

        //expect
        mockMvc.perform(
                put("/v1/libraryevent")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
        .andExpect(content().string("Please pass the LibraryEventId"));

    }
}
