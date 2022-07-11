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
@Table(name="classe")
public class Classe implements Serializable {
    private static List<Classe> liste = new ArrayList<>();

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name="id_niveau")
    private int id_niveau;
    @Column(name="code_classe")
    private int code_classe;
    @Column(name="code_classe_string")
    private String code_classe_string;
    private List<Eleve> listeEleve = new ArrayList<>();

    public Classe() {
    }

    public Classe(int id_niveau, int code_classe, String code_classe_string) {
        this.id_niveau = id_niveau;
        this.code_classe = code_classe;
        this.code_classe_string = code_classe_string;
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

    public int getCode_classe() {
        return code_classe;
    }

    public void setCode_classe(int code_classe) {
        this.code_classe = code_classe;
    }

    public String getCode_classe_string() {
        return code_classe_string;
    }

    public void setCode_classe_string(String code_classe_string) {
        this.code_classe_string = code_classe_string;
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
