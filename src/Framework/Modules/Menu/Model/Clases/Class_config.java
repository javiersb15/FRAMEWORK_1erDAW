package Framework.Modules.Menu.Model.Clases;

import Framework.Class.Connection_DB;
import Framework.Class.Mongo_DB;
import Framework.Class.Singleton_tools;
import Framework.Modules.Menu.Model.Functions.json_auto_config;
import Framework.Modules.Users.Admin.Model.Clases.Class_admin;
import Framework.Modules.Users.Admin.Model.Utils.Functions_dummy_admin;
import Framework.Modules.Users.Client.Model.Clases.Class_client;
import Framework.Modules.Users.Client.Model.Utils.Functions_dummy_client;
import Framework.Modules.Users.User.Model.Clases.Singleton;
import Framework.Modules.Users.User_register.Model.Clases.Class_user_register;
import Framework.Modules.Users.User_register.Model.Utils.Extensions.Json;
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
	@XStreamAlias("format_file")
	private String format_file;
	@XStreamAlias("language")
	private String language;
	@XStreamAlias("theme")
	private String theme;
	@XStreamAlias("decimal_number")
	private String decimal_number;
	@XStreamAlias("instance")
	private static Class_config instance;
		
	public Class_config(){
		this.format_date="dd/MM/yyyy";
		this.currency="EURO";
		this.format_file="1";
		this.language="ENGLISH";
		this.theme="Nimbus";
		this.decimal_number="2 DECIMAL";	
	}
	
	public static Class_config getInstance(){
		if (instance==null){
			instance=new Class_config();
                        
                json_auto_config.open_json_config();
			
		Connection_DB.inicializa_BasicDataSourceFactory();
                Singleton_tools.mongo=new Mongo_DB();
                Singleton_tools.client=Mongo_DB.connect();
                Theme.select_theme();
		Class_language.getInstance();
		
		Singleton.Admin_array=new ArrayList <Class_admin>();
		Singleton.Client_array=new ArrayList <Class_client>();
		Singleton.User_register_array=new ArrayList <Class_user_register>();		
		
                Json.auto_open_json_usr_reg();
		//Functions_dummy_admin.cargar_admin();
                //Functions_dummy_client.cargar_client();
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

	public String getFormat_file() {
		return format_file;
	}

	public void setFormat_file(String format_file) {
		this.format_file = format_file;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
                Class_language.getInstance().setlanguage();
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
                Theme.select_theme();
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
	
	public String toString() {
		StringBuffer string =new StringBuffer();
                string.append(Class_language.getInstance().getProperty("Date")+": "+this.getFormat_date()+"\n");
                string.append(Class_language.getInstance().getProperty("Currency")+": "+this.getCurrency()+"\n");
                string.append(Class_language.getInstance().getProperty("Language")+": "+this.getLanguage()+"\n");
                string.append(Class_language.getInstance().getProperty("Theme")+": "+this.getTheme()+"\n");
                string.append(Class_language.getInstance().getProperty("Decimal")+": "+this.getDecimal_number()+"\n");
                return string.toString();
	}
        
        /*public String toString() {
		return "Configuration [format_data="+format_date+", Currency="+currency
				+", Languages="+language+", Theme="+theme+", "
						+ "Decimal number="+decimal_number+"]";
	}*/
}