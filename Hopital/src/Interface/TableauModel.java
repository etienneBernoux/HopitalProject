/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

//import javax.swing.*;
import DAO.EmployeDAO;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author travail
 */

public class TableauModel extends AbstractTableModel  {

    //en-tete des colonnes du tableau
    private final String[] entetes = { "No employé","Nom", "Prénom", "Tel", "Adresse" };
    
    private ArrayList tabVal = new ArrayList(); //récupère les données de la requête, via le JPanel

    @Override
	public int getColumnCount() {
		// indique le nombre de colonnes
		return entetes.length;
	}

	@Override
	public int getRowCount() {
		// indique le nombre de ligne
		return tabVal.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		/*switch (columnIndex) {

		case 0:
			// Nom
			return tabVal.get(rowIndex).getNom();

		case 1:
			// Prenom
			return tabVal.get(rowIndex)..getPrenom();

		case 2:
			// Annee
			return tabVal.get(rowIndex).getEleve().getAnnee();

		case 3:
			// Sexe
			return tabVal.get(rowIndex).getEleve().getSexe();

		case 4:
			// Note au controle
			return tabVal.get(rowIndex).getNote();

		default:
			throw new IllegalArgumentException();
		}*/
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
