/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import tg.univlome.cic.apoo.project.dao.DaoImpl;
import tg.univlome.cic.apoo.project.dao.IDao;
import tg.univlome.cic.apoo.project.service.EvaluationService;

/**
 *
 * @author leBoulanger
 */
@Entity
@Table(name="evaluation")
public class Evaluation implements Serializable {
    private static List<Evaluation> liste = new ArrayList<>();
    private static IDao manager = new DaoImpl();
    @Column(name="id_cours")
    private int id_cours;
    @ManyToOne(fetch=FetchType.LAZY, cascade=(CascadeType.PERSIST))//, targetEntity = Cours.class)
    private Cours cours;
    @Column(name="id_periode")
    private int id_periode;
    @ManyToOne(fetch=FetchType.LAZY, cascade=(CascadeType.PERSIST))//, targetEntity = Periode.class)
    private Periode periode;
    @Column(name="id_type_eval")
    private int id_type_eval;
    @ManyToOne(fetch=FetchType.LAZY, cascade=(CascadeType.PERSIST))//, targetEntity = TypeEvaluation.class)
    private TypeEvaluation typeEvaluation;
    @Column(name="poids")
    private float poids;
    @Column(name="code")
    private int code;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    static {
        Evaluation e1 = new Evaluation(0, 0, 1, (float) 0.4, 0);
        liste.add(e1);
        manager.modifier(e1);
    }

    public Evaluation() {
    }

    public Evaluation(int id_cours, int id_periode, int id_type_eval, float poids, int code) {
        this.id_cours = id_cours;
        this.setCours(id_cours);
        this.id_periode = id_periode;
        this.setPeriode(id_periode);
        this.id_type_eval = id_type_eval;
        this.setTypeEvaluation(id_type_eval);
        this.poids = poids;
        this.code = code;
    }

    public Evaluation(int id_cours, int id_periode, int id_type_eval, float poids) {
        this.id_cours = id_cours;
        this.id_periode = id_periode;
        this.id_type_eval = id_type_eval;
        this.poids = poids;
    }
    
    public Evaluation(Long id) {
        this.id = id;
    }

    public Evaluation(int id_cours, int id_periode) {
        this.id_cours = id_cours;
        this.id_periode = id_periode;
    }

    public Evaluation(Cours cours, Periode periode, TypeEvaluation typeEvaluation, float poids) {
        this.cours = cours;
        this.periode = periode;
        this.typeEvaluation = typeEvaluation;
        this.poids = poids;
    }
    
    public static Evaluation getEvaluation(int code) {
        return new EvaluationService().getEvaluation(code);
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

    public void setCours(int code) {
        this.cours = Cours.getCours(code);
    }
    
    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public Periode getPeriode() {
        return periode;
    }
    
    public void setPeriode(int code) {
        this.periode = Periode.getPeriode(code);
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

    public void setTypeEvaluation(int code) {
        this.typeEvaluation = TypeEvaluation.getTypeEval(code);
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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
