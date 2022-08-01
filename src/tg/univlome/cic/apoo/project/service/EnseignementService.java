/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.service;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.SessionFactory;
import tg.univlome.cic.apoo.project.entities.Enseignant;
import tg.univlome.cic.apoo.project.entities.Enseignement;
import tg.univlome.cic.apoo.project.utils.HibernateSessionFactory;

/**
 *
 * @author leBoulanger
 */
public class EnseignementService {
     private static EntityManager manager;
    
    public EnseignementService() {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }
    
    public List<Enseignement> getEnseignements() {
        List<Enseignement> liste = manager.createQuery("select e from Enseignement e", Enseignement.class).getResultList();
        return liste;
    }
    
    public Enseignement getEnseignement(int code) {
        return manager.createQuery("select e from Enseignement e where e.code= :code", Enseignement.class)
                .setParameter("code", code)
                .getResultList().get(0);
    }
}
