/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.controllers;

import java.util.ArrayList;
import java.util.List;
import tg.univlome.cic.apoo.project.entities.Classe;
import tg.univlome.cic.apoo.project.entities.Cours;
import tg.univlome.cic.apoo.project.entities.Eleve;
import tg.univlome.cic.apoo.project.entities.Evaluation;
import tg.univlome.cic.apoo.project.entities.Notes;
import tg.univlome.cic.apoo.project.entities.Periode;
import tg.univlome.cic.apoo.project.entities.TypeEvaluation;
import tg.univlome.cic.apoo.project.traitements.EntityCliCRUD;

/**
 *
 * @author leBoulanger
 */
public class EleveCtrl {
    private EntityCliCRUD finder = new EntityCliCRUD();
    
    public List<Eleve> getListe() {
        return Eleve.getListe();
    }
    
    public void ajouter(Eleve e) {
        finder.ajouter(e, getListe());
    }
    
    public Eleve trouver(Eleve e) {
        return finder.trouver(e, getListe());
    }
    
    public Eleve trouver(int id) {
        return trouver(new Eleve(id));
    }
    
    public void supprimer(Eleve e) {
        finder.suppirmer(e, getListe());
    }
    
    /* Pour exécuter ces fonctions, on doit avoir un élève qui existe dékà et non un élève volatile*/
    public Classe getClasse(Eleve e) {
        return e.getClasse();
    }
    
    public List<Notes> getNotes(Eleve e) {
        return e.getNotes();
    }
    
    public String getNom(Eleve e) {
        return e.getNom();
    }
    
    public String getPrenom(Eleve e) {
        return e.getPrenom();
    }
    
    public List<Evaluation> getEvaluation(Eleve e) {
        List<Evaluation> liste = new ArrayList<>();
        for (Notes note : getNotes(e)) {
            liste.add(note.getEvaluation());
        }
        return liste;
    }
    
    public List<Notes> getNotes(Eleve e, TypeEvaluation t) {
        List<Notes> liste = new ArrayList<>();
        for (Notes note : getNotes(e)) {
            if(note.getEvaluation().getTypeEvaluation().equals(t)) {
                liste.add(note);
            }
        }
        return liste;
    }
    
    public int getId(Eleve e) {
        return e.getId();
    }
    
    public List<Cours> getListCours(Eleve e) {
        return e.getClasse().getCours();
    }
    
//    public float getMoyenneGenerale(Periode p, Eleve e) {
//        return p.getMoyenne(getListCours(e), listTypes, e)
//    }
}
