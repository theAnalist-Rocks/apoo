/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.service;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.SessionFactory;
import tg.univlome.cic.apoo.project.entities.Eleve;
import tg.univlome.cic.apoo.project.entities.Periode;
import tg.univlome.cic.apoo.project.traitements.MapClasseRanking;
import tg.univlome.cic.apoo.project.utils.HibernateSessionFactory;

/**
 *
 * @author leBoulanger
 */
public class RankingService {
    private static EntityManager manager;
    
    public RankingService() {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }
    
    public List<MapClasseRanking> getRanking(int codePeriode) {
        PeriodeService service = new PeriodeService();
        EleveService serviceEleve = new EleveService();
        Periode periode = service.getPeriode(codePeriode);
        List<MapClasseRanking> liste = new ArrayList<>();
        List<Eleve> listeEleve = serviceEleve.getEleves();
        for (Eleve eleve : listeEleve) {
            MapClasseRanking mcr = new MapClasseRanking();
            mcr.setNom(eleve.getNom());
            mcr.setPrenom(eleve.getPrenom());
            mcr.setMoyenne(periode.getMoyenne(eleve.getClasse().getCours(), new TypeEvaluationService().getPeriodes(), eleve));
            mcr.setIdPeriode(codePeriode);
            liste.add(mcr);
        }
        return liste;
    }
}
