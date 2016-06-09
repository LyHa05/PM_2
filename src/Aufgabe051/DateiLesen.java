package Aufgabe051;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author: Chris Thiele
 * @author: Lydia Pflug
 * @date: 01.07.2016
 * Diese Klasse verknuepft Predicates in einer Utility.
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

	public static void main(String[] args) {

		System.out.println(dateiEinlesen());

	}

}
