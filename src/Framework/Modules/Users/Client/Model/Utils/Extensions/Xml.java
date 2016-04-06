package Framework.Modules.Users.Client.Model.Utils.Extensions;

import Framework.Modules.Users.Client.Model.Clases.Class_client;
import Framework.Modules.Users.User.Model.Clases.Singleton;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;

public class Xml {

	 private static final String ENCODING = "UTF-8";

/**CLIENT*/
	 /**CREATE XML CLIENT*/
	 public static void create_xml_client() {
		        String PATH=null;
				try {
					OutputStream os=new ByteArrayOutputStream();
					OutputStreamWriter osw=new OutputStreamWriter(os);
					XStream xstream=new XStream();
					Annotations.configureAliases(xstream, Class_client.class);

		            String header="<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
		            xstream.toXML(Singleton.Client_array, osw);
		            StringBuffer xml=new StringBuffer();
		            xml.append(header);
		            xml.append(os.toString());
			    
		            JFileChooser fileChooser=new JFileChooser();
		            fileChooser.setAcceptAllFileFilterUsed(false);
		            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));
		            int seleccion=fileChooser.showSaveDialog(null);
		            if (seleccion==JFileChooser.APPROVE_OPTION) {
		            	File JFC=fileChooser.getSelectedFile();
		                PATH=JFC.getAbsolutePath();
		                PATH=PATH+".xml";
		                
		                FileWriter fileXml=new FileWriter(PATH);
		                fileXml.write(xml.toString());
		                fileXml.close();
		                osw.close();
		                os.close();
		                JOptionPane.showMessageDialog(null, "XML file successfully saved", "File XML", JOptionPane.INFORMATION_MESSAGE);
		            }
			    }catch (Exception e1){
			    	JOptionPane.showMessageDialog(null, "Error recording XML", "Error", JOptionPane.ERROR_MESSAGE);
			    } 
		    }
		    
	 /**OPEN XML CLIENT*/
	 public static void open_xml_client() {
		    	String PATH=null;
		    	try {
		            XStream xstream=new XStream();
		            Annotations.configureAliases(xstream, Class_client.class);
		 
		            JFileChooser fileChooser=new JFileChooser();
		            fileChooser.setAcceptAllFileFilterUsed(false);
		            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));
		            int seleccion=fileChooser.showOpenDialog(null);
		            if (seleccion==JFileChooser.APPROVE_OPTION) {
		            	File JFC=fileChooser.getSelectedFile();
		                PATH=JFC.getAbsolutePath();
		                Singleton.Client_array=(ArrayList <Class_client>)xstream.fromXML(new FileReader(PATH));
		            }
		        } catch (Exception e1) {
		        	JOptionPane.showMessageDialog(null, "Error reading XML", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		 
	 /**AUTOMATIC CREATE XML CLIENT*/
	 public static void auto_create_xml_client() {
		        String PATH = null;

		        try {
		            PATH = new java.io.File(".").getCanonicalPath()+ "/src/Framework/Modules/Users/Model/Files/client_files/xml/prova.xml";
		        } catch (IOException e) {
		            e.printStackTrace();
		        }

		        if (Singleton.Client_array.size() > 0) {
		            try {
		                OutputStream os=new ByteArrayOutputStream();
		                OutputStreamWriter osw=new OutputStreamWriter(os);
		                XStream xstream = new XStream();

		                Annotations.configureAliases(xstream, Class_client.class);
		                String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
		                xstream.toXML(Singleton.Client_array, osw);
		                StringBuffer xml = new StringBuffer();
		                xml.append(header);
		                xml.append(os.toString());

		                FileWriter fileXml = new FileWriter(PATH);
		                fileXml.write(xml.toString());
		                fileXml.close();
		                osw.close();
		                os.close();
		            } catch (IOException e) {
		                //JOptionPane.showMessageDialog(null, "Error al grabar el XML","Error", JOptionPane.ERROR_MESSAGE);
		            }
		        } else {
		            File path = new File(PATH);

		            path.delete();
		        }
		    }
		    
	 /**AUTOMATIC OPEN XML CLIENT*/
	 public static void auto_open_xml_client() {
		        String PATH;

		        try {
		            XStream xstream = new XStream();
		            Annotations.configureAliases(xstream, Class_client.class);

		            PATH = new java.io.File(".").getCanonicalPath()+ "/src/Framework/Modules/Users/Model/Files/client_files/xml/prova.xml";

		            File path = new File(PATH);

		            if (path.exists()) {
		            	Singleton.Client_array=(ArrayList <Class_client>)xstream.fromXML(new FileReader(PATH));
		            }

		        } catch (IOException e) {
		            // JOptionPane.showMessageDialog(null, "Error al leer el XML",
		            // "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
}