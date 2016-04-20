/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Modules.Users.Admin.Model.Bll;

import Framework.Class.Connection_DB;
import Framework.Modules.Users.Admin.Model.Dao.dao_admin_db;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class bll_admin_db {
     public static int insert_admin_bll() {

        int correct;
        Connection con = null;

         Connection_DB conect = new Connection_DB();
         
        con =conect.getConexion();
        //con = conect.openconnection();

        correct = dao_admin_db.insert_admin_dao(con);

        conect.liberaConexion(con);
        //conect.closeconnection(con);

        return correct;
    }
     
     public static void select_admin_bll() {

        Connection con = null;
        Connection_DB conect = new Connection_DB();

        con =conect.getConexion();
        //con = conect.openconnection();
        dao_admin_db adm_dao= new dao_admin_db();

        try {
           adm_dao.select_admin_dao(con); //Recuperamos los empleados 

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error Logger2 select!");
        }
        conect.liberaConexion(con);
        //conect.closeconnection(con);
    }
     
     public static void update_admin_bll() {

        Connection con;
        Connection_DB conect = new Connection_DB();

        con =conect.getConexion();
        //con = conect.openconnection();
        dao_admin_db adm_dao= new dao_admin_db();

        adm_dao.update_admin_dao(con);
        conect.liberaConexion(con);
        //conect.closeconnection(con);
    }
     
      public static boolean delete_admin_bll() {

        Connection con;
        boolean correct;

        Connection_DB conect = new Connection_DB();

        con =conect.getConexion();
        //con = conect.openconnection();
        dao_admin_db adm_dao= new dao_admin_db();

        correct = adm_dao.delete_admin_dao(con);
        conect.liberaConexion(con);
        //conect.closeconnection(con);

        return correct;
    }
}