/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.entities;

import java.io.Serializable;
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
@Table(name="notes")
public class Notes implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name="id_eleve")
    private int id_eleve;
    private Eleve eleve;
    @Column(name="id_evaluation")
    private int id_evaluation;
    private Evaluation evaluation;
    @Column(name="value")
    private float value;
    @Column(name="corr_par_id")
    private Enseignant enseignant;

    public Notes() {
    }

    public Notes(int id_eleve, int id_evaluation, int value) {
        this.id_eleve = id_eleve;
        this.id_evaluation = id_evaluation;
        this.value = value;
    }

    public Notes(Long id, Eleve eleve, Evaluation evaluation, float value, Enseignant enseignant) {
        this.id = id;
        this.eleve = eleve;
        this.evaluation = evaluation;
        this.value = value;
        this.enseignant = enseignant;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public float getValue() {
        return value * evaluation.getCours().getEnseignement().getCoefficient();
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
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
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
