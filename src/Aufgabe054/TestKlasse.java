package Aufgabe054;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

/**
 * @author: Chris Thiele
 * @author: Lydia Pflug
 * @date: 12.06.2016 Diese Klasse testet die verschiedenen Möglichkeiten bei Reflecion.
 */

public class TestKlasse {
	
	/**Methode testet verändertes privates Attribut.*/
	@Test
	public void testAttribut() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		MeineKlasse mk1 = new MeineKlasse();
		Field zahl1Field = MeineKlasse.class.getDeclaredField("zahl1");
		
		zahl1Field.setAccessible(true);
		
		zahl1Field.set(mk1,2);
		
		assertEquals(2,zahl1Field.get(mk1));
	}
	
	/**Methode fragt default-Konstruktor ab.*/
	@Test
	public void testKonstrktor() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		MeineKlasse mk2 = new MeineKlasse();
		Field zahl2Field = MeineKlasse.class.getDeclaredField("zahl2");
		
		zahl2Field.setAccessible(true);
		
		assertEquals(0,zahl2Field.get(mk2));
	}
	
	
	/**Methode erstellt von inneren Klasse ein neues Objekt*/
	@Test
	public void testInnereKlasse() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
			
		Class<?> aeussereKlasse = Class.forName("Collections");
//		Constructor<?> aeussererKonstruktor = aeussereKlasse.getDeclaredConstructor(aeussereKlasse);
		Object aeussereInstanz = aeussereKlasse.newInstance();
		
//		Object aeussereInstanz = aeussereKlasse.newInstance();

		Class<?> innereKlasse = Class.forName("Collections$ReverseComparator");
		Constructor<?> innererKonstruktor = innereKlasse.getDeclaredConstructor(aeussereKlasse);

		Object innerInstance = innererKonstruktor.newInstance(aeussereInstanz);
		
		innererKonstruktor.setAccessible(true);
		
		Collections aeussere = new Collections();
		
        Collections.ReverseComparator inner = innererKonstruktor.newInstance(aeussere);
        System.out.println(inner);
		
//		alle Konstruktoren mit Accessible auf true setzen, um irgendwie eine Chance zu haben
	
		
//		Collections.ReverseComparator.class.getConstructors()[0].newInstance(new Collections());
		
		
	}
	
	
	
	

}
