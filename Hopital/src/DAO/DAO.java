
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package DAO;

//~--- JDK imports ------------------------------------------------------------

import java.sql.Connection;

import java.util.ArrayList;

//Méthode général des DAO
public abstract class DAO<T> {
    protected Connection connect = null;

    public DAO(Connection conn) {
        this.connect = conn;
    }

    /**
     * Méthode de création
     * @param obj
     * @return boolean
     */
    public abstract boolean create(T obj);

    /**
     * Méthode pour effacer
     * @param obj
     * @return boolean
     */
    public abstract boolean delete(T obj);

    /**
     * Méthode de mise à jour
     * @param obj
     * @return boolean
     */
    public abstract boolean update(T obj);

    /**
     * Méthode de recherche des informations
     * @param id
     * @return T
     */
    public abstract T find(Object id);

    /**
     * Méthode re récupération de toutes les informations
     * @return T
     */
    public abstract ArrayList<T> findall();
}


//~ Formatted by Jindent --- http://www.jindent.com
