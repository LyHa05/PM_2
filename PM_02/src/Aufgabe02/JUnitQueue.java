package Aufgabe02;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**
 * @author: Chris Thiele
 * @author: Lydia Pflug
 * @date: 12.05.2016 Diese Klasse testet die Funktionalitaet der Klasse Queue.
 */

public class JUnitQueue {

	public Queue<Integer> q1;
	public Queue<String> q2;
	public Queue<Integer> q3;
	public Queue<Integer> q4;

	@Before
	public void setUp() {
		this.q1 = new Queue<Integer>(2);
		this.q2 = new Queue<String>(4);
		this.q3 = new Queue<Integer>(3);
		this.q4 = new Queue<Integer>(3);
	}

	/** erstelltes Array geprüft */
	@Test
	public void testErstelltesArray() {
		assertTrue(this.q1.empty());
	}

	/** Methode anzahlElemente testen **/
	@Test
	public void testAnzahlElemente() {
		this.q2.enqueue("ich");
		this.q2.enqueue("werde");
		this.q2.enqueue("getestet");
		assertSame(3, q2.getAnzahlElemente());
	}

	/** negativer Wert als Kapazität übergeben */
	@Test(expected = IllegalArgumentException.class)
	public void testNegativerWertfuerKapazitaet() {
		this.q3 = new Queue<Integer>(-1);
	}

	/** mehr Elemente als möglich Kapazität in Array einfügen */
	@Test(expected = IllegalStateException.class)
	public void testMehrElementeAlsKapazitaet() {
		this.q1.enqueue(1);
		this.q1.enqueue(2);
		this.q1.enqueue(3);
	}

	/** Ringpuffer auf Umschlag des Index prüfen */
	@Test
	public void testRingpuffer() {
		this.q4.enqueue(1);
		this.q4.enqueue(2);
		this.q4.enqueue(3);
		assertSame(1,this.q4.dequeue());
		this.q4.enqueue(4);
		assertSame(2,this.q4.dequeue());
		this.q4.enqueue(5);
		assertSame(3,this.q4.dequeue());
	}
	
	/** Testet, ob 

	/** Element aus leerem Queue entnehmen */
	@Test(expected = NoSuchElementException.class)
	public void testElementeAusLeeremQueueEntnehmen() {
		this.q2.dequeue();
	}

	/** prüfen, ob toString überschrieben */
	@Test
	public void testImplementierungToString() {
		assertEquals("", q1.toString());
	}

}
