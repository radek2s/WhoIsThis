package edu.study.radek.whoisthis;

import edu.study.radek.whoisthis.models.Loader;
import edu.study.radek.whoisthis.models.Team;

/**
 * @author radek2s
 * created 19.04.2017
 *
 * Core class to handle settings and game progress.
 */

public class Core {

    public static Loader loader = new Loader();
    public static Team teamA = new Team();
    public static Team teamB = new Team();

    public static int time      = 3;
    public static int rounds    = 1;
    public static int difficulty= 10;

}
