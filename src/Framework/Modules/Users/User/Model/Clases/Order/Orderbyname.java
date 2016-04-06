package Framework.Modules.Users.User.Model.Clases.Order;

import Framework.Modules.Users.User.Model.Clases.Class_user;
import java.util.Comparator;


	/**ORDER BY NAME*/
	public class Orderbyname implements Comparator <Class_user>{

		public int compare (Class_user usr1, Class_user usr2) {
			if(usr1.getname().compareTo(usr2.getname())>0)
				return 1;
			if(usr1.getname().compareTo(usr2.getname())<0)
				return -1;
			return 0;
		}
}