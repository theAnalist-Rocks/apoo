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
import tg.univlome.cic.apoo.project.traitements.EntityCliCRUD;

/**
 *
 * @author leBoulanger
 */
@Entity
@Table(name="cours")
public class Cours implements Serializable {
    private static List<Cours> liste = new ArrayList<>();
    private static EntityCliCRUD finder = new EntityCliCRUD();
    
    @Column(name="id_enseignant")
    private int id_enseignant;
    @ManyToOne(fetch=FetchType.LAZY, cascade=(CascadeType.PERSIST))// targetEntity = Enseignant.class)
    private Enseignant enseignant;
    @Column(name="id_enseignement")
    private int id_enseignement;
    @ManyToOne(fetch=FetchType.LAZY, cascade=(CascadeType.PERSIST))//targetEntity = Enseignement.class)
    private Enseignement enseignement;
    @Column(name="id_classe")
    private int id_classe;
    @ManyToOne(fetch=FetchType.LAZY, cascade=(CascadeType.PERSIST))// targetEntity = Classe.class)
    private Classe classe;
    @Column(name="code_cours")
    private int codeCours;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    public Cours() {
    }

    public Cours(int id_enseignant, int id_enseignement, int id_classe, int codeCours) {
        this.id_enseignant = id_enseignant;
        this.id_enseignement = id_enseignement;
        this.id_classe = id_classe;
        this.codeCours = codeCours;
    }

    public Cours(Enseignant enseignant, Enseignement enseignement, Classe classe, int id) {
        this.enseignant = enseignant;
        this.enseignement = enseignement;
        this.classe = classe;
        this.id = id;
    }
    

    public int getId_enseignant() {
        return id_enseignant;
    }

    public void setId_enseignant(int id_enseignant) {
        this.id_enseignant = id_enseignant;
    }

    public int getId_enseignement() {
        return id_enseignement;
    }

    public void setId_enseignement(int id_enseignement) {
        this.id_enseignement = id_enseignement;
    }

    public int getId_classe() {
        return id_classe;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    public int getCodeCours() {
        return codeCours;
    }

    public void setCodeCours(int codeCours) {
        this.codeCours = codeCours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Enseignement getEnseignement() {
        return enseignement;
    }

    public void setEnseignement(Enseignement enseignement) {
        this.enseignement = enseignement;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.id_enseignant;
        hash = 23 * hash + this.id_enseignement;
        hash = 23 * hash + this.id_classe;
        hash = 23 * hash + this.id;
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
        final Cours other = (Cours) obj;
        if (this.id_enseignant != other.id_enseignant) {
            return false;
        }
        if (this.id_enseignement != other.id_enseignement) {
            return false;
        }
        if (this.id_classe != other.id_classe) {
            return false;
        }
        return this.id == other.id;
    }
    
    
}
