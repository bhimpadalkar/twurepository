package com.twu.biblioteca.menu;

import com.twu.biblioteca.BibliotecaApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MenuTest {

    @Mock
    private BibliotecaApp app;

    @Test
    public void shouldGetItemById(){
        Menu menu = Menu.getItemFor(1);
        assertEquals(menu, Menu.LIST_BOOKS);
    }

    @Test
    public void shouldReturnInvalidItemIfIdInvalid(){
        Menu menu = Menu.getItemFor(100);
        assertEquals(menu, Menu.INVALID_MENU);
    }


    @Test
    public void shouldInvokeCorrectActionsOnApp(){
        Menu.LIST_BOOKS.performAction(app);
        verify(app).displayListOfAvailableBooks();

        Menu.CHECKOUT_BOOK.performAction(app);
        verify(app).checkoutBook();

        Menu.RETURN_BOOK.performAction(app);
        verify(app).returnBook();

        Menu.QUIT.performAction(app);
        verify(app).quit();

        Menu.INVALID_MENU.performAction(app);
        verify(app).invalidMenuAction();
    }


    @Test
    public void shouldReturnTextForDisplay(){
        assertEquals("1. List Books", Menu.LIST_BOOKS.getDisplayText());
        assertEquals("2. Checkout Book", Menu.CHECKOUT_BOOK.getDisplayText());
        assertEquals("3. Return Book", Menu.RETURN_BOOK.getDisplayText());
        assertEquals("4. Quit", Menu.QUIT.getDisplayText());
    }
}
