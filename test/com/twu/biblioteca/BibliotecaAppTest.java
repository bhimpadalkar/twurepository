package com.twu.biblioteca;

import com.twu.biblioteca.domain.Library;
import com.twu.biblioteca.io.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BibliotecaAppTest {

    @Mock
    private Console console;

    @Mock
    private Library library;

    private BibliotecaApp sut;

    @Before
    public void setup(){
        sut = new BibliotecaApp(console);
    }

    @Test
    public void shouldDisplayWelcomeMsgOnStart(){
        sut.start();

        verify(console).println("Welcome to Biblioteca !");

    }

    @Test
    public void shouldDisplayListOfAvailableBooks(){
        sut.displayListOfAvailableBooks();
        verify(console).println("Available books are : ");
    }

    @Test
    public void shouldAskToChooseValidOption(){
        sut.invalidMenuAction();
        verify(console).println("Choose Valid Option");
    }
}
