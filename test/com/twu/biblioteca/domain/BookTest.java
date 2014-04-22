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


    @Test
    public void shouldNotConsiderIncompatibleTypesForEquality(){
        assertFalse(new Book(1,"").equals(new Object()));
    }


    @Test
    public void shouldReturnTrueForEqualOrSameObjects(){
        Book book1 = new Book(1, "TEST");
        Book book2 = new Book(1, "TEST");
        assertTrue(book1.equals(book2));
        assertTrue(book1.equals(book1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowBooksWithNULLTitle(){
        new Book(1,null);
    }
}
