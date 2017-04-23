package edu.study.radek.whoisthis.models;

/**
 * @author radek2s
 * created 18.04.2017
 *
 */

public class Team {

    private String name;
    private int score;
    private int usedSkips;

    public Team(){
        name = null;
        score = 0;
        usedSkips = 0;
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

    public int getUsedSkips(){
        return this.usedSkips;
    }

    public void addPoint(){
        this.score = this.score + 1;
    }

    public void skip(){
        this.usedSkips += 1;
    }

    public void resetPoints(){
        this.score = 0;
        usedSkips = 0;
    }

}
