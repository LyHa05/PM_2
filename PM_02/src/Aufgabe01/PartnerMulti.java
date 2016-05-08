package Aufgabe01;

import java.util.ArrayList;


/**
@author: Chris Thiele
@author: Lydia Pflug
@date: 08.05.2016
Diese Klasse modelliert einen Partner mit allen Eigenschaften (Name, Vorname, Geburtsdatum), dem mehrere Adressen zugewiesen werden können.
*/
public class PartnerMulti extends Partner {
    private ArrayList<Adresse> adressenList;

    /** 2 Konstruktoren, um "1 zu *" und "* zu *" Beziehung darstellen zu können.*/
    public PartnerMulti(String name, String vorname, int jahr, int monat, int tag, ArrayList<Adresse> adressenList) {
        super(name, vorname, jahr, monat, tag);
        this.adressenList = adressenList;
        adressenList = new ArrayList<Adresse>();
    }

    public PartnerMulti(String name, String vorname, int jahr, int monat, int tag){
        super(name, vorname, jahr, monat, tag);
        adressenList = new ArrayList<Adresse>();
    }

    /** Get und Set Methoden bzw. Entfernen und Hinzufügen von Adressen*/
    public void addAdresse(Adresse adresse) {
        if (!(adressenList.contains(adresse))) {
            adressenList.add(adresse);
        }
    }

    public void removeAdresse(Adresse adresse){
        if(adressenList.contains(adresse)){
            adressenList.remove(adresse);
        }
    }

    public ArrayList<Adresse> getAdressenList(){
        return adressenList;
    }

	@Override
	public String toString() {
		return super.toString() + "\n"+ "Adressen: " + adressenList;
	}
}