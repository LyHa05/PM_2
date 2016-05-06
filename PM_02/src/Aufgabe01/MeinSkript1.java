package Aufgabe01;

import java.sql.Date;

public class MeinSkript1 {

	public MeinSkript1() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		PartnerMulti p1 = new PartnerMulti("Meyer", "Ingo", new Date (1999, 05, 12));
		AdresseNormal a1 = new AdresseNormal("Bruecke", 2, 11111, "Berghausen", "Dt");
		AdresseNormal a2 = new AdresseNormal("Muelleimer", 5, 22222, "Wiesendorf", "Dt");
		PartnerNormal p2 = new PartnerNormal("Schmidt", "Marion", new Date(1977, 1, 1));
		System.out.println(p1);
		p1.addAdresse(a1);
		System.out.println(p1);
		p1.addAdresse(a2);
		System.out.println(p1);
	}

}


