package Aufgabe01;

import java.util.Collections;
import java.util.HashSet;


/**
@author: Chris Thiele
@author: Lydia Pflug
@date: 08.05.2016
Diese Klasse  modelliert einen Partner mit allen Eigenschaften (Name, Vorname, Geburtsdatum), dem mehrere Adressen zugewiesen werden können.
*/
public class PartnerMulti extends Partner {
    private HashSet<AdresseMulti> adressenSet;

    /** 2 Konstruktoren, um "* zu *" Beziehung darstellen zu können.*/
    public PartnerMulti(String name, String vorname, int jahr, int monat, int tag, HashSet<AdresseMulti> adressenSet) {
        super(name, vorname, jahr, monat, tag);
        this.adressenSet = adressenSet;
        adressenSet = new HashSet<AdresseMulti>();
    }

    public PartnerMulti(String name, String vorname, int jahr, int monat, int tag){
        super(name, vorname, jahr, monat, tag);
        adressenSet = new HashSet<AdresseMulti>();
    }

    /** Get und Set Methoden bzw. Entfernen und Hinzufügen von Adressen*/
    public void addAdresse(AdresseMulti adresse) {
        if (!(adressenSet.contains(adresse))) {
            adressenSet.add(adresse);
        }
    }

    public void removeAdresse(AdresseMulti adresse){
        if(adressenSet.contains(adresse)){
            adressenSet.remove(adresse);
        }
    }

    public HashSet<AdresseMulti> getAdressenSet(){
        return (HashSet<AdresseMulti>) Collections.unmodifiableSet(adressenSet);
    }

	@Override
	public String toString() {
		return super.toString() + "\n"+ "Adressen: " + adressenSet;
	}
}