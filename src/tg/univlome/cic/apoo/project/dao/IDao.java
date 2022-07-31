/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tg.univlome.cic.apoo.project.dao;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author leBoulanger
 */
public interface IDao<T> {
    public <T> T ajouter(T object);
    public <T> void ajouter(Collection< ? extends T> object);
    public void supprimer(T object);
//    public <T> T trouver(T object, Long id);
    public T modifier(T object);
    public <T> void modifier(Collection<? extends T> object);
    public List<T> lister();
    public List<T> lister(Long id);
}
