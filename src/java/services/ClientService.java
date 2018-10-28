/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import classes.Client;
import dao.IDao;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author PC
 */
public class ClientService implements IDao<Client>{

    @Override
    public void create(Client o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Client findById(int id) {
        Client c = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        c = (Client) session.get(Client.class, id);
        session.getTransaction().commit();
        session.close();
        return c;
    }

    @Override
    public void update(Client o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Client o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List findAll() {
        List<Client> client = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        client = session.createQuery("FROM Client").list();
        session.getTransaction().commit();
        session.close();
        return client;
    }

}
