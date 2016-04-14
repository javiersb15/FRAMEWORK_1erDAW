package Framework.Modules.Users.Client.Model.Utils.Extensions;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
import Framework.Modules.Menu.Model.Clases.Class_config;
import Framework.Modules.Users.Client.Model.Clases.Class_client;
import Framework.Modules.Users.User.Model.Clases.Singleton;
import Framework.Utils.Theme;

public class Json {


/**CLIENT*/
	/**CREATE JSON CLIENT*/
	public static void create_json_client() {
	        String PATH=null;
		      try {
		          XStream xstreamjson=new XStream(new JettisonMappedXmlDriver());
		          xstreamjson.setMode(XStream.NO_REFERENCES);
		          xstreamjson.alias("Client", Class_client.class);
		          
		          JFileChooser fileChooser=new JFileChooser();
		          fileChooser.setAcceptAllFileFilterUsed(false);
		          fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
		          int seleccion=fileChooser.showSaveDialog(null);
		          if (seleccion==JFileChooser.APPROVE_OPTION) {
		                File JFC=fileChooser.getSelectedFile();
		                PATH=JFC.getAbsolutePath();
		                PATH=PATH+ ".json";
		                Gson gson=new Gson();
			            String json=gson.toJson(Singleton.Client_array);
			            FileWriter fileXml=new FileWriter(PATH);
		                fileXml.write(json.toString());
		                fileXml.close(); 
		                
		                JOptionPane.showMessageDialog(null, "JSON file successfully saved", "File JSON", JOptionPane.INFORMATION_MESSAGE);
		          }
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "Error recording JSON", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	    
	/**OPEN JSON CLIENT*/
	public static void open_json_client() {
	    	String PATH=null;
	    	Class_client e1=new Class_client("");
	    	
	        try {
	        	  XStream xstream=new XStream(new JettisonMappedXmlDriver());
		          xstream.setMode(XStream.NO_REFERENCES);
				  xstream.alias("Client", Class_client.class);
				  
				  JFileChooser fileChooser=new JFileChooser();
				  fileChooser.setAcceptAllFileFilterUsed(false);
		          fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
		          int seleccion=fileChooser.showOpenDialog(null);
		          if (seleccion==JFileChooser.APPROVE_OPTION) {
		                File JFC=fileChooser.getSelectedFile();
		                PATH=JFC.getAbsolutePath();
		               
		                Singleton.Client_array.clear();
		
		                JsonReader lector=new JsonReader(new FileReader(PATH));
		                JsonParser parseador=new JsonParser();
		                JsonElement raiz=parseador.parse(lector);
		            		  
		            	Gson json=new Gson();
		            	JsonArray lista=raiz.getAsJsonArray();
		            	for (JsonElement elemento : lista) {
		            		e1=json.fromJson(elemento, Class_client.class);
		            		Singleton.Client_array.add(e1);
		            	}
		          } 
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "Error reading JSON", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	
	/**AUTOMATIC CREATE JSON CLIENT*/
	public static void auto_create_json_client() {
		    	String PATH = null;
			      try {
			          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
			          xstreamjson.setMode(XStream.NO_REFERENCES);
			          xstreamjson.alias("Client", Class_client.class);

			                PATH = new java.io.File(".").getCanonicalPath()+"/src/Framework/Modules/Users/Client/Model/Files/client_files/json/prova.json";			              
			                Gson gson = new Gson();
				            String json1 = gson.toJson(Singleton.Client_array);
				            FileWriter fileXml = new FileWriter(PATH);
			                fileXml.write(json1.toString());
			                fileXml.close();
		        } catch (Exception e) {
		        }	
		    }
	
	/**AUTOMATIC OPEN JSON CLIENT*/
	public static void auto_open_json_client(){
    	String PATH = null;
    	Class_client e1=null;
    	
        try {
            
            XStream xstream = new XStream(new JettisonMappedXmlDriver());
	        xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("Client", Class_client.class);
            PATH = new java.io.File(".").getCanonicalPath()+"/src/Framework/Modules/Users/Client/Model/Files/client_files/json/prova.json";

            Singleton.Client_array.clear();
	                JsonReader lector = new JsonReader(new FileReader(PATH));
	                JsonParser parseador = new JsonParser();
	                JsonElement raiz = parseador.parse(lector);
	            		  
	            	Gson json = new Gson();
	            	JsonArray lista = raiz.getAsJsonArray();
	            	for (JsonElement elemento : lista) {
	            		e1 = json.fromJson(elemento, Class_client.class);
	            		Singleton.Client_array.add(e1);
	            	}
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erroropen_json");
        }
    }
		
	/**OPEN CONFIG*/
	public static void open_json_config(){
		String PATH=null;
		Class_config config=null;
		
		try{
			 XStream xstream=new XStream(new JettisonMappedXmlDriver());
	         xstream.setMode(XStream.NO_REFERENCES);
			 xstream.alias("Client", Class_client.class);
			 PATH = new java.io.File(".").getCanonicalPath()+"/src/Framework/Modules/Users/Model/Files/config_files/open_config/prova.json";
			 
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
             Theme.select_theme(config.getTheme());
			 
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error configuration JSON", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**SAVE CONFIG*/
	public static void create_json_config() {
    	String PATH=null;
    	
	      try {
	    	  PATH=new java.io.File(".").getCanonicalPath()+"/src/Framework/Modules/Users/Model/Files/config_files/create_config/prova.json";	
	      } catch (IOException e) {
	      }
	    	  try{
	          XStream xstreamjson=new XStream(new JettisonMappedXmlDriver());
	          xstreamjson.setMode(XStream.NO_REFERENCES);
	          xstreamjson.alias("Config", Class_config.class);		              
	          Gson gson=new Gson();
		      String json1=gson.toJson(Class_config.getInstance());
		      FileWriter fileXml=new FileWriter(PATH);
	          fileXml.write(json1.toString());
	          fileXml.close();
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Error configuration config", "Error", JOptionPane.ERROR_MESSAGE);
        }	
    }
}