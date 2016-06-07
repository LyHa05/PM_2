package Aufgabe052.A01;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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

    @Before
    public void SetUp(){
    }

    @Test
    public void TestMit25FibonacciZahlen() {
        System.out.println("Ausgabe Fibonacci Zahlen 25 Stellen");
        System.out.println("-----------------------------------");
        StreamMit25StellenFibo.filter(s -> s != 0).forEach(System.out::println);
    }
}
