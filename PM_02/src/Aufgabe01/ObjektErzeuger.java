package Aufgabe01;

public class ObjektErzeuger {

	public static PartnerSingle erzeugen(String name, String vorname, int jahr, int monat, int tag, String strasse, int hausnummer, String plz, String ort, String land) {
	
	PartnerSingle p = new PartnerSingle(name, vorname, jahr, monat, tag);
	AdresseSingle a = new AdresseSingle(strasse, hausnummer, plz, ort, land);
	
	p.setAdresse(a);
	a.setPartner(p);
	
	return p;

	}
}
