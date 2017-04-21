package edu.study.radek.whoisthis.models;

/**
 * Created by radek_000 on 18.04.2017.
 */

public class Team {

    private String name;
    private int score;

    public Team(){
        name = null;
        score = 0;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getScore(){
        return this.score;
    }

    public void addPoint(){
        this.score = this.score + 1;
    }

}
