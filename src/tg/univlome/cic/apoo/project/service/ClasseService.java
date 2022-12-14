/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.service;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.SessionFactory;
import tg.univlome.cic.apoo.project.dao.DaoImpl;
import tg.univlome.cic.apoo.project.dao.IDao;
import tg.univlome.cic.apoo.project.entities.Classe;
import tg.univlome.cic.apoo.project.utils.HibernateSessionFactory;

/**
 *
 * @author leBoulanger
 */
public class ClasseService {
    private static EntityManager manager;
    
    public ClasseService() {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }
    
    public List<Classe> getClasses() {
        List<Classe> liste = manager.createQuery("select c from Classe c").getResultList();
        return liste;
    }
    
    public Classe getClasse(int id) {
        return manager.createQuery("select c from Classe c where c.code = :id", Classe.class)
                .setParameter("id", id)
                .getResultList().get(0);
    }
}
