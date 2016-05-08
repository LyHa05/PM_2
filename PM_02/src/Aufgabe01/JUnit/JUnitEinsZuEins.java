package Aufgabe01.JUnit;

import java.sql.Date;
import org.junit.Before;
import org.junit.Test;

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
		
//		PartnerMulti p1 = new PartnerMulti("Meyer", "Ingo", new Date(1999, 05, 12));
		this.p1 = new PartnerNormal("Mueller", "Kai", new Date(1988, 8, 8));
		this.p2 = new PartnerNormal("Schmidt", "Marion", new Date(1977, 1, 1));
		this.a1 = new AdresseNormal("Bruecke", 2, 11111, "Berghausen", "Dt");
		this.a2 = new AdresseNormal("Muelleimer", 5, 22222, "Wiesendorf", "Dt");
//		AdresseMulti a3 = new AdresseMulti("Am Weg", 3, 33333, "Bergdorf", "Dt");
		p1.setAdresse(a1);
		p2.setAdresse(a2);
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


