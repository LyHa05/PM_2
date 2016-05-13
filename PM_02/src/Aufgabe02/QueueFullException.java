package Aufgabe02;

/**
 @author: Chris Thiele
 @author: Lydia Pflug
 @date: 12.05.2016
 Diese Klasse stellt eine
 */

public class QueueFullException extends RuntimeException {

    public QueueFullException(){
        super();
    }

    public QueueFullException(String message){
        super(message);
    }
}