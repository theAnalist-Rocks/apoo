/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author leBoulanger
 */
@Entity
@Table(name="evaluation")
public class Evaluation implements Serializable {
    private static List<Evaluation> liste = new ArrayList<>();
    @Column(name="id_cours")
    private int id_cours;
    private Cours cours;
    @Column(name="id_periode")
    private int id_periode;
    private Periode periode;
    @Column(name="id_type_eval")
    private int id_type_eval;
    private TypeEvaluation typeEvaluation;
    @Column(name="poids")
    private float poids;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    public Evaluation() {
    }
    
    public Evaluation(Long id) {
        this.id = id;
    }

    public Evaluation(int id_cours, int id_periode) {
        this.id_cours = id_cours;
        this.id_periode = id_periode;
    }

    public int getId_cours() {
        return id_cours;
    }

    public void setId_cours(int id_cours) {
        this.id_cours = id_cours;
    }

    public int getId_periode() {
        return id_periode;
    }

    public void setId_periode(int id_periode) {
        this.id_periode = id_periode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    public int getId_type_eval() {
        return id_type_eval;
    }

    public void setId_type_eval(int id_type_eval) {
        this.id_type_eval = id_type_eval;
    }

    public TypeEvaluation getTypeEvaluation() {
        return typeEvaluation;
    }

    public void setTypeEvaluation(TypeEvaluation typeEvaluation) {
        this.typeEvaluation = typeEvaluation;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public static List<Evaluation> getListe() {
        return liste;
    }

    public static void setListe(List<Evaluation> liste) {
        Evaluation.liste = liste;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id_cours;
        hash = 31 * hash + this.id_periode;
        hash = (int) (31 * hash + this.id);
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
        final Evaluation other = (Evaluation) obj;
        if (this.id_cours != other.id_cours) {
            return false;
        }
        if (this.id_periode != other.id_periode) {
            return false;
        }
        return this.id == other.id;
    }
    
    
}
