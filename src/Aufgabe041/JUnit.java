package Aufgabe041;

/**
 * @author: Chris Thiele
 * @author: Lydia Pflug
 * @date: 01.07.2016
 * Klasse JUnit testet die Implementierung der Utility und des funktionalen Interfaces.
 */

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import Aufgabe041.MeineUtility;

public class JUnit {
	
	int a, b, c, d, e;
	String f, g, h;
	LocalDate i, j, k;
	Auto a1, a2;
	

	@Before
	public void setUp() {
		f = "Auto";
		g = "Leben";
		h = "Unfall";
		i = LocalDate.of(2016, 06, 02);
		j = LocalDate.of(2015, 02, 16);
		k = LocalDate.of(2016, 03, 22);
		a1 = new Auto(100, "rot");
		a2 = new Auto(80,"gelb");
		
	}

	/** groesser als und kleiner als Vergleich */
	@Test
	public void testGroesserKleinerVergleich() {
		assertEquals(2, a = MeineUtility.betterElement(1, 2, (x, y) -> x > y));
		assertEquals(6, b = MeineUtility.betterElement(5, 6, (x, y) -> x > y));
		assertEquals(1, c = MeineUtility.betterElement(1, 2, (x, y) -> x < y));
	}
	
	/** Stringlaengenvergleich */
	@Test
	public void testStringGroesserKleinerVergleich() {
		assertEquals(4, d = MeineUtility.betterElement(f.length(), g.length() , (x, y) -> x < y));
		assertEquals(6, e = MeineUtility.betterElement(h.length(), g.length() , (x, y) -> x > y));
	}

	/** compareTo ueberschreiben fuer etwas*/
	
	
	/** Datumsvergleich*/
	@Test
	public void testDatumsVergleich() {
		assertEquals(LocalDate.of(2016, 06, 02), MeineUtility.betterElement(i, j, (x, y) -> x.isAfter(y)));
		assertEquals(LocalDate.of(2015, 02, 16), MeineUtility.betterElement(j, k, (x, y) -> x.isBefore(y)));
	}
	
	/** Autovergleich nach PS*/
	@Test
	public void testAutoVergleich() {
		assertEquals(a1, MeineUtility.betterElement(a1, a2, (x, y) -> x.vergleichen(y)));
		assertEquals(a1, MeineUtility.betterElement(a2, a1, (x, y) -> x.vergleichen(y)));
	}
	
	
	
	
	
	
}
