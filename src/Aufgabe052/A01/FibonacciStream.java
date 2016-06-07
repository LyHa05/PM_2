package Aufgabe052.A01;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author: Chris Thiele
 * @author: Lydia Pflug
 * @date: 07.06.2016 Diese Klasse implementiert die Berechnung der Fibonacci Zahlen als Stream
 */

public class FibonacciStream implements Supplier<Long> {
    private long vorgaenger = 0;
    private long nachfolger = 0;


    @Override
    public Long get() {
        long naechste = vorgaenger + nachfolger;
        nachfolger = vorgaenger;
        vorgaenger = naechste;
        return(naechste);
    }

    public static Stream<Long> erstellenFiboStream() {
        return(Stream.generate(new FibonacciStream()));
    }

    public static Stream<Long> erstellenFiboStream(int anzahlZahlen){
        return(erstellenFiboStream().limit(anzahlZahlen));
    }
}
