/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Class;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author usuario
 */
public class Connection_DB {
    
    public Connection openconnection() {

        Connection con = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String urlOdbc = "jdbc:mysql://127.0.0.1:3306/db_users";
            con = (java.sql.DriverManager.getConnection(urlOdbc, "root", ""));
            JOptionPane.showMessageDialog(null, "Connection established");
        } catch (Exception e) {
           
            JOptionPane.showMessageDialog(null, "Ha sido imposible establecer la conexion!");
        }
        return con;
    }

    /**
     * cerramos la conexion en la bd
     *
     * @param con
     */
 
    public void closeconnection(Connection con){
        try{
            if(con !=null){
                con.close();
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Ha sido imposible cerrar la conexion!");
        }
    }   
}