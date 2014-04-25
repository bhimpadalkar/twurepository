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
        String [] booksList = new String[]{"Angels & Demons", "Digital Fortress", "Da Vinchi Code"};
        List<String[]> moviesList = new ArrayList<String[]>();
        moviesList.add(new String[]{"Frozen","2013","Chris Buck","8"});
        moviesList.add(new String[]{"The Dark Knight","2008","Christopher Nolan","9"});
        sut = new Library(booksList,moviesList);
        
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
        sut.checkoutBookByName("Digital Fortress");
        assertTrue(sut.returnBookByName("Digital Fortress"));
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

    @Test
    public void shouldGetListOfAvailableMovies(){
        sut.checkoutBookByName("a");
        List<Book> expectedBooks = new ArrayList<Book>();
        expectedBooks.add(new Book(2,"b"));
        expectedBooks.add(new Book(3,"c"));
        List<Book> actualBooks = sut.getListOfAvailableBooks();
        assertEquals(expectedBooks, actualBooks);
    }


}
