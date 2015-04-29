/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BBDspéc.Chambre;
import BBDspéc.Docteur;
import BBDspéc.Malade;
import BBDspéc.Soigne;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Etienne
 */
public class SoigneDAO extends DAO<Soigne> {

    public SoigneDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Soigne obj) {
        DAO<Malade> maladeDAO = new MaladeDAO(super.connect);
        DAO<Docteur> docteurDAO = new DocteurDAO(super.connect);
        if (maladeDAO.find(obj.getNo_malade()) == null) {
            JOptionPane.showMessageDialog(null, "Le malade entré n'existe pas");
            return false;
        } else if (docteurDAO.find(obj.getNo_docteur()) == null) {
            JOptionPane.showMessageDialog(null, "Le docteur entré n'existe pas");
            return false;
        }
        
        try {
            ResultSet result1 ;
            ResultSet result2 ;
            result1 = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT *"
                    + " FROM soigne"
                    + " WHERE soigne.no_malade ='" + obj.getNo_malade() + "'"
                    + " AND ("
                    + "("
                    + "soigne.date_rdv <=  '" + ToSqlFormat(obj.getDate_rdv()) + "'"
                    + " AND soigne.fin_rdv >= '" + ToSqlFormat(obj.getFin_rdv()) + "'"
                    + ")"
                    + " OR ("
                    + "soigne.date_rdv <=  '" + ToSqlFormat(obj.getDate_rdv()) + "'"
                    + " AND soigne.fin_rdv >='" + ToSqlFormat(obj.getFin_rdv()) + "'"
                    + ")"
                    + ")"
            );

            result2 = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT *"
                    + " FROM soigne"
                    + " WHERE soigne.no_docteur ='" + obj.getNo_docteur() + "'"
                    + " AND ("
                    + "("
                    + "soigne.date_rdv <=  '" + ToSqlFormat(obj.getDate_rdv()) + "'"
                    + " AND soigne.fin_rdv >= '" + ToSqlFormat(obj.getFin_rdv()) + "'"
                    + ")"
                    + " OR ("
                    + "soigne.date_rdv <=  '" + ToSqlFormat(obj.getDate_rdv()) + "'"
                    + " AND soigne.fin_rdv >='" + ToSqlFormat(obj.getFin_rdv()) + "'"
                    + ")"
                    + ")"
            );
            if (result1.first()) {
                JOptionPane.showMessageDialog(null, "Le malade a déja un rdv à ctte horraire");
                return false;

            } else if (result2.first()) {
                JOptionPane.showMessageDialog(null, "Le docteur a déja un rdv a cette horraire");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        String[] cle = new String[3];
        cle[0]=""+obj.getNo_malade();
        cle[1]=""+obj.getNo_docteur();
        cle[2]=""+ToSqlFormat(obj.getDate_rdv());
        if(find(cle)!=null){
            JOptionPane.showMessageDialog(null, "Ce rdv existe déja");
                return false;
        }
        try {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            ).executeUpdate(
                    "INSERT INTO soigne (no_docteur ,no_malade,maladie,date_rdv,fin_rdv)"
                        + "VALUES('" + obj.getNo_docteur()
                        + "','" + obj.getNo_malade()
                        + "','" + obj.getMaladie()
                        + "','" + ToSqlFormat(obj.getDate_rdv())
                        + "','" + ToSqlFormat(obj.getFin_rdv()) + "')"
            );
        } catch (SQLException ex) {
            Logger.getLogger(ChambreDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
        
    }

    @Override
    public boolean delete(Soigne obj) {
        String[] cle = new String[3];
        cle[0]=""+obj.getNo_malade();
        cle[1]=""+obj.getNo_docteur();
        cle[2]=""+ToSqlFormat(obj.getDate_rdv());
        if(find(cle)==null){
            JOptionPane.showMessageDialog(null, "Ce soin n'existe pas");
                return false;
        }
        try {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            ).executeUpdate(
                    "DELETE FROM soigne "
                    +" WHERE no_docteur ='"+obj.getNo_docteur()+"'"
                    +" AND no_malade ='"+obj.getNo_malade()+"'"
                    +" AND date_rdv ='"+ToSqlFormat(obj.getDate_rdv())+"'"
            );
        } catch (SQLException ex) {
            Logger.getLogger(ChambreDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Soigne obj) {
        DAO<Malade> maladeDAO = new MaladeDAO(super.connect);
        DAO<Docteur> docteurDAO = new DocteurDAO(super.connect);
        if (maladeDAO.find(obj.getNo_malade()) == null) {
            JOptionPane.showMessageDialog(null, "Le malade entré n'existe pas");
            return false;
        } else if (docteurDAO.find(obj.getNo_docteur()) == null) {
            JOptionPane.showMessageDialog(null, "Le docteur entré n'existe pas");
            return false;
        }
        
        try {
            ResultSet result1 ;
            ResultSet result2 ;
            result1 = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT *"
                    + " FROM soigne"
                    + " WHERE soigne.no_malade ='" + obj.getNo_malade() + "'"
                    + " AND ("
                    + "("
                    + "soigne.date_rdv <  '" + ToSqlFormat(obj.getDate_rdv()) + "'"
                    + " AND soigne.fin_rdv > '" + ToSqlFormat(obj.getFin_rdv()) + "'"
                    + ")"
                    + " OR ("
                    + "soigne.date_rdv <  '" + ToSqlFormat(obj.getDate_rdv()) + "'"
                    + " AND soigne.fin_rdv >'" + ToSqlFormat(obj.getFin_rdv()) + "'"
                    + ")"
                    + ")"
            );

            result2 = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT *"
                    + " FROM soigne"
                    + " WHERE soigne.no_docteur ='" + obj.getNo_docteur() + "'"
                    + " AND ("
                    + "("
                    + "soigne.date_rdv <  '" + ToSqlFormat(obj.getDate_rdv()) + "'"
                    + " AND soigne.fin_rdv > '" + ToSqlFormat(obj.getFin_rdv()) + "'"
                    + ")"
                    + " OR ("
                    + "soigne.date_rdv <  '" + ToSqlFormat(obj.getDate_rdv()) + "'"
                    + " AND soigne.fin_rdv >'" + ToSqlFormat(obj.getFin_rdv()) + "'"
                    + ")"
                    + ")"
            );
            if (result1.first()) {
                JOptionPane.showMessageDialog(null, "Le malade a déja un rdv à ctte horraire");
                return false;

            } else if (result2.first()) {
                JOptionPane.showMessageDialog(null, "Le docteur a déja un rdv a cette horraire");
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChambreDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        String[] cle = new String[3];
        cle[0]=""+obj.getNo_malade();
        cle[1]=""+obj.getNo_docteur();
        cle[2]=""+ToSqlFormat(obj.getDate_rdv());
        if(find(cle)==null){
            JOptionPane.showMessageDialog(null, "Ce rdv n'existe pas");
                return false;
        }
        
        try {
            //System.out.println("hey:"+obj.getDate_rdv().getTime().toString()+"SQL:"+ToSqlFormat(obj.getDate_rdv()));
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            ).executeUpdate(
                    "UPDATE soigne "
                        +" SET maladie= '" + obj.getMaladie()
                        +"', fin_rdv = '" + ToSqlFormat(obj.getFin_rdv()) + "'"
                        +" WHERE no_docteur= '" + obj.getNo_docteur()
                        +"' AND no_malade= '" + obj.getNo_malade() 
                        +"' AND date_rdv = '" + ToSqlFormat(obj.getDate_rdv())+"'"
            );
        } catch (SQLException ex) {
            Logger.getLogger(ChambreDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /**
     *
     * @param id avec une clef de la forme string[2] no_malade - no_docteur
     * @return soigne complété
     */
    @Override
    public Soigne find(Object id) {
        Soigne soigne = null;
        String[] cle = (String[]) id;
        try {
            //System.out.println(cle[2]);
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT * FROM soigne "
                    + "WHERE soigne.no_malade =  '" + cle[0] + "'"
                    + "AND soigne.no_docteur =  '" + cle[1] + "'"
                    + "AND soigne.date_rdv =  '" + cle[2] + "'"
            );
            if (result.first()) {
                Calendar cal1 = Calendar.getInstance();
                cal1.setTime(result.getDate("date_rdv"));
                Calendar cal2 = Calendar.getInstance();
                cal2.setTime(result.getDate("fin_rdv"));
                
                soigne = new Soigne(result.getInt("no_malade"), result.getInt("no_docteur"), result.getString("maladie"), cal1, cal2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChambreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return soigne;
    }

    @Override
    public ArrayList<Soigne> findall() {
                ArrayList<Soigne> list= new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT * FROM soigne"  
            );
            if (result.first()) {
                Calendar cal1 = Calendar.getInstance();
                cal1.setTime(result.getDate("date_rdv"));
                Calendar cal2 = Calendar.getInstance();
                cal2.setTime(result.getDate("fin_rdv"));
                list.add(new Soigne(result.getInt("no_malade"), result.getInt("no_docteur"), result.getString("maladie"), cal1, cal2));
                while(result.next()){
                    cal1.setTime(result.getDate("date_rdv"));
                    cal2.setTime(result.getDate("fin_rdv"));
                    list.add(new Soigne(result.getInt("no_malade"), result.getInt("no_docteur"), result.getString("maladie"), cal1, cal2));
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (list);
    }
      
    //Convertit en format pour sql
    public String ToSqlFormat(Calendar cal){
        return +cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.DAY_OF_MONTH)+" "+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND);
        
    }  

}
