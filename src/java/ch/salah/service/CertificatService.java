/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.salah.service;

import ch.salah.classes.Certificat;
import ch.salah.dao.IDao;
import ch.salah.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ZAHIRA
 */
public class CertificatService implements IDao<Certificat> {

    @Override
    public void create(Certificat o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Certificat findById(int id) {
        Certificat c = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        c = (Certificat) session.get(Certificat.class, id);
        session.getTransaction().commit();
        session.close();
        return c;
    }

    @Override
    public void update(Certificat o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Certificat o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Certificat> findAll() {
        List<Certificat> certificat = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        certificat = session.createQuery("From Certificat").list();
        session.getTransaction().commit();
        session.close();
        return certificat;
    }

}
