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
    private int index;

    public Queue(int kapazitaet){
        if(kapazitaet <= 0){
            throw new IllegalArgumentException("Die Kapazitaet muss > 0 sein.");
        }
        this.kapazitaet = kapazitaet;
        this.array = new Object[kapazitaet];
        this.index = 0;
    }

    /** Die Methode enqueue fuegt ein neues Element in die Queue ein.
     *  Sollte die Queue voll sein, wird eine 'QueueFullException'
     *  geworfen. Ansonsten wird das Element an der aktuellen Stelle
     *  des Indexes eingefuegt und der index um 1 inkrementiert.
     *  Sind Index und Kapazitaet gleich, wird der Index auf 1 gesetzt.*/

    public void enqueue(T element){
        if(this.getAnzahlElemente() >= kapazitaet){
            throw new QueueFullException("Die Queue ist voll.");
        } else {
            array[index] = element;
            if(index == kapazitaet-1){
                index = 0;
            } else {
                index++;
            }
        }
    }

    public void dequeue(){

    }

    public int getAnzahlElemente(){
        return array.length;
    }

    public int getKapazitaet(){
        return kapazitaet;
    }
}
