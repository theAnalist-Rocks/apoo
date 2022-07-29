/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.controllers;

import java.util.List;
import tg.univlome.cic.apoo.project.entities.Classe;

/**
 *
 * @author leBoulanger
 */
public class ClasseCtrl {
    public static List<Classe> getClasses() {
        return Classe.getListe();
    }
}
