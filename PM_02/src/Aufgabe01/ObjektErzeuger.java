package Aufgabe01;

public class ObjektErzeuger {

	public static Partner erzeugen(String name, String vorname, int jahr, int monat, int tag, String strasse, int hausnummer, int plz, String ort, String land) {
	
	PartnerNormal p = new PartnerNormal(name, vorname, jahr, monat, tag);
	AdresseNormal a = new AdresseNormal(strasse, hausnummer, plz, ort, land);
	
	p.setAdresse(a);
	
	return p;

	}
}
