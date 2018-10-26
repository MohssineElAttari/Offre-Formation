/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.salah.service;

import ch.salah.classes.Specialite;
import ch.salah.dao.IDao;
import ch.salah.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author salah
 */
public class SpecialiteService implements IDao<Specialite>{

    @Override
    public void create(Specialite o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Specialite getById(int id) {
        Specialite s = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        s = (Specialite) session.get(Specialite.class, id);
        session.getTransaction().commit();
        session.close();
        return s;
    }
    
    public List<Specialite> findAll(){
        List<Specialite> spe = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        spe = session.createQuery("From Specialite").list();
        session.getTransaction().commit();
        session.close();
        return spe;
    }

    @Override
    public void delete(Specialite o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
