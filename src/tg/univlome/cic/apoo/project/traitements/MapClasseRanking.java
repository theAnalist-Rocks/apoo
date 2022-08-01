/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.traitements;

/**
 *
 * @author leBoulanger
 */
public class MapClasseRanking {
    private String nom;
    private String prenom;
    private float moyenne;
    private int idPeriode;
    
    public MapClasseRanking() {
        
    }
    
    public MapClasseRanking(String nom, String prenom, float moyenne, int idPeriode) {
        this.nom = nom;
        this.prenom = prenom;
        this.moyenne = moyenne;
        this.idPeriode = idPeriode;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public float getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
    }

    public int getIdPeriode() {
        return idPeriode;
    }

    public void setIdPeriode(int idPeriode) {
        this.idPeriode = idPeriode;
    }
    
}
