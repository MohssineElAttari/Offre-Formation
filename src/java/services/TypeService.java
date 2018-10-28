/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import classes.Type;
import dao.IDao;
import util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author dell
 */
public class TypeService implements IDao<Type>{

    @Override
    public void create(Type o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
    }
    
    public List<Type> findAll(){
        List<Type> type = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        type = session.createQuery("from Type").list();
        session.getTransaction().commit();
        session.close();
        return type;
    }

    @Override
    public void delete(Type o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Type findById(int id) {
        Type s = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        s = (Type) session.get(Type.class, id);
        session.getTransaction().commit();
        session.close();
        return s;
    }

    @Override
     public void update(Type o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
    }
    
}
