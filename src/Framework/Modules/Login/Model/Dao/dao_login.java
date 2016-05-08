/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Modules.Login.Model.Dao;

import static Framework.Class.Singleton_tools.collection;
import Framework.Modules.Login.View.login_frame;
import Framework.Modules.Users.Client.Model.Clases.Class_client;
import Framework.Modules.Users.Client.Model.Clases.Singleton_cli;
import Framework.Modules.Users.User.Model.Clases.Singleton;
import Framework.Modules.Users.User_register.Model.Clases.Singleton_usr_reg;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Javier
 */

public class dao_login {
    
    /**ADMIN*/
    
     public boolean login_admin_dao(Connection con, String DNI, String pass) {

        boolean resultado = false;
        ResultSet rs = null;
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM db_admin.admin WHERE DNI=? AND pass=?");

            stmt.setString(1, DNI);
            stmt.setString(2, pass);
            rs = stmt.executeQuery();

            while (rs.next()) {

                DNI = rs.getString("DNI");
                pass = rs.getString("pass");

                resultado = true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Logger1");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error Logger2");
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error Logger3");
                }
            }
        }
        return resultado;
    }
     
     /**CLIENT*/
     
     public static boolean select_client_dao() {
        DBCursor cursor = null;
        Class_client cli = new Class_client();
        boolean correcto = false;
        BasicDBObject query = new BasicDBObject();
        try {
            query.put("DNI", login_frame.eti_dni_login.getText());
            query.put("pass", login_frame.eti_pass_login.getText());
            cursor = collection.find(query);
            if (cursor.count() != 0) {
                while (cursor.hasNext()) {
                    BasicDBObject document = (BasicDBObject) cursor.next();
                    cli = cli.to_DB_client(document);
                    Singleton.Client_array.add(cli);
                    Singleton_cli.cli = cli;
                    if (cli == null) {
                        correcto = false;
                    } else {
                        correcto = true;
                    }
                }
            } else {
                //System.out.println("NOT DATA");
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return correcto;
    }
     
    /**USER REGISTER*/
     public static boolean search_user_register(){ 
            boolean correct=false;
         
		for (int i = 0; i<=(Singleton.User_register_array.size()-1); i++){
			if((Singleton.User_register_array.get(i)).getDNI().equals(login_frame.eti_dni_login.getText()) && (Singleton.User_register_array.get(i)).getpass().equals(login_frame.eti_pass_login.getText())){
                            Singleton_usr_reg.usr_reg=Singleton.User_register_array.get(i);
                            correct=true;
                        }
		}
		return correct;
    }     
}