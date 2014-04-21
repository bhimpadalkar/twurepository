package com.twu.biblioteca.domain;

import com.twu.biblioteca.menu.Displayable;

public class Book implements Displayable{
    public static final Book NULL_BOOK = new Book(-1, "") {
        @Override
        public boolean isAvailable() {
            return false;
        }
    };
    private int id;
    private String name;
    private boolean isAvailable = true;

    public void makeAvailable(){
        this.isAvailable = true;
    }

    public void makeNonAvailable(){
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

    public boolean isAvailable() {
        return this.isAvailable;
    }
}
