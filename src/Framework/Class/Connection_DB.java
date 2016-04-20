/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Class;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;


/**
 *
 * @author usuario
 */
public class Connection_DB {
    
    /*public Connection openconnection() {

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
    }*/

    /**
     * cerramos la conexion en la bd
     *
     * @param con
     */
 
    /*public void closeconnection(Connection con){
        try{
            if(con !=null){
                con.close();
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Ha sido imposible cerrar la conexion!");
        }
    }*/
    
    public static BasicDataSource dataSource;
    
    public static void inicializa_BasicDataSourceFactory() {
        Properties propiedades = new Properties();
        /*
        setMaxActive(): Nº máx de conexiones que se pueden abrir simultáneamente.
        setMinIdle(): Nº mín de conexiones inactivas que queremos que haya. Si el nº de conexiones baja de este nº, se abriran más.
        setMaxIdle(): Nº máx de conexiones inactivas que queremos que haya. Si hay más, se irán cerrando.
        */
        propiedades.setProperty("driverClassName", "com.mysql.jdbc.Driver");
        propiedades.setProperty("url", "jdbc:mysql://127.0.0.1:3306/db_users");
        propiedades.setProperty("maxActive", "10");
        propiedades.setProperty("maxIdle", "8");
        propiedades.setProperty("minIdle", "0");
        propiedades.setProperty("maxWait", "500");
        propiedades.setProperty("initialSize", "5");
        propiedades.setProperty("defaultAutoCommit", "true");
        propiedades.setProperty("username", "root");
        propiedades.setProperty("password", "");
        propiedades.setProperty("validationQuery", "select 1");
        propiedades.setProperty("validationQueryTimeout", "100");
        propiedades.setProperty("initConnectionSqls", "SELECT 1;SELECT 2");
        propiedades.setProperty("poolPreparedStatements", "true");
        propiedades.setProperty("maxOpenPreparedStatements", "10");
        
        try {
            //propiedades.load(new FileInputStream("src/config/datasource_config.properties"));
            dataSource = (BasicDataSource)BasicDataSourceFactory.createDataSource(propiedades);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    public static Connection getConexion() {
        Connection conexion=null;
        try {            
           conexion = dataSource.getConnection();            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return conexion;
    }
    
    public static void liberaConexion(Connection conexion) {
        try {
            if (null != conexion) 
                // En realidad no cierra, solo libera la conexion.
                conexion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
}