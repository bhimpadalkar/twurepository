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
    public void shouldDisplayListOfAvailableBooksOnDisplayBooksListCommand(){
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
    public void shouldAllowUserToExitFromCheckoutBookCommand(){
        when(console.readLine()).thenReturn("");
        sut.checkoutBook();
        verify(console).println("Which book you want to checkout?");
        verify(library,never()).checkoutBookByName(anyString());
    }

    @Test
    public void shouldCheckoutBookAndReturnSuccessMessageIfSuccessfulOnCheckoutCommand(){
        when(console.readLine()).thenReturn("a");
        when(library.checkoutBookByName("a")).thenReturn(true);
        sut.checkoutBook();
        verify(console).println("Which book you want to checkout?");
        verify(library).checkoutBookByName("a");
        verify(console).println("Thank you!! Enjoy the book.");
    }

    @Test
    public void shouldNotCheckoutBookAndReturnFailureMessageIfFailedOnCheckoutCommand(){
        when(console.readLine()).thenReturn("c");
        when(library.checkoutBookByName("c")).thenReturn(false);
        sut.checkoutBook();
        verify(console).println("Which book you want to checkout?");
        verify(library).checkoutBookByName("c");
        verify(console).println("That book is not available.");
    }

    @Test
    public void shouldAllowUserToExitFromCheckoutMovieCommand(){
        when(console.readLine()).thenReturn("");
        sut.checkoutMovie();
        verify(console).println("Which movie you want to checkout?");
        verify(console).readLine();
        verify(library,never()).checkoutMovieByName(anyString());
    }

    @Test
    public void shouldCheckoutMovieAndReturnSuccessMessageWhenSuccessfulOnCheckoutCommand(){
        when(console.readLine()).thenReturn("a");
        when(library.checkoutMovieByName("a")).thenReturn(true);
        sut.checkoutMovie();
        verify(console).println("Which movie you want to checkout?");
        verify(library).checkoutMovieByName("a");
        verify(console).println("Thank you!! Enjoy the movie.");
    }

    @Test
    public void shouldNotCheckoutMovieAndReturnFailureMessageWhenFailedOnCheckoutCommand(){
        when(console.readLine()).thenReturn("d");
        when(library.checkoutMovieByName("d")).thenReturn(false);
        sut.checkoutMovie();
        verify(console).println("Which movie you want to checkout?");
        verify(library).checkoutMovieByName("d");
        verify(console).println("That movie is not available");
    }

    @Test
    public void shouldAllowToExitFromReturnBookCommand(){
        when(console.readLine()).thenReturn("");
        sut.returnBook();
        verify(console).println("Which book you want to return?");
        verify(library,never()).returnBookByName(anyString());
    }

    @Test
    public void shouldReturnBookAndDisplaySuccessMessageOnSuccessfulReturn(){
        when(console.readLine()).thenReturn("a");
        when(library.returnBookByName("a")).thenReturn(true);
        sut.returnBook();
        verify(console).println("Which book you want to return?");
        verify(library).returnBookByName("a");
        verify(console).println("Thank you for returning the book");
    }

    @Test
    public void shouldNotReturnBookAndDisplayFailureMessageWhenFailedOnReturnMenu(){
        when(console.readLine()).thenReturn("a");
        when(library.returnBookByName("a")).thenReturn(false);
        sut.returnBook();
        verify(console).println("Which book you want to return?");
        verify(library).returnBookByName("a");
        verify(console).println("That is not a valid book to return");
    }

    @Test
    public void shouldAllowToExitFromReturnMovieCommand(){
        when(console.readLine()).thenReturn("");
        sut.returnMovie();
        verify(console).println("Which movie you want to return?");
        verify(library,never()).returnMovieByName(anyString());
    }

    @Test
    public void shouldReturnMovieAndDisplaySuccessMessageIfSuccessfulOnReturnMenu(){
        when(console.readLine()).thenReturn("a");
        when(library.returnMovieByName("a")).thenReturn(true);
        sut.returnMovie();
        verify(console).println("Which movie you want to return?");
        verify(library).returnMovieByName("a");
        verify(console).println("Thank you for returning the movie");
    }

    @Test
    public void shouldNotReturnMovieAndDisplayFailureMessageIfFailedOnReturnMenu(){
        when(console.readLine()).thenReturn("a");
        when(library.returnMovieByName("a")).thenReturn(false);
        sut.returnMovie();
        verify(console).println("Which movie you want to return?");
        verify(library).returnMovieByName("a");
        verify(console).println("That is not a valid movie to return");
    }

    @Test
    public void shouldAskToChooseValidOptionOnChoiceOfInvalidOption(){
        sut.invalidMenuAction();
        verify(console).println("Choose Valid Option");
    }


}
