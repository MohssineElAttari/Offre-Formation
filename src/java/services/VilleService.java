/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import classes.Ville;
import dao.IDao;
import util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Mustapha
 */
public class VilleService implements IDao<Ville> {

    @Override
    public void create(Ville o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Ville o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Ville o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Ville findById(int id) {
        Ville v = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        v = (Ville) session.get(Ville.class, id);
        session.getTransaction().commit();
        session.close();
        return v;
    }

    @Override
    public List findAll() {
        List<Ville> ville = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ville = session.createQuery("from Ville").list();
        session.getTransaction().commit();
        session.close();
        return ville;
    }
}
