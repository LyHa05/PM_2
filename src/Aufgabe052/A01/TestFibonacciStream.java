package Aufgabe052.A01;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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

    public Stream<Long> StreamMit25StellenFibo = FibonacciStream.erstellenFiboStream(25);
    public Stream<Long> StreamMit10StellenFiob = FibonacciStream.erstellenFiboStream(10);
    public List<Long> LoesungMit10 = new ArrayList<>();
    public List<Long> LoesungMit25 = new ArrayList<>();
    public List<Long> TestMit10 = new ArrayList<>();
    public List<Long> TestMit25 = new ArrayList<>();

    @Before
    public void SetUp(){
        /** Zahlen Quelle: http://primzahlen.zeta24.com/de/fibonaccizahlen_liste.php */
        LoesungMit10.add(Long.parseLong("0"));
        LoesungMit10.add(Long.parseLong("1"));
        LoesungMit10.add(Long.parseLong("1"));
        LoesungMit10.add(Long.parseLong("2"));
        LoesungMit10.add(Long.parseLong("3"));
        LoesungMit10.add(Long.parseLong("5"));
        LoesungMit10.add(Long.parseLong("8"));
        LoesungMit10.add(Long.parseLong("13"));
        LoesungMit10.add(Long.parseLong("21"));
        LoesungMit10.add(Long.parseLong("34"));
        LoesungMit10.add(Long.parseLong("55"));

        LoesungMit25.add(Long.parseLong("0"));
        LoesungMit25.add(Long.parseLong("1"));
        LoesungMit25.add(Long.parseLong("1"));
        LoesungMit25.add(Long.parseLong("2"));
        LoesungMit25.add(Long.parseLong("3"));
        LoesungMit25.add(Long.parseLong("5"));
        LoesungMit25.add(Long.parseLong("8"));
        LoesungMit25.add(Long.parseLong("13"));
        LoesungMit25.add(Long.parseLong("21"));
        LoesungMit25.add(Long.parseLong("34"));
        LoesungMit25.add(Long.parseLong("55"));
        LoesungMit25.add(Long.parseLong("89"));
        LoesungMit25.add(Long.parseLong("144"));
        LoesungMit25.add(Long.parseLong("233"));
        LoesungMit25.add(Long.parseLong("377"));
        LoesungMit25.add(Long.parseLong("610"));
        LoesungMit25.add(Long.parseLong("987"));
        LoesungMit25.add(Long.parseLong("1597"));
        LoesungMit25.add(Long.parseLong("2584"));
        LoesungMit25.add(Long.parseLong("4181"));
        LoesungMit25.add(Long.parseLong("6765"));
        LoesungMit25.add(Long.parseLong("10945"));
        LoesungMit25.add(Long.parseLong("17711"));
        LoesungMit25.add(Long.parseLong("28657"));
        LoesungMit25.add(Long.parseLong("46368"));
        LoesungMit25.add(Long.parseLong("75025"));
    }

    @Test
    public void TestMit25FibonacciZahlen() {
        StreamMit25StellenFibo.filter(l -> l != null).collect(Collectors.toCollection(() -> TestMit25));
        assertEquals(true, (TestMit25.equals(LoesungMit25)));
    }

    @Test
    public void TestMit10FibonacciZahlen() {
        StreamMit25StellenFibo.filter(l -> l != null).collect(Collectors.toCollection(() -> TestMit10));
        assertEquals(true, (TestMit10.equals(LoesungMit10));
    }
}
