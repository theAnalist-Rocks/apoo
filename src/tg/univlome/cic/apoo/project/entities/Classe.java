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
import javax.persistence.Table;

/**
 *
 * @author leBoulanger
 */
@Entity
@Table(name="classes")
public class Classe implements Serializable {
    /**@Notes:
     * Dans une classe donnée, on a plusieurs cours
     */
    private static List<Classe> liste = new ArrayList<>();

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name="code_niveau")
    private int id_niveau;
    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
    private Niveau niveau;
    @Column(name="libelle_court")
    private String libelle_court;
    @Column(name="libelle_long")
    private String libelle_long;
    @OneToMany(fetch=FetchType.LAZY, cascade=(CascadeType.PERSIST))// mappedBy = "classes", targetEntity = Eleve.class)
    private List<Eleve> eleve = new ArrayList<>();
    @OneToMany(fetch=FetchType.LAZY, cascade=(CascadeType.PERSIST))// mappedBy = "classes", targetEntity = Cours.class)
    private List<Cours> cours = new ArrayList<>();

    public Classe() {
    }

    public Classe(int id_niveau,String code_classe_string) {
        this.id_niveau = id_niveau;
//        this.code_classe = code_classe;
        this.libelle_court = libelle_court;
    }
    
    public void ajouterEleve(Eleve e) {
        eleve.add(e);
    }
    
    public void ajouterCours(Cours c) {
        cours.add(c);
    }
    
    public void ajouterEleve(List<Eleve> listeEleve) {
        for (Eleve eleve1 : listeEleve) {
            ajouterEleve(eleve1);
        }
    }
    
    public void ajouterCours(List<Cours> listeCours) {
        for (Cours cours : listeCours) {
            ajouterCours(cours);
        }
    }
    
    public void supprimerEleve(Eleve e) {
        eleve.remove(e);
    }
    
    public void supprimerCours(Cours c) {
        cours.remove(c);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_niveau() {
        return id_niveau;
    }

    public void setId_niveau(int id_niveau) {
        this.id_niveau = id_niveau;
    }

//    public int getCode_classe() {
//        return code_classe;
//    }
//
//    public void setCode_classe(int code_classe) {
//        this.code_classe = code_classe;
//    }

    public String getCode_classe_string() {
        return libelle_court;
    }

    public void setCode_classe_string(String libelle_court) {
        this.libelle_court = libelle_court;
    }

    public static List<Classe> getListe() {
        return liste;
    }

    public static void setListe(List<Classe> liste) {
        Classe.liste = liste;
    }

    public List<Eleve> getEleve() {
        return eleve;
    }

    public void setEleve(List<Eleve> eleve) {
        this.eleve = eleve;
    }

    public List<Cours> getCours() {
        return cours;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public String getLibelle_long() {
        return libelle_long;
    }

    public void setLibelle_long(String libelle_long) {
        this.libelle_long = libelle_long;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Classe other = (Classe) obj;
        return this.id == other.id;
    }
   
}
