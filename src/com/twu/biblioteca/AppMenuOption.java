package com.twu.biblioteca;

public class AppMenuOption {
    private String name;
    private int id;

    public AppMenuOption(String option, int id) {
        this.name = option;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return id;
    }
}
