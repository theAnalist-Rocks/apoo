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
import tg.univlome.cic.apoo.project.service.TypeEvaluationService;

/**
 *
 * @author leBoulanger
 */
@Entity
@Table(name="type_evaluation")
public class TypeEvaluation implements Serializable {
    private static List<TypeEvaluation> liste = new ArrayList<>();
    private static IDao manager = new DaoImpl();
    @Column(name="type")
    private String type;
    @Column(name="code")
    private int code;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    static {
        TypeEvaluation interro = new TypeEvaluation("INT", 0);
        TypeEvaluation dst = new TypeEvaluation("DST", 1);
        TypeEvaluation exam = new TypeEvaluation("Examen", 2);
        liste.add(dst);
        liste.add(exam);
        
        manager.ajouter(dst);
        manager.ajouter(exam);
    }

    public TypeEvaluation() {
    }

    public TypeEvaluation(String type) {
        this.type = type;
    }
    

    public TypeEvaluation(String typeShort, int code) {
        this.type = typeShort;
        this.code = code;

    }
    
    public static TypeEvaluation getTypeEval(int code) {
        return new TypeEvaluationService().getPeriode(code);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = (int) (37 * hash + this.id);
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
        final TypeEvaluation other = (TypeEvaluation) obj;
        return this.id == other.id;
    }

    
    
    
}
