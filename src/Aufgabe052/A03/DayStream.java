package Aufgabe052.A03;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author: Chris Thiele
 * @author: Lydia Pflug
 * @date: 09.06.2016 Diese Klasse implementiert einen DayStream
 */

public class DayStream implements Supplier<Integer> {
    private int aktuellerWert;

    private CollatzStream(Integer startWert){
        this.aktuellerWert = startWert;
    }

    @Override
    public Integer get() {
        if(aktuellerWert <= 0){
            throw new IllegalArgumentException("Der Startwert muss groesser als 0 sein.");
        }
        if(aktuellerWert%2 == 0){
            aktuellerWert = aktuellerWert/2;
            return aktuellerWert;
        } else {
            aktuellerWert = (aktuellerWert*3)+1;
            return aktuellerWert;
        }
    }

    /** Limitierung auf 20 Stellen */
    public static Stream<Integer> erstellenCollatzStream(int startWert) {
        return(Stream.generate(new DayStream(startWert)).limit(20)); /** <- HIER */
    }
}