package Framework.Modules.Users.Client.Model.Clases;

import java.io.Serializable;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import Framework.Class.Class_date;
import Framework.Modules.Users.User.Model.Clases.Class_user;

@XStreamAlias("Class_client")
public class Class_client extends Class_user implements Serializable {

	/**ATTRIBUTES*/
	@XStreamAlias("buy")
	private float buy;
	@XStreamAlias("premium")
	private boolean premium; 
	@XStreamAlias("date_start")
	private Class_date date_start;
	@XStreamAlias("client_type")
	private String client_type;
	@XStreamAlias("antique")
	private int antique;

	/**CONSTRUCTOR*/
	public Class_client(String DNI, String name, String surname, Class_date date_birthday, String mobile,
			String avatar, boolean state, String email, String user, String pass, float buy, boolean premium, 
			Class_date date_start, String client_type){
		
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
		super.setbenefit(benefitcalculate());
		this.buy=buy;
		this.date_start=date_start;
		this.setantique(antiquecalculate());
		this.premium=premium;
		this.client_type=client_type;
	}
	
	/**CONSTRUCTOR BY DEFAULT*/
	public Class_client(){	
		super();
	}
	
	/**CONSTRUCTOR BY PRIMARY KEY ONLY DNI*/
	public Class_client(String dni){
		super(dni);
	}
	
	/**CONSTRUCTOR BY PRIMARY KEY*/
	public Class_client(Object s, int i){
		super(s, i);
		
		switch(i){
			case 11:
				this.buy=(int) i;
			break;
			case 12:
				this.premium=(boolean) s;
			break;
			case 13:
				this.date_start=(Class_date) s;
			break;
			case 14:
				this.client_type=(String) s;
			break;
		}	
	}
	
	/**GETTERS*/
	public float getbuy(){
		return this.buy;
	}
		
	public boolean getpremium(){
		return this.premium;
	}
	
	public Class_date getdate_start(){
		return this.date_start;
	}
	
	public String getclient_type(){
		return this.client_type;
	}
	
	public int getantique(){
		return this.antique;
	}
	
	/**SETTERS*/
	public void setbuy(float buy){
		this.buy=buy;
	}
	
	public void setantique(int antique){
		this.antique=antique;
	}
		
	public void setpremium(boolean premium){
		this.premium=premium;
	}
	
	public void setdate_start(Class_date date_start){
		this.date_start=date_start;
		this.setantique(this.antiquecalculate());
	}
	
	public void setclient_type(String client_type){
		this.client_type=client_type;
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
		buffer.append("The buy is "+ this.getbuy() +"\n");
		buffer.append("The premium is "+ this.getpremium() +"\n");
		buffer.append("The date start is "+ this.getdate_start().toStringformat() +"\n");
		buffer.append("The client type is "+ this.getclient_type() +"\n");
		buffer.append("The antique is "+ this.getantique() +"\n");
		
		return buffer.toString();
	}
	
	/**TO STRING CLIENT*/
	public String toString(int i){
		String cad=" ";
		
		if (i<11){
			cad=cad+super.toString(i);
		}
		else
			switch(i){
			
			case 12:
				cad=cad+"The buy is "+ this.getbuy() +"\n";
			break;
			case 13:
				cad=cad+"The premium is "+ this.getpremium() +"\n";
			break;
			case 14:
				cad=cad+"The date start is "+ this.getdate_start() +"\n";
			break;
			case 15:
				cad=cad+"The client type is "+ this.getclient_type() +"\n";
			break;
			case 16:
				cad=cad+"The antique is "+ this.getantique() +"\n";
			break;
		}
	return cad;
	}
	
	/**CALCULATE BENEFIT*/
	public float benefitcalculate(){
		float benefit=0.0f;
		
		if(this.getpremium()==true)
			 benefit = 10;
			 else
				 benefit=5;
		
		return benefit;
		}
	
	/**CALCULATE ANTIQUE*/
	public int antiquecalculate(){
		int antique=0;
		
		antique=(this.getdate_start().substractdatesystem());
		
		return antique;
			
		}
}