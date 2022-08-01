/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.service;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.SessionFactory;
import tg.univlome.cic.apoo.project.entities.TypeEvaluation;
import tg.univlome.cic.apoo.project.utils.HibernateSessionFactory;

/**
 *
 * @author leBoulanger
 */
public class TypeEvaluationService {
    private static EntityManager manager;
    
    public TypeEvaluationService() {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }
    
    public List<TypeEvaluation> getPeriodes() {
        return manager.createQuery("select t from TypeEvaluation t", TypeEvaluation.class).getResultList();
    }
    
    public TypeEvaluation getPeriode(int code) {
        return manager.createQuery("select t from TypeEvaluation t where t.code = :id", TypeEvaluation.class)
                .setParameter("id", code)
                .getResultList().get(0);
    }
}
