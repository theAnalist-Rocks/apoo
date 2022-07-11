/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.traitements;

import java.util.List;
import tg.univlome.cic.apoo.project.entities.Eleve;
import tg.univlome.cic.apoo.project.entities.Periode;
import tg.univlome.cic.apoo.project.entities.TypeEvaluation;

/**
 *
 * @author leBoulanger
 */
public class Bulletin {
    private Periode periode;
    private int id;

    public Bulletin() {
    }

    public Bulletin(int id) {
        this.id = id;
    }
    
    public Bulletin(Periode p, int id) {
        this.periode = p;
        this.id = id;
    }
    

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
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
        hash = 89 * hash + this.id;
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
        final Bulletin other = (Bulletin) obj;
        return this.id == other.id;
    }
    
    
}
