package com.twu.biblioteca;

public class LibMenuOption {
    private String name;
    private int id;

    public LibMenuOption(String option) {
        this.name = option;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void doAction() {

    }
}
