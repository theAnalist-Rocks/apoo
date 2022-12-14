/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
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
import tg.univlome.cic.apoo.project.service.CoursService;
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
    private static IDao manager = new DaoImpl();
    
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
    
    static {
        Cours c = new Cours(0, 0, 0, 0);
        Cours c1 = new Cours(0, 1, 0, 1);
        Cours c2 = new Cours(0, 2, 0, 2);
        Cours c3 = new Cours(0, 3, 0, 3);
        Cours c4 = new Cours(0, 4, 0, 4);
        Cours c5 = new Cours(0, 5, 0, 5);
        liste.addAll(Arrays.asList(c, c1, c2, c3, c4, c5));
        manager.modifier(liste);
    }

    public Cours() {
    }

    public Cours(Enseignement enseignement, Classe classe, int codeCours) {
        this.enseignement = enseignement;
        this.classe = classe;
        this.codeCours = codeCours;
    }

    public Cours(int id_enseignant, int id_enseignement, int id_classe, int codeCours) {
        this.id_enseignant = id_enseignant;
        this.setEnseignant(id_enseignant);
        this.id_enseignement = id_enseignement;
        this.setEnseignement(id_enseignement);
        this.id_classe = id_classe;
        this.setClasse(id_classe);
        this.classe.setCours(liste);
        this.codeCours = codeCours;
    }

    public Cours(Enseignant enseignant, Enseignement enseignement, Classe classe, int id) {
        this.enseignant = enseignant;
        this.enseignement = enseignement;
        this.classe = classe;
        this.id = id;
    }
    
    public static Cours getCours(int code) {
        return new CoursService().getCours(code);
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
    
    public void setEnseignant(int code) {
        this.enseignant = Enseignant.getEnseignant(code);
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Enseignement getEnseignement() {
        return enseignement;
    }
    
    public void setEnseignement(int code) {
        this.enseignement = Enseignement.getEnseignement(code);
    }

    public void setEnseignement(Enseignement enseignement) {
        this.enseignement = enseignement;
    }

    public Classe getClasse() {
        return classe;
    }
    
    public void setClasse(int code)  {
        this.classe = Classe.getClasse(code);    }

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
