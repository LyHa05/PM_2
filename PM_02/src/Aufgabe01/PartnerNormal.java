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

    /** 2 Konstruktoren, um 1 zu * Beziehung darstellen zu können.*/
    public PartnerNormal(String name, String vorname, Date geburtsdatum, Adresse adresse){
        super(name, vorname, geburtsdatum);
        this.adresse = adresse;
    }

    public PartnerNormal(String name, String vorname, Date geburtsdatum){
        super(name, vorname, geburtsdatum);
    }

    /** Get und Set Methoden*/
    public Adresse getAdresse(){
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

	@Override
	public String toString() {
		return super.toString() + this.adresse.toString();
	}

}