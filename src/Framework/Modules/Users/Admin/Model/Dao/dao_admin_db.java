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
    
    /**INSSERT ADMIN*/
    public static int insert_admin_dao(Connection con) {
       
        PreparedStatement stmt = null;
        int correct = 0, state=0;
        try {
           
           stmt = con.prepareStatement ("INSERT INTO db_admin.admin"
                            +"(DNI, name, surname, date_birthday, mobile, age, avatar,"
                            +" state, email, user, pass, benefit, date_employ, antique, salary, "
                            +" incentive, activity)"
                            +" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
           
           if (Singleton_adm.adm.isstate()==true){
               state=1;
          }else{
               state=0;
           }

            stmt.setString(1, Singleton_adm.adm.getDNI());
            stmt.setString(2, Singleton_adm.adm.getname());
            stmt.setString(3, Singleton_adm.adm.getsurname());
            stmt.setString(4, Singleton_adm.adm.getdate_birthday().toString());
            stmt.setString(5, Singleton_adm.adm.getmobile());
            stmt.setInt(6, Singleton_adm.adm.getage());
            stmt.setString(7, Singleton_adm.adm.getavatar());
            stmt.setInt(8, state);
            stmt.setString(9, Singleton_adm.adm.getemail());
            stmt.setString(10, Singleton_adm.adm.getuser());
            stmt.setString(11, Singleton_adm.adm.getpass());
            stmt.setFloat(12, Singleton_adm.adm.getbenefit());
            stmt.setString(13, Singleton_adm.adm.getdate_employ().toString());
            stmt.setInt(14, Singleton_adm.adm.getantique());
            stmt.setFloat(15, Singleton_adm.adm.getsalary());
            stmt.setFloat(16, Singleton_adm.adm.getincentive());
            stmt.setInt(17, Singleton_adm.adm.getactivity());

            correct = stmt.executeUpdate();
            //JOptionPane.showMessageDialog(null, "El usuario ha sido dado de alta correctamente!");
            
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
    
    /**SELECT ADMIN*/
    public static void select_admin_dao(Connection con) {
        boolean state=false;
        ResultSet rs = null;
        PreparedStatement stmt = null;
       
        Singleton.Admin_array.clear();
        try {
            stmt = con.prepareStatement("SELECT * FROM db_admin.admin");
            rs = stmt.executeQuery();

            Class_admin adm=null;

            while (rs.next()) {
            adm = new Class_admin();   
           if (rs.getInt("state")== 0){
                state= false;
           }else
                state=true;
           
            
            adm.setDNI(rs.getString("DNI"));
            adm.setname(rs.getString("name"));
            adm.setsurname(rs.getString("surname"));
            adm.setdate_birthday(new Class_date(rs.getString("date_birthday"),"1"));
            adm.setmobile(rs.getString("mobile"));
            adm.setage(rs.getInt("age"));
            adm.setavatar(rs.getString("avatar"));
            adm.setstate(state);
            adm.setemail(rs.getString("email"));
            adm.setuser(rs.getString("user"));
            adm.setpass(rs.getString("pass"));
            adm.setbenefit(rs.getFloat("benefit"));
            adm.setdate_employ(new Class_date(rs.getString("date_employ"),"1"));
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
    
    /**UPDATE ADMIN*/
    public static void update_admin_dao(Connection con) {
        int state=0;
        
        PreparedStatement stmt = null;
       
        try {
                      

        //stmt = con.prepareStatement ("UPDATE db_users.users SET DNI='00000023T', name='pepito', surname='sanz', date_birthday='15/04/1993', mobile='654123987', age=23, avatar='/root', state=true, email='javier@gmail.com', user='javiersb15', pass='holaASD@12', benefit=654.0, date_employ='15/04/2014', antique=2, salary=147.0, incentive=654.0, activity=354 WHERE DNI='00000023T'");
        stmt = con.prepareStatement ("UPDATE db_admin.admin SET DNI=?, name=?, surname=?, date_birthday=?, mobile=?, age=?, avatar=?, state=?, email=?, user=?, pass=?, benefit=?, date_employ=?, antique=?, salary=?, incentive=?, activity=? WHERE DNI=?");
       
        

           if (Singleton_adm.adm.isstate()==true){
                   state=1;
            }else{
                    state=0;
            }
            
              stmt.setString(1, Singleton_adm.adm.getDNI());
              stmt.setString(2, Singleton_adm.adm.getname());
              stmt.setString(3, Singleton_adm.adm.getsurname());
              stmt.setString(4, Singleton_adm.adm.getdate_birthday().toString());             
              stmt.setString(5, Singleton_adm.adm.getmobile());
              stmt.setInt(6, Singleton_adm.adm.getage());
              stmt.setString(7, Singleton_adm.adm.getavatar());
              stmt.setInt(8, state);
              stmt.setString(9, Singleton_adm.adm.getemail());
              stmt.setString(10, Singleton_adm.adm.getuser());
              stmt.setString(11, Singleton_adm.adm.getpass());
              stmt.setFloat(12, Singleton_adm.adm.getbenefit());
              stmt.setString(13, Singleton_adm.adm.getdate_employ().toString());
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
    
    /**DELETE ADMIN*/
     public static boolean delete_admin_dao(Connection con) {

        PreparedStatement stmt = null;
        boolean correct = false;

        try {
            stmt = con.prepareStatement("DELETE FROM db_admin.admin WHERE DNI=?");
            stmt.setString(1, Singleton_adm.adm.getDNI());
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