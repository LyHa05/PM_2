package Aufgabe051;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Predicate;

import Aufgabe042.PredicateUtility;

/**
 * Created by abz826 on 07.06.2016.
 */
public class DateiLesen {
	
    public static Predicate<String> verseMitKapiteln;
	
    private DateiLesen() {
    	
    	verseMitKapiteln = PredicateUtility.andAll(
                s -> s.charAt(4) == '3',
                s -> s.charAt(4) == ':',
                s -> s.charAt(4) == '1',
                s -> s.charAt(4) == '6');
    	
    }
	
	

	
	
	public static void main(String[] args) {
		
    	verseMitKapiteln = PredicateUtility.andAll(s -> s.charAt(4) == '3',
                s -> s.charAt(5) == ':',
                s -> s.charAt(6) == '1',
                s -> s.charAt(7) == '6');
		
		 try {
			 Files.lines(Paths.get("src/Aufgabe051/Input/Martin_Luther_Uebersetzung_1912.txt")).filter(s -> s != null).
			 filter(verseMitKapiteln).forEach(System.out::println);
	      } catch (IOException e) {
	            e.printStackTrace();
	      }
	
	}
		 
}

