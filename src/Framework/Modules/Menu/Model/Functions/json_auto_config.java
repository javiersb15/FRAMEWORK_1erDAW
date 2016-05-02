/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Modules.Menu.Model.Functions;

import Framework.Modules.Menu.Model.Clases.Class_config;
import Framework.Modules.Users.Admin.Model.Clases.Class_admin;
import Framework.Utils.Theme;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class json_auto_config {
    
    /**OPEN CONFIG*/
	public static void open_json_config(){
		String PATH=null;
		Class_config config=null;
		
		try{
			 XStream xstream=new XStream(new JettisonMappedXmlDriver());
	         xstream.setMode(XStream.NO_REFERENCES);
			 xstream.alias("Admin", Class_admin.class);
			 PATH = new java.io.File(".").getCanonicalPath()+"/src/Framework/Modules/Menu/Model/Functions/config_files/create_config/prova.json";
			 
			 JsonReader lector=new JsonReader(new FileReader(PATH));
             JsonParser parseador=new JsonParser();
             JsonElement raiz=parseador.parse(lector);
             
             Gson json=new Gson();
             config=json.fromJson(raiz, Class_config.class);
             Class_config.getInstance().setCurrency(config.getCurrency());
             Class_config.getInstance().setDecimal_number(config.getDecimal_number());
             Class_config.getInstance().setFormat_date(config.getFormat_date());
             Class_config.getInstance().setLanguage(config.getLanguage());
             Class_config.getInstance().setTheme(config.getTheme());
			 
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error configuration JSON", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**SAVE CONFIG*/
	public static void create_json_config() {
    	String PATH=null;
    	
	      try {
	    	  PATH=new java.io.File(".").getCanonicalPath()+"/src/Framework/Modules/Menu/Model/Functions/config_files/create_config/prova.json";	
	      } catch (IOException e) {
	      }
	    	  try{
	          XStream xstreamjson=new XStream(new JettisonMappedXmlDriver());
	          xstreamjson.setMode(XStream.NO_REFERENCES);
	          xstreamjson.alias("Class_config", Class_config.class);		              
	          Gson gson=new Gson();
		  String json=gson.toJson(Class_config.getInstance());
		  FileWriter fileXml=new FileWriter(PATH);
	          fileXml.write(json.toString());
	          fileXml.close();
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Error configuration config", "Error", JOptionPane.ERROR_MESSAGE);
        }	
    }
}