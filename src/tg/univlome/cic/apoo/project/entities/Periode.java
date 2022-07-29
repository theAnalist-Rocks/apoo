/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.entities;

import java.io.Serializable;
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

/**
 *
 * @author leBoulanger
 */
@Entity
@Table(name="periode")
public class Periode implements Serializable {
    private static List<Periode> liste = new ArrayList<>();
    @Column(name="nom_periode")
    private String nom_periode;
    @Column(name="date_debut")
    private Date debut;
    @Column(name="date_fin")
    private Date fin;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    static {
        liste.add(new Periode("Trimestre 1", 0));
        liste.add(new Periode("Trimestre 2", 1));
        liste.add(new Periode("Trimestre 3", 2));
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

    public Periode(String nom_periode, int id) {
        this.nom_periode = nom_periode;
        this.id = id;
    }
    
    /* notes aux évaluations à la période courante pour un cours donné */
    public List<Notes> getNotes(Cours c, Eleve e) {
        
        /**
         *@c (Cours): le cours dont on veut récupérer les notes
         *@e (Eleve): l'élève dont on cherche les notes
         *@returns: la liste des notes pour l'élève e au cours c
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
         @t (TypeEvaluation): c'est le type d'évaluation
         @c (Cours): c'est le cours concerné par la recherche
         @e (Eleve): c'est l'évlève sur qui est porté la recherche à la période courante
         returns: une liste de notes pour la période courante concernant le cours c et et l'évaluation t
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
         @c (Cours): le cours dont on veut la moyenne pour un certain type d'évaluation
         @t (TypeEvaluation): c'est le type de l'évaluation dont on veut la moyenne
         @e (Eleve): c'est l'élève concerné par le calcul de la moyenne
         returns: la moyenne pour un type donné d'évaluation à la période courante
         */
        float moyenne = 0;
        int count = 0;
        List<Notes> liste = getNotesByType(t, c, e);
        for (Notes notes : liste) {
            moyenne += notes.getValue();
            count += notes.getEvaluation().getCours().getEnseignement().getCoefficient();
        }
        return moyenne /= count; //moyenne pondérée: moyenne /= liste.size() 
    }
    
    public float getMoyenneCours(Cours c, List<TypeEvaluation> list, Eleve e) {
        /**@params: 
        @cours c: le cours dont on cherche à calculer la moyenne à la période donnée
        @list : La liste des types d'évaluations concernés par le calcul de la moyenne
        @e: l'élève dont on veut la moyenne pour un cours donné
        returns: la moyenne totale (pour tous les cours et tous les types d'évaluation)
        */
        float moyenne = 0;
        /* vérifier le poids ici */
        for (TypeEvaluation typeEvaluation : list) {
            moyenne += getMoyenneType(typeEvaluation, e, c);
        }
        return moyenne /= list.size();
    }
    
    public float getMoyenne(List<Cours> listCours, List<TypeEvaluation> listTypes, Eleve e) {
        /**@params: 
        @listCours: La liste des cours suivis par l'élève passé en paramètre
        @listeTypes: La liste des types d'evaluations (INTERROGATION, DEVOIR ET EXAMEN)
        @e: L'elève dont on cherche la moyenne
        returns: la moyenne totale (pour tous les cours et tous les types d'évaluation)
        */
        float moyenne = 0;
        int count = 0;
        for (Cours cours : listCours) {
            moyenne += getMoyenneCours(cours, listTypes, e);
            count += cours.getEnseignement().getCoefficient();
        }
        return moyenne /= count;//listCours.size(); // moyenne non pondérée
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
