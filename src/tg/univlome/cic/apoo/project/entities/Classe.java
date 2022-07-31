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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import tg.univlome.cic.apoo.project.dao.DaoImpl;
import tg.univlome.cic.apoo.project.dao.IDao;

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
    private static IDao manager = new DaoImpl();

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name="code_niveau")
    private int code_niveau;
    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
    private Niveau niveau;
    @Column(name="libelle_court")
    private String libelle_court;
    @Column(name="libelle_long")
    private String libelle_long;
    @Column(name="code")
    private int code;
    @OneToMany(fetch=FetchType.LAZY, cascade=(CascadeType.PERSIST))// mappedBy = "classes", targetEntity = Eleve.class)
    private List<Eleve> eleve = new ArrayList<>();
    @OneToMany(fetch=FetchType.LAZY, cascade=(CascadeType.PERSIST))// mappedBy = "classes", targetEntity = Cours.class)
    private List<Cours> cours = new ArrayList<>();
    
    static {
        Classe c1 = new Classe(5, "5 A", 0);
        Classe c2 = new Classe(6, "6 A", 1);
        Classe c3 = new Classe(4, "4 A", 2);
        Classe c4 = new Classe(3, "3 A", 4);
//        manager.ajouter(Arrays.asList(c1, c2, c3, c4));
        manager.ajouter(Arrays.asList(c1, c2, c3, c4));       
        liste.addAll(Arrays.asList(c1, c2, c3, c4));
    }
    
    public Classe() {
    }

    public Classe(int code_niveau,String libelle_court) {
        this.code_niveau = code_niveau;
        this.setNiveau(code_niveau);
//        this.code_classe = code_classe;
        this.libelle_court = libelle_court;
    }

    public Classe(int code_niveau, String libelle_court, int code) {
        this.code_niveau = code_niveau;
        this.setNiveau(code_niveau);
        this.libelle_court = libelle_court;
        this.code = code;
    }
    
    public static Classe getClasse(int code) {
        for (Classe classe : liste) {
            if(classe.code == code) 
                return classe;
        }
        return null;
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
        return code_niveau;
    }

    public void setId_niveau(int code_niveau) {
        this.code_niveau = code_niveau;
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
    
    public void setNiveau(int code) {
        this.niveau = Niveau.getNiveau(code);
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
