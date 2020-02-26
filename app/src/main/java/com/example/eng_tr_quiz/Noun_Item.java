package com.example.eng_tr_quiz;


public class Noun_Item {

    String name;
    String anlam;
    public Noun_Item(String name, String anlam){

        this.name = name;
        this.anlam=anlam;
    }

    public  String getName(){
        return name;
    }

    public String getAnlam(){
        return anlam;
    }
}

