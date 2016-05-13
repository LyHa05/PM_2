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

    public void enqueue(T element){
        if(index == kapazitaet-1){
            throw new QueueFullException("Die Queue ist voll.");
        } else {
            array[index] = element;
            index++;
        }
    }

    public int getAnzahlElemente(){
        return array.length;
    }

    public int getKapazitaet(){
        return kapazitaet;
    }
}
