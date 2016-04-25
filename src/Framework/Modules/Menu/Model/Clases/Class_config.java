package Framework.Modules.Menu.Model.Clases;

import Framework.Modules.Users.Admin.Model.Bll.Functions_auto_open;
import Framework.Modules.Users.Admin.Model.Clases.Class_admin;
import Framework.Modules.Users.Admin.Model.Utils.Extensions.Json;
import Framework.Modules.Users.Admin.Model.Utils.Functions_dummy_admin;
import Framework.Modules.Users.Client.Model.Clases.Class_client;
import Framework.Modules.Users.Client.Model.Utils.Functions_dummy_client;
import Framework.Modules.Users.User.Model.Clases.Singleton;
import Framework.Modules.Users.User_register.Model.Clases.Class_user_register;
import Framework.Modules.Users.User_register.Model.Utils.Functions_dummy_usr_reg;
import Framework.Utils.Theme;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.util.ArrayList;

@XStreamAlias("Class_config")
public class Class_config implements Serializable{
	
	@XStreamAlias("format_date")
	private String format_date;
	@XStreamAlias("currency")
	private String currency;
	@XStreamAlias("language")
	private String language;
	@XStreamAlias("theme")
	private String theme;
	@XStreamAlias("decimal_number")
	private String decimal_number;
	@XStreamAlias("instance")
	private static Class_config instance;
		
	public Class_config (String format_date, String currency, String language, String decimal_number, String theme) {
		this.format_date=format_date;
		this.currency=currency;
		this.language=language;
                this.decimal_number=decimal_number;
                this.theme=theme;		
	}
        
        public Class_config(){
		this.format_date="dd/MM/yyyy";
		this.currency="€";
		this.language="val";
		this.theme="Nimbus";
		this.decimal_number="2";	
	}
	
	public static Class_config getInstance(){
		if (instance==null){
			instance=new Class_config();
			
		Theme.select_theme(Class_config.getInstance().getTheme());
		Class_language.getInstance();
		
		Singleton.Admin_array=new ArrayList <Class_admin>();
		Singleton.Client_array=new ArrayList <Class_client>();
		Singleton.User_register_array=new ArrayList <Class_user_register>();
				
                //Functions_dummy_admin.cargar_admin();
               Functions_dummy_client.cargar_client();
		//Functions_dummy_usr_reg.cargar_user_register();
		
		}
		return instance;
	}

	public String getFormat_date() {
		return format_date;
	}

	public void setFormat_date(String format_date) {
		this.format_date = format_date;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
                Theme.select_theme(Class_config.getInstance().getTheme());
	}

	public String getDecimal_number() {
		return decimal_number;
	}

	public void setDecimal_number(String decimal_number) {
		this.decimal_number = decimal_number;
	}

	public static void setInstance(Class_config instance) {
		Class_config.instance = instance;
	}
	
	public String toString(Class_config instance) {
            StringBuffer string = new StringBuffer();
            
            string.append("language" +this.getLanguage()+"\n");
	    string.append("format_date" +this.getFormat_date()+"\n");
            string.append("currency" +this.getCurrency()+"\n");
            string.append("decimal_number" +this.getDecimal_number()+"\n");
            string.append("theme" +this.getTheme()+"\n");
            return string.toString();
	}
}