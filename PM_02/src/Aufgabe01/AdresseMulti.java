package Aufgabe01;

import java.util.HashSet;


/**
 @author: Chris Thiele
 @author: Lydia Pflug
 @date: 08.05.2016
Diese Klasse modelliert eine Adresse mit allen Eigenschaften (Strasse mit Hausnummer, PLZ Ort und Land), die  mehreren Partner zugewiesen werden kann.
*/
public class AdresseMulti extends Adresse {
    private HashSet<Partner> partnerSet;

    /** 2 Konstruktoren, um "1 zu *" und "* zu *" Beziehung darstellen zu können.*/
    public AdresseMulti(String strasse, int hausnummer, String plz, String ort, String land, HashSet<Partner> partnerSet){
        super(strasse, hausnummer, plz, ort, land);
        this.partnerSet = partnerSet;
        partnerSet = new HashSet<Partner>();
    }

    public AdresseMulti(String strasse, int hausnummer, String plz, String ort, String land){
        super(strasse, hausnummer, plz, ort, land);
        partnerSet = new HashSet<Partner>();
    }

    /** Get und Set Methoden bzw. Entfernen und Hinzufügen von Partnern*/
    public void addPartner(Partner partner){
        if(!(partnerSet.contains(partner))){
            partnerSet.add(partner);
        }
    }

    public void removePartner(Partner partner){
        if(partnerSet.contains(partner)){
            partnerSet.remove(partner);
        }
    }

    public HashSet<Partner> getPartnerSet(){
        return partnerSet;
    }

	@Override
	public String toString() {
		return " Partner: " + partnerSet;
	}

}


