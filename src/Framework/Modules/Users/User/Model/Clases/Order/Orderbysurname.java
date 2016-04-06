package Framework.Modules.Users.User.Model.Clases.Order;

import Framework.Modules.Users.User.Model.Clases.Class_user;
import java.util.Comparator;


/**ORDER BY SURNAME*/
public class Orderbysurname implements Comparator <Class_user>{

	public int compare (Class_user usr1, Class_user usr2) {
		if(usr1.getsurname().compareTo(usr2.getsurname())>0)
			return 1;
		if(usr1.getsurname().compareTo(usr2.getsurname())<0)
			return -1;
		return 0;
	}
}