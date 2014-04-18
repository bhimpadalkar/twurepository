package com.twu.biblioteca;

public class Book {
    private int id;
    private String name;

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
}
