package com.twu.biblioteca;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Library;
import com.twu.biblioteca.io.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.same;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BibliotecaAppTest {

    @Mock
    private Console console;

    @Mock
    private Library library;

    private BibliotecaApp sut;

    @Before
    public void setup(){
        sut = new BibliotecaApp(console,library);
    }

    @Test
    public void shouldDisplayWelcomeMsgOnStart(){
        sut.start();

        verify(console).println("Welcome to Biblioteca !");

    }

    @Test
    public void shouldDisplayListOfAvailableBooks(){
        List<Book> bookList = new ArrayList<Book>();
        Book book1 = new Book(1, "a");
        bookList.add(book1);
        Book book2 = new Book(2, "b");
        bookList.add(book2);
        when(library.getListOfAvailableBooks()).thenReturn(bookList);
        sut.displayListOfAvailableBooks();

        InOrder order = inOrder(console);

        order.verify(console).println("Available books are : ");
        order.verify(console).println(same(book1));
        order.verify(console).println(same(book2));

    }

    @Test
    public void shouldAllowUserToExitFromCheckoutOption(){
        when(console.readLine()).thenReturn("");
        sut.checkoutBook();
        verify(console).println("Which book you want to checkout?");
        verify(library,never()).checkoutBookByName(anyString());
    }

    @Test
    public void shouldCheckoutBookAndReturnSuccessMessageIfSuccessful(){
        when(console.readLine()).thenReturn("a");
        when(library.checkoutBookByName("a")).thenReturn(true);
        sut.checkoutBook();
        verify(console).println("Which book you want to checkout?");
        verify(library).checkoutBookByName("a");
        verify(console).println("Thank you!! Enjoy the book.");
    }

    @Test
    public void shouldNotCheckoutBookAndReturnFailureMessageIfFailed(){
        when(console.readLine()).thenReturn("c");
        when(library.checkoutBookByName("c")).thenReturn(false);
        sut.checkoutBook();
        verify(console).println("Which book you want to checkout?");
        verify(library).checkoutBookByName("c");
        verify(console).println("That book is not available.");
    }

}
