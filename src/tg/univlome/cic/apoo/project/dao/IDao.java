/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tg.univlome.cic.apoo.project.dao;

import java.util.List;

/**
 *
 * @author leBoulanger
 */
public interface IDao<T> {
    public void supprimer(T object);
    public T trouver(T object, Long id);
    public T modifier(T object, Long id);
    public List<T> lister();
    public List<T> lister(Long id);
}
