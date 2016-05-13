package Aufgabe01;

import java.util.HashSet;


/**
 @author: Chris Thiele
 @author: Lydia Pflug
 @date: 08.05.2016
Diese Klasse modelliert eine Adresse mit allen Eigenschaften (Strasse mit Hausnummer, PLZ Ort und Land), die  mehreren Partner zugewiesen werden kann.
*/
public class AdresseMulti extends Adresse {
    private HashSet<PartnerMulti> partnerSet;

    /** 2 Konstruktoren, um "* zu *" Beziehung darstellen zu können.*/
    public AdresseMulti(String strasse, int hausnummer, String plz, String ort, String land, HashSet<PartnerMulti> partnerSet){
        super(strasse, hausnummer, plz, ort, land);
        this.partnerSet = partnerSet;
        partnerSet = new HashSet<PartnerMulti>();
    }

    public AdresseMulti(String strasse, int hausnummer, String plz, String ort, String land){
        super(strasse, hausnummer, plz, ort, land);
        partnerSet = new HashSet<PartnerMulti>();
    }

    /** Get und Set Methoden bzw. Entfernen und Hinzufügen von Partnern*/
    public void addPartner(PartnerMulti partner){
        if(!(partnerSet.contains(partner))){
            partnerSet.add(partner);
        }
    }

    public void removePartner(PartnerMulti partner){
        if(partnerSet.contains(partner)){
            partnerSet.remove(partner);
        }
    }

    public HashSet<PartnerMulti> getPartnerSet(){
        return partnerSet;
    }

	@Override
	public String toString() {
		return " Partner: " + partnerSet;
	}

}


