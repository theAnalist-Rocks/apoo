/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.dao;

import java.util.Collection;
import tg.univlome.cic.apoo.project.dao.DaoImpl;
import tg.univlome.cic.apoo.project.dao.IDao;

/**
 *
 * @author leBoulanger
 */
public class Manager {
    private static IDao manager = new DaoImpl();
    
    public static IDao getManager() {
        return manager;
    }
    
    public static void ajouter(Object o) {
        manager.ajouter(o);
    }
    
    public static void ajouter(Collection<Object> liste) {
        manager.ajouter(liste);
    }
}
