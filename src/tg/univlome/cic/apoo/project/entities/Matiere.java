/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import tg.univlome.cic.apoo.project.dao.DaoImpl;
import tg.univlome.cic.apoo.project.dao.IDao;

/**
 *
 * @author leBoulanger
 */
@Entity
@Table(name="matieres")
public class Matiere implements Serializable {
    private static List<Matiere> liste = new ArrayList<>();
    private static IDao manager = new DaoImpl();
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name="intitulle")
    private String intitulle;
    @Column(name="code")
    private int code;
    
    static {
        Matiere mat = new Matiere("Maths", 100);
        Matiere mat1 = new Matiere("Ang", 101);
        Matiere mat2 = new Matiere("Svt", 102);
        Matiere mat3 = new Matiere("HG", 103);
        Matiere mat4 = new Matiere("PC", 104);
        Matiere mat5 = new Matiere("FR", 105);
        
        liste.add(mat);
        liste.add(mat1);
        liste.add(mat2);
        liste.add(mat3);
        liste.add(mat4);
        liste.add(mat5);
        
        manager.ajouter(mat);
        manager.ajouter(mat1);
        manager.ajouter(mat2);
        manager.ajouter(mat3);
        manager.ajouter(mat4);
        manager.ajouter(mat5);
        
    }

    public Matiere() {
    }

    
    
    public Matiere(String intitulle, int code) {
        this.intitulle = intitulle;
        this.code = code;
    }

    public static Matiere getMatiere(int code) {
        for (Matiere matiere : liste) {
            if(matiere.code == code)
                return matiere;
        }
        return null;
    }
    
    public String getIntitulle() {
        return intitulle;
    }

    public void setIntitulle(String intitulle) {
        this.intitulle = intitulle;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static List<Matiere> getListe() {
        return liste;
    }

    public static void setListe(List<Matiere> liste) {
        Matiere.liste = liste;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.intitulle);
        hash = 53 * hash + Objects.hashCode(this.code);
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
        final Matiere other = (Matiere) obj;
        if (!Objects.equals(this.intitulle, other.intitulle)) {
            return false;
        }
        return Objects.equals(this.code, other.code);
    }
    
    
    
}
