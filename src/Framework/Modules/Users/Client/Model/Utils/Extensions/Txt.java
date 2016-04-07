package Framework.Modules.Users.Client.Model.Utils.Extensions;

import Framework.Modules.Users.Client.Model.Clases.Class_client;
import Framework.Modules.Users.User.Model.Clases.Singleton;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Txt {
	
	
/**CLIENT*/
	/**CREATE TXT CLIENT*/
	public static void create_txt_client() {
	        String PATH=null;
	        try {
	            File f;
	            JFileChooser fileChooser=new JFileChooser();
	            fileChooser.setAcceptAllFileFilterUsed(false);
	            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Text (*.txt)", "txt"));
	            int selection=fileChooser.showSaveDialog(null);
	            if (selection==JFileChooser.APPROVE_OPTION) {
	                File JFC=fileChooser.getSelectedFile();
	                PATH=JFC.getAbsolutePath();
	                PATH=PATH+ ".txt";
	                f=new File(PATH);
	                
	                FileOutputStream fo=new FileOutputStream(f);
					ObjectOutputStream o=new ObjectOutputStream(fo);
					o.writeObject(Singleton.Client_array);
					o.close();
	                JOptionPane.showMessageDialog(null, "TXT file successfully saved", "File TXT", JOptionPane.INFORMATION_MESSAGE);
	            }
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "Error recording TXT", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	
	/**OPEN TXT CLIENT*/
	public static void open_txt_cient() {
	    	String PATH=null;
	        try {
	            File f;
	            JFileChooser fileChooser=new JFileChooser();
	            fileChooser.setAcceptAllFileFilterUsed(false);
	            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Text (*.txt)", "txt"));
	            int seleccion=fileChooser.showOpenDialog(null);
	            if (seleccion==JFileChooser.APPROVE_OPTION) {
	                File JFC=fileChooser.getSelectedFile();
	                PATH=JFC.getAbsolutePath();
	                f=new File(PATH);
	                
	                FileInputStream fi=new FileInputStream(f);
	    			ObjectInputStream oi=new ObjectInputStream(fi);
	    			Singleton.Client_array=(ArrayList<Class_client>)oi.readObject();
	    			oi.close();
	            }
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "Error reading TXT", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	
	/**AUTOMATIC CREATE TXT CLIENT*/
	public static void auto_create_txt_cient() {
        String PATH = null;
        try {
            File f;
            PATH = new java.io.File(".").getCanonicalPath()+"/src/Framework/Modules/Users/Model/Files/client_files/txt/prova.txt";

                f = new File(PATH);
                
                FileOutputStream fo=new FileOutputStream(f);
				ObjectOutputStream o=new ObjectOutputStream(fo);
				o.writeObject(Singleton.Client_array);
				o.close();
            
        } catch (Exception e) {
        }
    }
	
	/**AUTOMATIC OPEN TXT CLIENT*/
	public static void auto_open_txt_client() {
    	String PATH = null;
        try {
            File f;
            PATH = new java.io.File(".").getCanonicalPath()+"/src/Framework/Modules/Users/Model/Files/client_files/txt/prova.txt";

                f = new File(PATH);
                
                FileInputStream fi=new FileInputStream(f);
    			ObjectInputStream oi=new ObjectInputStream(fi);
    			Singleton.Client_array=(ArrayList<Class_client>)oi.readObject();
    			oi.close();
            
        } catch (Exception e) {
        	
        }
    }
}