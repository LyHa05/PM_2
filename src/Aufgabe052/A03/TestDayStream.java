package Aufgabe052.A03;

import Aufgabe042.PredicateUtility;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.function.Predicate;

/**
 * @author: Chris Thiele
 * @author: Lydia Pflug
 * @date: 07.06.2016 Diese Klasse testet die PredicateUtilty Klasse
 */

public class TestDayStream {

    public static void main(String args[]){
        LocalDate startDatumAufgabeVier = LocalDate.of(2000, 1, 1);
        LocalDate startDatumAufgabeFuenf = LocalDate.of(2000, 1, 1);
        Predicate<LocalDate> aufgabe5Predicate;

        aufgabe5Predicate = PredicateUtility.andAll(d -> d.getDayOfMonth() == ) // To-Do


        // Ausgabe alle Freitag mit 13.
        DayStream.erstellenDayStream(startDatumAufgabeVier, 5840)
                .filter(d -> d.getDayOfWeek() == DayOfWeek.FRIDAY)
                .filter(d -> d.getDayOfMonth() == 13)
                .forEach(System.out::println);

        // Ausgabe Aufgabe 05
        DayStream.erstellenDayStream(startDatumAufgabeFuenf, 5840)
                .filter()
    }
}
