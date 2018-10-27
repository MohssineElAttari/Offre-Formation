/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import classes.Professeur_Cerfiticat;
import dao.IDao;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Sinponzakra
 */
public class ProfesseurCertificatService implements IDao<Professeur_Cerfiticat>{
    @Override
    public void create(Professeur_Cerfiticat o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Professeur_Cerfiticat o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Professeur_Cerfiticat o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Professeur_Cerfiticat findById(int id) {
        Professeur_Cerfiticat p = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        p = (Professeur_Cerfiticat) session.get(Professeur_Cerfiticat.class, id);
        session.getTransaction().commit();
        session.close();
        return p;
    }

    @Override
    public List findAll() {
        List<Professeur_Cerfiticat> p = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        p = session.createQuery("from Professeur_Cerfiticat").list();
        session.getTransaction().commit();
        session.close();
        return p;
    }
}
