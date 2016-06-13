package Aufgabe052.A03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: Chris Thiele
 * @author: Lydia Pflug
 * @date: 13.06.2016 Diese Utility Klasse stellt Methoden bereit, um die Range zwischen
 * zwei LocalDate Objekten zu ermitteln
 */

public class DayRange {

    public static void main(String[] args){


    }

    public static long minAbstand(){
        long minAbstand;
        LocalDate startDatum = LocalDate.of(2000, 1, 1);
        ArrayList<LocalDate> localDateList;

        Stream.iterate(startDatum, l -> l.plusDays(1))
                .filter((DateStreamUtility.istFreitag()))
                .filter((DateStreamUtility.tagDesMonats(13)))
                .limit(3250)
                .

        return minAbstand;
    }
}
