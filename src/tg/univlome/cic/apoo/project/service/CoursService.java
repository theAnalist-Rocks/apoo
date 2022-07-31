/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.service;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.SessionFactory;
import tg.univlome.cic.apoo.project.utils.HibernateSessionFactory;
import tg.univlome.cic.apoo.project.entities.Cours;

/**
 *
 * @author leBoulanger
 */
public class CoursService {
    private static EntityManager manager;
    
    public CoursService() {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }
    
    public List<Cours> getCourses() {
        return manager.createQuery("select c from Cours c", Cours.class).getResultList();
    }
    
    public Cours getCours(int id) {
        return manager.createQuery("select c from Cours c where c.id = :id", Cours.class).getSingleResult();
    }
}
