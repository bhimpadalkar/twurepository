package com.twu.biblioteca;

import com.twu.biblioteca.io.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;


/**
 * Created with IntelliJ IDEA.
 * User: bhimsenp
 * Date: 18/04/14
 * Time: 12:23 PM
 * To change this template use File | Settings | File Templates.
 */

@RunWith(MockitoJUnitRunner.class)
public class BibliotecaAppTest {

    @Mock
    private Console console;

    private BibliotecaApp sut;

    @Before
    public void setup(){
        sut = new BibliotecaApp(console);
    }

    @Test
    public void shouldDisplayWelcomeMsgOnStart(){
        sut = new BibliotecaApp(console);
        sut.start();

        verify(console).println("Welcome to Biblioteca !");


    }
}
