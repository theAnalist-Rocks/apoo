/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.service;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.SessionFactory;
import tg.univlome.cic.apoo.project.entities.Evaluation;
import tg.univlome.cic.apoo.project.utils.HibernateSessionFactory;

/**
 *
 * @author leBoulanger
 */
public class EvaluationService {
    private static EntityManager manager;
    
    public EvaluationService() {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }
    
    public Evaluation getEvaluation(Long id) {
        return manager.createQuery("select e from Evaluation e where e.id = :id", Evaluation.class).setParameter("id", id).getResultList().get(0);
    }
    
    public List<Evaluation> getEvaluations() {
        return manager.createQuery("select e from Evaluation e", Evaluation.class).getResultList();
    }
}
