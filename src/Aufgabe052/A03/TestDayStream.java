package Aufgabe052.A03;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author: Chris Thiele
 * @author: Lydia Pflug
 * @date: 07.06.2016 Diese Klasse testet die PredicateUtilty Klasse
 */

public class TestDayStream {

    public static void main(String args[]){
        LocalDate startDatumAufgabeVier = LocalDate.of(2000, 1, 1);

        System.out.println("Ausgabe Aufgabe 04, Startdatum 1.1.2000 - Limitierung 5840 Tage");
        // Ausgabe alle Freitag mit 13.
        DayStream.erstellenDayStream(startDatumAufgabeVier, 5840)
                .filter(d -> d.getDayOfWeek() == DayOfWeek.FRIDAY)
                .filter(d -> d.getDayOfMonth() == 13)
                .forEach(System.out::println);

        System.out.println("Ausgabe Aufgabe 05, Startdatum 1.1.2000 - Limitierung auf 10 Ausgaben");


        // Ausgabe Aufgabe 05
        LocalDate start = LocalDate.of(2000, 1, 1);

        /** Fuer diese Aufgabe wurde nicht mit dem DayStream gearbeitet, sondern dynamisch ein Stream
         * über die Methode Stream.iterate erzeugt. Hierbei wurde .iterate der Typ des zu iterierenen
         * Objekts uebergeben und per Lambda Ausdruck mitgeteilt, was beim naechsten Iterationschritt
         * erhoeht werden soll. Der Rest sind .filter Ausdrueck, die die geschriebene Klassen DateStreamutility
         * nutzen und die Ergebnisse filtern.
         */
        Stream.iterate(start, d -> d.plusDays(1))
                .filter(DateStreamUtility.istFreitag())
                .filter(DateStreamUtility.tagDesMonats(13))
                .limit(10)
                .forEach(System.out::println);
    }
}
