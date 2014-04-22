package com.twu.biblioteca.io;

import com.twu.biblioteca.menu.Displayable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class ConsoleTest {

    @Mock
    private PrintStream outputStream;

    @Mock
    private BufferedReader inputReader;
    private Console console;

    @Before
    public void init(){
        console = new Console(outputStream, inputReader);
    }

    @Test
    public void shouldPrintDisplayableItem(){
        Displayable displayableItem = mock(Displayable.class);

        when(displayableItem.getDisplayText()).thenReturn("TEST");

        console.println(displayableItem);
        verify(displayableItem).getDisplayText();
        verify(outputStream).println("TEST");
    }


    @Test
    public void shouldReturnInputLine() throws IOException {
        when(inputReader.readLine()).thenReturn("TEST");
        assertEquals("TEST", console.readLine());
        verify(inputReader).readLine();
    }

    @Test
    public void shouldReturnNullInCaseOfIOException() throws IOException {
        when(inputReader.readLine()).thenThrow(new IOException("IO ERROR"));
        assertNull(console.readLine());
        verify(inputReader).readLine();
    }

    @Test
    public void shouldReturnIntegerOnValidIntInput() throws IOException {
        when(inputReader.readLine()).thenReturn("5");
        assertEquals(Integer.valueOf(5), console.readInt());
        verify(inputReader).readLine();
    }

    @Test
    public void shouldReturnNullOnInvalidIntInput() throws IOException {
        when(inputReader.readLine()).thenReturn("xyz");
        assertNull(console.readInt());
        verify(inputReader).readLine();
    }

    @Test
    public void shouldReturnNullOnIOException() throws IOException {
        when(inputReader.readLine()).thenThrow(new IOException("IO ERROR"));
        assertNull(console.readInt());
        verify(inputReader).readLine();
    }

}
