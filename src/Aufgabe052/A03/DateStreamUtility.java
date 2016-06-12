package Aufgabe052.A03;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.function.Predicate;

/**
 * @author: Chris Thiele
 * @author: Lydia Pflug
 * @date: 10.06.2016 Diese Klasse stellt Funktionalitaetet fuer die Filterung von
 * einem LocalDateStream zur Verfuegung
 */
public class DateStreamUtility {

    static Predicate<LocalDate> istFreitag(){
        return d -> d.getDayOfWeek() == DayOfWeek.FRIDAY;
    }

    static Predicate<LocalDate> istWochenende(){
        return d -> d.getDayOfWeek() == DayOfWeek.SATURDAY
                || d.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    static Predicate<LocalDate> tagDesMonats(int tag){
        return d -> d.getDayOfMonth() == tag;
    }

    static Predicate<LocalDate> monat(Month monat){
        return d -> d.getMonth() == monat;
    }
}
