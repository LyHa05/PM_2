package Aufgabe01.JUnit;

import static org.junit.Assert.*;
import java.sql.Date;
import org.junit.Before;
import org.junit.Test;
import Aufgabe01.AdresseNormal;
import Aufgabe01.PartnerMulti;

/**
@author: Chris Thiele
@author: Lydia Pflug
@date: 08.05.2016
Diese Klasse testet die 1:N Assoziation zwischen Partner und Adresse.
*/

public class JUnitEinsZuN {
	
	public PartnerMulti p1;
	public PartnerMulti p2;
	public AdresseNormal a1;
	public AdresseNormal a2;
	public AdresseNormal a3;

	@Before
	public void setUp() {
		
		this.p1 = new PartnerMulti("Meyer", "Ingo", new Date(1999, 05, 12));
		this.p2 = new PartnerMulti("Baecker", "Gustav", new Date(1979, 04,23));
		this.a1 = new AdresseNormal("Bruecke", 2, 11111, "Berghausen", "Dt");
		this.a2 = new AdresseNormal("Muelleimer", 5, 22222, "Wiesendorf", "Dt");
		this.a3 = new AdresseNormal("Muelleimer", 5, 22222, "Wiesendorf", "Dt");
		p1.addAdresse(a1);
		p1.addAdresse(a2);
		a1.setPartner(p1);
		a2.setPartner(p2);
	}

	/**Adressenobjekt in ArrayList von Partnermulti wiederauffindbar*/
	@Test
	public void test_Adresse_in_ArrayList_von_PartnerMulti() {
		assertTrue(p1.getAdressenList().contains(a1));
	}
	
	/**Adressenobjekt in ArrayList von Partnermulti wiederauffindbar*/
	@Test
	public void test_Adresse_in_ArrayList_von_PartnerMulti_2() {
		assertTrue(p1.getAdressenList().contains(a3));
	}
	
	/**Objektgleichheit bei gleichen Objekten*/
	@Test
	public void test_Adressobjektgleichheit() {
		assertEquals(a2,a3);
	}
	
	/**Objektidentität bei Adressobjekten*/
	@Test
	public void test_Adressobjektidentitaet() {
		assertNotSame(a2,a3);
	}
	
}


