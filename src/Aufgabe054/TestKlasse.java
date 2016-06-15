package Aufgabe054;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Collections.*;

import org.junit.Test;

/**
 * @author: Chris Thiele
 * @author: Lydia Pflug
 * @date: 12.06.2016 Diese Klasse testet die verschiedenen Möglichkeiten bei Reflecion.
 */

public class TestKlasse {
	
	/**Methode testet verändertes privates Attribut.*/
	@Test
	public void testAttribut() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, InstantiationException, InvocationTargetException {
		
		Constructor<MeineKlasse> meinKlassenKonstruktor = MeineKlasse.class.getDeclaredConstructor();
		meinKlassenKonstruktor.setAccessible(true);
		MeineKlasse mk1 = (MeineKlasse)meinKlassenKonstruktor.newInstance();

		Field zahl1Field = MeineKlasse.class.getDeclaredField("zahl1");
		zahl1Field.setAccessible(true);
		zahl1Field.set(mk1,2);
		
		assertEquals(2,zahl1Field.get(mk1));
	}
	
	/**Methode fragt default-Konstruktor ab. */
	@Test
	public void testKonstrktor() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, InstantiationException, InvocationTargetException, NoSuchMethodException {
		
		Constructor<MeineKlasse> meinKlassenKonstruktor = MeineKlasse.class.getDeclaredConstructor();
		meinKlassenKonstruktor.setAccessible(true);
		MeineKlasse mk2 = (MeineKlasse)meinKlassenKonstruktor.newInstance();

		Field zahl2Field = MeineKlasse.class.getDeclaredField("zahl2");
		
		zahl2Field.setAccessible(true);
		
		assertEquals(0,zahl2Field.get(mk2));
	}
	
	
	/**Methode erstellt von inneren Klasse ein neues Objekt*/
	@Test
	public void testInnereKlasse() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
			
		Constructor<Collections> collectorsKonstruktor = Collections.class.getDeclaredConstructor();
		collectorsKonstruktor.setAccessible(true);
		Collections c = (Collections)collectorsKonstruktor.newInstance();
		Constructor<Collections> reverseComparatorKonstruktor = Collections.class.getEnclosingConstructor();
		
//		Constructor<Collections> reverseComparatorKonstruktor = Collections.ReverseCompartor.class.getDeclaredConstructor().getClass();
				
	}
	
	@Test
	public void testSingleton() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		MeinSingleton.INSTANZ.getMeinSingleton() = MeinSingleton
				
				ms1 = (MeinSingleton)meinKlassenKonstruktor.newInstance();

		Field zahl2Field = MeineKlasse.class.getDeclaredField("zahl2");
		
		zahl2Field.setAccessible(true);
		
		assertEquals(0,zahl2Field.get(mk2));
		
		Constructor<MeinSingleton> meinSingletonKonstruktor =  MeinSingleton.class.getDeclaredConstructor();
		meinSingletonKonstruktor.setAccessible(true);
		MeinSingleton ms1 = (MeinSingleton)meinSingletonKonstruktor.newInstance();
		
		field.set(this, Enum.valueOf((Class<Enum>) field.getType(), value));
		
	}
	
	
	

}
