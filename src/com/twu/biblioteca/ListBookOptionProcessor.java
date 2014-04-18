package com.twu.biblioteca;

public class ListBookOptionProcessor implements OptionProcessor {

    @Override
    public void doAction(Library library) {
        for(Book book : library.books){
            System.out.println(book.getName());
        }
    }
}
