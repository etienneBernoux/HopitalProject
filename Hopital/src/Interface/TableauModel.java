/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

//import javax.swing.*;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author travail
 */
public class TableauModel extends AbstractTableModel  {

    //en-tete des colonnes du tableau
    private final String[] entetes = { "Nom", "Prénom", "Année", "Sexe", "Note" };
    
    private ArrayList tabVal = new ArrayList();


    @Override
	public int getColumnCount() {
		// indique le nombre de colonnes
		return entetes.length;
	}

	@Override
	public int getRowCount() {
		// indique le nombre de ligne
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// permet d'avoir le contenu d'une case
		return null;
	}
        @Override
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}
        //ce qui nous renvoie les valeurs, le serveur. 
        
	
        //récupère une instance du serveur, qui contient toutes les données
        //celles-ci sont enregistrées dans un ArrayList<...> : ici note.
	
        
	public TableauModel(){
            super();
            tabVal.add(0);tabVal.add(1);tabVal.add(2);tabVal.add(3);tabVal.add(4);
        
            
        }
        
        
}
