package Aufgabe02;

/** @author: Chris Thiele
    @author: Lydia Pflug
    @date: 12.05.2016#
    Die Klasse 'Queue<T>' repraesentiert einen generischen Ringpuffer, welcher mit
    einem Array als interne Datenstruktur realisiert wird.
 */

import java.util.NoSuchElementException;

public class Queue<T> {
    private Object[] array;
    private int index_begin;
    private int index_ende;

    /** Der Konstruktor bekommt als Parameter einen Integer uebergeben, welcher > 0 sein
        muss, da dieser die Kapazitaet des Arrays repraesentiert.
    */
    public Queue(int kapazitaet){
        if(kapazitaet <= 0){
            throw new IllegalArgumentException("Die Kapazitaet muss > 0 sein.");
        }
        this.array = new Object[kapazitaet];
        this.index_begin = 0;
        this.index_ende = 0;
    }

    /** Die Methode enqueue fuegt ein neues Element in die Queue ein.
     *  Sollte die Queue voll sein, wird eine 'QueueFullException'
     *  geworfen. Ansonsten wird das Element an der aktuellen Stelle
     *  des Indexes eingefuegt und der index_begin um 1 inkrementiert.
     *  Sind Index und Kapazitaet gleich, wird der Index auf 1 gesetzt.*/

    public void enqueue(T element){
        if(this.getAnzahlElemente() == array.length){
            throw new IllegalStateException("Die Queue ist voll.");
        } else {
            array[index_begin] = element;
            if(index_begin == array.length-1){
                index_begin = 0;
            } else {
                index_begin++;
            }
        }
    }

    /** Die Methode dequeue entfernt das letzte Element aus der Queue.
     * Sollte die Queue leer sein wird eine 'EmptyQueueException' geworfen
     * Ansonsten wird das Element an der aktuellen Stelle
     * des Indexes eingefuegt und der index_begin um 1 inkrementiert.
     * Sind Index und Kapazitaet gleich, wird der Index auf 1 gesetzt.*/
    @SuppressWarnings("unchecked")
	public T dequeue(){
        T temp_element;

        if(this.getAnzahlElemente() == 0){
            throw new NoSuchElementException("Die Queue ist leer.");
        } else {

            temp_element = (T) array[index_ende];
            array[index_ende] = null;
            
            if(index_ende == array.length-1){
                index_ende = 0;
            } else {
                index_ende++;
            }

            return temp_element;
        }
    }

    /** Die Methode 'getAnzahlElemente' iteriert ueber die interne 
    *   Array Datenstruktur und zaehlt die Elemente welche != null
    *   sind. Am Ende wird diese Anzahl zurueck gegeben.*/

    public int getAnzahlElemente(){
        int elemente = 0;

        for(int i = 0; i < array.length; i++){
            if(array[i] != null){
               elemente++;
            }
        }

        return elemente;
    }

    /** Die Methode 'getKapazitaet' gibt die Kapazitaet der internen
    *   Array Datenstruktur zurueck. Hierbei wird die Konstante
        .length vom Array zurueck gegeben*/
    public int getKapazitaet(){
        return array.length;
    }

    /** Die Methode 'empty' liefert ein Boolean zurueck, ob der Array
        leer ist oder nicht */
    public boolean empty(){
        if(this.getAnzahlElemente() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /** Die Methode 'toString' liefert eine Darstellung der Elemente als
        String zurueck, sofern dies moeglich ist. */
    public String toString(){
        String temp_string = "";

        if(empty()){
            return "";
        } else {
            for(int i = 0; i < array.length; i++){
                if(array[i] != null){
                    temp_string = temp_string + " " + array[i].toString();
                }
            }
        }
        return temp_string;
    }
}
