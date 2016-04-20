/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Modules.Users.Admin.Model.Dao;

import Framework.Class.Class_date;
import Framework.Modules.Users.Admin.Model.Clases.Class_admin;
import Framework.Modules.Users.Admin.Model.Clases.Singleton_adm;
import Framework.Modules.Users.User.Model.Clases.Singleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class dao_admin_db {
    
    public static int insert_admin_dao(Connection con) {
       
        PreparedStatement stmt = null;
        int correct = 0, state=0;
        try {
           
           stmt = con.prepareStatement ("INSERT INTO users"
                            +"(DNI, name, surname, date_birthday, mobile, age, avatar,"
                            +" state, email, user, pass, benefit, date_employ, antique, salary, "
                            +" incentive, activity)"
                            +" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
           
           if (Singleton_adm.adm.isstate()==true){
               state=1;
              //System.out.println(state);
          }else{
               state=0;
           }

            stmt.setString(1, Singleton_adm.adm.getDNI());
            stmt.setString(2, Singleton_adm.adm.getname());
            stmt.setString(3, Singleton_adm.adm.getsurname());
            stmt.setString(4, Singleton_adm.adm.getdate_birthday().toStringformat());
            stmt.setString(5, Singleton_adm.adm.getmobile());
            stmt.setInt(6, Singleton_adm.adm.getage());
            stmt.setString(7, Singleton_adm.adm.getavatar());
            stmt.setInt(8, state);
            stmt.setString(9, Singleton_adm.adm.getemail());
            stmt.setString(10, Singleton_adm.adm.getuser());
            stmt.setString(11, Singleton_adm.adm.getpass());
            stmt.setFloat(12, Singleton_adm.adm.getbenefit());
            stmt.setString(13, Singleton_adm.adm.getdate_employ().toStringformat());
            stmt.setInt(14, Singleton_adm.adm.getantique());
            stmt.setFloat(15, Singleton_adm.adm.getsalary());
            stmt.setFloat(16, Singleton_adm.adm.getincentive());
            stmt.setInt(17, Singleton_adm.adm.getactivity());

            correct = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "El usuario ha sido dado de alta correctamente!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al insertar un nuevo usuario!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
                }
            }
        }
        return correct;
    }
    
    public void select_admin_dao(Connection con) {
        boolean state2=false;
        int state=0;
        ResultSet rs = null;
        PreparedStatement stmt = null;
       
        Singleton.Admin_array.clear();
        try {
            stmt = con.prepareStatement("SELECT * FROM users");
            rs = stmt.executeQuery();

            Class_admin adm=null;

            while (rs.next()) {
                      
           if (state == 0){
                state2= false;
           }else
                state2=true;
           
            adm = new Class_admin();
            adm.setDNI(rs.getString("DNI"));
            adm.setname(rs.getString("name"));
            adm.setsurname(rs.getString("surname"));
            adm.setdate_birthday(new Class_date(rs.getString("date_birthday")));
            adm.setmobile(rs.getString("mobile"));
            adm.setage(rs.getInt("age"));
            adm.setavatar(rs.getString("avatar"));
            adm.setstate(rs.getBoolean("state"));
            adm.setemail(rs.getString("email"));
            adm.setuser(rs.getString("user"));
            adm.setpass(rs.getString("pass"));
            adm.setbenefit(rs.getFloat("benefit"));
            adm.setdate_employ(new Class_date(rs.getString("date_employ")));
            adm.setantique(rs.getInt("antique"));
            adm.setsalary(rs.getFloat("salary"));
            adm.setincentive(rs.getFloat("incentive"));
            adm.setactivity(rs.getInt("activity"));

            Singleton.Admin_array.add(adm);
           
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al obtener los usuarios select!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
                }
            }
        }
    }
    
    public void update_admin_dao(Connection con) {
        int state=0;
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement ("UPDATE users SET"
                            +"DNI=?, name=?, surname=?, date_birthday=?, mobile=?, age=?, avatar=?,"
                            +" state=?, email=?, user=?, pass=?, benefit=?, date_employ=?, antique=?, salary=?, "
                            +" incentive=?, activity=? WHERE DNI=?");           
            
            if (Singleton_adm.adm.isstate()==true){
               state=1;
              //System.out.println(state);
          }else{
               state=0;
           }
            
            stmt.setString(1, Singleton_adm.adm.getDNI());
            stmt.setString(2, Singleton_adm.adm.getname());
            stmt.setString(3, Singleton_adm.adm.getsurname());
            stmt.setString(4, Singleton_adm.adm.getdate_birthday().toStringformat());            
            stmt.setString(5, Singleton_adm.adm.getmobile());
            stmt.setInt(6, Singleton_adm.adm.getage());
            stmt.setString(7, Singleton_adm.adm.getavatar());
            stmt.setInt(8, state);
            stmt.setString(9, Singleton_adm.adm.getemail());
            stmt.setString(10, Singleton_adm.adm.getuser());
            stmt.setString(11, Singleton_adm.adm.getpass());
            stmt.setFloat(12, Singleton_adm.adm.getbenefit());
            stmt.setString(13, Singleton_adm.adm.getdate_employ().toStringformat());
            stmt.setInt(14, Singleton_adm.adm.getantique());
            stmt.setFloat(15, Singleton_adm.adm.getsalary());
            stmt.setFloat(16, Singleton_adm.adm.getincentive());
            stmt.setInt(17, Singleton_adm.adm.getactivity());
            
            stmt.setString(18, Singleton_adm.adm.getDNI());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "El usuario ha sido modificado correctamente!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al actualizar el usuario!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
                }
            }
        }
    }
    
     public boolean delete_admin_dao(Connection con) {

        PreparedStatement stmt = null;
        boolean correct = false;
        Class_admin adm= new Class_admin();

        try {
            stmt = con.prepareStatement("DELETE FROM users WHERE DNI=?");
            stmt.setString(1, adm.getDNI());
            stmt.executeUpdate();
            correct = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al eliminar el usuario!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el Logger!");
                }
            }
        }
        return correct;
    }
     
     
}