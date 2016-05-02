package Framework.Modules.Menu.Model.Clases;

import Framework.Modules.Menu.Model.Clases.Class_config;
import java.io.IOException;
import java.util.Properties;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Class_language")
public class Class_language extends Properties{
		
		private static Class_language instance;
				
		public Class_language (){
		    switch(Class_config.getInstance().getLanguage()){
		    case "ENGLISH":
		        getProperties("english.properties");
		        break;
		    case "SPANISH":
		        getProperties("spanish.properties");
		        break;
		    case "VALENCIAN":
		        getProperties("valencian.properties");
		        break;
		    default:
		        getProperties("valencian.properties");
		    }
		}
		
		public static Class_language getInstance(){
			if (instance==null){
				instance=new Class_language();
			}
				return instance;
			}
		
		public void setlanguage() {
			
			switch(Class_config.getInstance().getLanguage()){
		    case "ENGLISH":
		        getProperties("english.properties");
		        break;
		    case "SPANISH":
		        getProperties("spanish.properties");
		        break;
		    case "VALENCIAN":
		        getProperties("valencian.properties");
		        break;
		    default:
		        getProperties("valencian.properties");
			}
		}

		public void getProperties(String choose_language) {
	        try {
	            this.load( getClass().getResourceAsStream(choose_language) );
	        } catch (IOException ex) {
	        }
	    }
}