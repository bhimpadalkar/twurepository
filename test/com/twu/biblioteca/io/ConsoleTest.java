package com.twu.biblioteca.io;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: bhimsenp
 * Date: 18/04/14
 * Time: 12:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConsoleTest {

    private Console sut;
    private PrintStream outputPrintStream;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setup(){
        outputStream = new ByteArrayOutputStream();
        outputPrintStream = new PrintStream(outputStream);
        sut = new Console(outputPrintStream);
    }

    @Test
    public void shouldPrintAString(){
        sut.println("Test");
        assertEquals("Test\n", new String(outputStream.toByteArray()));
    }

}
