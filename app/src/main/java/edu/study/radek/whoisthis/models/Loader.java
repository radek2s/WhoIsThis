package edu.study.radek.whoisthis.models;

import java.util.LinkedList;

import edu.study.radek.whoisthis.R;

/**
 * @author radek2s
 * created 19.04.2017
 *
 * Loader class carry data from resources to application
 * Loads images and sets up names
 */

public class Loader {

    private LinkedList<Picture> pictures;

    public Loader(){

        pictures = new LinkedList<>();
        loadPictures(pictures);
    }

    public LinkedList<Picture> getPictures(){
        return this.pictures;
    }

    private void loadPictures(LinkedList pictures){
        pictures.add(new Picture("Adam Małysz", R.drawable.adam_malysz));
        pictures.add(new Picture("Adam Mickiweicz",R.drawable.adam_mickiewicz));
        pictures.add(new Picture("Adolf Hitler",R.drawable.adolf_hitler));
        pictures.add(new Picture("Agnieszka Radwańska",R.drawable.agnieszka_radwanska));
        pictures.add(new Picture("Albert Einstein",R.drawable.albert_einstein));
        pictures.add(new Picture("Aleksander Macedoński",R.drawable.alexander));
        pictures.add(new Picture("Andrzej Duda",R.drawable.andrzej_duda));
        pictures.add(new Picture("Andrzej Gołota",R.drawable.andrzej_golota));
        pictures.add(new Picture("Aragorn",R.drawable.aragorn));
        pictures.add(new Picture("Archimedes",R.drawable.archimedes));
        pictures.add(new Picture("Barack Obama",R.drawable.barack_obama));
        pictures.add(new Picture("Ludwig van Beethoven",R.drawable.beethovenl));
        pictures.add(new Picture("Bill Gates",R.drawable.bill_gates));
        pictures.add(new Picture("Bob Marley",R.drawable.bob_marley));
        pictures.add(new Picture("Bolesław Chrobry",R.drawable.boleslaw_chrobry));
//        pictures.add(new Picture("Jack Sparrow",R.drawable.capitan_jack_sparrow));
        pictures.add(new Picture("Kazimierz Wielki",R.drawable.casimirthe_great));
        pictures.add(new Picture("Celine Dion",R.drawable.celine_dion));
        pictures.add(new Picture("Karol Darwin",R.drawable.charles_darwin));
        pictures.add(new Picture("Krzysztof Kolumb",R.drawable.christopher_columbus));
        pictures.add(new Picture("Cristiano Ronaldo",R.drawable.cristiano_ronaldo));
        pictures.add(new Picture("Czyngis Chan",R.drawable.czyngis_chan));
        pictures.add(new Picture("Darth Vader",R.drawable.darth_vader));
        pictures.add(new Picture("Donald Trump",R.drawable.donald_trump));
        pictures.add(new Picture("Ed Shreeran",R.drawable.ed_sheeran));
        pictures.add(new Picture("Elton John",R.drawable.elton_john));
        pictures.add(new Picture("Elvis Presley",R.drawable.elvis_presley));
        pictures.add(new Picture("Eminem",R.drawable.eminem));
        pictures.add(new Picture("Ezio Auditore",R.drawable.ezio_auditore));
        pictures.add(new Picture("Forrest Gump",R.drawable.forrest_gump));
        pictures.add(new Picture("Freddie Mercury",R.drawable.freddie_mercury));
        pictures.add(new Picture("Fryderyk Chopin",R.drawable.fryderyk_chopin));
        pictures.add(new Picture("Gandalf",R.drawable.gandalf));
        pictures.add(new Picture("George Washington",R.drawable.george_washington));
        pictures.add(new Picture("Geralt",R.drawable.geralt));
        pictures.add(new Picture("Gollum",R.drawable.gollum));
        pictures.add(new Picture("Han Solo",R.drawable.han_solo));
        pictures.add(new Picture("Hannibal Lecter",R.drawable.hannibal_lecter));
        pictures.add(new Picture("Harry Potter",R.drawable.harry_potter));
        pictures.add(new Picture("Henryk Sienkiewicz",R.drawable.henryk_sienkiewicz));
        pictures.add(new Picture("Indiana Jones",R.drawable.indiana_jones));
        pictures.add(new Picture("Izaak Newton",R.drawable.isaac_newton));
        pictures.add(new Picture("Jadwiga Andygawenska",R.drawable.jadwiga_andygawnska));
        pictures.add(new Picture("James Bond",R.drawable.james_bond));
        pictures.add(new Picture("James Hetfield",R.drawable.james_hetfield));
        pictures.add(new Picture("Jan III Sobieski",R.drawable.jan3sobieski));
        pictures.add(new Picture("Jan Kochanowski",R.drawable.jan_kochanowski));
        pictures.add(new Picture("Jan Paweł II",R.drawable.jan_pawel2));
        pictures.add(new Picture("Jeremy Clarkson",R.drawable.jeremy_clarkson));
        pictures.add(new Picture("Jezus",R.drawable.jezus));
        pictures.add(new Picture("John F. Kennedy",R.drawable.john_f_kennedy));
        pictures.add(new Picture("Józef Stalin",R.drawable.joseph_stalin));
        pictures.add(new Picture("Józef Piłsudzki",R.drawable.jozef_pilsudzki));
        pictures.add(new Picture("Juliusz Cezar",R.drawable.juliusz_cezar));
        pictures.add(new Picture("Kubuś Puchatek",R.drawable.kubus_puchatek));
        pictures.add(new Picture("Lara Croft",R.drawable.lara_croft));
        pictures.add(new Picture("Leonardo Da Vinci",R.drawable.leonardo_da_vinci));
        pictures.add(new Picture("Maria Skłodowska-Curie",R.drawable.maria_curie));
        pictures.add(new Picture("Marilyn Monroe",R.drawable.marilyn_monroe));
        pictures.add(new Picture("Mario",R.drawable.mario));
        pictures.add(new Picture("Maximus",R.drawable.maximus_gladiator));
        pictures.add(new Picture("Michael Jackson",R.drawable.michael_jackson));
        pictures.add(new Picture("Michael Jordan",R.drawable.michael_jordan));
        pictures.add(new Picture("Mike Tyson",R.drawable.mike_tyson));
        pictures.add(new Picture("Mikołaj Kopernik",R.drawable.mikolaj_lopernik));
        pictures.add(new Picture("Napoleon Bonaparte",R.drawable.napoleon_bonaparte));
        pictures.add(new Picture("Nathan Drake",R.drawable.nathan_drake));
        //pictures.add(new Picture("Neil Armstrong",R.drawable.neil_armstrong));
        pictures.add(new Picture("Niko Bellic",R.drawable.niko_bellic));
        pictures.add(new Picture("Nikola Tesla",R.drawable.nikola_tesla));
        pictures.add(new Picture("Nikolai Bielinski",R.drawable.nikolai_bielinski));
        pictures.add(new Picture("Pikachu",R.drawable.pikachu));
        pictures.add(new Picture("Posejdon",R.drawable.poseidon));
        pictures.add(new Picture("Rihanna",R.drawable.rihanna));
        pictures.add(new Picture("Robert Lewandowski",R.drawable.robert_lewandowski));
        pictures.add(new Picture("Robin Hood",R.drawable.robin_hood));
        pictures.add(new Picture("Sackboy",R.drawable.sackboy));
        pictures.add(new Picture("Slash",R.drawable.slash));
        pictures.add(new Picture("Steve",R.drawable.steve));
        pictures.add(new Picture("Steve Jobs",R.drawable.steve_jobs));
        pictures.add(new Picture("Tadeusz Mazowiecki",R.drawable.tadeusz_mazowiecki));
        pictures.add(new Picture("Tadeusz Kosciuszko",R.drawable.tadeuszkosciuszko));
        pictures.add(new Picture("Taylor Swift",R.drawable.taylor_swift));
        pictures.add(new Picture("Usain Bolt",R.drawable.usain_bolt));
        pictures.add(new Picture("Vito Corleone",R.drawable.vito_corleone));
        pictures.add(new Picture("Władymir Putin",R.drawable.vladimir_putin));
        pictures.add(new Picture("William Shakespeare",R.drawable.william_shakespeare));
        pictures.add(new Picture("Władysław Jagiełło",R.drawable.wladyslaw_jagiello));
        pictures.add(new Picture("Zeus",R.drawable.zeus));

    }
}
