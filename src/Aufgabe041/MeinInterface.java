package Aufgabe041;

import Aufgabe054.Copyright;

/**
 * @author: Chris Thiele
 * @author: Lydia Pflug
 * @date: 01.07.2016
 * Funktionales Interface, das Methode vergleichenVonZweiEigenschaften zur Verfügung stellt.
 */

@Copyright(copyRightInhaber = "wir", jahr = 2016)
@FunctionalInterface
public interface MeinInterface<T> {

	public boolean vergleichenVonZweiEigenschaften(T element1, T element2);
}