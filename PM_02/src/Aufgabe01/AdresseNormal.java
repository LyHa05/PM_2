package Aufgabe01;

/**
 @author: Chris Thiele
 @author: Lydia Pflug
 @date: 08.05.2016
Diese Klasse modelliert eine Adresse mit allen Eigenschaften (Strasse mit Hausnummer, PLZ Ort und Land), der ein Partner zugewiesen werden kann.
*/
public class AdresseNormal extends Adresse {
    private Partner partner;

    // Konstruktoren
    public AdresseNormal(String strasse, int hausnummer, int plz, String ort, String land, Partner partner){
        super(strasse, hausnummer, plz, ort, land);
        this.partner = partner;
    }

    public AdresseNormal(String strasse, int hausnummer, int plz, String ort, String land){
        super(strasse, hausnummer, plz, ort, land);
    }

    // Get und Set Methoden
    public Partner getPartner(){
        return partner;
    }


    public void setPartner(Partner partner) {
		this.partner = partner;
	}

	// Override Methods
    @Override
    public String toString() {
        return "Adresse{" +
                "strasse='" + getStrasse() + '\'' +
                ", hausnummer=" + getHausnummer() +
                ", plz=" + getPlz() +
                ", land='" + getLand() + '\'' +
                '}';
    }
}


