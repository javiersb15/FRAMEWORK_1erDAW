package Framework.Modules.Users.Admin.Model.Clases;

import java.io.Serializable;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import Framework.Class.Class_date;
import Framework.Modules.Users.User.Model.Clases.Class_user;
import Framework.Modules.Menu.Model.Config_menus;
import Framework.Utils.Format;

@XStreamAlias("Class_admin")
public class Class_admin extends Class_user implements Serializable{
	
	/**ATTRIBUTES*/
	@XStreamAlias("date_employ")
	private Class_date date_employ;
	@XStreamAlias("antique")
	private int antique;
	@XStreamAlias("salary")
	private float salary;
	@XStreamAlias("activity")
	private int activity;
	@XStreamAlias("incentive")
	private float incentive;
	
	/**CONSTRUCTOR*/
	public Class_admin(String DNI, String name, String surname, Class_date date_birthday, String mobile, String avatar, 
			boolean state, String email, String user, String pass, Class_date date_employ, float salary, 
			float incentive, int activity){
		
		super.setDNI(DNI);
		super.setname(name);
		super.setsurname(surname);
		super.setdate_birthday(date_birthday);
		super.setmobile(mobile);
		super.setavatar(avatar);
		super.setstate(state);
		super.setemail(email);
		super.setuser(user);
		super.setpass(pass);
		this.date_employ=date_employ;
		this.setantique(antiquecalculate());
		this.salary=salary;
		this.activity=activity;
		this.incentive=incentive;
		super.setbenefit(benefitcalculate());
	}
	
	/**CONSTRUCTOR BY DEFAULT*/
	public Class_admin(){	
		super();
	}
	
	/**CONSTRUCTOR BY PRIMARY KEY ONLY DNI*/
	public Class_admin(String dni){
		super(dni);
	}
	
	/**CONSTRUCTOR BY PRIMARY KEY*/
	public Class_admin(Object s, int i){
		super(s, i);
		
		switch(i){
			case 11:
				this.date_employ=(Class_date) s;
			break;
			case 12:
				this.incentive=(float) s;
			break;
			case 13:
				this.salary=(float) s;
			break;
			case 14:
				this.activity=(int) s;
			break;
		}	
	}
	
	/**GETTERS*/
	public Class_date getdate_employ(){
		return this.date_employ;
	}
	
	public int getantique(){
		return this.antique;
	}
	
	public float getsalary(){
		return this.salary;
	}
		
	public int getactivity(){
		return this.activity;
	}
	
	public float getincentive(){
		return this.incentive;
	}
	
	/**SETTERS*/
	public void setdate_employ(Class_date date_employ){
		this.date_employ=date_employ;
		this.setantique(this.antiquecalculate());
	}
	
	public void setantique(int antique){
		this.antique=antique;
	}
	
	public void setsalary(float salary){
		this.salary=salary;
	}
	
	public void setactivity(int activity){
		this.activity=activity;
		super.setbenefit(this.benefitcalculate());
	}
	
	public void setincentive(float incentive){
		this.incentive=incentive;
	}
		
	/**TO STRING*/
	public String toString(String dni){
		String cad=" ";
		cad=cad+this.getDNI() +"\n";
		
		return cad;
	}
	
	public String toString(){
		StringBuffer string=new StringBuffer();
		string.append(super.toString());
		string.append("The date employ is "+ this.getdate_employ().toStringformat() +"\n");
		string.append("The antique is "+ this.getantique() +"\n");
		string.append("The salary is "+ Config_menus.formatcoin(this.getsalary()) +"\n");
		string.append("The activity is "+ this.getactivity() +"\n");
		string.append("The incentive is "+ this.getincentive() +"\n");
				
		return string.toString();
	}
	
	/**TO STRING ADMIN*/
	public String toString_election(int i){
		String cad=" ";
		
		switch(i){
		case 0:
			cad=cad+super.toString(i);
		break;
		case 1:
			cad=cad+super.toString(i);
		break;
		case 2:
			cad=cad+super.toString(i);
		break;
		case 3:
			cad=cad+super.toString(i);
		break;
		case 4:
			cad=cad+super.toString(i);
		break;
		case 5:
			cad=cad+super.toString(i);
		break;
		case 6:
			cad=cad+super.toString(i);
		break;
		case 7:
			cad=cad+super.toString(i);
		break;
		case 8:
			cad=cad+super.toString(i);
		break;
		case 9:
			cad=cad+super.toString(i);
		break;
		case 10:
			cad=cad+super.toString(i);
		break;
		case 11:
			cad=cad+super.toString(i);
		break;
		case 12:
			cad=cad+"The date employ is "+ this.getdate_employ() +"\n";
		break;
		case 13:
			cad=cad+"The antique is "+ this.getantique() +"\n";
		break;
		case 14:
			cad=cad+"The salary is "+ Format.euro(this.getsalary())+"\n";
		break;
		case 15:
			cad=cad+"The activity is "+ this.getactivity() +"\n";
		break;
		case 16:
			cad=cad+"The incentive is "+ this.getincentive() +"\n";
		break;
	}
		return cad;
	}
	
	/**CALCULATE BENEFIT*/
	public float benefitcalculate(){
		float benefit=0.0f;
		
		benefit=(this.getactivity())+4;
		
		return benefit;
			
		}
	
	/**CALCULATE ANTIQUE*/
	public int antiquecalculate(){
		int antique=0;
		
		antique=(this.getdate_employ().substractdatesystem());
		
		return antique;
			
		}
}