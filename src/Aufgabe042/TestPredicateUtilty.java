package Aufgabe042;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Predicate;

/**
 * @author: Chris Thiele
 * @author: Lydia Pflug
 * @date: 01.07.2016 Diese Klasse testet die PredicateUtilty Klasse
 */

public class TestPredicateUtilty {
    public Predicate<String> doppelBuchstabeSN;
    public Predicate<String> ganzKomisch;
    public Predicate<String> doppelVocale;
    public Predicate<String> eAnStelleX;
    public Predicate<String> palindromeMitSechsBuchsten;

    @Before
    public void setUp() throws Exception {
        doppelBuchstabeSN = PredicateUtility.andAll(s -> s.contains("ss"),
                s -> s.contains("nn"));

        ganzKomisch = PredicateUtility.andAll(s -> s.startsWith("x"), s -> s.contains("wk"));

        doppelVocale = PredicateUtility.orAny(s -> s.contains("aa"),
                s -> s.contains("ee"),
                s -> s.contains("ii"),
                s -> s.contains("oo"),
                s -> s.contains("uu"));

        eAnStelleX = PredicateUtility.andAll(s -> s.length() >= 6,
                s -> s.charAt(1) == 'e',
                s -> s.charAt(3) == 'e',
                s -> s.charAt(5) == 'e');

        palindromeMitSechsBuchsten = PredicateUtility.andAll(s -> s.length() == 6,
                s -> s.charAt(0) == s.charAt(5),
                s -> s.charAt(1) == s.charAt(4),
                s -> s.charAt(2) == s.charAt(3));
    }

    @Test
    public void testPredicate(){
        System.out.println("testPredicate");
        System.out.println("-------------------------");
        try {
            Files.lines(Paths.get("src/Aufgabe042/scrabble.txt")).filter(s -> s != null)
                    .filter(doppelBuchstabeSN).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------");
    }

    @Test
    public void testPredicateDieZweite(){
        System.out.println("testPredicateDieZweite");
        System.out.println("-------------------------");
        try {
            Files.lines(Paths.get("src/Aufgabe042/scrabble.txt")).filter(s -> s != null)
                    .filter(ganzKomisch).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------");
    }

    @Test
    public void testDoppelVocale(){
        System.out.println("testDoppelVocale");
        System.out.println("-------------------------");
        try {
            Files.lines(Paths.get("src/Aufgabe042/scrabble.txt")).filter(s -> s != null)
                    .filter(doppelVocale).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------");
    }

    @Test
    public void Palindrome(){
        System.out.println("Palindrome");
        System.out.println("-------------------------");
        try {
            Files.lines(Paths.get("src/Aufgabe042/scrabble.txt")).filter(s -> s != null)
                    .filter(palindromeMitSechsBuchsten).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------");

    }

    @Test
    public void anStelle2Und4Und6E(){
        System.out.println("anStelle2Und4Und6E");
        System.out.println("-------------------------");
        try {
            Files.lines(Paths.get("src/Aufgabe042/scrabble.txt")).filter(s -> s != null)
                    .filter(eAnStelleX).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------");
    }
}
