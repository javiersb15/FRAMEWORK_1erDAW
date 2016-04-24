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

        con =Connection_DB.getConexion();
        //con = conect.openconnection();

        correct = dao_admin_db.insert_admin_dao(con);

        Connection_DB.liberaConexion(con);
        //conect.closeconnection(con);

        return correct;
    }
     
     public static void select_admin_bll() {

        Connection con = null;

        con =Connection_DB.getConexion();
        //con = conect.openconnection();
        //dao_admin_db adm_dao= new dao_admin_db();

        try {
           dao_admin_db.select_admin_dao(con);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error Logger2 select!");
        }
        Connection_DB.liberaConexion(con);
        //conect.closeconnection(con);
    }
     
     public static void update_admin_bll() {

        Connection con;       

        con =Connection_DB.getConexion();
        //con = conect.openconnection();

        dao_admin_db.update_admin_dao(con);
        Connection_DB.liberaConexion(con);
        //conect.closeconnection(con);
    }
     
      public static boolean delete_admin_bll() {

        Connection con;
        boolean correct;       

        con =Connection_DB.getConexion();
        //con = conect.openconnection();

        correct = dao_admin_db.delete_admin_dao(con);
        Connection_DB.liberaConexion(con);
        //conect.closeconnection(con);

        return correct;
    }
}