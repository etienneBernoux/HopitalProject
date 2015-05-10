/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import javax.swing.*;
import BBDspéc.Employe;
import Connection.ConnectionEce;
import Connection.*;
import DAO.DAO;
import DAO.EmployeDAO;
import BBDspéc.Batiment;
import DAO.Requete;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author travail
 */
public class PanelRequete_Paul extends javax.swing.JPanel {

    private String requeteChoisie = "0";
    private final ConnectionEce conn1;//= new ConnectionEce("0","","",""); //erreur
    private final ArrayList tabVal = new ArrayList();
    private Object MAJTableau[] ;
    private final JTable leTableau = new JTable();
    private DefaultTableModel modelTabGlobal = new DefaultTableModel();
    
    private final EmployeDAO retourEmployeAll = new EmployeDAO(ConnectionEce.getConn());
    
    public PanelRequete_Paul(ConnectionEce connIN) {
        initComponents();
        conn1 = connIN; 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        jButton1.setText("MAJ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("AFFICHAGE ET MISE A JOUR DE VOS DONNEES");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Table à afficher", "Batiment", "Chambre", "Docteur", "Employe", "Infirmier", "Hospitalisation", "Malade", "Service", "Soigne", "Requête 10" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton2.setText("Insérer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Supprimer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Aide");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextField1.setText("Indice");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel2)))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(392, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
    requeteChoisie =  (String)jComboBox1.getSelectedItem(); 
    
    
    //JScrollPane scrollPane = new JScrollPane(jTable1);

    //Recupère le String de la requête choisie.
// TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    /*OBJECTIF:
      Selon la requête, remplir un ArrayList tabVal. 
        Il permettra de remplir un tableauModel de l'interface.
        arrayList length();
        */ 
      //layout.add(new JScrollPane(jTable1));    
    System.out.println("La table choisie est "+ requeteChoisie);
    
    if("Employe".equals(requeteChoisie))//pour employé
        {      
//réception des valeurs de la table
            ArrayList<Employe> tabVal1 = retourEmployeAll.findall();
           //Test de sortie 
          // System.out.println("ON VA Y ARRIVER !!! 22222");
           //entetes du tableau
           String[] entetes = { "No employé","Nom", "Prénom", "Tel", "Adresse" };
           //mise en place du Model du tableau
           DefaultTableModel tableModel = new DefaultTableModel(entetes, 0);
           //modification du model stocké
           modelTabGlobal = tableModel;
           //allocation de MAJTableau=> stockage pour utilisation future
          // System.out.println(" "+tabVal1.size());//test pour la taille du tableau
          
           MAJTableau = new Object[tabVal1.size()];
           
           //remplissage des data => objectTab          
           for(int i = 0; i<tabVal1.size();i++)
           {
                Employe emp = new Employe();
                emp =(Employe) tabVal1.get(i);
                Object objectTab[]= { //objectTab permet de remplir le JTable
                emp.getNo_employe(),
                emp.getNom(),
                emp.getPrenom(),
                emp.getTel(),
                emp.getAdresse()
                 };
               MAJTableau[i]=  objectTab; 
                tableModel.addRow(objectTab);
           }              
        //permet de changer le model du tableau  
        leTableau.setModel(tableModel);
        //Ajout du scrollPane dans le JPanel
        JScrollPane scrollPane11 = new JScrollPane(leTableau);
        this.add(scrollPane11);  
        scrollPane11.setBounds(50,180,1100,500);
       
        //Test de sortie
        System.out.println("Test Find All Employe");  
        
        //Fermeture du connection =>  à mettre dans un bouton.
       /* try {
                conn1.fermerConnection();
                //C'est le cas, mais ils sont complètement dans le désordre. 
             } catch (SQLException ex) {
                Logger.getLogger(PanelRequete.class.getName()).log(Level.SEVERE, null, ex);
                 }*/
        tableModel.addTableModelListener( new TableModelListener(){
                @Override
                public void tableChanged(TableModelEvent e) {
                   // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    updateFonctionEmp();
                }
       });
    }    
    }//GEN-LAST:event_jButton1ActionPerformed

    public void updateFonctionEmp()
    {
        //créer l'objet Employe à envoyer pour l'update
       Employe MAJEmployRecu = new Employe();  
       //regarde là où l'utilisateur effectue la modification dans le tableau
       int ligne = leTableau.getSelectedRow();//Si tu veut la cellule selectionnée, sinon une autre valeur
       int colonne = leTableau.getSelectedColumn();//Si tu veut la cellule selectionnée, sinon une autre valeur
       Object cellule = leTableau.getValueAt(ligne,colonne);
       String currentVal = (String)cellule;
       //"No employé","Nom", "Prénom", "Tel", "Adresse":=> 5 colonnes
       
    //enregistre les informations de l'employe de la ligne où l'utilisateur  
    //effectue des modifications
       int curNo = (Integer)leTableau.getValueAt(ligne,0); //d'abord le N°
       MAJEmployRecu.setNo_employe(curNo);
       //puis les autres attributs String
       for(int i=1; i<5;i++)
       { 
           String curVal= (String)leTableau.getValueAt(ligne,i);
           switch(i)
           {
           case 1: MAJEmployRecu.setNom(curVal);    break;
           case 2: MAJEmployRecu.setPrenom(curVal); break;
           case 3: MAJEmployRecu.setTel(curVal);    break;
           case 4: MAJEmployRecu.setAdresse(curVal);break;
           default : break;
            }  
       }
       //le programme regarde dans quelle colonne est effectuée la modification
       //en fonction, il détermine quel attribut a changé
       //et l'enregistre dans l'employé correspondant
       switch(colonne){
           case 0: MAJEmployRecu.setNo_employe(Integer.parseInt(currentVal));break;
           case 1: MAJEmployRecu.setNom(currentVal);    break;
           case 2: MAJEmployRecu.setPrenom(currentVal); break;
           case 3: MAJEmployRecu.setTel(currentVal);    break;
           case 4: MAJEmployRecu.setAdresse(currentVal);break;
           default : break;       
       }
      //l'instance modifiée de la classe Employé et ensuite envoyée pour update
       retourEmployeAll.update(MAJEmployRecu);
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  //Mise à jour en direct des modifications du tableau => dans la base de données, via EmployeeDAO update
  //Noter que l'update ne sera validée que si les conditions de la methode update dans DAO sont respectées     
        int lenghtEntete = modelTabGlobal.getColumnCount();
        Object newRow[]= new Object[lenghtEntete];
      for(int i =0; i<lenghtEntete;i++)
          newRow[i] = "data";
        modelTabGlobal.addRow(newRow);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // SUPPRESSION :=> basée sur le N° de la valeur.
        //attention=> irréversible.//il est préférable de Supprimer une ligne précedemment ajoutée
       
        int entreeLigneASupprimer= Integer.parseInt(jTextField1.getText());
        int curNo;
  
       //On rempli l'object Employe à supprimer => seul le Numero_emp est utile
       Employe EmployASuppr = new Employe(); 
       EmployASuppr.setNo_employe(entreeLigneASupprimer); 
       /*EmployASuppr.setNom(curVal);     EmployASuppr.setPrenom("Suppr");
       EmployASuppr.setTel("Suppr"); EmployASuppr.setAdresse("Suppr");*/
       //Test sur toutes les lignes
       for(int i =0; i< modelTabGlobal.getRowCount();i++ )
            {       
                curNo = (Integer)leTableau.getValueAt(i,0);
                if(curNo == entreeLigneASupprimer && retourEmployeAll.delete(EmployASuppr))
                    modelTabGlobal.removeRow(entreeLigneASupprimer);
            }          
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //AIDE :=> ouvre une JFrame qui indique les actions possibles avec les bouttons et sur le tableau
      ReadMeConnection aideUtil = new ReadMeConnection("MAJ");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
       
    }//GEN-LAST:event_jTextField1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
