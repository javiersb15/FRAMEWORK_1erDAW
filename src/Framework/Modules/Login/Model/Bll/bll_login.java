/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Modules.Login.Model.Bll;

import Framework.Class.Connection_DB;
import Framework.Modules.Login.Model.Dao.dao_login;
import Framework.Modules.Login.View.login_frame;
import java.sql.Connection;

/**
 *
 * @author Javier
 */
public class bll_login {
    public static String DNI_login;
    public static String password;
    
    /**FUNCTIONS ADMIN*/
    
    public boolean login_admin_bll(String DNI, String pass) {

        Connection con;
        boolean result;
        Connection_DB conect = new Connection_DB();

        con=conect.getConexion();

        dao_login logindao = new dao_login();

        result = logindao.login_admin_dao(con, DNI, pass);

        conect.liberaConexion(con);

        return result;

    } 
    
    public static boolean login_admin(){        
        boolean login=false;
                DNI_login = login_frame.eti_dni_login.getText();
                password = login_frame.eti_pass_login.getText();

                bll_login loginbll_admin = new bll_login();
                login = loginbll_admin.login_admin_bll(DNI_login, password);
                
                return login;
    }
    
    /**FUNCTIONS CLIENT*/
    
   public static boolean login_client(){
       boolean login=false;
       
       login=dao_login.select_client_dao();
               
       return login;
   }
       
   /**USER REGISTER*/
   
   public static boolean login_usr_reg(){
       boolean login=false;
       
       login=dao_login.search_user_register();
               
       return login;
   }
   
   /**CHOOSE TYPE USER*/
   public static int type_user(){
        int find=0;
         
         if(bll_login.login_admin()==true){
             find=0;
         }else if (bll_login.login_client()==true){
             find=1;
         }else if (bll_login.login_usr_reg()==true){
             find=2;  
         }else{
             find=3;
         }
         return find;
     }
}    