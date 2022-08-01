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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author leBoulanger
 */
@Entity
@Table(name="notes")
public class Notes implements Serializable {
    private static List<Notes> listeNotes = new ArrayList<>();
    @Column(name="code")
    private static int code = 0;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name="id_eleve")
    private int id_eleve;
    @ManyToOne(fetch=FetchType.LAZY, cascade=(CascadeType.PERSIST))
    private Eleve eleve;
    @ManyToOne(fetch=FetchType.LAZY, cascade=(CascadeType.PERSIST))// targetEntity = Evaluation.class)
    private Evaluation evaluations;
    @Column(name="id_evaluation")
    private int id_evaluation;
    @Column(name="value")
    private float value;
    @ManyToOne(fetch=FetchType.LAZY, cascade=(CascadeType.PERSIST))// mappedBy = "notes", targetEntity = Enseignant.class)
    private Enseignant enseignants;
    @Column(name="id_enseignant")
    private int id_enseignant;

    public Notes() {
        this.code ++;
    }

    public Notes(int code_eleve, int code_evaluation, float value, int code_enseignant) {
        this.id_eleve = code_eleve;
        setEleve(id_eleve);
        this.id_evaluation = code_evaluation;
        setEvaluation(id_evaluation);
        this.value = value;
        this.id_enseignant = code_enseignant;
        setEnseignants(id_enseignant);
    }
    
    public Notes(Eleve eleve, Evaluation evaluations, float value, Enseignant enseignants) {
        this();
        this.eleve = eleve;
        this.evaluations = evaluations;
        this.value = value;
        this.enseignants = enseignants;
    }

    public Notes(Eleve eleve, Evaluation evaluations, float value) {
        this();
        this.eleve = eleve;
        this.evaluations = evaluations;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Evaluation getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(Evaluation evaluations) {
        this.evaluations = evaluations;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Enseignant getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(Enseignant enseignants) {
        this.enseignants = enseignants;
    }
    
    public void setEnseignants(int code) {
        this.enseignants = Enseignant.getEnseignant(code);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Eleve getEleve() {
        return eleve;
    }
    
    public void setEleve(int code) {
        this.eleve = Eleve.getEleve(code);
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public Evaluation getEvaluation() {
        return evaluations;
    }
    
    public void setEvaluation(int code) {
        this.evaluations = Evaluation.getEvaluation(code);
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluations = evaluation;
    }

    public Enseignant getEnseignant() {
        return enseignants;
    }
    
    public void setEnseignant(int code) {
        this.enseignants = Enseignant.getEnseignant(code);
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignants = enseignant;
    }

    public List<Notes> getListeNotes() {
        return listeNotes;
    }

    public void setListeNotes(List<Notes> listeNotes) {
        this.listeNotes = listeNotes;
    }

    public static int getCode() {
        return code;
    }

    public static void setCode(int code) {
        Notes.code = code;
    }

    public int getId_eleve() {
        return id_eleve;
    }

    public void setId_eleve(int id_eleve) {
        this.id_eleve = id_eleve;
    }

    public int getId_evaluation() {
        return id_evaluation;
    }

    public void setId_evaluation(int id_evaluation) {
        this.id_evaluation = id_evaluation;
    }

    public int getId_enseignant() {
        return id_enseignant;
    }

    public void setId_enseignant(int id_enseignant) {
        this.id_enseignant = id_enseignant;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = (int) (37 * hash + this.id);
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
        final Notes other = (Notes) obj;
        return this.id == other.id;
    }
    
    
}
