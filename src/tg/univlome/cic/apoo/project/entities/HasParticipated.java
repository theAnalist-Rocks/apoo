/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.entities;

import java.io.Serializable;
import java.util.Date;
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
@Table(name="has_participated")
public class HasParticipated implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name="id_eleve")
    private int id_eleve;
    @Column(name="id_eval")
    private int id_eval;
    @Column(name="date")
    private Date date;

    public HasParticipated() {
    }

    public HasParticipated(int id_eleve, int id_eval) {
        this.id_eleve = id_eleve;
        this.id_eval = id_eval;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_eleve() {
        return id_eleve;
    }

    public void setId_eleve(int id_eleve) {
        this.id_eleve = id_eleve;
    }

    public int getId_eval() {
        return id_eval;
    }

    public void setId_eval(int id_eval) {
        this.id_eval = id_eval;
    }

    public Date getDate() {
        return date;
    }

    public void setData(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id;
        hash = 17 * hash + this.id_eleve;
        hash = 17 * hash + this.id_eval;
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
        if (this.id != other.id) {
            return false;
        }
        if (this.id_eleve != other.id_eleve) {
            return false;
        }
        return this.id_eval == other.id_eval;
    }
    
    
}
