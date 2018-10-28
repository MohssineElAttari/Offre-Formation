/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import classes.Formation;
import dao.IDao;
import util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author dell
 */
public class FormationService implements IDao<Formation>{

    @Override
    public void create(Formation o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
    }
    
    public List<Formation> findAll(){
        List<Formation> formations = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        formations = session.createQuery("From Formation").list();
        session.getTransaction().commit();
        session.close();
        return formations;
    }


    @Override
    public void delete(Formation o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Formation findById(int id) {
        Formation s = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        s = (Formation) session.get(Formation.class, id);
        session.getTransaction().commit();
        session.close();
        return s;
    }

    @Override
    public void update(Formation o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
    }

    public List<Object[]> getFormations() {
        List<Object[]> formations = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        formations = session.createQuery("Select f,p,t From Formation f, Professeur p, Type t where f.professeur.id = p.id and f.type.id = t.id").list();
        session.getTransaction().commit();
        session.close();
        return formations;
    }

//    public List<Object[]> getFormationsByInscription() {
//        List<Object[]> formations = null;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        formations = session.createQuery("Select f From Formation f, Professeur p, Type t where f.professeur.id = p.id and f.type.id = t.id and ").list();
//        session.getTransaction().commit();
//        session.close();
//        return formations;
//    }
    
}
