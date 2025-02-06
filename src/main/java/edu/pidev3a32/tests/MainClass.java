package edu.pidev3a32.tests;

import edu.pidev3a32.entities.Personne;
import edu.pidev3a32.services.PersonneService;
import edu.pidev3a32.tools.MyConnection;

public class MainClass {
    public static void main(String[] args) {
        //MyConnection mc = new MyConnection();
        //Personne p = new Personne("Thomas", "Wayne");
        //ps.addEntity2(p);
        PersonneService ps = new PersonneService();
        System.out.println(ps.getAllData());
    }
}
