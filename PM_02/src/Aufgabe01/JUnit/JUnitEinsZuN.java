package Aufgabe01.JUnit;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import Aufgabe01.AdresseNormal;
import Aufgabe01.PartnerNormal;

public class JUnitEinsZuN {

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

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
}


