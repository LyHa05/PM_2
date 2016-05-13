package Aufgabe01;

/**
@author: Chris Thiele
@author: Lydia Pflug
@date: 08.05.2016
Diese Klasse modelliert einen Partner mit allen Eigenschaften (Name, Vorname, Geburtsdatum), dem eine Adresse zugewiesen werden kann.
*/

public class PartnerSingle extends Partner{
    private Adresse adresse;

    /** 3 Konstruktoren, um "1 zu 1" Beziehung darstellen zu können und um zu verhindern, dass ein Partner ohne Adresse erstellt werden kann.*/
    public PartnerSingle(String name, String vorname, int jahr, int monat, int tag, Adresse adresse){
        super(name, vorname, jahr, monat, tag);
        this.adresse = adresse;
    }

    public PartnerSingle(String name, String vorname, int jahr, int monat, int tag, String strasse, int hausnummer, String plz, String ort, String land){
        super(name, vorname, jahr, monat, tag);
        
        AdresseSingle a = new AdresseSingle(strasse, hausnummer, plz, ort, land, this);
        this.setAdresse(a);
        
    }
    
    public PartnerSingle(String name, String vorname, int jahr, int monat, int tag){
    	super(name, vorname, jahr, monat, tag);
    	throw new IllegalArgumentException("PartnerSingle kann nur mit Adresse erstellt!");
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