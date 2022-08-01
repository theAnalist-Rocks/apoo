
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.SessionFactory;
import tg.univlome.cic.apoo.project.entities.Eleve;
import tg.univlome.cic.apoo.project.utils.HibernateSessionFactory;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author leBoulanger
 */
public class PersonneService {
     private static EntityManager manager;
    
    public PersonneService() {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }
    
    public List<?> getPersonne() {
        List<Eleve> liste = manager.createQuery("select e from Eleve e").getResultList();
        return liste;
    }
}
