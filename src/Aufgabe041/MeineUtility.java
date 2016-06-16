package Aufgabe041;

import Aufgabe054.Copyright;

/**
 * @author: Chris Thiele
 * @author: Lydia Pflug
 * @date: 01.07.2016
 * Klasse MeineUtility, die mit Mehtode betterElement das beste Element zurückgibt.
 */

@Copyright(copyRightInhaber = "wir", jahr = 2016)
public class MeineUtility {
	
	private MeineUtility() {
	}

	public static <T> T betterElement(T element1, T element2, MeinInterface<T> f ) {
		if(f.vergleichenVonZweiEigenschaften(element1, element2)) {
			return element1;
		} else {
			return element2;
		}
	}
}
