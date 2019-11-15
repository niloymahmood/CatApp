package com.example.catapp;

public class Favourites {
    private String name;

    public Favourites(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //returns cat name in String and creates spaces between each cat name when cats are added to favs
    @Override
    public String toString() {
        return  name + "\n" + "\n";
    }


}
