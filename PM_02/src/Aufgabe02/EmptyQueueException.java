package Aufgabe02;

/**
 @author: Chris Thiele
 @author: Lydia Pflug
 @date: 12.05.2016
 Diese Klasse Stellt eine EmptyQueueException da, welche geworfen wird, wenn die Queue leer ist.
 */

public class EmptyQueueException extends RuntimeException {

    public EmptyQueueException(){
        super();
    }

    public EmptyQueueException(String message){
        super(message);
    }
}