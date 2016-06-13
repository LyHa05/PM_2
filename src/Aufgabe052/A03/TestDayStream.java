package Aufgabe052.A03;

import org.junit.Before;
import org.junit.Test;

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

    public LocalDate startDatum;

    @Before
    public void setUp(){
        startDatum = LocalDate.of(2000, 1, 1);
    }

    @Test
    public void testRangeFreitagDen13UndSoMinAbstand(){
        long minAbstand = DayRange.getMinAbstand(startDatum);
        System.out.println("Min " + DayRange.getMinAbstand(startDatum));
        //assertEquals(28, minAbstand);
    }

    @Test
    public void testRangeFreitagDen13UndSoMaxAbstand(){
        //System.out.println(DayRange.getMaxAbstand(startDatum));
        System.out.println("Max " + DayRange.getMaxAbstand(startDatum));
        //assertEquals(1823, minAbstand);
    }
    @Test
    public void testRangeFreitagDen13UndSoDurchschnittsAbstand(){
        //System.out.println(DayRange.getDurchschnittAbstand(startDatum));
        System.out.println("Durchschnitt " + DayRange.getDurchschnittAbstand(startDatum));
        //assertEquals(4109, minAbstand);
    }
}
