package com.twu.biblioteca.domain;

import com.twu.biblioteca.menu.Displayable;

public class Book implements Displayable{
    public static final Book NULL_BOOK = new Book(-1, "") {
        @Override
        public boolean isAvailableForCheckout() {
            return false;
        }

        @Override
        public boolean isCheckedOut() {
            return false;
        }
    };
    private int id;
    private String name;
    private boolean isAvailable = true;

    void markAsAvailableForCheckOut(){
        this.isAvailable = true;
    }

    void markAsCheckedOut(){
        this.isAvailable = false;
    }

    public Book(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getDisplayText() {
        return String.format("%s. %s",getId(),getName());
    }

    public boolean isAvailableForCheckout() {
        return this.isAvailable;
    }

    public boolean isCheckedOut() {
        return !this.isAvailable;
    }
}
