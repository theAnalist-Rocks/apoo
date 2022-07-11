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
@Table(name="enseignement")
public class Enseignement implements Serializable {
    private static List<Enseignement> liste = new ArrayList<>();
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name="coefficient")
    private float coefficient;
    @Column(name="id_niveau")
    private int id_niveau;
    private Niveau niveau;
    @Column(name="id_matiere")
    private int id_matiere;
    private Matiere matiere;

    public Enseignement(float coefficient, int id_niveau, int id_matiere) {
        this.coefficient = coefficient;
        this.id_niveau = id_niveau;
        this.id_matiere = id_matiere;
    }

    public Enseignement() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public int getId_niveau() {
        return id_niveau;
    }

    public void setId_niveau(int id_niveau) {
        this.id_niveau = id_niveau;
    }

    public int getId_matiere() {
        return id_matiere;
    }

    public void setId_matiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + this.id_niveau;
        hash = 59 * hash + this.id_matiere;
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
        final Enseignement other = (Enseignement) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_niveau != other.id_niveau) {
            return false;
        }
        return this.id_matiere == other.id_matiere;
    }
    
    
}
