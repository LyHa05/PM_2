package Aufgabe02;

/**
 @author: Chris Thiele
 @author: Lydia Pflug
 @date: 12.05.2016
 Diese Klasse stellt eine
 */

public class Queue<T> {
    private int kapazitaet;
    private Object[] array;
    private int index_begin;
    private int index_ende;

    public Queue(int kapazitaet){
        if(kapazitaet <= 0){
            throw new IllegalArgumentException("Die Kapazitaet muss > 0 sein.");
        }
        this.kapazitaet = kapazitaet;
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
        if(this.getAnzahlElemente() <= kapazitaet){
            throw new QueueFullException("Die Queue ist voll.");
        } else {
            array[index_begin] = element;
            if(index_begin == kapazitaet-1){
                index_begin = 0;
            } else {
                index_begin++;
            }
        }
    }

    /** Die Methode dequeue entfernt das letzt*/

    public T dequeue(){
        if(this.getAnzahlElemente() == 0){
            throw new EmptyQueueException("Die Queue ist leer.");
        } else {
            int temp_end = index_ende;
            if(index_ende == kapazitaet-1){
                index_ende = 0;
            } else {
                index_ende++;
            }
            return (T) array[temp_end];
        }
    }

    public int getAnzahlElemente(){
        return array.length;
    }

    public int getKapazitaet(){
        return kapazitaet;
    }

    public boolean empty(){
        if(array.length == 0) {
            return true;
        } else {
            return false;
        }
    }
}
