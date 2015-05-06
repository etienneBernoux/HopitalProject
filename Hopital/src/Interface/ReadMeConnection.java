package Interface;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

public class ReadMeConnection extends JFrame implements ActionListener{
	
	private JPanel pan = new JPanel();
	JButton close = new JButton("Fermer");
	
	public ReadMeConnection()
	{
		this.setTitle("Comment démarrer?");
		this.setSize(725,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	
		Label text = new Label("<html>Blabla.<br> Ligne suivante<html>" );
		Label text2 = new Label("<html>Second label.<br> Ligne suivante12 <br> Ligne suivante22.<html>");	
		Label text3 = new Label("<html>Troisième label <br> Ligne suivante13 <html>");
	
		
		close.addActionListener(this);
		pan.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		pan.add(text);		pan.add(text2);		pan.add(text3);
		pan.add(close);

		this.getContentPane().add(pan);
		this.setVisible(true);
		setResizable(false);
		setAlwaysOnTop(true);
		
	}
		
	public void actionPerformed(ActionEvent e) { 
		  if((JButton)e.getSource()== close)
		  {
			  this.setVisible(false);
		  }
}
}
