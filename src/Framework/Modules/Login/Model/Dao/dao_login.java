/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Modules.Login.Model.Dao;

import static Framework.Class.Singleton_tools.collection;
import Framework.Modules.Users.Admin.Model.Bll.bll_admin_db;
import Framework.Modules.Users.Client.Model.Clases.Class_client;
import Framework.Modules.Users.Client.Model.Clases.Singleton_cli;
import Framework.Modules.Users.User.Model.Clases.Singleton;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
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
     
     public static boolean insert_client_dao() {
         boolean login=false;
        collection.insert(Singleton_cli.cli.client_to_DB_login());
        login =true;
        
        return true;
    }
     
     public static boolean select_client_dao() {
        boolean login=false;
        DBCursor cursor = null;
        Class_client cli = new Class_client();
        try {
            cursor = collection.find().sort(new BasicDBObject("DNI", -1));
            cursor = collection.find().sort(new BasicDBObject("pass", -1));
            if(cursor.count()!=0){
                while(cursor.hasNext()){
                    BasicDBObject document = (BasicDBObject) cursor.next();
                    cli=cli.to_DB_client(document);
                    Singleton.Client_array.add(cli);
                    login=true;
                }
            }else{
                System.out.println("NOT DATA"); 
            }
        } finally {
            if (cursor != null){
		cursor.close();
            }
	}
        return login;
    }
     
     /*public static void insert_client_dao() {
        collection.insert(Singleton_cli.cli.client_to_DB_login());
    }
     
     public static void select_client_dao() {
        DBCursor cursor = null;
        Class_client cli = new Class_client();
        try {
            cursor = collection.find().sort(new BasicDBObject("DNI", -1));
            cursor = collection.find().sort(new BasicDBObject("pass", -1));
            if(cursor.count()!=0){
                while(cursor.hasNext()){
                    BasicDBObject document = (BasicDBObject) cursor.next();
                    cli=cli.to_DB_client(document);
                    Singleton.Client_array.add(cli);
                }
            }else{
                System.out.println("NOT DATA"); 
            }
        } finally {
            if (cursor != null){
		cursor.close();
            }
	}	
    }*/
}