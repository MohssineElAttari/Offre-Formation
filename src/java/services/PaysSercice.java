/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import classes.Pays;
import dao.IDao;
import util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Mustapha
 */
public class PaysSercice implements IDao <Pays>{

    @Override
    public void create(Pays o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Pays o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Pays o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Pays findById(int id) {
        Pays p = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        p = (Pays) session.get(Pays.class, id);
        session.getTransaction().commit();
        session.close();
        return p;
    }

    @Override
    public List findAll() {
        List<Pays> pays = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        pays = session.createQuery("from Pays").list();
        session.getTransaction().commit();
        session.close();
        return pays;
    }

}
