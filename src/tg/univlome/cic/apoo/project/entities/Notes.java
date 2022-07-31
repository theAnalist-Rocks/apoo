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
@Entity(name = "Notes")
@Table(name="notes")
public class Notes implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch=FetchType.LAZY, cascade=(CascadeType.PERSIST))
    private Eleve eleve;
    @ManyToOne(fetch=FetchType.LAZY, cascade=(CascadeType.PERSIST))// targetEntity = Evaluation.class)
    private Evaluation evaluations;
    @Column(name="value")
    private float value;
    @ManyToOne(fetch=FetchType.LAZY, cascade=(CascadeType.PERSIST))// mappedBy = "notes", targetEntity = Enseignant.class)
    private Enseignant enseignants;
    private static List<Notes> listeNotes = new ArrayList<>();

    public Notes() {
    }

    public Notes(Eleve eleve, Evaluation evaluations, float value, Enseignant enseignants) {
        this.eleve = eleve;
        this.evaluations = evaluations;
        this.value = value;
        this.enseignants = enseignants;
    }

    public Notes(Eleve eleve, Evaluation evaluations, float value) {
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

    public void setValue(int value) {
        this.value = value;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public Evaluation getEvaluation() {
        return evaluations;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluations = evaluation;
    }

    public Enseignant getEnseignant() {
        return enseignants;
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
