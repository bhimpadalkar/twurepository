package com.twu.biblioteca.menu;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MenuTest {


    @Test
    public void shouldGetItemById(){
        Menu menu = Menu.getItemFor(1);
        assertEquals(menu, Menu.LIST_BOOKS);
    }
}
