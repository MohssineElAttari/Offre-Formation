/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.salah.service;

import ch.salah.classes.Diplome;
import ch.salah.dao.IDao;
import ch.salah.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author AbderrahmanGu3
 */
public class DiplomeService implements IDao<Diplome>{
    
    @Override
    public void create(Diplome o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.clear();
    }

    @Override
    public Diplome findById(int id) {
        Diplome d = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        d = (Diplome) session.get(Diplome.class,id);
        session.getTransaction().commit();
        session.clear();
        return d;
    }

    @Override
    public void update(Diplome o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.clear();
    }

    @Override
    public void delete(Diplome o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.clear();
    }

    @Override
    public List<Diplome> findAll() {
        List<Diplome> diplomes = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        diplomes = session.createQuery("select Diplome").list();
        session.getTransaction().commit();
        session.clear();
        return diplomes;
    }
    
    
    
}
