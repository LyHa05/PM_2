package Aufgabe01;

/**
@author: Chris Thiele
@author: Lydia Pflug
@date: 08.05.2016
Diese Klasse modelliert einen Partner mit allen Eigenschaften (Name, Vorname, Geburtsdatum), dem eine Adresse zugewiesen werden kann.
*/

public class PartnerSingle extends Partner{
    private Adresse adresse;

    /** 2 Konstruktoren, um "1 zu 1" und "1 zu *" Beziehung darstellen zu können.*/
    public PartnerSingle(String name, String vorname, int jahr, int monat, int tag, Adresse adresse){
        super(name, vorname, jahr, monat, tag);
        this.adresse = adresse;
    }

//    public PartnerSingle(String name, String vorname, int jahr, int monat, int tag){
//        super(name, vorname, jahr, monat, tag);
//    }

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