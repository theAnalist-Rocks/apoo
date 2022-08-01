/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.service;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.SessionFactory;
import tg.univlome.cic.apoo.project.entities.Eleve;
import tg.univlome.cic.apoo.project.entities.Enseignant;
import tg.univlome.cic.apoo.project.utils.HibernateSessionFactory;

/**
 *
 * @author leBoulanger
 */
public class EnseignantService {
    private static EntityManager manager;
    
    public EnseignantService() {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }
    
    public List<Enseignant> getEnseignants() {
        List<Enseignant> liste = manager.createQuery("select e from Enseignant e", Enseignant.class).getResultList();
        return liste;
    }
    
    public Enseignant getEnseignant(int code) {
        return manager.createQuery("select e from Enseignant e where e.code = :code", Enseignant.class)
                .setParameter("code", code)
                .getResultList().get(0);
    }
}
