/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import tg.univlome.cic.apoo.project.controllers.EleveCtrl;
import tg.univlome.cic.apoo.project.controllers.EvaluationCtrl;
import tg.univlome.cic.apoo.project.dao.DaoImpl;
import tg.univlome.cic.apoo.project.dao.IDao;
import tg.univlome.cic.apoo.project.dao.Manager;
import tg.univlome.cic.apoo.project.service.PeriodeService;

/**
 *
 * @author leBoulanger
 */
@Entity
@Table(name="periode")
public class Periode implements Serializable {
    private static List<Periode> liste = new ArrayList<>();
    private static IDao manager = new DaoImpl();
    @Column(name="nom_periode")
    private String nom_periode;
    @Column(name="date_debut")
    private Date debut;
    @Column(name="date_fin")
    private Date fin;
    @Column(name="code")
    private int code;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    static {
        Periode p1 = new Periode("Trimestre 1", 0);
        Periode p2 = new Periode("Trimestre 2", 1);
        Periode p3 = new Periode("Trimestre 3", 2);
        
        liste.add(p1);
        liste.add(p2);
        liste.add(p3);
        
        manager.ajouter(p1);
        manager.ajouter(p2);
        manager.ajouter(p3);
    }

    public Periode() {
    }

    public Periode(String nom_periode, Date debut, Date fin) {
        this.nom_periode = nom_periode;
        this.debut = debut;
        this.fin = fin;
    }

    public Periode(String nom_periode) {
        this.nom_periode = nom_periode;
    }

    public Periode(String nom_periode, int code) {
        this.nom_periode = nom_periode;
        this.code = code;
    }
    
    public static Periode getPeriode(int code) {
        return new PeriodeService().getPeriode(code);
    }
    
    /* notes aux ??valuations ?? la p??riode courante pour un cours donn?? */
    public List<Notes> getNotes(Cours c, Eleve e) {
        
        /**
         *@c (Cours): le cours dont on veut r??cup??rer les notes
         *@e (Eleve): l'??l??ve dont on cherche les notes
         *@returns: la liste des notes pour l'??l??ve e au cours c
         */
        List<Notes> listeNotes = new ArrayList<>();
        for (Notes note : new EleveCtrl().getNotes(e)) {
            if (note.getEvaluation().getCours().equals(c) && note.getEvaluation().getPeriode().equals(this)) {
                listeNotes.add(note);
            }
        }
        return listeNotes;
    }
    
    public List<Notes> getNotesByType(TypeEvaluation t, Cours c, Eleve e) {
        /**
         @t (TypeEvaluation): c'est le type d'??valuation
         @c (Cours): c'est le cours concern?? par la recherche
         @e (Eleve): c'est l'??vl??ve sur qui est port?? la recherche ?? la p??riode courante
         returns: une liste de notes pour la p??riode courante concernant le cours c et et l'??valuation t
         */
        
        List<Notes> liste = new ArrayList<>();
        for (Notes note : getNotes(c, e)) {
            if(note.getEvaluation().getTypeEvaluation().equals(t)) {
                liste.add(note);
            }
        }
        return liste;
    }
    
    public float getMoyenneType(TypeEvaluation t, Eleve e, Cours c) {
        /**
         @c (Cours): le cours dont on veut la moyenne pour un certain type d'??valuation
         @t (TypeEvaluation): c'est le type de l'??valuation dont on veut la moyenne
         @e (Eleve): c'est l'??l??ve concern?? par le calcul de la moyenne
         returns: la moyenne pour un type donn?? d'??valuation ?? la p??riode courante
         */
        float moyenne = 0;
        int count = 0;
        List<Notes> liste = getNotesByType(t, c, e);
        for (Notes notes : liste) {
            moyenne += notes.getValue();
            count += notes.getEvaluation().getCours().getEnseignement().getCoefficient();
        }
        return moyenne /= count; //moyenne pond??r??e: moyenne /= liste.size() 
    }
    
    public float getMoyenneCours(Cours c, List<TypeEvaluation> list, Eleve e) {
        /**@params: 
        @cours c: le cours dont on cherche ?? calculer la moyenne ?? la p??riode donn??e
        @list : La liste des types d'??valuations concern??s par le calcul de la moyenne
        @e: l'??l??ve dont on veut la moyenne pour un cours donn??
        returns: la moyenne totale (pour tous les cours et tous les types d'??valuation)
        */
        float moyenne = 0;
        /* v??rifier le poids ici */
        for (TypeEvaluation typeEvaluation : list) {
            moyenne += getMoyenneType(typeEvaluation, e, c);
        }
        return moyenne /= list.size();
    }
    
    public float getMoyenne(List<Cours> listCours, List<TypeEvaluation> listTypes, Eleve e) {
        /**@params: 
        @listCours: La liste des cours suivis par l'??l??ve pass?? en param??tre
        @listeTypes: La liste des types d'evaluations (INTERROGATION, DEVOIR ET EXAMEN)
        @e: L'el??ve dont on cherche la moyenne
        returns: la moyenne totale (pour tous les cours et tous les types d'??valuation)
        */
        float moyenne = 0;
        int count = 0;
        for (Cours cours : listCours) {
            moyenne += getMoyenneCours(cours, listTypes, e);
            count += cours.getEnseignement().getCoefficient();
        }
        return moyenne /= count;//listCours.size(); // moyenne non pond??r??e
    }
    
    public String getNom_periode() {
        return nom_periode;
    }

    public void setNom_periode(String nom_periode) {
        this.nom_periode = nom_periode;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static List<Periode> getListe() {
        return liste;
    }

    public static void setListe(List<Periode> liste) {
        Periode.liste = liste;
    }

    public static IDao getManager() {
        return manager;
    }

    public static void setManager(IDao manager) {
        Periode.manager = manager;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Periode other = (Periode) obj;
        return this.id == other.id;
    }

    
    
    
}
