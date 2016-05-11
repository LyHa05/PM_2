package Aufgabe01.JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Aufgabe01.AdresseNormal;
import Aufgabe01.PartnerNormal;

/**
@author: Chris Thiele
@author: Lydia Pflug
@date: 08.05.2016
Diese Klasse testet die 1:1 Assoziation zwischen Partner und Adresse.
*/

public class JUnitEinsZuEins {

	public PartnerNormal p1;
	public PartnerNormal p2;
	public AdresseNormal a1;
	public AdresseNormal a2;
		
	@Before
	public void setUp() {
		
		/**Erzeugung Personen Objekte*/
		this.p1 = new PartnerNormal("Mueller", "Kai", 1988, 8, 8);
		this.p2 = new PartnerNormal("Schmidt", "Marion", 1977, 7, 7);
		
		/**Erzeugung Adress Obejekte*/
		this.a1 = new AdresseNormal("Bruecke", 2, "11111", "Berghausen", "Dt");
		this.a2 = new AdresseNormal("Muelleimer", 5, "22222", "Wiesendorf", "Dt");
		
		/** Weisen p1  und p2 Adressen a1 und a2 zu*/
		p1.setAdresse(a1);
		p2.setAdresse(a2);
		
		/** Weisen a1 und a2 Partner p1  und p2 zu*/
		a1.setPartner(p1);
		a2.setPartner(p2);
	}
	
	/**Abgleich: Referenz in Adresse auf Partner mit Adressobjekt vergleichen*/
	@Test
	public void test_auf_identische_Adressobjekte() {
		assertEquals(a1, p1.getAdresse());
		assertEquals(a2, p2.getAdresse());
	}
	
	/**Abgleich: Referenz in Adresse auf Partner mit Adressobjekt vergleichen*/
	@Test
	public void test_auf_nicht_identische_Adressobjekte() {
		assertNotEquals(a2, p1.getAdresse());
		assertNotEquals(a1, p2.getAdresse());
	}
	
	/**Abgleich: Referenz in Partner auf Adresse mit Partnerobjekt vergleichen*/
	@Test
	public void test_auf_identische_Partnerobjekte() {
		assertEquals(p1, a1.getPartner());
		assertEquals(p2, a2.getPartner());
	}
	
	/**Abgleich: Referenz in Partner auf Adresse mit Partnerobjekt vergleichen*/
	@Test
	public void test_auf_nicht_identische_Partnerobjekte() {
		assertNotEquals(p2, a1.getPartner());
		assertNotEquals(p1, a2.getPartner());
	}

}


