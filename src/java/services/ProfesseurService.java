/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import classes.Professeur;
import classes.Specialite;
import dao.IDao;
import util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author salah
 */
public class ProfesseurService implements IDao<Professeur>{

    @Override
    public void create(Professeur o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
    }

    
    public List<Professeur> getProBySpe(Specialite s){
        List<Professeur> profs = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        profs =  session.createQuery("From Professeur where specialite = "+s.getId()).list();
        session.getTransaction().commit();
        session.close();
        return profs;
    }
    
    public List<Object[]> getProfs(){
        List<Object[]> profs = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        profs =  session.createQuery("Select p,s From Professeur p,Specialite s where p.specialite.id = s.id").list();
        session.getTransaction().commit();
        session.close();
        return profs;
    }

    @Override
    public void delete(Professeur o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Professeur findById(int id) {
        Professeur p = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        p = (Professeur) session.get(Professeur.class, id);
        session.getTransaction().commit();
        session.close();
        return p;
    }

    @Override
    public void update(Professeur o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Professeur> findAll() {
        List<Professeur> profs = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        profs =  session.createQuery("From Professeur order by nom").list();
        session.getTransaction().commit();
        session.close();
        return profs;
    }
    
}
