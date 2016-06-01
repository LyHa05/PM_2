package Aufgabe042;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Predicate;

/**
 * Created by chris on 01.06.16.
 */
public class TestPredicateUtilty {
    public Predicate<String> doppelBuchstabeSN, ganzKomisch, doppelVocale, eAnStelleX, palindromeMitSechsBuchsten;

    @Before
    public void setUp(){
        doppelBuchstabeSN = PredicateUtilty.andAll(s -> s.contains("ss"),
                s -> s.contains("nn"));

        ganzKomisch = PredicateUtilty.andAll(s -> s.startsWith("x"), s -> s.contains("wk"));

        doppelVocale = PredicateUtilty.orAny(s -> s.contains("aa"),
                s -> s.contains("ee"),
                s -> s.contains("ii"),
                s -> s.contains("oo"),
                s -> s.contains("uu"));

        eAnStelleX = PredicateUtilty.andAll(s -> s.length() >= 6,
                s -> s.charAt(1) == 'e',
                s -> s.charAt(3) == 'e',
                s -> s.charAt(5) == 'e');

        palindromeMitSechsBuchsten = PredicateUtilty.andAll(s -> s.length() == 6,
                s -> s.charAt(0) == s.charAt(5),
                s -> s.charAt(1) == s.charAt(4),
                s -> s.charAt(2) == s.charAt(3));
    }

    @Test
    public void testPredicate(){
        System.out.println("testPredicate");
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
        try {
            Files.lines(Paths.get("src/Aufgabe042/scrabble.txt")).filter(s -> s != null)
                    .filter(eAnStelleX).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------");
    }
}
