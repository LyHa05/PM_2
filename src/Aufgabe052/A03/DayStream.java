package Aufgabe052.A03;

import java.time.LocalDate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author: Chris Thiele
 * @author: Lydia Pflug
 * @date: 09.06.2016 Diese Klasse implementiert einen DayStream
 */

public class DayStream implements Supplier<LocalDate> {
    private LocalDate aktuellesDatum;

    private DayStream(LocalDate aktuellesDatum){
        this.aktuellesDatum = aktuellesDatum;
    }

    @Override
    public LocalDate get() {
        LocalDate neueDatum = aktuellesDatum.plusDays(1);
        aktuellesDatum = neueDatum;
        return neueDatum;
    }

    public static Stream<LocalDate> erstellenDayStream(LocalDate startDatum,int streamLimit) {
        return(Stream.generate(new DayStream(startDatum)).limit(streamLimit));
    }
}