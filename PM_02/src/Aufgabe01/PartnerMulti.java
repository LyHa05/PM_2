package Aufgabe01;

import java.util.HashSet;


/**
@author: Chris Thiele
@author: Lydia Pflug
@date: 08.05.2016
Diese Klasse  modelliert einen Partner mit allen Eigenschaften (Name, Vorname, Geburtsdatum), dem mehrere Adressen zugewiesen werden können.
*/
public class PartnerMulti extends Partner {
    private HashSet<Adresse> adressenSet;

    /** 2 Konstruktoren, um "1 zu *" und "* zu *" Beziehung darstellen zu können.*/
    public PartnerMulti(String name, String vorname, int jahr, int monat, int tag, HashSet<Adresse> adressenList) {
        super(name, vorname, jahr, monat, tag);
        this.adressenSet = adressenList;
        adressenList = new HashSet<Adresse>();
    }

    public PartnerMulti(String name, String vorname, int jahr, int monat, int tag){
        super(name, vorname, jahr, monat, tag);
        adressenSet = new HashSet<Adresse>();
    }

    /** Get und Set Methoden bzw. Entfernen und Hinzufügen von Adressen*/
    public void addAdresse(Adresse adresse) {
        if (!(adressenSet.contains(adresse))) {
            adressenSet.add(adresse);
        }
    }

    public void removeAdresse(Adresse adresse){
        if(adressenSet.contains(adresse)){
            adressenSet.remove(adresse);
        }
    }

    public HashSet<Adresse> getAdressenList(){
        return adressenSet;
    }

	@Override
	public String toString() {
		return super.toString() + "\n"+ "Adressen: " + adressenSet;
	}
}