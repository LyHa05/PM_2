package Aufgabe041;

/**
 * @author: Chris Thiele
 * @author: Lydia Pflug
 * @date: 01.07.2016
 * Klasse MeineUtility, die mit Mehtode betterElement das beste Element zurückgibt.
 */

public class MeineUtility {

	public static <T> T betterElement(T element1, T element2, MeinInterface<T> f ) {
		if(f.vergleichenVonZweiEige
				nschaften(element1, element2) == true) {
			return element1;
		} else {
			return element2;
		}
	}
}