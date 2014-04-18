package com.twu.biblioteca;

public class LibMenuOption {
    private String name;
    private int id;

    public LibMenuOption(String option, int id) {
        this.name = option;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return id;
    }

    public void doAction() {

    }
}
