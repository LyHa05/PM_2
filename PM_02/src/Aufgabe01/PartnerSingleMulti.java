package Aufgabe01;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


/**
@author: Chris Thiele
@author: Lydia Pflug
@date: 08.05.2016
Diese Klasse  modelliert einen Partner mit allen Eigenschaften (Name, Vorname, Geburtsdatum), dem mehrere Adressen zugewiesen werden können.
*/
public class PartnerSingleMulti extends Partner {
    private Set<AdresseSingleMulti> adressenSet;

    /** 2 Konstruktoren, um "1 zu *" Beziehung darstellen zu können.*/
    public PartnerSingleMulti(String name, String vorname, int jahr, int monat, int tag, Set<AdresseSingleMulti> adressenSet) {
        super(name, vorname, jahr, monat, tag);
        this.adressenSet = adressenSet;
        adressenSet = new HashSet<AdresseSingleMulti>();
    }

    public PartnerSingleMulti(String name, String vorname, int jahr, int monat, int tag){
        super(name, vorname, jahr, monat, tag);
        adressenSet = new HashSet<AdresseSingleMulti>();
    }

    /** Get und Set Methoden bzw. Entfernen und Hinzufügen von Adressen*/
    public void addAdresse(AdresseSingleMulti adresse) {
        if (!(adressenSet.contains(adresse))) {
            adressenSet.add(adresse);
        }
    }

    public void removeAdresse(AdresseSingleMulti adresse){
        if(adressenSet.contains(adresse)){
            adressenSet.remove(adresse);
        }
    }

    public Set<AdresseSingleMulti> getAdressenSet(){
    	return Collections.unmodifiableSet(adressenSet);
    }

	@Override
	public String toString() {
		return super.toString() + "\n"+ "Adressen: " + adressenSet;
	}
}