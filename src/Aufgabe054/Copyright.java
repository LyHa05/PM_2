package Aufgabe054;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;

/**
 * @author: Chris Thiele
 * @author: Lydia Pflug
 * @date: 12.06.2016
 * Beschreibt Annotation Copyright mit dem Inhaber und dem Jahr.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Copyright {
	String copyRightInhaber();
	int jahr();
}
