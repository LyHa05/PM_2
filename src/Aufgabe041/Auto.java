package Aufgabe041;

/**
 * @author: Chris Thiele
 * @author: Lydia Pflug
 * @date: 01.07.2016
 * Einfach Klasse Auto, um Implementierung der betterElement Methode mit einer weiteren Vergleichsmethode zu testen.
 */

public class Auto {
	
	int ps;
	String farbe;
	
	
	public Auto(int ps, String farbe) {
		this.ps = ps;
		this.farbe = farbe;
	}
	
	public boolean vergleichen(Auto other) {
		if (this.ps > other.ps) {
			return true;
		} else if (this.ps < other.ps) {
			return false;
		}
		return true;
	}

}
