/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import classes.Professeur_Diplome;
import dao.IDao;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Sinponzakra
 */
public class ProfesseurDiplomeService implements IDao<Professeur_Diplome>{
    @Override
    public void create(Professeur_Diplome o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Professeur_Diplome o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Professeur_Diplome o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Professeur_Diplome findById(int id) {
        Professeur_Diplome p = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        p = (Professeur_Diplome) session.get(Professeur_Diplome.class, id);
        session.getTransaction().commit();
        session.close();
        return p;
    }

    @Override
    public List findAll() {
        List<Professeur_Diplome> p = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        p = session.createQuery("from Professeur_Diplome").list();
        session.getTransaction().commit();
        session.close();
        return p;
    }
}
