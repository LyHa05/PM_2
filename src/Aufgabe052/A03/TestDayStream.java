package Aufgabe052.A03;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

/**
 * @author: Chris Thiele
 * @author: Lydia Pflug
 * @date: 07.06.2016 Diese Klasse die Funktionalitaet der unbegrenzente Streams.
 */

public class TestDayStream {

    public LocalDate startDatum;
    public LocalDate endDatum;

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
    
    @Test
    public void testWeihnachtenAmWochenende(){
    	List<LocalDate> weihnachten2000 = Stream.iterate(startDatum, l -> l.plusDays(1))
    		.limit(365)
    		.filter((DateStreamUtility.monat(Month.DECEMBER)))
    		.filter((DateStreamUtility.tagDesMonats(24)))
    		.filter((DateStreamUtility.istWochenende()))
    		.collect(Collectors.toList());
    	assertEquals(true,weihnachten2000.size()==1);		
    }
    
}
