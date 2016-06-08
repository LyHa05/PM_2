package Aufgabe052.A02;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;


/**
 * @author: Chris Thiele
 * @author: Lydia Pflug
 * @date: 07.06.2016 Diese Klasse testet die PredicateUtilty Klasse
 */

public class TestCollatzStream {
    public Stream<Integer> collatzTestStream1 = CollatzStream.erstellenCollatzStream(1);
    public Stream<Integer> collatzTestStream5 = CollatzStream.erstellenCollatzStream(5);
    public Stream<Integer> collatzTestStream10 = CollatzStream.erstellenCollatzStream(10);
    public Stream<Integer> collatzTestStream20 = CollatzStream.erstellenCollatzStream(20);
    public List<Integer> testMitstartwert1 = new ArrayList<>();
    public List<Integer> testMitStartwert5 = new ArrayList<>();
    public List<Integer> testMitStartwert10 = new ArrayList<>();
    public List<Integer> testMitStartwert20 = new ArrayList<>();
    public Integer endWertBeiStartwert1;
    public Integer endWertBeiStartwert5;
    public Integer endWertBeiStartwert10;
    public Integer endWertBeiStartwert20;

    @Before
    public void setUp(){
        /** Wertquelle http://oeis.org/search?q=Collatz&language=english&go=Search
         *  Der Endwert bezieht sich auf die 20. Stelle des Streams*/
        endWertBeiStartwert1 = 2;
        endWertBeiStartwert5 = 1;
        endWertBeiStartwert10 = 1;
        endWertBeiStartwert20 = 4;
    }

    @Test
    public void testEndWertMitStartWert1() {
        collatzTestStream1.filter(l -> l != null).collect(Collectors.toCollection(() -> testMitstartwert1));
        assertEquals(endWertBeiStartwert1, testMitstartwert1.get(19));
    }

    @Test
    public void testEndWertMitStartWert5() {
        collatzTestStream5.filter(l -> l != null).collect(Collectors.toCollection(() -> testMitStartwert5));
        assertEquals(true, endWertBeiStartwert5.equals(testMitStartwert5.get(19)));
    }

    @Test
    public void testEndWertMitStartWert10() {
        collatzTestStream10.filter(l -> l != null).collect(Collectors.toCollection(() -> testMitStartwert10));
        assertEquals(true, endWertBeiStartwert10.equals(testMitStartwert10.get(19)));
    }

    @Test
    public void testEndWertMitStartWert20() {
        collatzTestStream20.filter(l -> l != null).collect(Collectors.toCollection(() -> testMitStartwert20));
        assertEquals(true, endWertBeiStartwert20.equals(testMitStartwert20.get(19)));
    }
}