package com.example.hansel.demo4;

import java.util.ArrayList;

/**
 * Created by Hansel on 13/4/2017.
 */

public class Ideas {
    private ArrayList<Idea> ideaList;

    Ideas(){
        ideaList = new ArrayList<>();
    }

    public void newIdea(Idea idea){
        ideaList.add(idea);
    }

    public ArrayList<String> getIdeas(){
        ArrayList<String> ideasToReturn = new ArrayList<>();
        for(Idea idea: ideaList)
        {
            ideasToReturn.add(idea.getIdea());
        }
        return ideasToReturn;
    }

    public ArrayList<Idea> getIdeaList() {
        return ideaList;
    }
}
