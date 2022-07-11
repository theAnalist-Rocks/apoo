/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.Document;

/**
 *
 * @author leBoulanger
 */
public class Home extends JPanel {
    private static JPanel panel = new JPanel();
    
    public Home() {
        scalfold();
        setParams();
    }
    
    public Home(String s) {
        scalfold(s);
        setParams();
    }
    
    public void setParams() {
        setLayout(new BorderLayout());
        setSize(800, 900);
        setVisible(true);
    }
    
    public void scalfold() {
        JLabel welcome = new JLabel("Notes Manager");
        welcome.setFont(new Font("Serif", Font.ROMAN_BASELINE, 47));
        JTextArea text = new JTextArea("Ceci est un charabia");
        
        add(welcome, BorderLayout.NORTH);
        add(text);
    }
    
        public void scalfold(String s) {
        JLabel welcome = new JLabel(s);
        welcome.setFont(new Font("Serif", Font.ROMAN_BASELINE, 47));
        JTextArea text = new JTextArea("Ceci est un charabia");
        
        add(welcome, BorderLayout.NORTH);
        add(text);
    }
}
