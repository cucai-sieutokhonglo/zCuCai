package com.example.zcucai.adapter_view_day6;

public class MySong {
    private int resourceID;
    private String name, author;

    public MySong(int id, String name, String author) {
        this.resourceID = id;
        this.name = name;
        this.author = author;

    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
