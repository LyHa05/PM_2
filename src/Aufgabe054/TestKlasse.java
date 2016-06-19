package Aufgabe054;

import static org.junit.Assert.assertEquals;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import Aufgabe041.MeinInterface;
import Aufgabe041.MeineUtility;

/**
 * @author: Chris Thiele
 * @author: Lydia Pflug
 * @date: 12.06.2016
 * Diese Klasse testet die verschiedenen Möglichkeiten bei Reflecion.
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
	public void testKonstruktor() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, InstantiationException, InvocationTargetException, NoSuchMethodException {
		
		Constructor<MeineKlasse> meinKlassenKonstruktor = MeineKlasse.class.getDeclaredConstructor();
		meinKlassenKonstruktor.setAccessible(true);
		MeineKlasse mk2 = (MeineKlasse)meinKlassenKonstruktor.newInstance();

		Field zahl2Field = MeineKlasse.class.getDeclaredField("zahl2");
		
		zahl2Field.setAccessible(true);
		
		assertEquals(0,zahl2Field.get(mk2));
	}
	
	/**Methode prueft Annotation bei MeineUtility. */
	@Test
	public void testAnnotationMeineUtility() {
	
		Class<MeineUtility> meineUtility = MeineUtility.class;
		Annotation[] annotationen = meineUtility.getAnnotations();
		
		for(Annotation annotationenIterator : annotationen){
			assertEquals(true,annotationenIterator instanceof Copyright);}
				
	}
	
	/**Methode prueft Annotation bei MeinIterface.*/
	@Test
	public void testAnnotationMeinInterface() {
	
		@SuppressWarnings("rawtypes")
		Class<MeinInterface> meinInterface = MeinInterface.class;
		Annotation[] annotationen = meinInterface.getAnnotations();
		
		for(Annotation annotationenIterator : annotationen){
			assertEquals(true,(annotationenIterator instanceof Copyright) ||(annotationenIterator instanceof FunctionalInterface));}
				
	}

}
