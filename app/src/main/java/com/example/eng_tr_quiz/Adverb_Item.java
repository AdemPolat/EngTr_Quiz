package com.example.eng_tr_quiz;


public class Adverb_Item {

    String name;
    String anlam;
    public Adverb_Item(String name, String anlam){

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

