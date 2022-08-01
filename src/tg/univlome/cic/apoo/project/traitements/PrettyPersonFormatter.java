/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.traitements;

import java.util.List;
import tg.univlome.cic.apoo.project.entities.Classe;
import tg.univlome.cic.apoo.project.entities.Eleve;
import tg.univlome.cic.apoo.project.entities.Enseignant;

/**
 *
 * @author leBoulanger
 */
public class PrettyPersonFormatter {
    public static String[][] formatListEleve(List<Eleve> liste, int columns){
        String[][] data = new String[64][columns];
        int x = 0;
        for (Eleve e : liste) {
                data[x][0] = e.getId() + "";
                data[x][1] = e.getNom();
                data[x][2] = e.getPrenom();
                data[x][3] = e.getAge() + "";
            x++;
        }
        return data;
    }
    
    public static String[][] formatListEnseignant(List<Enseignant> liste, int columns){
        String[][] data = new String[255][columns];
        int x = 0;
        for (Enseignant e : liste) {
                data[x][0] = e.getId() + "";
                data[x][1] = e.getNom();
                data[x][2] = e.getPrenom();
                data[x][3] = e.getAge() + "";
            x++;
        }
        return data;
    }

}
