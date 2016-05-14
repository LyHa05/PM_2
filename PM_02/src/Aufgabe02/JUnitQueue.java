package Aufgabe02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JUnitQueue {

	public Queue<Integer> q1;
	public Queue<String> q2;
	public Queue<Integer> q3;

	@Before
	public void setUp() {
		this.q1 = new Queue<Integer>(2);
		this.q2 = new Queue<String>(4);
	}

	/** erstelltes Array geprüft*/
	@Test
	public void testErstelltesArray() {
		assertTrue(this.q1.empty);
	}
	
	/** Methode anzahlElemente testen**/
	@Test
	public void testAnzahlElemente() {
		this.q2.enqueue("ich");
		this.q2.enqueue("werde");
		//this.q2.enqueue("getestet");
		assertSame(3,q2.getAnzahlElemente());
	}
		
	/** negativer Wert als Kapazität übergeben */
	@Test(expected = IllegalArgumentException.class)
	public void testNegativerWertfuerKapazitaet() {
		this.q3 = new Queue<Integer>(-1);
	}

	/** mehr Elemente als möglich Kapazität in Array einfügen*/
	@Test(expected = QueueFullException.class)
	public void testMehrElementeAlsKapazitaet() {
		this.q1.enqueue(1);
		this.q1.enqueue(2);
		this.q1.enqueue(3);
	}

	/** Element aus leerem Queue entnehmen*/
	@Test(expected = EmptyQueueException.class)
	public void testElementeAusLeeremQueueEntnehmen() {
		this.q2.dequeue();
	}
	
	/** bei getter Methode prüfen, ob Objekt veränderbar */
	@Test
	public void testRueckgabewertGetterMethode() {
		assertNotSame(q1.getKapazitaet(),q1.getKapazitaet() + 2);
	}

	/** prüfen, ob toString überschrieben */
	@Test
	public void testImplementierungToString() {
		assertNotSame(System.out.println(q1),/**regulärer toString ausdruckt*/);
	}

}
