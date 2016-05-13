package Aufgabe01.JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Aufgabe01.AdresseMulti;
import Aufgabe01.AdresseSingle;
import Aufgabe01.ObjektErzeuger;
import Aufgabe01.PartnerSingle;

/**
@author: Chris Thiele
@author: Lydia Pflug
@date: 08.05.2016
Diese Klasse testet die 1:1 Assoziation zwischen Partner und Adresse.
*/

public class JUnitEinsZuEins {

	public PartnerSingle p1;
	public PartnerSingle p2;
	public PartnerSingle p3;
	public PartnerSingle p4;
	public AdresseSingle a1;
	public AdresseSingle a2;
	public AdresseSingle a3;
	public AdresseSingle a4;
			
	@Before
	public void setUp() {
				
		/**Erzeugung Personen Objekte*/
		this.p1 = new PartnerSingle("Mueller", "Kai", 1988, 8, 8, "Bruecke", 2, "11111", "Berghausen", "Dt");
		this.p2 = new PartnerSingle("Schmidt", "Marion", 1977, 7, 7, "Muelleimer", 5, "22222", "Wiesendorf", "Dt");
		
		/**Zuweisen der erzeugten Adresse zu Adressvariable*/
		this.a1 = p1.getAdresse();
		this.a2 = p2.getAdresse();
		
		/**Erzeugung Adress Obejekte*/
		this.a3 = new AdresseSingle("Peterstruck Str", 42, "22222", "Irgendwo", "De", "Meyer", "Ingo", 1999, 05, 12);
		this.a4 = new AdresseSingle("Jockelsteig", 666, "42424", "Nirgendwo", "US", "Haahn", "Lisa", 1999, 07, 01);
		
		/**Zuweisen der erzeugten Partner zu Partnervariable*/
		this.p3 = a3.getPartner();
		this.p4 = a4.getPartner();

	}
	
	/**Adressobjekt ohne Partner erstellt*/
	@Test(expected = IllegalArgumentException.class)
	public void test_Erstellung_Adresse_ohne_Partner() {
		this.a1 = new AdresseSingle("Bruecke", 2, "11111", "Berghausen", "Dt");
	}
	
	/**Partnerobjekt ohne Adresse erstellt*/
	@Test(expected = IllegalArgumentException.class)
	public void test_Erstellung_Partner_ohne_Adresse() {
		this.p2 = new PartnerSingle("Schmidt", "Marion", 1977, 7, 7);
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


