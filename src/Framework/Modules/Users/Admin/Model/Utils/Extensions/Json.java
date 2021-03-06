package Framework.Modules.Users.Admin.Model.Utils.Extensions;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import Framework.Modules.Users.Admin.Model.Clases.Class_admin;
import Framework.Modules.Users.User.Model.Clases.Singleton;

public class Json {

/**ADMIN*/
	/**CREATE JSON ADMIN*/
	public static void create_json_admin() {
	        String PATH=null;
		      try {
		          XStream xstreamjson=new XStream(new JettisonMappedXmlDriver());
		          xstreamjson.setMode(XStream.NO_REFERENCES);
		          xstreamjson.alias("Admin", Class_admin.class);
		          
		          JFileChooser fileChooser=new JFileChooser();
		          fileChooser.setAcceptAllFileFilterUsed(false);
		          fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
		          int seleccion=fileChooser.showSaveDialog(null);
		          if (seleccion==JFileChooser.APPROVE_OPTION) {
		                File JFC=fileChooser.getSelectedFile();
		                PATH=JFC.getAbsolutePath();
		                PATH=PATH+ ".json";
		                Gson gson=new Gson();
			            String json=gson.toJson(Singleton.Admin_array);
			            FileWriter fileXml=new FileWriter(PATH);
		                fileXml.write(json.toString());
		                fileXml.close(); 
		                
		                JOptionPane.showMessageDialog(null, "JSON file successfully saved", "File JSON", JOptionPane.INFORMATION_MESSAGE);
		          }
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "Error recording JSON", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	    
	/**OPEN JSON ADMIN*/
	public static void open_json_admin() {
	    	String PATH=null;
	    	Class_admin e1=new Class_admin("");
	    	
	        try {
	        	  XStream xstream=new XStream(new JettisonMappedXmlDriver());
		          xstream.setMode(XStream.NO_REFERENCES);
				  xstream.alias("Admin", Class_admin.class);
				  
				  JFileChooser fileChooser=new JFileChooser();
				  fileChooser.setAcceptAllFileFilterUsed(false);
		          fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
		          int seleccion=fileChooser.showOpenDialog(null);
		          if (seleccion==JFileChooser.APPROVE_OPTION) {
		                File JFC=fileChooser.getSelectedFile();
		                PATH=JFC.getAbsolutePath();
		               
		                Singleton.Admin_array.clear();
		
		                JsonReader lector=new JsonReader(new FileReader(PATH));
		                JsonParser parseador=new JsonParser();
		                JsonElement raiz=parseador.parse(lector);
		            		  
		            	Gson json=new Gson();
		            	JsonArray lista=raiz.getAsJsonArray();
		            	for (JsonElement elemento : lista) {
		            		e1=json.fromJson(elemento, Class_admin.class);
		            		Singleton.Admin_array.add(e1);
		            	}
		          } 
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "Error reading JSON", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	
	/**AUTOMATIC CREATE JSON ADMIN*/
	public static void auto_create_json_admin() {
		    	String PATH = null;
			      try {
			          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
			          xstreamjson.setMode(XStream.NO_REFERENCES);
			          xstreamjson.alias("Admin", Class_admin.class);

			                PATH = new java.io.File(".").getCanonicalPath()+"/src/Framework/Modules/Users/Admin/Model/Files/admin_files/json/prova.json";			              
			                Gson gson = new Gson();
				            String json1 = gson.toJson(Singleton.Admin_array);
				            FileWriter fileXml = new FileWriter(PATH);
			                fileXml.write(json1.toString());
			                fileXml.close();
		        } catch (Exception e) {
		        }	
		    }
	
	/**AUTOMATIC OPEN JSON ADMIN*/
	public static void auto_open_json_admin(){
    	String PATH = null;
    	Class_admin e1=null;
    	
        try {
            
            XStream xstream = new XStream(new JettisonMappedXmlDriver());
	        xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("Admin", Class_admin.class);
                        
            PATH = new java.io.File(".").getCanonicalPath()+"/src/Framework/Modules/Users/Admin/Model/Files/admin_files/json/prova.json";

            Singleton.Admin_array.clear();
	                JsonReader lector = new JsonReader(new FileReader(PATH));
	                JsonParser parseador = new JsonParser();
	                JsonElement raiz = parseador.parse(lector);
	            		  
	            	Gson json = new Gson();
	            	JsonArray lista = raiz.getAsJsonArray();
	            	for (JsonElement elemento : lista) {
	            		e1 = json.fromJson(elemento, Class_admin.class);
	            		Singleton.Admin_array.add(e1);
	            	}
        } catch (Exception e) {
                    	JOptionPane.showMessageDialog(null, "erroropen_json");

        }
    }
}