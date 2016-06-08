package Aufgabe052.A01;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: Chris Thiele
 * @author: Lydia Pflug
 * @date: 07.06.2016 Diese Klasse testet die PredicateUtilty Klasse
 */

public class TestFibonacciStream {
    /**
    * public ArrayList<Long> ArrayMit25StellenFibo;
    * public ArrayList<Long> ArrayMit10StellenFibo;
     */

    public Stream<Long> streamMit25StellenFibo = FibonacciStream.erstellenFiboStream(25);
    public Stream<Long> streamMit10StellenFiob = FibonacciStream.erstellenFiboStream(10);
    public List<Long> testMit10 = new ArrayList<>();
    public List<Long> testMit25 = new ArrayList<>();
    public Long loesungMit10LetzteZahl;
    public Long loesungMit25LetzteZahl;


    @Before
    public void setUp(){
        /** Zahlen Quelle: http://primzahlen.zeta24.com/de/fibonaccizahlen_liste.php */
        loesungMit10LetzteZahl = Long.parseLong("55");
        loesungMit25LetzteZahl = Long.parseLong("75025");
    }

    @Test
    public void testMit25FibonacciZahlen() {
        streamMit25StellenFibo.filter(l -> l != null).collect(Collectors.toCollection(() -> testMit25));
        assertEquals(true, loesungMit25LetzteZahl.equals(testMit25.get(24)));
    }

    @Test
    public void testMit10FibonacciZahlen() {
        streamMit25StellenFibo.filter(l -> l != null).collect(Collectors.toCollection(() -> testMit10));
        assertEquals(true, (loesungMit10LetzteZahl.equals(testMit10.get(9))));
    }
}
