package Aufgabe042;

import java.util.function.Predicate;

/**
 * @author: Chris Thiele
 * @author: Lydia Pflug
 * @date: 01.07.2016
 * Diese Klasse verknuepft Predicates in einer Utility.
 */

public class PredicateUtility {

	private PredicateUtility(){}

	@SafeVarargs
	public static <T> Predicate<T> andAll(Predicate<T>... predicates ) {
		Predicate<T> result = null;

		for(Predicate<T> tempPre : predicates){
			if (result == null){
				result = tempPre;
			} else {
				result = result.and(tempPre);
			}
		}

		return result;
	}

	@SafeVarargs
	public static <T> Predicate<T> orAny(Predicate<T>... predicates){
		Predicate<T> result = null;

		for(Predicate<T> tempPre : predicates){
			if (result == null){
				result = tempPre;
			} else {
				result = result.or(tempPre);
			}
		}

		return result;
	}
}
