/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.service;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.SessionFactory;
import tg.univlome.cic.apoo.project.entities.Periode;
import tg.univlome.cic.apoo.project.utils.HibernateSessionFactory;

/**
 *
 * @author leBoulanger
 */
public class PeriodeService {
    private static EntityManager manager;
    
    public PeriodeService() {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }
    
    public List<Periode> getPeriodes() {
        return manager.createQuery("select p from Periode p", Periode.class).getResultList();
    }
    
    public Periode getPeriode(int code) {
        return manager.createQuery("select p from Periode p where p.code = :id", Periode.class)
                .setParameter("id", code)
                .getResultList().get(0);
    }
}
