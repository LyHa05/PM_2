package Aufgabe051;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author: Chris Thiele
 * @author: Lydia Pflug
 * @date: 09.06.2016
 * Diese Klasse prueft Einlesen und Filterung der Datei.
 */

public class TestDateiLesen {

	
	/**Methode prueft, ob richtigen Kapitel entnommen worden.*/
	@Test
	public void testDateiEinlesen() {
		assertEquals(true,DateiLesen.dateiEinlesen().get(0).contains("3:16"));
		assertEquals(true,DateiLesen.dateiEinlesen().get(2).contains("3:16"));
		assertEquals(false,DateiLesen.dateiEinlesen().get(1).contains("13:16"));	
	}
	
	/**Methode*/
	@Test
	public void testAnzahlWorte() {
		
	}

}
