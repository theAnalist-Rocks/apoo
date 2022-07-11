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

/**
 *
 * @author leBoulanger
 */
@Entity
@Table(name="matiere")
public class Matiere implements Serializable {
    private static List<Matiere> liste = new ArrayList<>();
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name="intitulle")
    private String intitulle;
    @Column(name="code")
    private int code;

    public Matiere() {
    }

    
    
    public Matiere(String intitulle, int code) {
        this.intitulle = intitulle;
        this.code = code;
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
