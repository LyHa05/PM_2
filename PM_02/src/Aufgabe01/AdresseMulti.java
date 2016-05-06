package Aufgabe01;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by chris on 02.05.16.
 */
public class AdresseMulti extends Adresse {
    private ArrayList<Partner> partnerList;

    // Konstruktoren
    public AdresseMulti(String strasse, int hausnummer, int plz, String ort, String land, ArrayList<Partner> partnerList){
        super(strasse, hausnummer, plz, ort, land);
        this.partnerList = partnerList;
        partnerList = new ArrayList<Partner>();
    }

    public AdresseMulti(String strasse, int hausnummer, int plz, String ort, String land){
        super(strasse, hausnummer, plz, ort, land);
        partnerList = new ArrayList<Partner>();
    }

    // Get und Set Methoden
    public void addPartner(Partner partner){
        if(!(partnerList.contains(partner))){
            partnerList.add(partner);
        }
    }

    public void removePartner(Adresse partner){
        if(partnerList.contains(partner)){
            partnerList.remove(partner);
        }
    }

    public ArrayList<Partner> getAdressenList(){
        return partnerList;
    }

}


