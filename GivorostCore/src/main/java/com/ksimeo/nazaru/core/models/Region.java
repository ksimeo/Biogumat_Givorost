package com.ksimeo.nazaru.core.models;

/**
 * @author Ksimeo on 14.02.2015.
 * @version 2.5
 */
public class Region {

    private int id;

    private String name;

    public Region(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
