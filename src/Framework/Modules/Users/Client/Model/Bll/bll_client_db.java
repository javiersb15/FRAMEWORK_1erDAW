/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Modules.Users.Client.Model.Bll;

import Framework.Modules.Users.Client.Model.Dao.dao_client_db;

/**
 *
 * @author usuario
 */
public class bll_client_db {
    
    public static void insert_client_bll(){
        dao_client_db.insert_client_dao();
    }
    
     public static void update_client_bll() {
         dao_client_db.update_client_dao();         
     }
     
     public static void delete_client_bll() {
         dao_client_db.delete_client_dao();
     }
    
     public static void select_client_bll() {
         dao_client_db.select_client_dao();         
     }
     
     public static void Find_client_bll() {
         dao_client_db.Find_client_dao();
     }   
}