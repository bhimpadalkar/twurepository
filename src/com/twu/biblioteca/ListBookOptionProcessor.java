package com.twu.biblioteca;

public class ListBookOptionProcessor implements OptionProcessor {

    @Override
    public void doAction(Library library) {
        System.out.println("\nAvailable Books are: ");
        library.printAllBooks();
    }
}
