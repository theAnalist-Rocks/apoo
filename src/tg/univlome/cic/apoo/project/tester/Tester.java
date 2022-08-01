/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.tester;

import java.util.ArrayList;
import java.util.List;
import tg.univlome.cic.apoo.project.controllers.EleveCtrl;
import tg.univlome.cic.apoo.project.dao.DaoImpl;
import tg.univlome.cic.apoo.project.dao.IDao;
import tg.univlome.cic.apoo.project.entities.Classe;
import tg.univlome.cic.apoo.project.entities.Cours;
import tg.univlome.cic.apoo.project.entities.Eleve;
import tg.univlome.cic.apoo.project.entities.Enseignant;
import tg.univlome.cic.apoo.project.entities.Enseignement;
import tg.univlome.cic.apoo.project.entities.Notes;
import tg.univlome.cic.apoo.project.entities.Periode;
import tg.univlome.cic.apoo.project.entities.TypeEvaluation;
import tg.univlome.cic.apoo.project.traitements.EntityCliCRUD;

/**
 *
 * @author leBoulanger
 */
public class Tester {
    
    public static void main(String[] agrs) {
        Enseignant ens = Enseignant.getEnseignant(0);
        Enseignement ensm = Enseignement.getEnseignement(0);
        Classe c = Classe.getClasse(0);
        Cours cours = Cours.getCours(0);
        Periode p = Periode.getPeriode(0);
        TypeEvaluation t = TypeEvaluation.getTypeEval(1);
        Eleve e = Eleve.getEleve(21);
        Notes note = new Notes(21, 0, 20, 2);
        e.addNote(note);
        IDao dao  = new DaoImpl();
        dao.modifier(note);
        dao.ajouter(e);
        
        System.out.println("Classe: " + c.getId());
        System.out.println("Enseignement: " + ensm.getId());
        System.out.println("Enseignant: " + ens.getNom() + " " + ens.getId());
        System.out.println("Cours: " + cours.getId());
        System.out.println("Periode: " + p.getId());
        System.out.println("Type: " + t.getId());
        System.out.println("Eleve: " + e.getId());
        System.out.println("Note: " + note.getEleve().getId());
        
           
    }
}
