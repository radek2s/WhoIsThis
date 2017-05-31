package edu.study.radek.whoisthis.models;

/**
 * @author radek2s
 * created 19.04.2017
 *
 */

public class Picture {

    private int src;
    private String name;

    /* package-private constructor - only to use by Loader Class */
    public Picture(String name, int src){
        this.name = name;
        this.src = src;
    }

    public int getSrc() {
        return src;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
