package Interface;

//~--- JDK imports ------------------------------------------------------------

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

import javax.swing.*;
import javax.swing.JButton;

public class ReadMeConnection extends JFrame implements ActionListener {
    private JPanel pan   = new JPanel();
    JButton        close = new JButton("Fermer");

    // Selon le String Entree, la fenêtre affichera les labels utiles.
    public ReadMeConnection(String Entree) {
        this.setTitle("Comment démarrer?");
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);

        Label text  = new Label("<html>Blabla.<br> Ligne suivante<html>");
        Label text2 = new Label("<html>Second label.<br> Ligne suivante12 <br> Ligne suivante22.<html>");
        Label text3 = new Label("<html>Troisième label <br> Ligne suivante13 <html>");

        switch (Entree) {
        case "MAJ" :
            text.setText("Voici comment utiliser cette fenêtre...");
            text2.setText("ATTENTION ! La suppression est irreversible !");
            text3.setText("Merci pour votre attention !");

            break;

        case "Connection" :
            text.setText("Voici comment utiliser cette fenêtre...");
            text2.setText("En fait c'est très simple..");
            text3.setText("Merci pour votre attention !");

            break;

        case "Reporting" :
            text.setText("Voici comment utiliser cette fenêtre...");
            text2.setText("En fait c'est très simple..");
            text3.setText("Merci pour votre attention !");

            break;

        case "Requete" :
            text.setText("Voici comment utiliser cette fenêtre...");
            text2.setText("En fait c'est très simple..");
            text3.setText("Merci pour votre attention !");

            break;

        default :
            ;
        }

        close.addActionListener(this);
        pan.setLayout(new FlowLayout(FlowLayout.LEADING));
        pan.add(text);
        pan.add(text2);
        pan.add(text3);
        pan.add(close);
        this.getContentPane().add(pan);
        this.setVisible(true);
        setResizable(false);
        setAlwaysOnTop(true);
    }

    public void actionPerformed(ActionEvent e) {
        if ((JButton) e.getSource() == close) {
            this.setVisible(false);
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
