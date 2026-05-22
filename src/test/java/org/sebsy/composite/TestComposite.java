package org.sebsy.composite;

import org.junit.Test;

import junit.framework.TestCase;

public class TestComposite extends TestCase {

    private static final double DELTA = 0.0000001;

    private Employe creerEmploye(String nom, String prenom, double salaire) {
        Employe employe = new Employe();
        employe.setNom(nom);
        employe.setPrenom(prenom);
        employe.setSalaire(salaire);
        return employe;
    }

    private Service creerService(String nom) {
        Service service = new Service();
        service.setNom(nom);
        return service;
    }

    private Service creerOrganisationDsin() {
        Service dsin = creerService("DSIN");
        dsin.addElement(creerEmploye("RASPEY", "Cécile", 10000));
        dsin.addElement(creerEmploye("BECHKAR", "Bilel", 8000));

        Service bigData = creerService("Big Data");
        bigData.addElement(creerEmploye("RANMEY", "JB", 7500));
        bigData.addElement(creerEmploye("DOE", "Jane", 3500));

        Service javaDev = creerService("Java Dev");
        javaDev.addElement(creerEmploye("GUINEAU", "KEVIN", 7500));
        javaDev.addElement(creerEmploye("MARTIN", "Paul", 3500));

        dsin.addElement(bigData);
        dsin.addElement(javaDev);
        return dsin;
    }

    @Test
    public void testEmployeCalculerSalaire() {
        Employe employe = creerEmploye("MARTIN", "Paul", 3500);
        assertEquals(3500, employe.calculerSalaire(), DELTA);
    }

    @Test
    public void testServiceVideCalculerSalaire() {
        Service service = creerService("Vide");
        assertEquals(0, service.calculerSalaire(), DELTA);
    }

    @Test
    public void testServiceBigDataCalculerSalaire() {
        Service bigData = creerService("Big Data");
        bigData.addElement(creerEmploye("RANMEY", "JB", 7500));
        bigData.addElement(creerEmploye("DOE", "Jane", 3500));
        assertEquals(11000, bigData.calculerSalaire(), DELTA);
    }

    @Test
    public void testServiceJavaDevCalculerSalaire() {
        Service javaDev = creerService("Java Dev");
        javaDev.addElement(creerEmploye("GUINEAU", "KEVIN", 7500));
        javaDev.addElement(creerEmploye("MARTIN", "Paul", 3500));
        assertEquals(11000, javaDev.calculerSalaire(), DELTA);
    }

    @Test
    public void testServiceDsinCalculerSalaire() {
        Service dsin = creerOrganisationDsin();
        assertEquals(40000, dsin.calculerSalaire(), DELTA);
    }
}
