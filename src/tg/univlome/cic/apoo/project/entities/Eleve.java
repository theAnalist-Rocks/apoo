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
import tg.univlome.cic.apoo.project.service.EleveService;

/**
 *
 * @author leBoulanger
 */
@Entity
@Table(name="eleves")
public class Eleve implements Serializable {
    private static List<Eleve> liste = new ArrayList<>();
    private static int count = 0;
    @Column(name="nom")
    private String nom;
    @Column(name="prenom")
    private String prenom;
    @Column(name="age")
    private int age;
    @Column(name="id_classe")
    private int id_classe;
    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Classe classe;
    @Column(name="num_matricule")
    private int matricule;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @OneToMany(fetch=FetchType.LAZY, cascade=(CascadeType.PERSIST))
    private List<Notes> notes = new ArrayList<>();
    
    static {
        liste.add(new Eleve("Adenyo", "Junior", 0));
        liste.add(new Eleve("Benissan", "Winner", 1));
        liste.add(new Eleve("Attitsogbe", "Daniel", 2));
        liste.add(new Eleve("Kombede", "Magloire", 3));
        liste.add(new Eleve("Ouro", "Ridoine", 4));
    }

    public Eleve() {
        Eleve.count ++;
        this.matricule = count;
    }
    
    public Eleve(int id) {
        this();
        this.id = id;
    }

    public Eleve(String nom, String prenom, int age) {
        this();
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }
    
        public Eleve(String nom, String prenom, int age, int mat) {
        this();
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.matricule = mat;
    }
    
    public static Eleve getEleve(int code) {
        return new EleveService().getEleve(code);
    }
    
    public List<Notes> getNotes(Periode p) {
        List<Notes> liste = new ArrayList<>();
        for (Notes note : notes) {
            if(note.getEvaluation().getPeriode().equals(p)) {
                liste.add(note); // notes de la période donnée
            }
        }
        return liste;
    }
    
    public List<Notes> getNotes(TypeEvaluation t) {
        List<Notes> liste = new ArrayList<>();
        for (Notes note : notes) {
            if(note.getEvaluation().getTypeEvaluation().equals(t)) {
                liste.add(note);
            }
        }
        return liste;
    }
    
    public void addNote(Notes n) {
        this.notes.add(n);
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

    public int getId_classe() {
        return id_classe;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public static List<Eleve> getListe() {
        return liste;
    }

    public static void setListe(List<Eleve> liste) {
        Eleve.liste = liste;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Notes> getNotes() {
        return notes;
    }

    public void setNotes(List<Notes> notes) {
        this.notes = notes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.id;
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
        final Eleve other = (Eleve) obj;
        return this.id == other.id;
    }
    
    

    @Override
    public String toString() {
        return "Eleve{" + "nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", id_classe=" + id_classe + ", classe=" + classe + ", matricule=" + matricule + ", id=" + id + ", notes=" + notes + '}';
    }
    
    
}
