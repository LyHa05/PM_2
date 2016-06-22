package Tutorium.Termin12;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 15.06.16.
 */
public class StringTest {

    public static void main(String[] args){

        List<String> sList = new ArrayList<>();

        sList.add("bla");
        sList.add("1337133742");
        sList.add("kkk");
        sList.add("blablabla");
        sList.add("x");
        sList.add("wassollichhiereintippen");
        sList.add("hawstudium");
        sList.add("irgendwelcheninput");
        sList.add("opopopo");
        sList.add("haaaaaaalllllloooooo");
        sList.add("eseskaliertetwashartundsowirklich");

        System.out.println(StringListUtility.shortestString(sList));
        System.out.println(StringListUtility.longestStringLength(sList));
        System.out.println(StringListUtility.cumulatedlength(sList));
        System.out.println(StringListUtility.groupByLength(sList));
        System.out.println(StringListUtility.containsNumber(sList));
        System.out.println("\n");
        System.out.println(StringListUtilityOhne.shortestString(sList));
        System.out.println(StringListUtilityOhne.longestStringLength(sList));
        System.out.println(StringListUtilityOhne.cumulatedlength(sList));
        System.out.println(StringListUtility.groupByLength(sList));
        System.out.println(StringListUtilityOhne.containsNumber(sList));
    }
}