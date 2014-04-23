package com.twu.biblioteca.menu;

import com.twu.biblioteca.BibliotecaApp;

public enum Menu implements Displayable{
    LIST_BOOKS(1,"List Books", new MenuAction() {
        @Override
        public void performAction(BibliotecaApp app) {
              app.displayListOfAvailableBooks();
        }
    }),
    LIST_MOVIES(2,"List Movies", new MenuAction() {
        @Override
        public void performAction(BibliotecaApp app) {
            app.displayListOfAvailableMovies();
        }
    }),
    CHECKOUT_BOOK(3,"Checkout Book", new MenuAction(){

        @Override
        public void performAction(BibliotecaApp app) {
            app.checkoutBook();
        }
    }),
    CHECKOUT_MOVIE(4,"Checkout Movie", new MenuAction(){

        @Override
        public void performAction(BibliotecaApp app) {
            app.checkoutMovie();
        }
    }),
    RETURN_BOOK(5,"Return Book", new MenuAction(){

        @Override
        public void performAction(BibliotecaApp app) {
            app.returnBook();
        }
    }),
    RETURN_MOVIE(6,"Return Movie", new MenuAction(){

        @Override
        public void performAction(BibliotecaApp app) {
            app.returnMovie();
        }
    }),
    QUIT(7,"Quit", new MenuAction(){

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

    private Integer id;
    private String title;
    private MenuAction action;

    Menu(Integer id, String title, MenuAction action) {
        this.id = id;
        this.title = title;
        this.action = action;
    }

    @Override
    public String getDisplayText() {
        if(id>0)return String.format("%s. %s", this.id, this.title);
        return "";
    }

    public static Menu getItemFor(Integer userInput) {
        for (Menu menu : Menu.values()) {
            if(menu.id == userInput) return menu;
        }
        return Menu.INVALID_MENU;
    }

    public void performAction(BibliotecaApp app) {
        this.action.performAction(app);
    }
}
