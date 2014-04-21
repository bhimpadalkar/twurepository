package com.twu.biblioteca.domain;

import org.junit.Before;
import org.junit.Test;

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
    public void shouldCheckOutBookIfAvailable(){
        assertTrue(sut.checkoutBookByName("c"));
    }

    @Test
    public void shouldNotCheckOutBookIfNotAvailable(){
        assertFalse(sut.checkoutBookByName("d"));
    }

    @Test
    public void shouldReturnBookIfValid(){
        sut.checkoutBookByName("c");
        assertTrue(sut.returnBookByName("c"));
    }

    @Test
    public void shouldNotReturnBookIfNotValid(){
        assertFalse(sut.returnBookByName("c"));
    }
}
