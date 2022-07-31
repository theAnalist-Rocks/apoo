/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
@Table(name="niveaux")
public class Niveau implements Serializable {
    private static List<Niveau> liste = new ArrayList<>();
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name="label")
    private String label;
    @Column(name="code")
    private int code;
    @Column(name="description")
    private String description;
    private static IDao manager = new DaoImpl();
    
    static {
        Niveau lvl2 = new Niveau("Cinquième", 5, "Niveau Cinquième");
        Niveau lvl1 = new Niveau("Sixième", 6, "Niveau Sixième");
        Niveau lvl3 = new Niveau("Quatrième", 4, "Niveau Quatrième");
        Niveau lvl4 = new Niveau("Troisième", 3, "Niveau Troisième");
        
        liste.add(lvl1);
        liste.add(lvl2);
        liste.add(lvl3);
        liste.add(lvl4);
        manager.ajouter(Arrays.asList(lvl1, lvl2, lvl3, lvl4));
        
    }

    public Niveau() {
    }

    public Niveau(String label, int code, String description) {
        this.label = label;
        this.code = code;
        this.description = description;
    }
    
    public static Niveau getNiveau(int code) {
        for (Niveau niveau : liste) {
            if(niveau.code == code) {
                return niveau;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static List<Niveau> getListe() {
        return liste;
    }

    public static void setListe(List<Niveau> liste) {
        Niveau.liste = liste;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.id;
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
        final Niveau other = (Niveau) obj;
        return this.id == other.id;
    }

}
