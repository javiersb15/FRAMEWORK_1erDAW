package Framework.Modules.Users.User.Model.Clases;

import java.io.Serializable;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import Framework.Class.Class_date;

@XStreamAlias("Class_user")
public abstract class Class_user implements Comparable<Class_user>, Serializable {

	/**ATTRIBUTES*/
	@XStreamAlias("DNI")
	private String DNI;
	@XStreamAlias("name")
	private String name;
	@XStreamAlias("surname")
	private String surname;
	@XStreamAlias("date_bisthday")
	private Class_date date_birthday;
	@XStreamAlias("mobile")
	private String mobile;
	@XStreamAlias("age")
	private int age;
	@XStreamAlias("avatar")
	private String avatar;
	@XStreamAlias("state")
	private boolean state;
	@XStreamAlias("email")
	private String email;
	@XStreamAlias("user")
	private String user;
	@XStreamAlias("pass")
	private String pass;
	@XStreamAlias("benefit")
	private float benefit;
	
	
	/**CONSTRUCTOR*/
	public Class_user(String DNI, String name, String surname, Class_date date_birthday, String mobile,	String avatar, boolean state, 
			String email, String user, String pass, float benefit){
		
		this.DNI=DNI;
		this.name=name;
		this.surname=surname;
		this.date_birthday=date_birthday;
		this.mobile=mobile;
		this.setage(calculateage());
		this.avatar=avatar;
		this.state=state;
		this.email=email;
		this.user=user;
		this.pass=pass;
		this.benefit=benefit;
	}
	
	/**CONSTRUCTOR BY DEFAULT*/
		public Class_user(){	
		}
	
	/**CONSTRUCTOR BY PRIMARY KEY ONLY DNI*/
		public Class_user(String DNI){
			this.DNI=DNI;
		}
		
	/**CONSTRUCTOR BY PRIMARY KEY*/
		public Class_user(Object s, int i){
			
			switch(i){
				case 0:
					this.DNI=(String) s;
				break;
				case 1:
					this.name=(String) s;
				break;
				case 2:
					this.surname=(String) s;
				break;
				case 3:
					this.date_birthday=(Class_date) s;
				break;
				case 4:
					this.mobile=(String) s;
				break;
				case 5:
					this.avatar=(String) s;
				break;
				case 6:
					this.state=(boolean) s;
				break;
				case 7:
					this.email=(String) s;
				break;
				case 8:
					this.user=(String) s;
				break;
				case 9:
					this.pass=(String) s;
				break;
				case 10:
					this.benefit=(float) s;
				break;
			}	
		}
	
		/**GETTERS*/
		public String getDNI(){
			return this.DNI;
		}
		
		public String getname(){
			return this.name;
		}
		
		public String getsurname(){
			return this.surname;
		}
		
		public Class_date getdate_birthday(){
			return date_birthday;
		}
		
		public String getmobile(){
			return this.mobile;
		}
			
		public int getage(){
			return age;
		}
		
		public String getavatar(){
			return this.avatar;
		}
		
		public boolean isstate(){
			return this.state;
		}
		
		public String getemail(){
			return this.email;
		}
		
		public String getuser(){
			return this.user;
		}
		
		public String getpass(){
			return this.pass;
		}
		
		public float getbenefit(){
			return this.benefit;
		}
	
		/**SETTERS*/
		public void setDNI(String dni){
			DNI=dni;
		}
		
		public void setname(String name){
			this.name=name;
		}
		
		public void setsurname(String surname){
			this.surname=surname;
		}
		
		public void setdate_birthday(Class_date date_birthday){
			this.date_birthday=date_birthday;
			this.setage(this.calculateage());
		}
		
		public void setmobile(String mobile){
			this.mobile=mobile;
		}
			
		public void setage(int age){
			this.age=age;
		}
		
		public void setavatar(String avatar){
			this.avatar=avatar;
		}
		
		public void setstate(boolean state){
			this.state=state;
		}

		public void setemail(String email) {
			this.email=email;
		}

		public void setuser(String user) {
			this.user=user;
		}

		public void setpass(String pass) {
			this.pass=pass;
		}
		
		public void setbenefit(float benefit){
			this.benefit=benefit;
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
			buffer.append("The DNI is "+ this.getDNI() + "\n");
			buffer.append("The name is "+ this.getname() +"\n");
			buffer.append("The surname is "+ this.getsurname() +"\n");
			buffer.append("The date_birthday is "+ this.getdate_birthday().toStringformat() +"\n");
			buffer.append("The mobile is "+ this.getmobile() +"\n");
			buffer.append("The age is "+ this.getage() +"\n");
			buffer.append("The avatar is "+ this.getavatar() +"\n");
			buffer.append("The state is "+ this.isstate() +"\n");
			buffer.append("The email is "+ this.getemail() +"\n");
			buffer.append("The user is "+ this.getuser() +"\n");
			buffer.append("The pass is "+ this.getpass() +"\n");
			buffer.append("The benefit is "+ this.getbenefit() +"\n");
			
			return buffer.toString();
		}
		
		/**TO STRING USER*/
		public String toString(int i){
			String cad=" ";
			
			switch(i){
			case 0:
				cad=cad+"The DNI is "+ this.getDNI() + "\n";
			break;
			case 1:
				cad=cad+"The name is "+ this.getname() +"\n";
			break;
			case 2:
				cad=cad+"The surname is "+ this.getsurname() +"\n";
			break;
			case 3:
				cad=cad+"The date_birthday is "+ this.getdate_birthday() +"\n";
			break;
			case 4:
				cad=cad+"The mobile is "+ this.getmobile() +"\n";
			break;
			case 5:
				cad=cad+"The age is "+ this.getage() +"\n";
			break;
			case 6:
				cad=cad+"The avatar is "+ this.getavatar() +"\n";
			break;
			case 7:
				cad=cad+"The state is "+ this.isstate() +"\n";
			break;
			case 8:
				cad=cad+"The email is "+ this.getemail() +"\n";
			break;
			case 9:
				cad=cad+"The user is "+ this.getuser() +"\n";
			break;
			case 10:
				cad=cad+"The pass is "+ this.getpass() +"\n";
			break;	
			case 11:
				cad=cad+"The benefit is "+ this.getbenefit() +"\n";
			break;
		}
			return cad;
		}
		public abstract float benefitcalculate();
		
		/**CALCULATE AGE*/
		public int calculateage() {
			int substract=0;
			
				substract=this.getdate_birthday().substractdatesystem();
				return substract;
			}
		
		/**ORDER BY NAME*/
		public int compareTo (Class_user s) {
			if(this.getDNI().compareTo(s.getDNI())>0)
				return 1;
			if(this.getDNI().compareTo(s.getDNI())<0)
				return -1;
			return 0;
		}
		
		public boolean equals (Object s) {
			return this.getDNI().equals(((Class_user)s).getDNI());
		}
}