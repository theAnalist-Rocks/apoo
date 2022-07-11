/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 *
 * @author leBoulanger
 */
public class App extends JFrame {
    private static JPanel sideBar = new JPanel();
    private static JPanel main = new JPanel();
    private static GridBagConstraints gbc = new GridBagConstraints();
    private static Home home = new Home();
    
    public static void scalfold() {
        sideBar.setSize(200, 900);
        main.setSize(800, 900);
        main.setPreferredSize(new Dimension(800, 900));
        sideBar.setVisible(true);
        main.setVisible(true);
    }
    
    //scalfold
    public static void setBtnColor(Color c, JButton btn) {
        btn.setBackground(c);
        btn.setPreferredSize(new Dimension(200, 60));
        btn.setSize(200, 50);
//        btn.setMaximumSize(new Dimension(200, 30));
//        btn.setMinimumSize(new Dimension(200, 30));
    }
    
    public static void welcome(){
        JLabel welcome = new JLabel("Notes Manager");
        welcome.setHorizontalAlignment(SwingConstants.CENTER);
        welcome.setFont(new Font("Serif", Font.ROMAN_BASELINE, 47));
        JLabel text = new JLabel("Ceci est un charabia");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        main.add(welcome, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        main.add(text, gbc);
    }
    
    public static void scalfoldButtons() {
        Home home = new Home("Ceci est un autre Home");
        JButton btn1 = new JButton("Home");
        JButton btn2 = new JButton("Eleve");
        JButton btn3 = new JButton("Evaluer");
        JButton btn4 = new JButton("DashBord");
        JButton btn5 = new JButton("About Us");
        
        setBtnColor(new Color(255, 255, 255), btn1);
        setBtnColor(new Color(255, 255, 255), btn2);
        setBtnColor(new Color(255, 255, 255), btn3);
        setBtnColor(new Color(255, 255, 255), btn4);
        setBtnColor(new Color(255, 255, 255), btn5);
        
        addActionListener(btn1, home, 0);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        addSideBarItem(btn1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        addSideBarItem(btn2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        addSideBarItem(btn3, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        addSideBarItem(btn4, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        addSideBarItem(btn5, gbc);
        
    }
    
    public static void addActionListener(JButton btn, Component c, int old) {
        btn.addActionListener((ActionEvent ae) -> {
            changePage(old, c);
        });
    }
    
    public static void addSideBarItem(Component comp) {
        sideBar.add(comp);
    }
    
    public static void addSideBarItem(Component comp, Object constraints) {
        sideBar.add(comp, constraints);
    }
    
    public static void changePage(Component old, Component comp) {
        main.remove(old);
        main.add(comp);
        main.repaint();
    }
    
    public static void changePage(int old, Component comp) {
        main.remove(old);
        main.add(comp);
        main.repaint();
    }
    
    public static void main(String[] argv) {
        App app = new App();
        app.setLayout(new BorderLayout());
        scalfold();
        sideBar.setLayout(new GridBagLayout());
        sideBar.setBackground(new Color(76, 41, 211));
        scalfoldButtons();
        main.setLayout(new GridBagLayout());
        welcome();
        
        app.add(sideBar, BorderLayout.WEST);
        app.add(main, BorderLayout.CENTER);
        app.setSize(1000, 900);
        app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        app.setVisible(true);
    }
}
