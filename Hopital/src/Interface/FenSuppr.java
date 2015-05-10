/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author travail
 */
   

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

public class FenSuppr extends JFrame implements ActionListener{
	
	private JPanel pan = new JPanel();
	JButton closeNon = new JButton("Non");
        JButton closeOui = new JButton("Non");
        JLabel entree = new JLabel();
        boolean result = false;
        //Selon le String Entree, la fenêtre affichera les labels utiles.
	public FenSuppr(int valMax)
	{
		this.setTitle("Suppression");
		this.setSize(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
            
                entree.setText("Etes-vous sur de vouloir supprimer l'entree de numéro "+valMax+"?");
		closeNon.addActionListener(this);
                closeOui.addActionListener(this);

                
		pan.setLayout(new FlowLayout(FlowLayout.LEADING));
		pan.add(entree);		
		pan.add(closeNon); pan.add(closeOui);
                
		this.getContentPane().add(pan);
		this.setVisible(true);
		setResizable(false);
		setAlwaysOnTop(true);   
        }	
        
	public void actionPerformed(ActionEvent e) { 
		  if((JButton)e.getSource()== closeNon)
                    {
                            this.setVisible(false);
                            
                    }
                  else if((JButton)e.getSource()== closeOui)
                  {
                      result = true;
                      
                  }
        }
        public boolean getVal()
        {
            return result;
        }
}

                  



