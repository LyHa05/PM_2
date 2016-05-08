package Aufgabe01;

import java.time.LocalDate;

/**
@author: Chris Thiele
@author: Lydia Pflug
@date: 08.05.2016
Diese Klasse modelliert einen Partner mit allen Eigenschaften (Name, Vorname, Geburtsdatum).
*/
public class Partner {
    private String name;
    private String vorname;
    private LocalDate geburtsdatum;

    /** Konstruktor*/
    public Partner(String name, String vorname, int jahr, int monat, int tag){
        this.name = name;
        this.vorname = vorname;
        this.geburtsdatum = LocalDate.of(jahr, monat, tag);
    }

//    public Partner(String name, String vorname){
//        this.name = name;
//        this.vorname = vorname;
//    }

    /** Get und Set Methoden*/
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getVorname(){
        return vorname;
    }

    public void setVorname(String vorname){
        this.vorname = vorname;
    }

    public LocalDate getGeburtsdatum(){
        return geburtsdatum;
    }

    public void setGeburtsdatum(LocalDate geburtsdatum){
        this.geburtsdatum = geburtsdatum;
    }

    /** Anpassung von equals() und hashCode() an Klasse*/
    @Override
    public boolean equals(Object obj){

        if(this == obj){
            return true;
        }

        if(obj == null){
            return false;
        }

        if(obj.getClass() != getClass()){
            return false;
        }
        Partner other = (Partner) obj;

        if(this.name.equals(other.name) && this.vorname.equals(other.vorname) && this.geburtsdatum.equals(other.geburtsdatum)){
            return true;
        } else {
            return false;
        }

    }
    
    /** Anpassung von equals() und hashCode() an Klasse*/
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (vorname != null ? vorname.hashCode() : 0);
        result = 31 * result + (geburtsdatum != null ? geburtsdatum.hashCode() : 0);
        return result;
    }

	@Override
	public String toString() {
		return "Partner: " + vorname + " " + name + ", geboren am " + geburtsdatum;
	}
}

