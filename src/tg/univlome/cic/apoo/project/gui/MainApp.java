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
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import tg.univlome.cic.apoo.project.dao.DaoImpl;
import tg.univlome.cic.apoo.project.dao.IDao;
import tg.univlome.cic.apoo.project.entities.Classe;
import tg.univlome.cic.apoo.project.entities.Eleve;
import tg.univlome.cic.apoo.project.entities.Enseignant;
import tg.univlome.cic.apoo.project.entities.Niveau;
import tg.univlome.cic.apoo.project.service.ClasseService;
import tg.univlome.cic.apoo.project.service.EleveService;
import tg.univlome.cic.apoo.project.traitements.PrettyClassFormatter;
import tg.univlome.cic.apoo.project.traitements.PrettyPersonFormatter;

/**
 *
 * @author leBoulanger
 */
public class MainApp extends JFrame {
    private static JButton creer = new JButton("Créer");
    private static JButton ajouter = new JButton("Créer Personne");
    private static JButton classe = new JButton("Lister Classe");
    private static JButton enseignant = new JButton("Enseignant");
    private static JButton noter = new JButton("Noter");
    private static JButton eleves = new JButton("Lister Elèves");
    private static JButton evaluations = new JButton("Creer Evaluation");
    private static JButton enseignement = new JButton("Créer Enseignement");
    private static JButton periode = new JButton("Periodes");
    private static JButton valider = new JButton("Ajouter");
    private static JButton refresh = new JButton("Refresh");
    private static JButton refreshEleve = new JButton("Refresh");
    private static JButton creerEvaluation = new JButton("Creer");
    private static JButton creerEnseignement = new JButton("Creer");
    private static JTextField nom = new JTextField("Nom");
    private static JTextField prenom = new JTextField("Prenom");
    private static JTextField age = new JTextField("Age");
    private static JTextField noter_id_evele = new JTextField("Identifiant de l'élève");
    private static JTextField noter_id_evaluation = new JTextField("Identifiant de l'évaluation");
    private static JTextField noter_id_enseignant = new JTextField("Identifiant de l'enseignant");
    private static JTextField noter_value = new JTextField("Valeur obtenue");
    private static JTextField eval_id_cours = new JTextField("Identifiant du Cours");
    private static JTextField eval_id_periode = new JTextField("Identifiant de la Periode");
    private static JTextField eval_id_type_eval = new JTextField("Identifiant de l'Evaluation");
    private static JTextField eval_piods = new JTextField("Poids de l'Evaluation");
    private static JTextField esm_coeff = new JTextField("Coefficient");
    private static JTextField esm_id_niveau = new JTextField("Niveau de l'Enseignement");
    private static JTextField esm_id_matiere = new JTextField("Matiere Enseignée");
    private static JLabel welcome = new JLabel("Welcome");
    private static JList listeClasse;
    private static String[] items = {"Eleve", "Enseignant"};
    private static JComboBox<String> choix = new JComboBox<>(items);
    private static JPanel main = new JPanel();
    private static JPanel sideMenu = new JPanel();
    private static JPanel ajouterPanel = new JPanel();
    private static JPanel classePanel = new JPanel();
    private static JPanel enseignantPanel = new JPanel();
    private static JPanel noterPanel = new JPanel();
    private static JPanel elevesPanel = new JPanel();
    private static JPanel evaluationPanel = new JPanel();
    private static JPanel enseignementPanel = new JPanel();
    private static JPanel creerPanel = new JPanel();
    private static DefaultTableModel model;
    private static String[] classeTableColumns = {"Id", "Libelle_Court", "Libelle_Long"};
    private static String[] personneTableColumns = {"Id", "Nom", "Prenom", "Age"};
    private static JTable tableClasse;
    private static JTable tableEleves;
    private static IDao manager = new DaoImpl();
    
    public MainApp() {
        initComposants();
    }
    
    public void initComposants() {
        setJTextFieldSize(nom);
        setJTextFieldSize(prenom);
        setJTextFieldSize(age);
        
        choix.setSize(300, 20);
        choix.setPreferredSize(new Dimension(300, 20));
        valider.setSize(300, 20);
        valider.setPreferredSize(new Dimension(300, 20));
        
        eval_id_cours.setSize(300, 50);
        eval_id_cours.setPreferredSize(new Dimension(300, 50));
        eval_id_periode.setSize(300, 50);
        eval_id_periode.setPreferredSize(new Dimension(300, 50));
        eval_id_type_eval.setSize(300, 50);
        eval_id_type_eval.setPreferredSize(new Dimension(300, 50));
        eval_piods.setSize(300, 50);
        eval_piods.setPreferredSize(new Dimension(300, 50));
        
        esm_coeff.setSize(300, 50);
        esm_coeff.setPreferredSize(new Dimension(300, 50));
        esm_id_matiere.setSize(300, 50);
        esm_id_matiere.setPreferredSize(new Dimension(300, 50));
        esm_id_niveau.setSize(300, 50);
        esm_id_niveau.setPreferredSize(new Dimension(300, 50));
        
        welcome.setForeground(Color.WHITE);
         
        setPanelButton(refresh);
        setPanelButton(creerEvaluation);
        setPanelButton(creerEnseignement);
        setPanelButton(refreshEleve);
        
        setSideMenuBtn(eleves);
        setSideMenuBtnHoverEffect(eleves);
        setSideMenuBtn(evaluations);
        setSideMenuBtnHoverEffect(evaluations);
        setSideMenuBtn(periode);   
        setSideMenuBtnHoverEffect(periode);
        setSideMenuBtn(ajouter);   
        setSideMenuBtnHoverEffect(ajouter);
        setSideMenuBtn(enseignement);   
        setSideMenuBtnHoverEffect(enseignement);
        setSideMenuBtn(noter);      
        setSideMenuBtnHoverEffect(noter);
        setSideMenuBtn(classe);
        setSideMenuBtnHoverEffect(classe);
        setSideMenuBtn(enseignant);
        setSideMenuBtnHoverEffect(enseignant);
    }
    
    public void setJTextFieldSize(JTextField text) {
        text.setSize(300, 20);
        text.setPreferredSize(new Dimension(300, 20));
    }
    
    public void setPanelButton(JButton btn) {
        btn.setBackground(new Color(54, 79, 124));
        btn.setForeground(Color.WHITE);
        btn.setSize(100, 50);
        btn.setPreferredSize(new Dimension(300, 50));
    }
    
    public void setSideMenuBtn(JButton btn) {
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setForeground(Color.WHITE);
        btn.setSize(200, 50);
        btn.setPreferredSize(new Dimension(200, 50));
    }
    
    public void setSideMenuBtnHoverEffect(JButton btn) {
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            btn.setOpaque(true);
            btn.setContentAreaFilled(true);
            btn.setBorderPainted(false);
            btn.setBackground(Color.WHITE);
            btn.setForeground(Color.BLACK);
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
            btn.setOpaque(false);
            btn.setContentAreaFilled(false);
            btn.setBorderPainted(false);
            btn.setForeground(Color.WHITE);
        }
        });
    }
    
    public static void gridBagComponentStartUp(JPanel parent, List<JButton> items) {
        parent.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.gridx = 0;
        for(int i = 0; i<items.size(); i++) {
            gbc.gridy = i;
            parent.add(items.get(i), gbc);
        }
    }
    
    public static void changePanelActionListener(JButton trigger, JPanel redirect, String jLabelText) {
        trigger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                while(main.getComponentCount() > 0) {
                    main.remove(0);
                }
                
                JLabel noterLabel = new JLabel(jLabelText);
                noterLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
                main.add(noterLabel);
                main.add(redirect);
                main.revalidate();
                main.repaint();
            }
        });
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

        
        valider.setBackground(new Color(54, 79, 124));
        valider.setForeground(Color.WHITE);
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
        List<JButton> items_ = Arrays.asList(ajouter, noter, periode, enseignant, classe, eleves, evaluations, enseignement);
        gridBagComponentStartUp(sideMenu, items_);
        
        // evaluations list
        changePanelActionListener(evaluations, evaluationPanel, "Créer Une Evaluation");
        
        JLabel evaluationWelcome = new JLabel("Créer une Evaluation");
        evaluationPanel.setLayout(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();
        cons.insets = new Insets(10, 0, 10, 0);
        cons.gridx = 0;
        cons.gridy = 0;
        evaluationPanel.add(eval_id_type_eval, cons);
        cons.gridx = 0;
        cons.gridy = 1;
        evaluationPanel.add(eval_id_periode, cons);
        cons.gridx = 0;
        cons.gridy = 2;
        evaluationPanel.add(eval_id_cours, cons);
        cons.gridx = 0;
        cons.gridy = 3;
        evaluationPanel.add(eval_piods, cons);
        cons.gridx = 0;
        cons.gridy = 4;
        evaluationPanel.add(creerEvaluation, cons);
        
        //enseignement
        changePanelActionListener(enseignement, enseignementPanel, "Créer Un Enseignement");

        JLabel esmWelcome = new JLabel("Créer une Evaluation");
        enseignementPanel.setLayout(new GridBagLayout());
        cons.insets = new Insets(10, 0, 10, 0);
        
        cons.gridx = 0;
        cons.gridy = 0;
        enseignementPanel.add(esm_id_matiere, cons);
        cons.gridx = 0;
        cons.gridy = 1;
        enseignementPanel.add(esm_id_niveau, cons);
        cons.gridx = 0;
        cons.gridy = 2;
        enseignementPanel.add(esm_coeff, cons);
        cons.gridx = 0;
        cons.gridy = 3;
        enseignementPanel.add(creerEnseignement, cons);
        
        // eleves list
        EleveService serviceEleve = new EleveService();
        List<Eleve> list_eleves = serviceEleve.getEleves();
        changePanelActionListener(eleves, elevesPanel, "Liste des Elves");
        
        
        String[][] dataEleves = PrettyPersonFormatter.formatListEleve(list_eleves, 4);
        model = new DefaultTableModel(dataEleves, personneTableColumns);
        tableEleves = new JTable(model);
        tableEleves.setShowGrid(true);
        tableEleves.setShowVerticalLines(true);
        JScrollPane paneEleve = new JScrollPane(tableEleves);
        elevesPanel.setLayout(new BorderLayout(10, 20));
        elevesPanel.add(paneEleve, BorderLayout.CENTER);
        elevesPanel.add(refreshEleve, BorderLayout.SOUTH);
        
        changePanelActionListener(classe, classePanel, "Liste des Classes");
        ClasseService service = new ClasseService();
        List<Classe> list_classes = service.getClasses();
        
        String[][] data = PrettyClassFormatter.formatList(list_classes, 3);
        model = new DefaultTableModel(data, classeTableColumns);
        tableClasse = new JTable(model);
        tableClasse.setShowGrid(true);
        tableClasse.setShowVerticalLines(true);
        JScrollPane pane = new JScrollPane(tableClasse);
//        classePanel.setLayout(new GridBagLayout());
//        GridBagConstraints constraints = new GridBagConstraints();
//        
//        constraints.insets = new Insets(20, 0, 0, 0);
//        constraints.gridx = 0;
//        constraints.gridy = 0;
        classePanel.setLayout(new BorderLayout(10, 20));
        classePanel.add(pane, BorderLayout.CENTER);
//        constraints.gridx = 0;
//        constraints.gridy = 1;
        classePanel.add(refresh, BorderLayout.SOUTH);
        
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                while(classePanel.getComponentCount() > 0) {
                    classePanel.remove(0);
                }
                
                ClasseService service = new ClasseService();
                List<Classe> list_classes = service.getClasses();
                String[][] data = PrettyClassFormatter.formatList(list_classes, 3);
                model = new DefaultTableModel(data, classeTableColumns);
                tableClasse = new JTable(model);
                tableClasse.setShowGrid(true);
                tableClasse.setShowVerticalLines(true);
                JScrollPane pane = new JScrollPane(tableClasse);
                classePanel.add(pane, BorderLayout.CENTER);
                classePanel.add(refresh, BorderLayout.SOUTH);
                classePanel.revalidate();
                classePanel.repaint();
            }
        });
        changePanelActionListener(noter, noterPanel, "Noter Une Evaluation");
        noterPanel.setLayout(new GridBagLayout());
        GridBagConstraints noterGbc = new GridBagConstraints();
        noterGbc.insets = new Insets(10, 0, 10, 0);
        
        JLabel noterWelcome = new JLabel("Noter un Elève sur une Evaluation");
        noterGbc.gridx = 0;
        noterGbc.gridy = 0;
//        noterGbc.gridheight = 10;
        noterGbc.gridwidth = 20;
        noterPanel.add(noterWelcome, noterGbc);
        noterGbc.gridx = 0;
        noterGbc.gridy = 1;
//        noterGbc.gridheight = 10;
//        noterGbc.gridwidth = 20;
        noter_id_evele.setSize(300, 40);
        noter_id_evele.setPreferredSize(new Dimension(300, 40));
        noterPanel.add(noter_id_evele, noterGbc);
        noterGbc.gridx = 0;
        noterGbc.gridy = 2;
//        noterGbc.gridheight = 10;
//        noterGbc.gridwidth = 20;
        noter_id_enseignant.setSize(300, 40);
        noter_id_enseignant.setPreferredSize(new Dimension(300, 40));
        noterPanel.add(noter_id_enseignant, noterGbc);
        noterGbc.gridx = 0;
        noterGbc.gridy = 3;
        //noterGbc.gridheight = 10;
        //noterGbc.gridwidth = 20;
        noter_id_evaluation.setSize(300, 40);
        noter_id_evaluation.setPreferredSize(new Dimension(300, 40));
        noterPanel.add(noter_id_evaluation, noterGbc);
        noterGbc.gridx = 0;
        noterGbc.gridy = 4;
//        noterGbc.gridheight = 10;
//        noterGbc.gridwidth = 20;
        noter_value.setSize(300, 40);
        noter_value.setPreferredSize(new Dimension(300, 40));
        noterPanel.add(noter_value, noterGbc);
        JButton noterBtn = new JButton("Noter");
        noterBtn.setSize(300, 50);
        noterBtn.setPreferredSize(new Dimension(300, 50));
        noterBtn.setBackground(new Color(54, 79, 124));
        noterBtn.setForeground(Color.WHITE);
        noterGbc.gridx = 0;
        noterGbc.gridy = 5;
//        noterGbc.gridheight = 10;
//        noterGbc.gridwidth = 20;
        noterPanel.add(noterBtn, noterGbc);
        
        /**@Note: mettre ajouterLabel et ajouterPanel dans un même contenaire*/
        changePanelActionListener(ajouter, ajouterPanel, "Ajouter Une Personne");
        
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
