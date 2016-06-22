package Tutorium.Termin12;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by chris on 15.06.16.
 */

public class StringListUtility {


    public static String shortestString(List<String> sList){
        String min = sList.stream().reduce((s1,s2) -> (s1.length() <= s2.length()) ? s1 : s2).get();
        return min;
    }

    public static int longestStringLength(List<String> sList){
        String max = sList.stream().reduce((s1,s2) -> (s1.length() >= s2.length()) ? s1 : s2).get();
        return max.length();
    }

    public static int cumulatedlength(List<String> sList){
        Integer sumLength = sList.stream().reduce(0, (sum, l) -> sum += l.length(), (sum1, sum2) -> sum1 + sum2);
        return sumLength;
    }

    public static List<String> reverseAllStrings(List<String> sList){
        List<String> reversedList = sList.stream().map(string -> new StringBuilder(string)
                .reverse()
                .toString())
                .collect(Collectors.toList());
        return reversedList;
    }
    

    public static boolean containsNumber(List<String> sList){
    	/**
    	 * Die Methode wandelt eine Liste in einen Stream um und ueberprueft mit 'anyMatch'
    	 * ob einer der Strings die Bedingung erfuellt, dass dieser nur aus Zahlen besteht.
    	 * Um dies zu bewerkstelligen wird wiederum jeder String in einen neuen Stream
    	 * aufgeloest und es wird mit 'allMatch' ueberprueft ob eine der Stringklassen
    	 * nur aus Zahlen besteht. Damit der Vergleich mit den ASCII Werten statt findet,
    	 * werden die vergleichs Ziffern als Chars geschrieben ('0' & '0')
    	 */
        return sList.stream().anyMatch(s -> s.chars().allMatch(c -> c >= '0' && c <= '9'));
    }

    public static Map<Integer, List<String>> groupByLength(List<String> sList){
    	/**
    	 * Die Methode gruppiert eine Liste nach der Wortlaenge ihrer Elemente und gibt
    	 * diese zurueck.
    	 */
        Map<Integer, List<String>> mapString = sList.stream().collect(Collectors.groupingBy(String::length));
        return mapString;
    }

    // Private Construktor
    private StringListUtility(){}
}
