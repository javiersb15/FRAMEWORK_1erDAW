/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Modules.Users.Client.Model.Dao;

import static Framework.Class.Singleton_tools.*;
import Framework.Modules.Users.Client.Model.Clases.Class_client;
import Framework.Modules.Users.Client.Model.Clases.Singleton_cli;
import Framework.Modules.Users.User.Model.Clases.Singleton;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author usuario
 */
public class dao_client_db {
    
     public static DateFormat format_fecha = new SimpleDateFormat("dd/MM/yyyy");
    
    /**GIVE INSERT CLIENT*/
    public static void insert_client_dao() {
        collection.insert(Singleton_cli.cli.client_to_DB());
    }
    
    /**GIVE UPDATE CLIENT*/
    public static void update_client_dao() {
        //Prepara para insertar un nuevo campo
        BasicDBObject updateAnyos = new BasicDBObject();
        updateAnyos.append("$set", Singleton_cli.cli.client_to_DB());
 
        //Busca el/los registro/s con el nombre indicado
        BasicDBObject searchById = new BasicDBObject();
        searchById.append("DNI", Singleton_cli.cli.getDNI());
 
        //Realiza la actualización
        collection.updateMulti(searchById, updateAnyos);
    }
    
    /**GIVE DELETE CLIENT */
     public static void delete_client_dao() {
        collection.remove(new BasicDBObject().append("DNI", Singleton_cli.cli.getDNI()));
    }
    
     /**GIVE SELECT CLIENT*/
     public static void select_client_dao() {
        DBCursor cursor = null;
        Class_client cli = new Class_client();
        try {
            cursor = collection.find().sort(new BasicDBObject("DNI", -1));
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
    }
     
     /**GIVE FIND CLIENT*/
     public static void Find_client_dao(String dni) {
        DBCursor cursor = null;
        //String dni="";
        
        try {
            BasicDBObject query = new BasicDBObject("DNI", dni);
            cursor = collection.find(query);
            if(cursor.count()!=0){
                while(cursor.hasNext()){
                    BasicDBObject document = (BasicDBObject) cursor.next();
                    Singleton_cli.cli=Singleton_cli.cli.to_DB_client(document);
                }
            }else{
                System.out.println("NOT DATA"); 
            }
        } finally {
            if (cursor != null){
		cursor.close();
            }
	}	
    }
}