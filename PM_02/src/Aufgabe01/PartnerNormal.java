package Aufgabe01;

import java.util.Date;

/**
@author: Chris Thiele
@author: Lydia Pflug
@date: 08.05.2016
Diese Klasse modelliert einen Partner mit allen Eigenschaften (Name, Vorname, Geburtsdatum), dem eine Adresse zugewiesen werden kann.
*/
public class PartnerNormal extends Partner{
    private Adresse adresse;

    // Konstruktoren
    public PartnerNormal(String name, String vorname, Date geburtsdatum, Adresse adresse){
        super(name, vorname, geburtsdatum);
        this.adresse = adresse;
    }

    public PartnerNormal(String name, String vorname, Date geburtsdatum){
        super(name, vorname, geburtsdatum);
    }

    // Get und Set Methode
    public Adresse getAdresse(){
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    //Override Methode
    @Override
    public String toString(){
        String ausgabeAdressen = "";

        ausgabeAdressen += ("\'" + adresse.getStrasse() + "\'");
        ausgabeAdressen += (adresse.getHausnummer() + "\'");
        ausgabeAdressen += (adresse.getPlz() + "\n");
        ausgabeAdressen += (adresse.getOrt() + "\n");
        ausgabeAdressen += (adresse.getLand() + "\n");
        ausgabeAdressen += "\'\'";

        return  "Name           : " + getName() + "\'" +
                "Vorname        : " + getVorname() + "\'" +
                "Geburtsdatum   : " + getGeburtsdatum().toString() + "\'" +
                "Adresse        : \'" + ausgabeAdressen;
    }

}