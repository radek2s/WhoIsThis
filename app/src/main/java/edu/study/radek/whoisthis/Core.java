package edu.study.radek.whoisthis;

import java.util.LinkedList;

import edu.study.radek.whoisthis.models.Loader;
import edu.study.radek.whoisthis.models.Picture;
import edu.study.radek.whoisthis.models.Team;

/**
 * @author radek2s
 * created 19.04.2017
 *
 * Core class to handle settings and game progress.
 */

public class Core {

    //TODO: Złe odpowiedzi, co było nie tak

    private static Core instance = null;

    private int time        = 3;
    private int rounds      = 1;
    private int difficulty  = 10;

    private Loader loader;
    private Team teamA;
    private Team teamB;

    private LinkedList<Picture> skippedCharacters = null;

    /* Initialization */
    protected Core(){
        loader = new Loader();
        teamA = new Team();
        teamB = new Team();
        skippedCharacters = new LinkedList<>();

    }

    /* Core Singleton */
    public static Core getInstance(){
        if (instance == null){
            instance = new Core();
        }
        return instance;
    }

    // -- getters & setters -- //
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public Loader getLoader() {
        return loader;
    }

    public Team getTeamA() {
        return teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public LinkedList<Picture> getSkippedCharacters(){
        return skippedCharacters;
    }

}
