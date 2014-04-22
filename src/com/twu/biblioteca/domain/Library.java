package com.twu.biblioteca.domain;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> booksList = new ArrayList<Book>();

    public Library(String[] booksList) {
        int i=1;
        for (String bookTitle : booksList) {
            this.booksList.add(new Book(i++,bookTitle));
        }
    }

    public List<Book> getListOfAvailableBooks() {
        List<Book> availableBooks = new ArrayList<Book>();
        for(Book book : this.booksList){
            if(book.isAvailableForCheckout()) availableBooks.add(book);
        }
        return availableBooks;
    }

    public boolean checkoutBookByName(String bookToBeCheckedOut) {
        Book book = getBookByName(bookToBeCheckedOut);
        if(book.isAvailableForCheckout()){
            book.markAsCheckedOut();
            return true;
        }
        else
            return false;
    }

    public boolean returnBookByName(String bookToBeReturned) {
        Book book = getBookByName(bookToBeReturned);
        if(book.isCheckedOut()){
            book.markAsAvailableForCheckOut();
            return true;
        }
        else
            return false;
    }

    private Book getBookByName(String titleOfBookToBeCheckedOut) {
        for (Book book : booksList) {
            if(titleOfBookToBeCheckedOut.equals(book.getName()))
                return book;
        }
        return Book.NULL_BOOK;
    }
}