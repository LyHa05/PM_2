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

    public List<String> reverseAllStrings(List<String> sList){
        List<String> reversedList = sList.stream().map(string -> new StringBuilder(string)
                .reverse()
                .toString())
                .collect(Collectors.toList());
        return reversedList;
    }

    //public boolean containsNumber(List<String> sList){
    //    boolean contains = sList.stream().
    //}

    public static Map<Integer, List<String>> groupByLength(List<String> sList){
        Map<Integer, List<String>> mapString = sList.stream().collect(Collectors.toMap(s -> s.length(), s -> ));
        return mapString;
    }

    // Private Construktor
    private StringListUtility(){}
}
