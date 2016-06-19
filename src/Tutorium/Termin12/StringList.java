package Tutorium.Termin12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by chris on 15.06.16.
 */

public class StringList {

    public List<String> sList = new ArrayList<>();

    StringList(){
        listeBefuellen();
    }

    // Methode zum Befuellen der Liste
    private void listeBefuellen(){
        sList.add("bla");
        sList.add("blablabla");
        sList.add("x");
        sList.add("wassollichhiereintippen");
        sList.add("hawstudium");
        sList.add("irgendwelcheninput");
        sList.add("opopopo");
        sList.add("haaaaaaalllllloooooo");
        sList.add("eseskaliertetwashartundsowirklich");
    }

    public String shortestString(){
        String min = sList.stream().min(Comparator.naturalOrder()).get();
        return min;
    }

    public int longestStringLength(){
        String max = sList.stream().max(Comparator.naturalOrder()).get();
        int maxInt = max.length();
        return maxInt;
    }
}
