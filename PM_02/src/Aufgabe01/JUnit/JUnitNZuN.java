package Aufgabe01.JUnit;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import Aufgabe01.AdresseMulti;
import Aufgabe01.PartnerMulti;

public class JUnitEinsZuN {

    public PartnerMulti p1;
    public PartnerMulti p2;
    public AdresseMulti a1;
    public AdresseMulti a2;

    @Before
    public void setUp() {

        this.p1 = new PartnerMulti("Meyer", "Ingo", new Date(1999, 05, 12));
        this.p2 = new PartnerMulti("Baecker", "Gustav", new Date(1979, 04,23));
        this.a1 = new AdresseMulti("Bruecke", 2, 11111, "Berghausen", "Dt");
        this.a2 = new AdresseMulti("Muelleimer", 5, 22222, "Wiesendorf", "Dt");
        p1.addAdresse(a1);
        p1.addAdresse(a2);
        a1.addPartner(p1);
        a2.addPartner(p2);
    }

    @Test
    public void test_() {
        assertEquals(a1, p1.getAdresse());
    }

    //
}


