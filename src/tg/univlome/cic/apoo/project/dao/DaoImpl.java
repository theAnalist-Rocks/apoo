/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.hibernate.SessionFactory;
import tg.univlome.cic.apoo.project.entities.Classe;
import tg.univlome.cic.apoo.project.utils.HibernateSessionFactory;

/**
 *
 * @author leBoulanger
 */
public class DaoImpl<T> implements IDao {
    private final EntityManager manager;
    

    public DaoImpl() {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }

    @Override
    public void supprimer(Object object) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.remove(object);
            transaction.commit();
        }
        catch(Exception e) {
            transaction.rollback();
        }
    }

    @Override
    public Object trouver(Object object, Long id) {
        EntityTransaction transaction = manager.getTransaction();
        Object found = null;
        try {
            transaction.begin();
            found = manager.find(Object.class, id);
        }catch(Exception ex) {
            transaction.rollback();
        }
        return found;
    }

    @Override
    public Object modifier(Object object, Long id) {
        EntityTransaction transaction = manager.getTransaction();
        Object found = null;
        try {
            transaction.begin();
            found = manager.find(Object.class, id);
            transaction.commit();
        }catch(Exception e) {
            transaction.rollback();
        }
        return found;
    }

//    @Override
//    public List lister() {
//        EntityTransaction transaction = manager.getTransaction();
//        List<Object> listFound = new ArrayList<>();
//        try {
//            transaction.begin();
//            listFound = manager.createQuery(sql).setParameter("", t)
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
    
    
}
