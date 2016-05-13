package Aufgabe02;

/**
 @author: Chris Thiele
 @author: Lydia Pflug
 @date: 12.05.2016
 Diese Klasse stellt eine
 */

public class Queue<T> {
    private T type;
    private int kapazitaet;
    private Object[] array;

    public Queue(T type, int kapazitaet){
        this.type = type;
        this.kapazitaet = kapazitaet;
        this.array = new Object[kapazitaet];
    }

    public int getAnzahlElemente(){
        return array.length;
    }

    public int getKapazitaet(){
        return kapazitaet;
    }
}
