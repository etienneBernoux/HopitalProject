/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Color;
import javax.swing.*;
//import java.awt.*;
import java.awt.event.*;
//import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Connection.ConnectionEce;


/**
 *
 * @author travail
 */
public class FenetreConnection  extends JFrame implements ActionListener {
    
private JButton launchButton = new JButton(" Launch "), readme = new JButton("Read Me");
private JPanel containerConnection = new JPanel();
private JTextField idECEConnection = new JTextField("Identifiant ECE");
private JTextField mdpECEConnection = new JTextField("Mot de passe ECE");
private JTextField idSQLConnection = new JTextField("Identifiant SQL");
private JTextField mdpSQLConnection = new JTextField("Mot de passe SQL");
private ConnectionEce connexion1;
//private JTextField ipText = new JTextField("Adresse IP du serveur", 15); // no properties private TextField portText = new TextField("Port",30);
    
    public FenetreConnection(ConnectionEce connection) {
        //connexion1 = new ConnectionEce("0","","","");
        //stocke les valeurs de la connection effectuée en amont
        //cette action est à mettre dans l'ActionPerformed au niveau du bouton
        connexion1= connection;
        
    this.setTitle("Application Hôpital");
    this.setSize(300,300);
    
    //pour fermer la fenêtre en cliquant sur le bouton d’arret de la fenêtre
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    
    //this.setLocationRelativeTo(null);
    //Ajout des composants Swing dans une boite verticale 
    containerConnection.setBackground(Color.GREEN);
    Box b1 = Box.createVerticalBox();
    b1.add(idECEConnection);
    b1.add(mdpECEConnection);
     b1.add(idSQLConnection);
    b1.add(mdpSQLConnection);
    b1.add(launchButton);
    b1.add(readme);    
    
    containerConnection.add(b1);
   /* container1.add(ipText);
    container1.add(port);
    container1.add(launchButton);
    */
    //Bouton the “ReadMe” pour les instructions, aide pour l’utilisateur container1.add(readme);
    this.readme.addActionListener(this); //Bouton de lancement
    //Action Listeners
    this.launchButton.addActionListener(this); 
    //Mise en place globale
    this.setContentPane(containerConnection);
    setResizable(false); 
    setAlwaysOnTop(true);
    this.setVisible(true);
    } 
    
    public void actionPerformed(ActionEvent e) { 
		  if((JButton)e.getSource()== launchButton)
		  { 
                       //try{ 
   //FenetrePrincipale nouvelleFenPrin = new FenetrePrincipale(idECEConnection.getText(),mdpECEConnection.getText(),idSQLConnection.getText(),mdpSQLConnection.getText());
                     PanelMajFinal Pan1 = new PanelMajFinal(connexion1);
                      this.setContentPane(Pan1);
                      this.setSize(1250,795);
                      setAlwaysOnTop(false);
                    
                  }
		  else if((JButton)e.getSource()==readme)
		  {
                      ReadMeConnection read = new ReadMeConnection("Connection");
                      read.setVisible(true);
		  }
    }
    
}
