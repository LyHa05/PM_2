package Aufgabe051;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: Chris Thiele
 * @author: Lydia Pflug
 * @date: 12.06.2016
 * Diese Klasse liest eine Datei ein und filtert und zaehlt dann die enthaltenen Worte.
 */
public class DateiLesen {

	public static Predicate<String> verseMitKapiteln() {
		return aktuelleZeile -> aktuelleZeile.contains(" 3:16");
	}

	public static List<String> dateiEinlesen() {

		 List<String> stringListe = new ArrayList<String>();

		try {

			stringListe = Files.lines(Paths.get("src/Aufgabe051/Input/Martin_Luther_Uebersetzung_1912.txt"),
					Charset.forName("ISO_8859_1")).filter(verseMitKapiteln()).collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return stringListe;

	}
	
	public static Map<String, Integer> woerterZaehlen(List<String> gefilterteVerse) {
		Stream<String> woerter = Stream.of(gefilterteVerse.toString().replaceAll("[;*\\.*\\,*\\?*\\!*\\:*\\d+]", ""));
			
		Map<String, Integer> gezaehlteWoerter =woerter.map(w -> w.split(" "))
		                                   			.flatMap(Arrays::stream)
		                                   			.collect(Collectors.groupingBy(String::toLowerCase, Collectors.summingInt(s -> 1)));

		
		return gezaehlteWoerter;
	}


	public static void main(String[] args) {

		System.out.println(dateiEinlesen());
		System.out.println(woerterZaehlen(dateiEinlesen()));



	}

}
