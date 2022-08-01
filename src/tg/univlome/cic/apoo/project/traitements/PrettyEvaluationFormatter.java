/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.traitements;

import java.util.List;
import tg.univlome.cic.apoo.project.entities.Evaluation;

/**
 *
 * @author leBoulanger
 */
public class PrettyEvaluationFormatter {
    public static String[][] formatList(List<Evaluation> liste, int columns){
        String[][] data = new String[64][columns];
        int x = 0;
        for (Evaluation e : liste) {
                data[x][0] = e.getId() + "";
                data[x][1] = e.getId_periode() + "";
                data[x][2] = e.getPoids() + "";
                data[x][3] = e.getCode() + "";
            x++;
        }
        return data;
    }
}
