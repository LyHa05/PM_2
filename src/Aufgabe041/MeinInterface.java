package Aufgabe041;

/**
 * @author: Chris Thiele
 * @author: Lydia Pflug
 * @date: 01.07.2016
 * Funktionales Interface, das Methode vergleichenVonZweiEigenschaften zur Verfügung stellt.
 */

@FunctionalInterface
public interface MeinInterface<T> {

	public boolean vergleichenVonZweiEigenschaften(T element1, T element2);
	
}