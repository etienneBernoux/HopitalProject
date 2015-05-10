
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the t  emplate in the editor.
 */
package Interface;

//~--- non-JDK imports --------------------------------------------------------

import Main.SecondMain;

//~--- JDK imports ------------------------------------------------------------

import java.awt.Color;
import java.awt.event.*;

import java.sql.SQLException;

import javax.swing.*;

/**
 *
 * @author travail
 */
public class FenetrePrincipale extends JFrame implements ActionListener {
    private JPanel  container1   = new JPanel();
    private JButton searchButton = new JButton("Recherche"),
                    readMe       = new JButton("Aide");
    private JButton majButton    = new JButton(""),
                    statButton   = new JButton("");
    private JLabel  entete       = new JLabel("Soyez le bienvenu utilisateur. Veuillez selectionner une action");
    private String  idECE, mdpECE;
    private String  idSQL, mdpSQL;

    public FenetrePrincipale(String id1, String mdp1, String id2, String mdp2) throws SQLException {
        idECE  = id1;
        mdpECE = mdp1;
        idSQL  = id2;
        mdpSQL = mdp2;

        // lancement de la connection
        this.setTitle("Application Hôpital");
        container1.setBackground(Color.darkGray);
        this.setSize(900, 500);
        this.setLocationRelativeTo(null);

        Box b1 = Box.createHorizontalBox();

        b1.add(searchButton);
        b1.add(readMe);
        b1.add(majButton);
        b1.add(statButton);
        container1.add(entete);

        // container1.add(b1);
        this.readMe.addActionListener(this);
        this.searchButton.addActionListener(this);
        this.statButton.addActionListener(this);
        this.majButton.addActionListener(this);
        container1.add(b1);
        this.setContentPane(container1);

        // pour fermer la fenêtre en cliquant sur le bouton d’arret de la fenêtre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        setAlwaysOnTop(true);

        // Ajout des composants Swing dans une boite verticale
        // SecondMain Test = new SecondMain(id1, mdp1, id2,mdp2);
    }

    public void actionPerformed(ActionEvent e) {
        if ((JButton) e.getSource() == searchButton) {
            System.out.println("cool ta vie");
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
