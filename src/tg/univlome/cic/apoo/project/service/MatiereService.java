/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.service;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.SessionFactory;
import tg.univlome.cic.apoo.project.entities.Enseignant;
import tg.univlome.cic.apoo.project.entities.Matiere;
import tg.univlome.cic.apoo.project.utils.HibernateSessionFactory;

/**
 *
 * @author leBoulanger
 */
public class MatiereService {
     private static EntityManager manager;
    
    public MatiereService() {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }
    
    public List<Matiere> getMatieres() {
        List<Matiere> liste = manager.createQuery("select e from Matiere e", Matiere.class).getResultList();
        return liste;
    }
    
    public Matiere getMatiere(int code) {
        return manager.createQuery("select e from Matiere e where e.code = :code", Matiere.class)
                .setParameter("code", code)
                .getResultList().get(0);
    }
}
