
import ch.salah.classes.Specialite;
import ch.salah.service.SpecialiteService;
import ch.salah.classes.Professeur;
import ch.salah.service.ProfesseurService;
import ch.salah.util.HibernateUtil;
import com.google.gson.Gson;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author salah
 */
public class ProfesseurSpecialite {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
//        org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
//        
//        SpecialiteService ss = new SpecialiteService();
//        ProfesseurService ps = new ProfesseurService();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        Date dateD = format.parse("2014-08-01");
//        Date dateF = format.parse("2017-10-18");
//        List<Professeur> profs = session.getNamedQuery("findBetweenDate").setParameter("dateD", dateD).setParameter("dateF", dateF).list();
//        for(Professeur p : profs){
//            System.out.println(" Professeur : " + p.getNom());
//        }
        
        //Professeur p = new Professeur();
//        for(Professeur p : ps.getProBySpe(ss.getById(4))){
//            System.out.println("Professeur : " + p.getNom() + " " + p.getPrenom());
//        }
//        p.setNom("Rami");p.setPrenom("imane");p.setEmail("rami@gmail.com");p.setSexe("F");p.setTelephone("066666666");
//        Specialite s = ss.getById(4);
//        p.setSpecialite(s);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        Date dateE = format.parse("2015-08-01");
//        p.setDateEmbouche(dateE);
//        ps.create(p);
//        Specialite s0 = new Specialite(0, "TDI", "JAVA/JEE");
//        Specialite s1 = new Specialite(0, "TDI", ".Net ");
//        Specialite s2 = new Specialite(0, "TDI", "Gestion de projet ");
//        Specialite s3 = new Specialite(0, "TDI", "CISCO");
//        Specialite s4 = new Specialite(0, "TDI", "PHP");
//        ss.create(s0);ss.create(s1);ss.create(s2);ss.create(s3);ss.create(s4);
        
        
    }
}
