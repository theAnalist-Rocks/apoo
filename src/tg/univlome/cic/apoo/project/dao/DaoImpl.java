/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.dao;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.hibernate.SessionFactory;
import tg.univlome.cic.apoo.project.utils.HibernateSessionFactory;

/**
 *
 * @author leBoulanger
 */
public class DaoImpl<T> implements IDao {
    private final EntityManager mymanager;
    

    public DaoImpl() {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.mymanager = sessionFactory.createEntityManager();
        this.mymanager.isOpen();
    }

    @Override
    public void supprimer(Object object) {
        EntityTransaction transaction = mymanager.getTransaction();
        try {
            transaction.begin();
            mymanager.remove(object);
            transaction.commit();
        }
        catch(Exception e) {
            transaction.rollback();
        }
    }

    public Object trouver(Object object, Long id) {
        EntityTransaction transaction = mymanager.getTransaction();
        Object found = null;
        try {
            transaction.begin();
            found = mymanager.find(Object.class, id);
        }catch(Exception ex) {
            transaction.rollback();
        }
        return found;
    }

    @Override
    public Object modifier(Object object) {
        EntityTransaction transaction = mymanager.getTransaction();
        Object found = null;
        try {
            transaction.begin();
            found = mymanager.merge(object);
            transaction.commit();
        }catch(Exception e) {
            transaction.rollback();
        }
        return found;
    }

//    @Override
//    public List lister() {
//        EntityTransaction transaction = mymanager.getTransaction();
//        List<Object> listFound = new ArrayList<>();
//        try {
//            transaction.begin();
//            listFound = mymanager.createQuery(sql).setParameter("", t)
//            transaction.commit();
//        }
//    }

    @Override
    public List lister(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List lister() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object ajouter(Object object) {
        EntityTransaction transaction = mymanager.getTransaction();
        try {
            transaction.begin();
            mymanager.persist(object);
            transaction.commit();
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return object;
    }

    @Override
    public void ajouter(Collection object) {
        for (Object object1 : object) {
            ajouter(object1);
        }
    }

    @Override
    public void modifier(Collection object) {
        for (Object object1 : object) {
            modifier(object1);
        }
    }
    
    
}
