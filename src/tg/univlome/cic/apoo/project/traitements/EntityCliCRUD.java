/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.traitements;

import java.util.List;

/**
 *
 * @author leBoulanger
 */
public class EntityCliCRUD {
    public <T> T trouver(T type, List<T> list) {
        for (T t : list) {
            if(t.equals(type)) {
                return t;
            }
        }
        return null;
    }
    
    public <T> void suppirmer(T type, List<T> list) {
        list.remove(type);
    }
    
    public <T> void ajouter(T type, List<T> list) {
        list.add(type);
    }
}
