package com.twu.biblioteca.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class LibraryTest {

    private Library sut;

    @Before
    public void setup(){
        sut = new Library(new String[] {"a","b","c"});
        
    }
    
    @Test
    public void shouldCheckOutBookIfAvailableAndNotCheckedOut(){
        assertTrue(sut.checkoutBookByName("c"));
    }

    @Test
    public void shouldNotCheckOutBookIfNotAvailable(){
        assertFalse(sut.checkoutBookByName("d"));
    }

    @Test
    public void shouldNotCheckOutBookIfAlreadyCheckedOut(){
        sut.checkoutBookByName("c");
        assertFalse(sut.checkoutBookByName("c"));
    }

    @Test
    public void shouldReturnBookIfCheckedOut(){
        sut.checkoutBookByName("c");
        assertTrue(sut.returnBookByName("c"));
    }

    @Test
    public void shouldNotReturnBookIfNotCheckedOut(){
        assertFalse(sut.returnBookByName("c"));
    }

    @Test
    public void shouldNotReturnBookIfInvalid(){
        assertFalse(sut.returnBookByName("d"));
    }

    @Test
    public void shouldGetListOfAvailableBooks(){
        sut.checkoutBookByName("a");
        List<Book> expectedBooks = new ArrayList<Book>();
        expectedBooks.add(new Book(2,"b"));
        expectedBooks.add(new Book(3,"c"));
        List<Book> actualBooks = sut.getListOfAvailableBooks();
        assertEquals(expectedBooks, actualBooks);
    }


}
