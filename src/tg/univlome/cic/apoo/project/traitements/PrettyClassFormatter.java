/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.traitements;

import java.util.List;
import tg.univlome.cic.apoo.project.entities.Classe;

/**
 *
 * @author leBoulanger
 */
public class PrettyClassFormatter {
    public static String[][] formatList(List<Classe> liste, int columns){
        String[][] data = new String[255][columns];
        int x = 0;
        for (Classe class1 : liste) {
                data[x][0] = ""+class1.getId()+"";
                data[x][1] = class1.getCode_classe_string();
                data[x][2] = class1.getLibelle_long();
            x++;
        }
        return data;
    }
}
