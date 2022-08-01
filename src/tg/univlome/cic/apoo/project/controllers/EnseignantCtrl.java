/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.controllers;

import java.util.List;
import tg.univlome.cic.apoo.project.entities.Enseignant;
import tg.univlome.cic.apoo.project.entities.Notes;
import tg.univlome.cic.apoo.project.traitements.EntityCliCRUD;

/**
 *
 * @author leBoulanger
 */
public class EnseignantCtrl {
    private EntityCliCRUD finder = new EntityCliCRUD();
    
    public List<Enseignant> getListe() {
        return Enseignant.getListe();
    }
    
    public Enseignant trouver(Enseignant e) {
        return finder.trouver(e, getListe());
    }
    
    
    /* Pour exécuter ces fonctions, on doit avoir un élève qui existe dékà et non un élève volatile*/
//    public Classe getClasse(Enseignant e) {
//        return e.getClasse();
//    } get spéciality ici plutôt
    
    public List<Notes> getNotes(Enseignant e) {
        return e.getNotes();
    }
    
    public String getNom(Enseignant e) {
        return e.getNom();
    }
    
    public String getPrenom(Enseignant e) {
        return e.getPrenom();
    }
    
    public int getId(Enseignant e) {
        return e.getId();
    }
}
