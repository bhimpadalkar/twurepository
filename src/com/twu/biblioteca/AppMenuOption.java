package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class AppMenuOption {
    private String name;
    private int id;
    List<AppMenuOption> options = new ArrayList<AppMenuOption>();

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
