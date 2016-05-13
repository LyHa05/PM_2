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

    public Queue(T type, int kapazitaet){
        if(kapazitaet <= 0){
            throw new IllegalArgumentException("Die Kapazitaet muss > 0 sein.");
        }
        this.kapazitaet = kapazitaet;
        this.array = new Object[kapazitaet];
        this.
    }

    public void enqueue(Object element){
        //if(== element.getClass() && array.length <= kapazitaet ){
//
  //      }
    }

    public int getAnzahlElemente(){
        return array.length;
    }

    public int getKapazitaet(){
        return kapazitaet;
    }
}
