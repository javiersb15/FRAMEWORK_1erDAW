/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Class;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.ImageIcon;

/**
 *
 * @author usuario
 */
public class Singleton_tools {
    public static ImageIcon okey= new ImageIcon("src/Framework/img/tick.jpg");
    public static ImageIcon cancel= new ImageIcon("src/Framework/img/cross.png");
    public static int position=0;
    public static Properties prop = new Properties();
    public static InputStream input = null;
    public static String machine = null;
    public static String port = null;
    public static Mongo client = null;
    public static DB db = null;
    public static String nom_bd = null;
    public static DBCollection collection = null;
    public static String nom_table = null;
    public static Mongo_DB mongo = null;
 }
