/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import classes.Formation;
import classes.Professeur;
import classes.Specialite;
import classes.Type;
import java.util.Date;
import java.util.List;
import services.FormationService;
import services.ProfesseurService;
import services.SpecialiteService;
import services.TypeService;
import util.HibernateUtil;

/**
 *
 * @author Sinponzakra
 */
public class Main {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory().openSession();
        FormationService fs = new FormationService();
        ProfesseurService ps = new ProfesseurService();
        SpecialiteService ss = new SpecialiteService();
        TypeService ts = new TypeService();
//        Type t = new Type("Informatique");
//        ts.create(t);
//        Specialite s = new Specialite("JAVA/JEE","JAVA/JEE");
//        ss.create(s);
//        Professeur p =new Professeur("salah", "mst", "066666666", "email@g.com", new Date(), "homme", ss.findById(1));
//        ps.create(p);
//        Formation f = new Formation("java", "descr", "prerequis", new Date(), null, 10, "marrakech", ps.findById(1), ts.findById(1));
//        fs.create(f);
    }
}
