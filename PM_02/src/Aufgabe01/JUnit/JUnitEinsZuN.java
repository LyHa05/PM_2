package Aufgabe01.JUnit;

import static org.junit.Assert.*;
import java.sql.Date;
import org.junit.Before;
import org.junit.Test;
import Aufgabe01.AdresseSingleMulti;
import Aufgabe01.PartnerSingleMulti;

/**
@author: Chris Thiele
@author: Lydia Pflug
@date: 08.05.2016
Diese Klasse testet die 1:N Assoziation zwischen Partner und Adresse.
*/

public class JUnitEinsZuN {
	
	public PartnerSingleMulti p1;
	public PartnerSingleMulti p2;
	public PartnerSingleMulti p3;
	public AdresseSingleMulti a1;
	public AdresseSingleMulti a2;
	public AdresseSingleMulti a3;
	public AdresseSingleMulti a4;

	@Before
	public void setUp() {

		/**Erzeugung Personen Objekte*/

		this.a1 = new AdresseSingleMulti("Holsteiner", 21, "22941", "Bargteheide", "De", "Hans", "Peter", 1998, 5, 11);
		this.p1 = a1.getPartner();

		this.a2 = new AdresseSingleMulti("Holsteiner", 21, "22941", "Bargteheide", "De", "Otto", "Maier", 1998, 5, 11);
		this.p2 = a2.getPartner();

		this.a4 = new AdresseSingleMulti("Sonstwo", 22, "23156", "Irgendwo", "De", "Hans", "Peter", 1997, 4, 12);
		this.p3 = a4.getPartner();

	}

	@Test(expected = IllegalArgumentException.class)
	public void test_AdresseSingle_ExceptionTrow() {
		a3 = new AdresseSingleMulti("Working as", 12, "12345", "intended", "unso");
	}

	/**Adressenobjekt in Set von PartnerSingleMulti wiederauffindbar*/
	@Test
	public void test_Adresse_in_Set_von_PartnerSingleMulti() {
		assertTrue(p1.getAdressenSet().contains(a1));
	}
	
	/**Adressenobjekt in Set von PartneSingleMulti wiederauffindbar*/
	@Test
	public void test_Adresse_in_Set_von_PartnerSingleMulti_2() {
		assertTrue(p2.getAdressenSet().contains(a2));
	}
	
	/**Objektgleichheit bei gleichen Objekten*/
	@Test
	public void test_Adressobjektgleichheit() {
		assertEquals(a1,a2);
	}
	
	/**Objektidentität bei Adressobjekten*/
	@Test
	public void test_Adressobjektidentitaet() {
		assertNotSame(a1,a4);
	}
	
}


