package Aufgabe01;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
@author: Chris Thiele
@author: Lydia Pflug
@date: 08.05.2016
Diese Klasse modelliert einen Partner mit allen Eigenschaften (Name, Vorname, Geburtsdatum), dem mehrere Adressen zugewiesen werden können.
*/
public class PartnerMulti extends Partner {
    private ArrayList<Adresse> adressenList;

    // Konstruktoren
    public PartnerMulti(String name, String vorname, Date geburtsdatum, ArrayList<Adresse> adressenList) {
        super(name, vorname, geburtsdatum);
        this.adressenList = adressenList;
        adressenList = new ArrayList<Adresse>();
    }

    public PartnerMulti(String name, String vorname, Date geburtsdatum){
        super(name, vorname, geburtsdatum);
        adressenList = new ArrayList<Adresse>();
    }

    // Get und Set Methoden
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

    // Override Methoden
    @Override
    public String toString(){
        String ausgabeAdressen = "";

        for(Adresse objekt : adressenList){
            ausgabeAdressen += ("\'" + objekt.getStrasse() + "\'");
            ausgabeAdressen += (objekt.getHausnummer() + "\'");
            ausgabeAdressen += (objekt.getPlz() + "\n");
            ausgabeAdressen += (objekt.getOrt() + "\n");
            ausgabeAdressen += (objekt.getLand() + "\n");
            ausgabeAdressen += "\'\'";
        }

        return  "Name           : " + getName() + "\'" +
                "Vorname        : " + getVorname() + "\'" +
                "Geburtsdatum   : " + getGeburtsdatum().toString() + "\'" +
                "Adresse        : \'" + ausgabeAdressen;
    }
}