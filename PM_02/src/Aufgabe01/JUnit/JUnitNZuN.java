package Aufgabe01.JUnit;

import static org.junit.Assert.*;
import java.sql.Date;
import org.junit.Before;
import org.junit.Test;
import Aufgabe01.AdresseMulti;
import Aufgabe01.PartnerMulti;

/**
@author: Chris Thiele
@author: Lydia Pflug
@date: 08.05.2016
Diese Klasse testet die N:N Assoziation zwischen Partner und Adresse.
*/

public class JUnitNZuN {

    public PartnerMulti p1;
    public PartnerMulti p2;
    public PartnerMulti p3;
    public PartnerMulti p4;
    public PartnerMulti p5;
    public PartnerMulti p6;
    public AdresseMulti a1;
    public AdresseMulti a2;
    public AdresseMulti a3;
    public AdresseMulti a4;
    public AdresseMulti a5;
    public AdresseMulti a6;

    @Before
    public void setUp() {

        /**Erzeugung Personen Objekte*/
        this.p1 = new PartnerMulti("Meyer", "Ingo", 1999, 05, 12);
        this.p2 = new PartnerMulti("Baecker", "Gustav", 1979, 04, 23);
        this.p3 = new PartnerMulti("Maier", "Otto", 1978, 04, 12);
        this.p4 = new PartnerMulti("Hans", "Peter", 1949, 12, 02);
        this.p5 = new PartnerMulti("Haahn", "Lisa", 1999, 07, 01);
        this.p6 = new PartnerMulti("Meyer", "Ingo", 1999, 05, 12);

        /**Erzeugung Adress Obejekte*/
        this.a1 = new AdresseMulti("Bruecke", 2, 11111, "Berghausen", "De");
        this.a2 = new AdresseMulti("Muelleimer", 5, 22222, "Wiesendorf", "De");
        this.a3 = new AdresseMulti("Muelleimer", 5, 22222, "Wiesendorf", "De");
        this.a4 = new AdresseMulti("Hansmeier Str", 23, 22941, "Sonstwo", "De");
        this.a5 = new AdresseMulti("Peterstruck Str", 42, 22222, "Irgendwo", "De");
        this.a6 = new AdresseMulti("Jockelsteig", 666, 42424, "Nirgendwo", "US");

        /** Weisen p1 Adressen a1 - a5 zu*/
        p1.addAdresse(a1);
        p1.addAdresse(a2);
        p1.addAdresse(a3);
        p1.addAdresse(a4);
        p1.addAdresse(a5);

        /** Weisen a4 Partner p4 - p6*/
        a4.addPartner(p4);
        a4.addPartner(p5);
        a4.addPartner(p6);
    }

    /**Adressenobjekt in ArrayList von Partnermulti wiederauffindbar*/
    @Test
    public void test_Adresse_in_ArrayList_von_PartnerMulti() {
        assertTrue(p1.getAdressenList().contains(a1));
    }

    /** Partnerobjekt in ArrayList von AdresseMulti wiederauffindbar*/
    @Test
    public void test_Partnerobjekt_in_ArrayList_von_AdresseMulti() {
        assertTrue(a4.getAdressenList().contains(p5));
    }

    /**Adressenobjekt in ArrayList von Partnermulti wiederauffindbar*/
    @Test
    public void test_Adresse_in_ArrayList_von_PartnerMulti_2() {
        assertTrue(p1.getAdressenList().contains(a3));
    }

    /** Partnerobjekt in ArrayList von AdresseMulti wiederauffindbar*/
    @Test
    public void test_Partnerobjekt_in_ArrayList_von_AdresseMulti_2() {
        assertTrue(a4.getAdressenList().contains(p6));
    }

    /**Objektgleichheit bei gleichen Objekten*/
    @Test
    public void test_Adressobjektgleichheit() {
        assertEquals(a2,a3);
    }

    /** Objektgleichheit bei gleichen Objekten*/
    @Test
    public void test_PartnerObjektGleichheit() {
        assertEquals(p1,p6);
    }

    /**Objektidentität bei Adressobjekten*/
    @Test
    public void test_Adressobjektidentitaet() {
        assertNotSame(a2,a3);
    }

    /** Objektidentität bei Adressobjekten*/
    @Test
    public void test_PersonenObjektIdentitaet() {
        assertNotSame(p1,p6);
    }
}


