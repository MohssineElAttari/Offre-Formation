/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import classes.ClientFormation;
import dao.IDao;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Mr. Mohamed DAKIR
 */
public class ClientFormationService implements IDao<ClientFormation>{

    @Override
    public void create(ClientFormation o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public ClientFormation findById(int id) {
         ClientFormation cf = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        cf = (ClientFormation) session.get(ClientFormation.class, id);
        session.getTransaction().commit();
        session.close();
        return cf;
    }

    @Override
    public void update(ClientFormation o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(ClientFormation o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<ClientFormation> findAll() {
         List<ClientFormation> liste = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        liste = session.createQuery("from ClientFormation").list();
        session.getTransaction().commit();
        session.close();
        return liste;
    }
    
}
