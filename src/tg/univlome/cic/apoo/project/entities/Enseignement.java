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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import tg.univlome.cic.apoo.project.dao.DaoImpl;
import tg.univlome.cic.apoo.project.dao.IDao;
import tg.univlome.cic.apoo.project.dao.Manager;
import tg.univlome.cic.apoo.project.service.CoursService;
import tg.univlome.cic.apoo.project.service.EnseignementService;

/**
 *
 * @author leBoulanger
 */
@Entity
@Table(name="enseignements")
public class Enseignement implements Serializable {
    private static List<Enseignement> liste = new ArrayList<>();
    private static IDao manager = new DaoImpl();
    private static CoursService service = new CoursService();
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name="coefficient")
    private float coefficient;
    @Column(name="id_niveau")
    private int id_niveau;
    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
    private Niveau niveau;
    @Column(name="id_matiere")
    private int id_matiere;
    @ManyToOne(fetch=FetchType.LAZY, cascade=(CascadeType.PERSIST))//, targetEntity = Matiere.class)
    private Matiere matiere;
    @Column(name="code")
    private int code;
    
    static {
        Enseignement e1 = new Enseignement(2, 3, 100, 0);
        Enseignement e2 = new Enseignement(2, 3, 102, 1);
        Enseignement e3 = new Enseignement(2, 3, 103, 2);
        Enseignement e4 = new Enseignement(2, 3, 104, 3);
        Enseignement e5 = new Enseignement(2, 3, 105, 4);
        Enseignement e6 = new Enseignement(2, 3, 101, 5);
        
        liste.add(e1);
        liste.addAll(Arrays.asList(e2, e3, e4, e5, e6));
//        manager.ajouter(Arrays.asList(e1, e2, e3, e4, e5, e6));

        manager.modifier(Arrays.asList(e1, e2, e3, e4, e5, e6));
    }

    public Enseignement(float coefficient, int id_niveau, int id_matiere, int code) {
        this.coefficient = coefficient;
        this.setNiveau(id_niveau);
        this.id_niveau = id_niveau;
        this.setMatiere(id_matiere);
        this.id_matiere = id_matiere;
        this.code = code;
    }
    
    public Enseignement(int id_niveau, int id_matiere, int code) {
        this.coefficient = 2;
        this.setNiveau(id_niveau);
        this.id_niveau = id_niveau;
        this.setMatiere(id_matiere);
        this.id_matiere = id_matiere;
        this.code = code;
    }

    public Enseignement(float coefficient, Niveau niveau, Matiere matiere) {
        this.coefficient = coefficient;
        this.niveau = niveau;
        this.matiere = matiere;
    }

    public Enseignement() {
    }
    
    public static Enseignement getEnseignement(int code) {
        return new EnseignementService().getEnseignement(code);
    }

    public static List<Enseignement> getListe() {
        return liste;
    }

    public static void setListe(List<Enseignement> liste) {
        Enseignement.liste = liste;
    }
    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
    
    public void setNiveau(int code) {
        this.niveau = Niveau.getNiveau(code);
        System.out.println(">>> ESM Niveau ID: "+niveau.getId());
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }
    
    public void setMatiere(int code) {
        this.matiere = Matiere.getMatiere(code);
        System.out.println(">>> ESM Matiere ID: " + matiere.getId());
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
