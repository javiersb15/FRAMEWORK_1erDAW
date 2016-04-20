package Framework.Utils;

import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import Framework.Modules.Menu.Model.Class_config;
import Framework.Modules.Menu.Model.Class_language;

public class Config_menus {
	
	/**TYPE OF CURRENCY*/
	public static String formatcoin(float money) {
		String credit=" ";
		float valuedolar=1.08394f;
		float valuelibra=0.727202f;

		switch (Class_config.getInstance().getCurrency()) {
		
		/**Euro*/
		case '€':
			NumberFormat coin_euro = NumberFormat.getCurrencyInstance(Locale.FRANCE);
			credit=coin_euro.format(money);				
			break;
			
		/**Libra*/
		case '£':
			money= money * valuelibra;
			NumberFormat coin_libra = NumberFormat.getCurrencyInstance(Locale.UK);
			credit=coin_libra.format(money);
			break;

		/**Dolar*/
		case '$':
			money=money * valuedolar;
			NumberFormat coin_dolar = NumberFormat.getCurrencyInstance(Locale.US);
			credit=coin_dolar.format(money);
			break;
		}
		return credit;
	}
	
	/**MENU DATE*/
	public static void menudate() {
				String [] options_format_date={"dd/MM/yyyy", "dd-MM-yyyy", "yyyy/MM/dd", "yyyy-MM-dd"};
				int selection_format=0;
				int[] format={0, 0, 0, 0};
				
				format[0]=Menus.menubutton(options_format_date,"Choose the format of date", "Choosing");
				
				switch(selection_format){
					case 0:
						Class_config.getInstance().setFormat_date("dd/MM/yyyy");
						break;
					case 1:
						Class_config.getInstance().setFormat_date("dd-MM-yyyy");
						break;	
					case 2:
						Class_config.getInstance().setFormat_date("yyyy/MM/dd");
						break;	
					case 3:
						Class_config.getInstance().setFormat_date("yyyy-MM-dd");
						break;
				}
	}
	
	/**MENU COIN*/
	public static void menucoin() {
				String [] options_currency={"�", "�", "$"};
				int selection_currency=0;
				int[] format={0, 0, 0, 0};
				
				format[1]=Menus.menubutton(options_currency,"Choose the type of currency", "Choosing");
				
				switch(selection_currency){
				/**euro*/
					case 0:
						Class_config.getInstance().setCurrency('�');
						break;
						
				/**libra*/		
					case 1:
						Class_config.getInstance().setCurrency('�');
						break;
						
				/**dolar*/		
					case 2:
						Class_config.getInstance().setCurrency('$');
						break;
				}
	}
	
	/**MENU DECIMAL*/
	public static void menudecimal() {
				String [] options_decimal={"1", "2", "3"};
				int selection_decimal=0;
				int[] format={0, 0, 0, 0};
				
				format[2]=Menus.menubutton(options_decimal,"Choose the number of decimal", "Choosing");
				
				switch(selection_decimal){
				/**one decimal*/
					case 0:
						Class_config.getInstance().setDecimal_number(1);
						break;
						
				/**two decimal*/		
					case 1:
						Class_config.getInstance().setDecimal_number(2);
						break;
						
				/**three decimal*/		
					case 2:
						Class_config.getInstance().setDecimal_number(3);
						break;
				}
	}
	
	/**CHOOSE THE LANGUAGE*/
	public static void menulanguage() {
		
			String [] options_language={"English", "Spanish", "Valencian"};
			int selection_language=0;
			int[] format={0, 0, 0, 0};
			
			format[3]=Menus.menubutton(options_language,"Choose the type of language", "Choosing");
			
			switch(selection_language){
			/**english*/
				case 0:
					Class_config.getInstance().setLanguage("English");
					//Class_language.getInstance().setlanguage();
					break;
					
			/**spanish*/		
				case 1:
					Class_config.getInstance().setLanguage("Spanish");
					//Class_language.getInstance().setlanguage();
					break;
					
			/**valencian*/		
				case 2:
					Class_config.getInstance().setLanguage("Valencian");
					//Class_language.getInstance().setlanguage();
					break;
			}
	}
	
	/**THEME MENU*/
	public static void theme_menu(){
		String[] tipo = {"Metal","Windows","Motif","Nimbus"};
		
		
		int resp = JOptionPane.showOptionDialog(null,"What Theme do you want?",
				   "Choosing",0,JOptionPane.QUESTION_MESSAGE,null,tipo,tipo[0]);
		if(resp == 0){
			Class_config.getInstance().setTheme("Metal");
				Theme.select_theme("Metal");
		}else if (resp == 1){
			Class_config.getInstance().setTheme("Windows");
				Theme.select_theme("Windows");
		}else if (resp == 2){
			Class_config.getInstance().setTheme("Motif");
				Theme.select_theme("Motif");
		}else if (resp == 3){
			Class_config.getInstance().setTheme("Nimbus");
				Theme.select_theme("Nimbus");
		}
	}
}
