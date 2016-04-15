/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import Framework.Class.Class_date;
import Framework.Class.Connection_DB;
import Framework.Modules.Users.Admin.Model.Clases.Class_admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class test {
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //Class_config.getInstance();

        /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Controller_menu(new choose_frame(),0).began(0);  
                
                Connection con = null;
                Connection_DB conect = new Connection_DB();
                PreparedStatement stmt = null;
                int resultado = 0;
                
                
                con = (Connection) conect.openconnection();
                try {
                 Class_admin adm= new Class_admin("87654321X", "Javier", "Sanz", new Class_date("15/04/1993"), "654987321", "/root", true, "javier@gmail.com",
                         "javiersb15", "conTRA@123", new Class_date("15/04/2015"), 0.0f, 0.0f, 0);
                    stmt = con.prepareStatement ("INSERT INTO users"
                            +"(DNI, name, surname, date_birthday, mobile, age, avatar,"
                            +" state, email, user, pass, benefit, date_employ, antique, salary, "
                            +" incentive, activity)"
                            +" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                
            stmt.setString(1, adm.getDNI());
            stmt.setString(2, adm.getname());
            stmt.setString(3, adm.getsurname());
            stmt.setString(4, adm.getdate_birthday().toStringformat());
            stmt.setString(5, adm.getmobile());
            stmt.setInt(6, adm.getage());
            stmt.setString(7, adm.getavatar());
            stmt.setBoolean(8, adm.getstate());
            stmt.setString(9, adm.getemail());
            stmt.setString(10, adm.getuser());
            stmt.setString(11, adm.getpass());
            stmt.setFloat(12, adm.getbenefit());
            stmt.setString(13, adm.getdate_employ().toStringformat());
            stmt.setInt(14, adm.getantique());
            stmt.setFloat(15, adm.getsalary());
            stmt.setFloat(16, adm.getincentive());
            stmt.setInt(17, adm.getactivity());

            stmt.executeUpdate();
            } catch (SQLException ex) {
                    Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
                }
                conect.closeconnection(con);
                }            
        });
    }
}