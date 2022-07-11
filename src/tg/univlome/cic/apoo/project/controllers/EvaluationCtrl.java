/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.controllers;

import java.util.List;
import tg.univlome.cic.apoo.project.entities.Classe;
import tg.univlome.cic.apoo.project.entities.Evaluation;
import tg.univlome.cic.apoo.project.traitements.EntityCliCRUD;

/**
 *
 * @author leBoulanger
 */
public class EvaluationCtrl {
        private EntityCliCRUD finder = new EntityCliCRUD();
    
    public List<Evaluation> getListe() {
        return Evaluation.getListe();
    }
    
    public Evaluation trouver(Evaluation e) {
        return finder.trouver(e, getListe());
    }
    
    public Evaluation trouver(Long id) {
        return trouver(new Evaluation(id));
    }
    
    /* Pour exécuter ces fonctions, on doit avoir un élève qui existe dékà et non un élève volatile*/ 
    public Long getId(Evaluation e) {
        return e.getId();
    }
}
