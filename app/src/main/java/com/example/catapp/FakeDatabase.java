package com.example.catapp;

import java.util.HashMap;
import java.util.List;

public class FakeDatabase {

    public static HashMap <String, Cat> cats = new HashMap<>();

    public static Cat getCatByID(String catID) {
        return cats.get(catID);
    }

    public static List<Cat>  getAllCats(){
        return (List) cats.values();
    }


    public static void saveCatsToFakeDatabase(List <Cat> catsToSave){
        for(int i = 0; i < catsToSave.size(); i++){
            Cat cat = catsToSave.get(i);
            cats.put(cat.getId(), cat);
        }
    }
}
