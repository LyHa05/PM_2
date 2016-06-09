package Aufgabe051;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Predicate;


/**
 * Created by abz826 on 07.06.2016.
 */
public class DateiLesen {
	
    public static Predicate<String> verseMitKapiteln() {
    	return aktuelleZeile -> aktuelleZeile.contains(" 3:16");
    }
	
//    private DateiLesen() {
//    	
//    	verseMitKapiteln = PredicateUtility.andAll(
//                s -> s.charAt(4) == '3',
//                s -> s.charAt(4) == ':',
//                s -> s.charAt(4) == '1',
//                s -> s.charAt(4) == '6');
//    	
//    }
    
    public static void dateiEinlesen() {
	
//    	try {
//    	verseMitKapiteln = PredicateUtility.andAll(s -> s.charAt(4) == '3',
//                s -> s.charAt(5) == ':',
//                s -> s.charAt(6) == '1',
//                s -> s.charAt(7) == '6');
		
		 try {
//			 File ausgabeFile = new File("src/Aufgabe051/Output/newfile.txt");
//			 ausgabeFile.setWritable(true);
//			 FileWriter fw = new FileWriter(ausgabeFile.getAbsoluteFile());
//			 BufferedWriter bw = new BufferedWriter(fw);
			
			 Files.lines(Paths.get("src/Aufgabe051/Input/Martin_Luther_Uebersetzung_1912.txt"), Charset.forName("ISO_8859_1")).filter(s -> s != null).
			 filter(verseMitKapiteln()).forEach(System.out::println);
			 
//			 bw.close();
			 			 
	      } catch (IOException e) {
	            e.printStackTrace();
	      }
		 
//    	} catch ()
	
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//    	verseMitKapiteln = PredicateUtility.andAll(s -> s.charAt(4) == '3',
//                s -> s.charAt(5) == ':',
//                s -> s.charAt(6) == '1',
//                s -> s.charAt(7) == '6');
    	
//		verseMitKapiteln = 
		
//		 try {
//			 File ausgabeFile = new File("src/Aufgabe051/Output/newfile.txt");
//			 ausgabeFile.setWritable(true);
//			 FileWriter fw = new FileWriter(ausgabeFile.getAbsoluteFile());
//			 BufferedWriter bw = new BufferedWriter(fw);
			
//			 Files.lines(Paths.get("src/Aufgabe051/Input/Martin_Luther_Uebersetzung_1912.txt"), Charset.forName("ISO_8859_1")).filter(s -> s != "").
//			 filter(verseMitKapiteln).forEach(System.out::println);
			 
//			 bw.close();
			 			 
//    } catch (IOException e) {
//        e.printStackTrace();
//  }
 
		dateiEinlesen();
	
	}
		 
}

