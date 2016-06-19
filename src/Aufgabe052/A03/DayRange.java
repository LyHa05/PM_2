package Aufgabe052.A03;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;


/**
 * @author: Chris Thiele
 * @author: Lydia Pflug
 * @date: 13.06.2016 Diese Utility Klasse stellt Methoden bereit, um die Range zwischen
 * den Blackfridays zu ermitteln.
 */

public class DayRange {

    public static long getMinAbstand(LocalDate start){
        return rangeBetweenDates(start).stream().min(Comparator.naturalOrder()).get();
    }

    public static long getMaxAbstand(LocalDate start){
        return rangeBetweenDates(start).stream().max(Comparator.naturalOrder()).get();

    }

    public static long getDurchschnittAbstand(LocalDate start){
        List<Long> rangeBetweenDates = rangeBetweenDates(start);

        long summe = 0;

        for(long element : rangeBetweenDates){
            summe += element;
        }
        System.out.println("Summe: " + summe);
        return (summe/(rangeBetweenDates.size()));
    }

    private static List<Long> rangeBetweenDates(LocalDate start){
        ArrayList<LocalDate> listBlackFridays = new ArrayList<>(listAllerBlackFridays(start));
        List<Long> rangeBetweenDates = new ArrayList<>();

        for(int i = 0; i < (listBlackFridays.size())-1; i++){
            rangeBetweenDates.add(Duration.between(listBlackFridays.get(i).atTime(0, 0), listBlackFridays.get(i+1).atTime(0, 0)).toDays());
        }

        return rangeBetweenDates;
    }

    private static List<LocalDate> listAllerBlackFridays(LocalDate start){
        List<LocalDate> listBlackFridays = Stream.iterate(start, l -> l.plusDays(1))
                .filter((DateStreamUtility.istFreitag()))
                .filter((DateStreamUtility.tagDesMonats(13)))
                .limit(20)
                .collect(Collectors.toList());

        return listBlackFridays;
    }

    private DayRange(){}

}

