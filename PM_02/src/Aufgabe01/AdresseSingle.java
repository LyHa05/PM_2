package Aufgabe01;

/**
 @author: Chris Thiele
 @author: Lydia Pflug
 @date: 08.05.2016
Diese Klasse modelliert eine Adresse mit allen Eigenschaften (Strasse mit Hausnummer, PLZ Ort und Land), der ein Partner zugewiesen werden kann.
*/
public class AdresseSingle extends Adresse {
    private PartnerSingle partner;

    /** 3 Konstruktoren, um "1 zu 1" Beziehung darstellen zu können und zu verhindern, dass eine Adresse ohne Partner erstellt wird.*/
    public AdresseSingle(String strasse, int hausnummer, String plz, String ort, String land, PartnerSingle partner){
        super(strasse, hausnummer, plz, ort, land);
        this.partner = partner;
    }

    public AdresseSingle(String strasse, int hausnummer, String plz, String ort, String land, String name, String vorname, int jahr, int monat, int tag){
        super(strasse, hausnummer, plz, ort, land);
        PartnerSingle p = new PartnerSingle(name, vorname, jahr, monat, tag, this);
        this.setPartner(p);
    }
    
    public AdresseSingle(String strasse, int hausnummer, String plz, String ort, String land){
        super(strasse, hausnummer, plz, ort, land);
        throw new IllegalArgumentException("Adresse darf nicht ohne Partner erstellt werden!");
    }
    

    /** Get und Set Methoden*/
    public PartnerSingle getPartner(){
        return partner;
    }


    public void setPartner(PartnerSingle partner) {
		this.partner = partner;
	}

	@Override
	public String toString() {
		return super.toString() + "Partner: " + partner;
	}
}


