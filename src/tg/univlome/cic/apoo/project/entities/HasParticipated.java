/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author leBoulanger
 */
@Entity
@Table(name="has_participated")
public class HasParticipated implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch=FetchType.LAZY, cascade=(CascadeType.PERSIST), targetEntity = Eleve.class)
    private Eleve eleves;
    @ManyToOne(fetch=FetchType.LAZY, cascade=(CascadeType.PERSIST), targetEntity = Evaluation.class)
    private Evaluation evaluations;
    @Column(name="date", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date date;

    public HasParticipated() {
    }

    public HasParticipated(Eleve eleves, Evaluation evaluations) {
        this.eleves = eleves;
        this.evaluations = evaluations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Eleve getEleves() {
        return eleves;
    }

    public void setEleves(Eleve eleves) {
        this.eleves = eleves;
    }

    public Evaluation getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(Evaluation evaluations) {
        this.evaluations = evaluations;
    }

    

    public Date getDate() {
        return date;
    }

    public void setData(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
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
        final HasParticipated other = (HasParticipated) obj;
        return this.id == other.id;
    }
    
    
}
