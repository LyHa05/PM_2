package Aufgabe01;

import java.util.ArrayList;


/**
 @author: Chris Thiele
 @author: Lydia Pflug
 @date: 08.05.2016
Diese Klasse modelliert eine Adresse mit allen Eigenschaften (Strasse mit Hausnummer, PLZ Ort und Land), die  mehreren Partner zugewiesen werden kann.
*/
public class AdresseMulti extends Adresse {
    private ArrayList<Partner> partnerList;

    /** 2 Konstruktoren, um "1 zu *" und "* zu *" Beziehung darstellen zu können.*/
    public AdresseMulti(String strasse, int hausnummer, int plz, String ort, String land, ArrayList<Partner> partnerList){
        super(strasse, hausnummer, plz, ort, land);
        this.partnerList = partnerList;
        partnerList = new ArrayList<Partner>();
    }

    public AdresseMulti(String strasse, int hausnummer, int plz, String ort, String land){
        super(strasse, hausnummer, plz, ort, land);
        partnerList = new ArrayList<Partner>();
    }

    /** Get und Set Methoden bzw. Entfernen und Hinzufügen von Partnern*/
    public void addPartner(Partner partner){
        if(!(partnerList.contains(partner))){
            partnerList.add(partner);
        }
    }

    public void removePartner(Partner partner){
        if(partnerList.contains(partner)){
            partnerList.remove(partner);
        }
    }

    public ArrayList<Partner> getPartnerList(){
        return partnerList;
    }

	@Override
	public String toString() {
		return " Partner: " + partnerList;
	}

}


