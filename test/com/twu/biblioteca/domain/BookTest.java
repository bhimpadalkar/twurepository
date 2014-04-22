package com.twu.biblioteca.domain;

import org.junit.Test;

import static org.junit.Assert.*;


public class BookTest {
    @Test
    public void shouldReturnBookDetailsForDisplay(){
        Book book = new Book(1,"xyz");
        assertEquals("1. xyz",book.getDisplayText());
    }

    @Test
    public void shouldBeAvailableForCheckoutByDefault(){
        Book book = new Book(1,"xyz");
        assertTrue(book.isAvailableForCheckout());
        assertFalse(book.isCheckedOut());
    }

    @Test
    public void shouldMarkBookAsNotAvailableWhenCheckedOut(){
        Book book = new Book(1,"xyz");
        book.markAsCheckedOut();
        assertFalse(book.isAvailableForCheckout());
        assertTrue(book.isCheckedOut());
    }

    @Test
    public void shouldMarkBookAvailableWhenReturned(){
        Book book = new Book(1,"xyz");
        book.markAsCheckedOut();
        book.markAsAvailableForCheckOut();
        assertTrue(book.isAvailableForCheckout());
        assertFalse(book.isCheckedOut());
    }
}
