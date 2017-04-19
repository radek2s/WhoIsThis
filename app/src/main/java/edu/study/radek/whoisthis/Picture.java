package edu.study.radek.whoisthis;

/**
 * Created by radek_000 on 19.04.2017.
 */

public class Picture {

    private int src;
    private String name;

    public Picture(String name, int src){
        this.name = name;
        this.src = src;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
