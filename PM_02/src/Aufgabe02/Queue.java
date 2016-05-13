package Aufgabe02;

/**
 @author: Chris Thiele
 @author: Lydia Pflug
 @date: 12.05.2016
 Diese Klasse stellt eine
 */

public class Queue<T> {
    private Object[] array;
    private int index_begin;
    private int index_ende;

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
            throw new QueueFullException("Die Queue ist voll.");
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
     * Wenn das Element */

    public T dequeue(){
        if(this.getAnzahlElemente() == 0){
            throw new EmptyQueueException("Die Queue ist leer.");
        } else {
            int temp_end = index_ende;
            if(index_ende == array.length-1){
                index_ende = 0;
            } else {
                index_ende++;
            }
            return (T) array[temp_end];
        }
    }

    public int getAnzahlElemente(){
        int elemente = 0;

        for(int i = 0; i <= array.length; i++){
            if(array[i] != null){
               elemente++;
            }
        }

        return elemente;
    }

    public int getKapazitaet(){
        return array.length;
    }

    public boolean empty(){
        if(this.getAnzahlElemente() == 0) {
            return true;
        } else {
            return false;
        }
    }
}