package Framework.Modules.Config.Model;

import java.io.IOException;
import java.util.Properties;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Class_language")
public class Class_language extends Properties{
		
		private static Class_language instance;
				
		public Class_language (){
		    switch(Class_config.getInstance().getLanguage()){
		    case "English":
		        getProperties("english.properties");
		        break;
		    case "Spanish":
		        getProperties("spanish.properties");
		        break;
		    case "Valencian":
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
		    case "English":
		        getProperties("english.properties");
		        break;
		    case "Spanish":
		        getProperties("spanish.properties");
		        break;
		    case "Valencian":
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