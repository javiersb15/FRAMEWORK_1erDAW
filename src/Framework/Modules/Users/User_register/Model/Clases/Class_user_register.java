package Framework.Modules.Users.User_register.Model.Clases;

import java.io.Serializable;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import Framework.Class.Class_date;
import Framework.Modules.Users.User.Model.Clases.Class_user;

@XStreamAlias("Class_user_register")
public class Class_user_register extends Class_user implements Serializable {

	/**ATTRIBUTES*/
	@XStreamAlias("activity")
	private int activity;
	@XStreamAlias("karma")
	private String karma;
	@XStreamAlias("points")
	private int points;

	/**CONSTRUCTOR*/
	public Class_user_register(String DNI, String name, String surname, Class_date date_birthday, String mobile,
			String avatar, boolean state, String email, String user, String pass, int activity){
		
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
		this.activity=activity;
		this.setkarma(karmacalculate());
		super.setbenefit(benefitcalculate());
		this.setpoints(pointscalculate());
	}
	
	/**CONSTRUCTOR BY DEFAULT*/
	public Class_user_register(){	
		super();
	}
	
	/**CONSTRUCTOR BY PRIMARY KEY ONLY DNI*/
	public Class_user_register(String dni){
		super(dni);
	}
	
	/**CONSTRUCTOR BY PRIMARY KEY*/
	public Class_user_register(Object s, int i){
		super (s,i);
		
		switch(i){
			case 12:
				this.activity=(int) i;
			break;
		}	
	}
	
	/**GETTERS*/
	public int getactivity(){
		return this.activity;
	}
	
	public String getkarma(){
		return this.karma;
	}
	
	public int getpoints(){
		return this.points;
	}
	
	/**SETTERS*/
	public void setactivity(int activity){
		this.activity=activity;	
		this.setkarma(this.karmacalculate());
		this.setpoints(this.pointscalculate());
		super.setbenefit(this.benefitcalculate());
	}
	
	public void setkarma(String karma){
		this.karma=karma;
	}
	
	public void setpoints(int points){
		this.points=points;
	}
	
	/**TO STRING*/
	public String toString(String dni){
		String cad=" ";
		cad=cad+this.getDNI() +"\n";
		
		return cad;
	}
			
	/**TO STRING*/
	public String toString(){
		StringBuffer buffer=new StringBuffer();
		buffer.append(super.toString());
		buffer.append("The activity is "+ this.getactivity() +"\n");
		buffer.append("The karma is "+ this.getkarma() +"\n");
				
		return buffer.toString();
	}
	
	/**TO STRING USER REGISTER*/
	public String toString(int i){
		String cad=" ";
		
		if (i<11){
			cad=cad+super.toString(i);
		}
		else
			switch(i){
			
			case 12:
				cad=cad+"The activity is "+ this.getactivity() +"\n";
			break;
			case 13:
				cad=cad+"The karma is "+ this.getkarma() +"\n";
			break;
		}
		return cad;
	}
	
	/**CALCULATE KARMA */
	public String karmacalculate(){
		if (getactivity() > 25)
			karma="Hight";
		else if (getactivity() > 15)
			karma="Medium";
		else if (getactivity() >= 0)
			karma="Low";
		return karma;
	}
	
	/**CALCULATE BENEFIT*/
	public float benefitcalculate(){
		float benefit=0.0f;
		
		if(this.getkarma().equals("Low"))
			 benefit = 10 * this.getactivity();
		else if (this.getkarma().equals("Medium"))
			benefit = 20 * this.getactivity();
		else if (this.getkarma().equals("Hight"))
			benefit = 30 * this.getactivity();
		return benefit;
		}
	
	/**CALCULATE POINTS*/
	public int pointscalculate(){
		int points=0;
		
		if(this.getactivity()>100)
			 points = 10;
		else if (this.getactivity()>200)
			points = 20;
		else if (this.getactivity()>300)
			points = 30;
		return points;
	}
}