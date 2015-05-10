
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the t  emplate in the editor.
 */
package Interface;

//~--- non-JDK imports --------------------------------------------------------
import Connection.ConnectionEce;
import Main.SecondMain;

//~--- JDK imports ------------------------------------------------------------
import java.awt.Color;
import java.awt.event.*;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

/**
 *
 * @author travail
 */
public class FenetrePrincipale extends JFrame implements ActionListener {
    //private JPanel  container1   = new JPanel();

    private ConnectionEce conn1;
    JButton button1 = new JButton("Requete");
    JButton button2 = new JButton("Afficher Tables");
    JButton button3 = new JButton("Deconnexion");
    JPanel containerMain; //JPanel Modifié
    JPanel paneldeBase = new JPanel(); //JPanel constant
    JButton retour = new JButton("Fin");

    public FenetrePrincipale(ConnectionEce connect) {
        conn1 = new ConnectionEce(connect);
        Box b1 = Box.createHorizontalBox();
        b1.add(button1);
        b1.add(button2);
        b1.add(button3);
        containerMain = new JPanel();
        containerMain.add(b1);
        this.setContentPane(containerMain);
        this.setSize(1400, 798);
        this.button1.addActionListener(this);
        this.button2.addActionListener(this);
        this.button3.addActionListener(this);

        // pour fermer la fenêtre en cliquant sur le bouton d’arret de la fenêtre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        setAlwaysOnTop(false);
        // Ajout des composants Swing dans une boite verticale
        // SecondMain Test = new SecondMain(id1, mdp1, id2,mdp2);
    }

    public void actionPerformed(ActionEvent e) {
        if ((JButton) e.getSource() == button1) {
            this.getContentPane().removeAll(); //remet le panel à zéro
            this.paneldeBase.removeAll();
            //JPanel containerNew = new JPanel ();
            JPanel panelVariable = new PanelRequete(conn1.getConn());
            //containerNew.add(panelVariable);
            paneldeBase.add(retour);
            paneldeBase.add(panelVariable);
            this.getContentPane().add(paneldeBase);
            this.getContentPane().validate();
            this.retour.addActionListener(this);
       
            
            
            
            
        } else if ((JButton) e.getSource() == button2) {
            this.getContentPane().removeAll();
            this.paneldeBase.removeAll();
            //JPanel containerNew = new JPanel ();
            JPanel panelVariable = new PanelMajFinal(conn1);
            //containerNew.add(panelVariable);
            paneldeBase.add(retour);
            paneldeBase.add(panelVariable);
            this.getContentPane().add(paneldeBase);
            this.getContentPane().validate();
            this.retour.addActionListener(this);  
        } else if ((JButton) e.getSource() == button3) {
            try {
                conn1.fermerConnection();
            } catch (SQLException ex) {
                Logger.getLogger(FenetrePrincipale.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setVisible(false);
            System.exit(0);
        } else if ((JButton) e.getSource() == retour) {
            try {
                conn1.fermerConnection();
            } catch (SQLException ex) {
                Logger.getLogger(FenetrePrincipale.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setVisible(false);
            System.exit(0);
        }

    }

}
