package com.twu.biblioteca;

import com.twu.biblioteca.io.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;


/**
 * Created with IntelliJ IDEA.
 * User: bhimsenp
 * Date: 18/04/14
 * Time: 12:23 PM
 * To change this template use File | Settings | File Templates.
 */

public class BibliotecaAppIntgTest {

    private Console console;

    private BibliotecaApp sut;
    private PrintStream outputPrintStream;
    private ByteArrayOutputStream outputStream;


    @Before
    public void setup(){
        outputStream = new ByteArrayOutputStream();
        outputPrintStream = new PrintStream(outputStream);

        console = new Console(outputPrintStream);
        sut = new BibliotecaApp(console);
    }

    @Test
    public void shouldDisplayWelcomeMsgOnStart(){
        sut = new BibliotecaApp(console);
        sut.start();

        assertEquals("Welcome to Biblioteca !\n", new String(outputStream.toByteArray()));


    }
}
