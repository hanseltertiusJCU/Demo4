package com.example.hansel.demo4;

import java.util.ArrayList;

/**
 * Created by Hansel on 13/4/2017.
 */


public class Idea {
    private String item;
    private String desc;

    Idea(String itemName, String itemDesc){
        item = itemName;
        desc = itemDesc;
    }

    public String getIdea(){
        return item;
    }

    public String getDesc() {
        return desc;
    }
}
