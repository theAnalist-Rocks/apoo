/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.project.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import tg.univlome.cic.apoo.project.dao.DaoImpl;
import tg.univlome.cic.apoo.project.dao.IDao;
import tg.univlome.cic.apoo.project.entities.Classe;
import tg.univlome.cic.apoo.project.entities.Eleve;
import tg.univlome.cic.apoo.project.entities.Enseignant;
import tg.univlome.cic.apoo.project.service.ClasseService;

/**
 *
 * @author leBoulanger
 */
public class MainApp extends JFrame {
    private static JButton ajouter = new JButton("Ajout");
    private static JButton classe = new JButton("Classe");
    private static JButton enseignant = new JButton("Enseignant");
    private static JButton noter = new JButton("Noter");
    private static JButton valider = new JButton("Ajouter");
    private static JTextField nom = new JTextField("Nom");
    private static JTextField prenom = new JTextField("Prenom");
    private static JTextField age = new JTextField("Age");
    private static JLabel welcome = new JLabel("Welcome");
    private static JList listeClasse;
    private static String[] items = {"Eleve", "Enseignant"};
    private static JComboBox<String> choix = new JComboBox<>(items);
    private static JPanel main = new JPanel();
    private static JPanel sideMenu = new JPanel();
    private static JPanel ajouterPanel = new JPanel();
    private static JPanel classePanel = new JPanel();
    private static JPanel enseignantPanel = new JPanel();
    private static IDao manager = new DaoImpl();
    
    public MainApp() {
        initComposants();
    }
    
    public void initComposants() {
        nom.setSize(300, 20);
        nom.setPreferredSize(new Dimension(300, 20));
        prenom.setSize(300, 20);
        prenom.setPreferredSize(new Dimension(300, 20));
        age.setSize(300, 20);
        age.setPreferredSize(new Dimension(300, 20));
        choix.setSize(300, 20);
        choix.setPreferredSize(new Dimension(300, 20));
        valider.setSize(300, 20);
        valider.setPreferredSize(new Dimension(300, 20));
        welcome.setForeground(Color.WHITE);
        
        ajouter.setSize(200, 50);
        ajouter.setPreferredSize(new Dimension(200, 50));
        noter.setSize(200, 50);
        noter.setPreferredSize(new Dimension(200, 50));
        classe.setSize(200, 50);
        classe.setPreferredSize(new Dimension(200, 50));
        enseignant.setSize(200, 50);
        enseignant.setPreferredSize(new Dimension(200, 50));
    }
    
    public static void main(String[] argv) {
        MainApp app = new MainApp();
        app.setLayout(new BorderLayout());
        
        // page ajouter
        //ajouterPanel.setLayout(new BorderLayout());
        //container panel
        JLabel ajouterLabel = new JLabel("Ajouter Une Personne");
        ajouterLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
        
        ajouterPanel.setLayout(new GridLayout(6, 1,20, 10));
        ajouterPanel.add(nom);
        ajouterPanel.add(prenom);
        ajouterPanel.add(age);
        ajouterPanel.add(choix);
        ajouterPanel.add(valider);
        ajouterPanel.setSize(400, 600);
        ajouterPanel.setPreferredSize(new Dimension(200, 300));
//        ajouterPanel.setBackground(Color.red);
        //action listener
        valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nomS = nom.getText();
                String prenomS = prenom.getText();
                int ageI = Integer.parseInt(age.getText());
                if (!prenomS.equals("Prenom") && !nomS.equals("Nom") && !age.getText().equals("Age")) {
                    if ("Eleve".equals(choix.getSelectedItem().toString())) {
                        Eleve eleve_ = new Eleve(nomS, prenomS, ageI);
                        manager.ajouter(eleve_);
                    }else {
                        Enseignant ens_ = new Enseignant(nomS, prenomS, ageI);
                        manager.ajouter(ens_);
                    }
                }
                nom.setText("Nom");
                prenom.setText("Prenom");
                age.setText("Age");
           }
        });
        main.setSize(400, 700);
        sideMenu.setSize(200, 700);
        sideMenu.setPreferredSize(new Dimension(200, 500));
        sideMenu.setBackground(new Color(54, 79, 124));
        sideMenu.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        sideMenu.add(welcome, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        sideMenu.add(ajouter, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        sideMenu.add(noter, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        sideMenu.add(enseignant, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        sideMenu.add(classe, gbc);
        
        // classes list
        classe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                main.remove(1);
                main.add(classePanel);
                main.repaint();
            }
        });
        ClasseService service = new ClasseService();
        List<Classe> list_classes = service.getClasses();
        //listeClasse = new JList((ListModel) liste_classes);
        
        
        //mettre ajouterLabel et ajouterPanel dans un même contenaire
        main.add(ajouterLabel);
        main.add(ajouterPanel);
        
        app.add(sideMenu, BorderLayout.WEST);
        app.add(main, BorderLayout.CENTER);
        app.setSize(700, 700);
        app.setResizable(false);
        app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        app.setVisible(true);
    }
}
