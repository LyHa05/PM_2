package Aufgabe01;

/**
 @author: Chris Thiele
 @author: Lydia Pflug
 @date: 08.05.2016
Diese Klasse modelliert eine Adresse mit allen Eigenschaften (Strasse mit Hausnummer, PLZ Ort und Land), der ein Partner zugewiesen werden kann.
*/
public class AdresseSingle extends Adresse {
    private Partner partner;

    /** 2 Konstruktoren, um "1 zu 1" und "1 zu *" Beziehung darstellen zu können.*/
    public AdresseSingle(String strasse, int hausnummer, String plz, String ort, String land, Partner partner){
        super(strasse, hausnummer, plz, ort, land);
        this.partner = partner;
    }

    
    /** veraltet, muss entfernt werden */
    public AdresseSingle(String strasse, int hausnummer, String plz, String ort, String land){
        super(strasse, hausnummer, plz, ort, land);
    }
    

    /** Get und Set Methoden*/
    public Partner getPartner(){
        return partner;
    }


    public void setPartner(Partner partner) {
		this.partner = partner;
	}

	@Override
	public String toString() {
		return super.toString() + "Partner: " + partner;
	}
}


