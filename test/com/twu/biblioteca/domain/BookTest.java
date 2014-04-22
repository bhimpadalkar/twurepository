package com.twu.biblioteca.domain;

import org.junit.Test;

import static junit.framework.Assert.*;

public class BookTest {
    @Test
    public void shouldReturnBookDetailsForDisplay(){
        Book book = new Book(1,"xyz");
        assertEquals("1. xyz",book.getDisplayText());
    }

    @Test
    public void shouldBeAvailableByDefault(){
        Book book = new Book(1,"xyz");
        assertTrue(book.isAvailable());
    }

    @Test
    public void shouldMarkBookAsNotAvailableWhenCheckedOut(){
        Book book = new Book(1,"xyz");
        book.markAsCheckedOut();
        assertFalse(book.isAvailable());
    }

    @Test
    public void shouldMarkBookAvailableWhenReturned(){
        Book book = new Book(1,"xyz");
        book.markAsCheckedOut();
        book.markAsAvailableForCheckOut();
        assertTrue(book.isAvailable());
    }
}
