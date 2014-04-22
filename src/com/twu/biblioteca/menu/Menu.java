package com.twu.biblioteca.menu;

import com.twu.biblioteca.BibliotecaApp;

public enum Menu implements Displayable{
    LIST_BOOKS(1,"List Books", new MenuAction() {
        @Override
        public void performAction(BibliotecaApp app) {
              app.displayListOfAvailableBooks();
        }
    }),
    CHECKOUT_BOOK(2,"Checkout Book", new MenuAction(){

        @Override
        public void performAction(BibliotecaApp app) {
            app.checkoutBook();
        }
    }),
    RETURN_BOOK(3,"Return Book", new MenuAction(){

        @Override
        public void performAction(BibliotecaApp app) {
            app.returnBook();
        }
    }),
    QUIT(4,"Quit", new MenuAction(){

        @Override
        public void performAction(BibliotecaApp app) {
            app.quit();
        }
    }),
    INVALID_MENU(-1,"", new MenuAction() {
        @Override
        public void performAction(BibliotecaApp app) {
            app.invalidMenuAction();
        }
    });
    private int id;
    private String title;
    public MenuAction action;

    Menu(int id, String title, MenuAction action) {
        this.id = id;
        this.title = title;
        this.action = action;
    }

    @Override
    public String getDisplayText() {
        if(id>0)return String.format("%s. %s", this.id, this.title);
        return "";
    }

    public static Menu getItemFor(int userInput) {
        for (Menu menu : Menu.values()) {
            if(menu.id == userInput) return menu;
        }
        return Menu.INVALID_MENU;
    }
}
