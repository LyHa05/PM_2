package Aufgabe01;

import java.sql.Date;
import java.time.LocalDate;

public class MeinSkript1 {

	public MeinSkript1() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		PartnerMulti p1 = new PartnerMulti("Meyer", "Ingo", 1995, 05, 04);
		AdresseSingle a1 = new AdresseSingle("Bruecke", 2, "11111", "Berghausen", "Dt");
		AdresseSingle a2 = new AdresseSingle("Muelleimer", 5, "22222", "Wiesendorf", "Dt");
		PartnerSingle p2 = new PartnerSingle("Schmidt", "Marion", 1977, 12, 01);
		
		
		System.out.println(p1);
		p1.addAdresse(a1);
		System.out.println(p1);
		p1.addAdresse(a2);
		System.out.println(p1);
		
	}

}


