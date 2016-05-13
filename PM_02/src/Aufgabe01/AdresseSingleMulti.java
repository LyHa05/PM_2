package Aufgabe01;

/**
 @author: Chris Thiele
 @author: Lydia Pflug
 @date: 08.05.2016
Diese Klasse modelliert eine Adresse mit allen Eigenschaften (Strasse mit Hausnummer, PLZ Ort und Land), der ein Partner zugewiesen werden kann.
*/
public class AdresseSingleMulti extends Adresse {
    private PartnerSingleMulti partner;

    /** 3 Konstruktoren, um "1 zu *" Beziehung darstellen zu können und ein Erzeugen der Adresse ohne Partner zu verhindern.*/
    public AdresseSingleMulti(String strasse, int hausnummer, String plz, String ort, String land, PartnerSingleMulti partner){
        super(strasse, hausnummer, plz, ort, land);
        this.partner = partner;
    }

    public AdresseSingleMulti(String strasse, int hausnummer, String plz, String ort, String land, String name, String vorname, int jahr, int monat, int tag){
        super(strasse, hausnummer, plz, ort, land);
        PartnerSingleMulti p = new PartnerSingleMulti(name, vorname, jahr, monat, tag);
        this.setPartner(p);
    }
    
    /** veraltet, muss entfernt werden */
    public AdresseSingleMulti(String strasse, int hausnummer, String plz, String ort, String land){
        super(strasse, hausnummer, plz, ort, land);
        throw new IllegalArgumentException("Adresse darf nicht ohne Partner erstellt werden!");
    }
    

    /** Get und Set Methoden*/
    public PartnerSingleMulti getPartner(){
        return partner;
    }


    public void setPartner(PartnerSingleMulti partner) {
		this.partner = partner;
	}

	@Override
	public String toString() {
		return super.toString() + "Partner: " + partner;
	}
}


