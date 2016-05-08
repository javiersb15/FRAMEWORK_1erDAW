package Framework.Utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Format {
		
		/**1 DECIMAL*/
		public static String onedecimal(float number) {
			DecimalFormat onedecimal = new DecimalFormat(".0");
			return onedecimal.format(number);
		}
		
		/**2 DECIMAL*/
		public static String twodecimal(float number) {
			DecimalFormat twodecimal = new DecimalFormat(".00");
			return twodecimal.format(number);
		}
		
		/**3 DECIMAL*/
		public static String threedecimal(float number) {
			DecimalFormat threedecimal = new DecimalFormat(".000");
			return threedecimal.format(number);
		}
		
		/**DOLAR*/
		public static String dolar(float money) {
			NumberFormat coin = NumberFormat.getCurrencyInstance(Locale.US);
			return coin.format(money);
		}
		
		/**LIBRA*/
		public static String libra(float money) {
			NumberFormat coin = NumberFormat.getCurrencyInstance(Locale.UK);
			return coin.format(money);
		}
		
		/**EURO*/
		public static String euro(float money) {
			NumberFormat coin = NumberFormat.getCurrencyInstance(Locale.FRANCE);
			return coin.format(money);
		}
		
		/**TYPE OF CURRENCY*/
		public static String formatcoin(float money, int tipe) {
			String credit= "";
			float valuedolar=1.08394f;
			float valuelibra=0.727202f;

			switch (tipe) {
			
			/**Euro*/
			case 0:
				NumberFormat coin_euro = NumberFormat.getCurrencyInstance(Locale.FRANCE);
				credit=coin_euro.format(money);				
				break;
				
			/**Libra*/
			case 1:
				money= money * valuelibra;
				NumberFormat coin_libra = NumberFormat.getCurrencyInstance(Locale.UK);
				credit=coin_libra.format(money);
				break;

			/**Dolar*/
			case 2:
				money=money * valuedolar;
				NumberFormat coin_dolar = NumberFormat.getCurrencyInstance(Locale.US);
				credit=coin_dolar.format(money);
				break;
			}
			return credit;
		}
}