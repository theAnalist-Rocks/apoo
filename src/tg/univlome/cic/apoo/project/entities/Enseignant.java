/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import tg.univlome.cic.apoo.project.dao.DaoImpl;
import tg.univlome.cic.apoo.project.dao.IDao;

/**
 *
 * @author leBoulanger
 */
@Entity
@Table(name="enseignants")
public class Enseignant implements Serializable {
    private static List<Enseignant> liste = new ArrayList<>();
    private static IDao manager = new DaoImpl();
    
    @Column(name="nom")
    private String nom;
    @Column(name="prenom")
    private String prenom;
    @Column(name="age")
    private int age;
    @Column(name="base_salary")
    private float baseSalarial;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @OneToMany(fetch=FetchType.LAZY, cascade=(CascadeType.PERSIST))// mappedBy = "enseignants", targetEntity = Notes.class)
    private List<Notes> notes = new ArrayList<>();
    @OneToMany(fetch=FetchType.LAZY, cascade=(CascadeType.PERSIST))// mappedBy = "cours", targetEntity = Cours.class)
    private List<Cours> cours = new ArrayList<>();
    
    static {
        Enseignant e1 = new Enseignant("Yovo", "Amevi", 27, (float) 21);
        Enseignant e2 = new Enseignant("Ma", "Cooper", 23, (float)11);
        Enseignant e3 = new Enseignant("LeBoulanger", "Thomas", 29,(float) 12);
        liste.addAll(Arrays.asList(e1, e2, e3));
        
        manager.ajouter(e1);
        manager.ajouter(e2);
        manager.ajouter(e3);
    }

    public Enseignant() {
    }

    public Enseignant(String nom, String prenom, int age, float baseSalarial) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.baseSalarial = baseSalarial;
    }
    
    public Enseignant(int id) {
        this.id = id;
    }

    public Enseignant(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }
    
    public Enseignant(String nom, String prenom, int age, int code) {
        this(nom, prenom, age);
        this.id = code;
    }
    
    public static Enseignant getEnseignant(int code) {
        for (Enseignant enseignant : liste) {
            if (enseignant.id == code)
                return enseignant;
        }
        return null;
    }

    public void ajouterNote(Notes n) {
        notes.add(n);
    }
    
    public void ajouterNote(float value, Evaluation eval, Eleve e) {
        ajouterNote(new Notes(e, eval, value));
    }
    
    public void enleverNote(Notes n) {
        notes.remove(n);
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getBaseSalarial() {
        return baseSalarial;
    }

    public void setBaseSalarial(float baseSalarial) {
        this.baseSalarial = baseSalarial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static List<Enseignant> getListe() {
        return liste;
    }

    public static void setListe(List<Enseignant> liste) {
        Enseignant.liste = liste;
    }

    public List<Notes> getNotes() {
        return notes;
    }

    public void setNotes(List<Notes> notes) {
        this.notes = notes;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
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
        final Enseignant other = (Enseignant) obj;
        return this.id == other.id;
    }
    
    
}
