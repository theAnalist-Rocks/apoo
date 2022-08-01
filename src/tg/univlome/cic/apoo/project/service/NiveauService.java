/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.service;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.SessionFactory;
import tg.univlome.cic.apoo.project.entities.Enseignant;
import tg.univlome.cic.apoo.project.entities.Niveau;
import tg.univlome.cic.apoo.project.utils.HibernateSessionFactory;

/**
 *
 * @author leBoulanger
 */
public class NiveauService {
     private static EntityManager manager;
    
    public NiveauService() {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }
    
    public List<Niveau> getNiveaux() {
        List<Niveau> liste = manager.createQuery("select e from Niveau e", Niveau.class).getResultList();
        return liste;
    }
    
    public Niveau getNiveau(int code) {
        return manager.createQuery("select e from Niveau e where e.code = :code", Niveau.class)
                .setParameter("code", code)
                .getResultList().get(0);
    }
}
