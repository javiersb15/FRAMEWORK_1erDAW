package Framework.Modules.Users.Client.Model.Dao;

import Framework.Class.Class_date;
import Framework.Modules.Users.Client.Model.Bll.bll_client;
import Framework.Modules.Users.Client.Model.Clases.Class_client;
import Framework.Modules.Users.Client.View.client_jframe_create;
import static Framework.Modules.Users.Client.View.client_jframe_create.eti_avatar_create;
import Framework.Modules.Users.Client.View.client_jframe_update;
import Framework.Modules.Users.User.Model.Clases.Files_class;
import Framework.Utils.Validate;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Image;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;



public class dao_client {

	
	/**MODIFY CLIENT*/
	public static void modifyadmin() {
            Class_client a_1=null;
            a_1=bll_client.select_client();
            
            
            if (a_1!=null){
            client_jframe_update.eti_dni_update.setText(a_1.getDNI());
            client_jframe_update.eti_name_update.setText(a_1.getname());
            client_jframe_update.eti_surname_update.setText(a_1.getsurname());
            client_jframe_update.eti_date_birthday_update.setCalendar(a_1.getdate_birthday().stringtocalendar());
            client_jframe_update.eti_mobile_update.setText(a_1.getmobile());
            client_jframe_update.eti_avatar_update.setText(a_1.getavatar());            
            if (a_1.isstate()==true){
                client_jframe_update.eti_state_co_update.setSelected(true);
            }else{ 
                client_jframe_update.eti_state_di_update.setSelected(true);
            }
            client_jframe_update.eti_email_update.setText(a_1.getemail());
            client_jframe_update.eti_user_update.setText(a_1.getuser());
            client_jframe_update.eti_pass_update.setText(a_1.getpass());
            client_jframe_update.eti_date_start_update.setCalendar(a_1.getdate_start().stringtocalendar());
            client_jframe_update.eti_buy_update.setText(a_1.getbuy()+"");
            if (a_1.getpremium()==true){
                client_jframe_update.eti_premi_true_update.setSelected(true);
            }else{ 
                client_jframe_update.eti_premi_false_update.setSelected(true);
            }
            client_jframe_update.eti_tipeclient_update.setText(a_1.getclient_type());
            	
            }
        }
        
        public static Class_client create() {
           Class_client client=null;           
       
        String dni = null;
        String name;
        String surname;
        Class_date date_birthday=null;
        String mobile;
        String avatar;
        boolean state;
        String email;
        String user;
        String pass;
        Class_date date_start=null;
        float buy;
        boolean premium;
        String client_type;
        boolean correct, correct1, correct2, correct3, correct4, correct5, correct6, correct7, correct8, correct9, correct10;

        correct=givedni();
        correct1=givename();
        correct2=givesurname();
        correct3=give_date_birthday(client_jframe_create.eti_date_birthday_create.getCalendar());
        correct4=givemobile();
        correct5=givemail();
        correct6=giveuser();
        correct7=givepassword();
        correct8=give_date_start(client_jframe_create.eti_date_birthday_create.getCalendar(), client_jframe_create.eti_date_start_create.getCalendar());
        correct9=givebuy();
        correct10=givetypeclient();

        if (correct== true && correct1==true && correct2==true && correct3==true && correct4==true && correct5==true && correct6==true && correct7==true && correct8==true && correct9==true && correct10==true) {
            dni=client_jframe_create.eti_dni_create.getText();
            name=client_jframe_create.eti_name_create.getText();
            surname=client_jframe_create.eti_surname_create.getText();
            date_birthday=new Class_date (((JTextFieldDateEditor)client_jframe_create.eti_date_birthday_create.getDateEditor()).getText());
            mobile=client_jframe_create.eti_mobile_create.getText();
            avatar=client_jframe_create.eti_avatar_create.getText();
            state=state();
            email=client_jframe_create.eti_email_create.getText();
            user=client_jframe_create.eti_user_create.getText();
            pass=client_jframe_create.eti_pass_create.getText();
            date_start=new Class_date (((JTextFieldDateEditor)client_jframe_create.eti_date_start_create.getDateEditor()).getText());
            buy=Float.parseFloat(client_jframe_create.eti_buy_create.getText());
            premium=premium();
            client_type=client_jframe_create.eti_tipeclient_create.getText();
            
            client= new Class_client(dni, name, surname, date_birthday, mobile, avatar, state, email, user, pass, buy, premium, date_start, client_type);
        } else {
            client= null;
        }
        return client;
    }
        
        public static Class_client create_update() {
           Class_client client=null;           
       
        String dni = null;
        String name;
        String surname;
        Class_date date_birthday=null;
        String mobile;
        String avatar;
        boolean state;
        String email;
        String user;
        String pass;
        Class_date date_start=null;
        float buy;
        boolean premium;
        String client_type;
        boolean correct, correct1, correct2, correct3, correct4, correct5, correct6, correct7, correct8, correct9, correct10;

        correct=givedni();
        correct1=givename();
        correct2=givesurname();
        correct3=give_date_birthday(client_jframe_update.eti_date_birthday_update.getCalendar());
        correct4=givemobile();
        correct5=givemail();
        correct6=giveuser();
        correct7=givepassword();
        correct8=give_date_start(client_jframe_update.eti_date_birthday_update.getCalendar(), client_jframe_update.eti_date_start_update.getCalendar());
        correct9=givebuy();
        correct10=givetypeclient();

        if (correct== true && correct1==true && correct2==true && correct3==true && correct4==true && correct5==true && correct6==true && correct7==true && correct8==true && correct9==true && correct10==true) {
            dni=client_jframe_update.eti_dni_update.getText();
            name=client_jframe_update.eti_name_update.getText();
            surname=client_jframe_update.eti_surname_update.getText();
            date_birthday=new Class_date (((JTextFieldDateEditor)client_jframe_update.eti_date_birthday_update.getDateEditor()).getText());
            mobile=client_jframe_update.eti_mobile_update.getText();
            avatar=client_jframe_update.eti_avatar_update.getText();
            state=state_update();
            email=client_jframe_update.eti_email_update.getText();
            user=client_jframe_update.eti_user_update.getText();
            pass=client_jframe_update.eti_pass_update.getText();
            date_start=new Class_date (((JTextFieldDateEditor)client_jframe_update.eti_date_start_update.getDateEditor()).getText());
            buy=Float.parseFloat(client_jframe_update.eti_buy_update.getText());
            premium=premium_update();
            client_type=client_jframe_update.eti_tipeclient_update.getText();
            
            client= new Class_client(dni, name, surname, date_birthday, mobile, avatar, state, email, user, pass, buy, premium, date_start, client_type);
        } else {
            client= null;
        }
        return client;
    }
        
        public static Class_client ask_clientDNI_update () {
	boolean checkDNI;
        String DNI;
        Class_client admin=null;
        
        checkDNI=DNI_update();
        if (checkDNI==true){
            admin = new Class_client (client_jframe_update.eti_dni_update.getText());
        }        
        return admin;
    }
        
        public static boolean DNI_update () {
        boolean check=true;
        
        String DNI = "", aux = "", caracteres = "TRWAGMYFPDXBNJZSQVHLCKET";
		boolean confirm;
		int number = 0, module = 0;
		char character = ' ', control = ' ';
		
		DNI=client_jframe_update.eti_dni_update.getText();
		confirm=Validate.validate_dni(DNI);
		if (confirm==false) {
                    check = false;
                }else{
                    aux = "";
                    for(int i=0; i<8; i++){
                        aux += DNI.charAt(i);
                    }	
                    character = DNI.charAt(8);			
                    number = Integer.parseInt(aux);
                    module= number % 23;
                    control = caracteres.charAt(module);
                    if(control == character){
                        check = true;
                    }else{
                        check = false;
                    }
                }
        
        return check;
    }
        
        public static boolean state(){
            boolean correct=false;
            
            if(client_jframe_create.eti_state_co_create.isSelected())
                correct=true;
            if(client_jframe_create.eti_state_di_create.isSelected())
                correct=false;            
            return correct;
        }
        
        public static boolean premium(){
            boolean correct=false;
            
            if(client_jframe_create.eti_premi_true_create.isSelected())
                correct=true;
            if(client_jframe_create.eti_premi_false_create.isSelected())
                correct=false;            
            return correct;
        }
        
        
          public static boolean givedni() {
        boolean correct = false;
        
        if (client_jframe_create.eti_dni_create.getText().equals("")) {
            
            correct = false;
            
        } else {
            if (Validate.validate_dni(client_jframe_create.eti_dni_create.getText()) == false) {
               
                correct = false;
                
            } else {
                
                correct = true;
            }
        }
        return correct;
    }
        
        public static boolean givename() {
        boolean correct = false;
        
        if (client_jframe_create.eti_name_create.getText().equals("")) {
            
            correct = false;
            
        } else {
            if (Validate.validate_name(client_jframe_create.eti_name_create.getText()) == false) {
                
                correct = false;
               
            } else {
                
                correct = true;
            }
        }
        return correct;
    }
        
        public static boolean givesurname() {
        boolean correct = false;
        
        if (client_jframe_create.eti_surname_create.getText().equals("")) {
            
            correct = false;
           
        } else {
            if (Validate.validate_surname(client_jframe_create.eti_surname_create.getText()) == false) {
                
                correct = false;
                
            } else {
               
                correct = true;
            }
        }
        return correct;
    }
        public static boolean give_date_birthday(Calendar birthdate) {
            boolean correct = false;
            Class_date fecha = new Class_date(birthdate);
            Class_date factualMenos16Anyos = Class_date.Factual();
            
            try {
            factualMenos16Anyos.setyear(factualMenos16Anyos.getyear() - 18);
            } catch (Exception e) {
                e.printStackTrace();
            }            
            if (fecha.comparedate(factualMenos16Anyos) > 0) {
                correct= false;			
            } else {
                correct= true;                
            }                    
            return correct;
        }
        
        public static boolean give_date_start(Calendar birthdate, Calendar datestart) {
            boolean correct= false;
            Class_date fbirthday = new Class_date(birthdate);
            Class_date fstart = new Class_date(datestart);
            Class_date factualMenos16Anyos = null;

            try {            
            factualMenos16Anyos = new Class_date(fbirthday.getday(), fbirthday.getmonth(), fbirthday.getyear() + 18);
            } catch (Exception e) {
                e.printStackTrace();
            }            
            if ((fstart.comparedate(factualMenos16Anyos) < 0) || (fstart.comparedate(Class_date.Factual()) > 0)) {
                correct= false;                
            } else {
                correct= true;               
            }            
            return correct;
        }
        
        
         public static boolean givemobile() {
        boolean correct = false;
       
        if (client_jframe_create.eti_mobile_create.getText().equals("")){            
            correct = false;            
        } else {
            if (Validate.validate_mobile(client_jframe_create.eti_mobile_create.getText()) == false) {                
                correct = false;                
            } else {               
                correct = true;
            }
        }
        return correct;
    }
         
         public static boolean givemail() {
        boolean correct = false;
       
        if (client_jframe_create.eti_email_create.getText().equals("")) {            
            correct = false;            
        } else {
            if (Validate.validate_mail(client_jframe_create.eti_email_create.getText()) == false) {                
                correct = false;                
            } else {                
                correct = true;
            }
        }
        return correct;
    }
        
        public static boolean giveuser() {
        boolean correct = false;
       
        if (client_jframe_create.eti_user_create.getText().equals("")) {
            
            correct = false;
           
        } else {
            if (Validate.validate_user(client_jframe_create.eti_user_create.getText()) == false) {
               
                correct = false;
               
            } else {
               
                correct = true;
            }
        }
        return correct;
    }
                   
        public static boolean givepassword() {
        boolean correct = false;
        
        if (client_jframe_create.eti_pass_create.getText().equals("")) {            
            correct = false;         
        } else {
            if (Validate.validate_password(client_jframe_create.eti_pass_create.getText()) == false) {                
                correct = false;                
            } else {                
                correct = true;
            }
        }
        return correct;
    }
     
       public static boolean givebuy() {
        float buy=0.0f;
        boolean correct = false;
        
        try {
            buy= Float.parseFloat(client_jframe_create.eti_buy_create.getText());            
            correct = true;
        }   catch (Exception e) {           
            correct = false;
        }
        return correct;
       }
       
       public static boolean givetypeclient() {
        boolean correct = false;
        
        if (client_jframe_create.eti_tipeclient_create.getText().equals("")) {            
            correct = false;           
        } else {
            if (Validate.validate_typeofclient(client_jframe_create.eti_tipeclient_create.getText()) == false) {                
                correct = false;                
            } else {               
                correct = true;
            }
        }
        return correct;
    }
       
       public static String dialogoSelectorImagen() {
        String img = "";

        String extensiones[] = {"jpg", "png", "gif"};
        int valor;

        Files_class filtro = new Files_class(extensiones, "Imagenes jpg, gif, png");

        JFileChooser selector = new JFileChooser();
        selector.setFileFilter(filtro);
        selector.setAcceptAllFileFilterUsed(false);

        valor = selector.showOpenDialog(null);

        if (valor == JFileChooser.APPROVE_OPTION) {
            img = selector.getSelectedFile().getPath();
            eti_avatar_create.setText(selector.getSelectedFile().getPath());
        }

        return img;
    }
       
       public static void giveavatar(String img){
           ImageIcon temporal=new ImageIcon(img);
           ImageIcon imagen=new ImageIcon(temporal.getImage().getScaledInstance(160, -1, Image.SCALE_DEFAULT));
            client_jframe_create.lab_avatar.setIcon(imagen);
       }
       
       public static boolean givedni_update() {
        boolean correct = false;
        
        if (client_jframe_update.eti_dni_update.getText().equals("")) {            
            correct = false;            
        } else {
            if (Validate.validate_dni(client_jframe_update.eti_dni_update.getText()) == false) {               
                correct = false;                
            } else {                
                correct = true;
            }
        }
        return correct;
    }
        
        public static boolean givename_update() {
        boolean correct = false;
        
        if (client_jframe_update.eti_name_update.getText().equals("")) {            
            correct = false;            
        } else {
            if (Validate.validate_name(client_jframe_update.eti_name_update.getText()) == false) {                
                correct = false;               
            } else {                
                correct = true;
            }
        }
        return correct;
    }
        
        public static boolean givesurname_update() {
        boolean correct = false;
        
        if (client_jframe_update.eti_surname_update.getText().equals("")) {            
            correct = false;           
        } else {
            if (Validate.validate_surname(client_jframe_update.eti_surname_update.getText()) == false) {                
                correct = false;                
            } else {               
                correct = true;
            }
        }
        return correct;
    }
        
        public static boolean Validatedatebirthday_update(Calendar birthdate) {
            boolean check = false;
            
            Class_date fecha = new Class_date(birthdate);
            Class_date factualMenos16Anyos = Class_date.Factual();            
            try {
            factualMenos16Anyos.setyear(factualMenos16Anyos.getyear() - 18);
            } catch (Exception e) {
                e.printStackTrace();
            }            
            if (fecha.comparedate(factualMenos16Anyos) > 0) {
                check = false;			
            } else {
                check = true;                
            }                    
            return check;
        }
        
        public static boolean Validatedatestart_update(Calendar birthdate, Calendar datestart) {
            boolean check = false;
            Class_date fbirthday = new Class_date(birthdate);
            Class_date fstart = new Class_date(datestart);
            Class_date factualMenos16Anyos = null;

            try {            
            factualMenos16Anyos = new Class_date(fbirthday.getday(), fbirthday.getmonth(), fbirthday.getyear() + 18);
            } catch (Exception e) {
                e.printStackTrace();
            }            
            if ((fstart.comparedate(factualMenos16Anyos) < 0) || (fstart.comparedate(Class_date.Factual()) > 0)) {
                check = false;                
            } else {
                check = true;                
            }            
            return check;
        }
                
        public static boolean givemobile_update() {
            boolean correct = false;
       
            if (client_jframe_update.eti_mobile_update.getText().equals("")){            
                correct = false;            
            } else {
                if (Validate.validate_mobile(client_jframe_update.eti_mobile_update.getText()) == false) {                
                    correct = false;                
                } else {               
                    correct = true;
                }
            }
            return correct;
        }
         
         public static boolean givemail_update() {
        boolean correct = false;
       
        if (client_jframe_update.eti_email_update.getText().equals("")) {
            
            correct = false;
            
        } else {
            if (Validate.validate_mail(client_jframe_update.eti_email_update.getText()) == false) {
                
                correct = false;
                
            } else {
                
                correct = true;
            }
        }
        return correct;
    }
        
        public static boolean giveuser_update() {
        boolean correct = false;
       
        if (client_jframe_update.eti_user_update.getText().equals("")) {
            
            correct = false;
           
        } else {
            if (Validate.validate_user(client_jframe_update.eti_user_update.getText()) == false) {
               
                correct = false;
               
            } else {
               
                correct = true;
            }
        }
        return correct;
    }
                   
        public static boolean givepassword_update() {
        boolean correct = false;
        
        if (client_jframe_update.eti_pass_update.getText().equals("")) {
            
            correct = false;
         
        } else {
            if (Validate.validate_password(client_jframe_update.eti_pass_update.getText()) == false) {
                
                correct = false;
                
            } else {
                
                correct = true;
            }
        }
        return correct;
    }
      
       public static boolean givebuy_update() {
        float buy=0.0f;
        boolean correct = false;
        
        try {
            buy= Float.parseFloat(client_jframe_update.eti_buy_update.getText());
            
            correct = true;
        }   catch (Exception e) {
           
            correct = false;
        }
        return correct;
       }
       
       public static boolean givetypeclient_update() {
        boolean correct = false;
        
        if (client_jframe_update.eti_tipeclient_update.getText().equals("")) {
            
            correct = false;
           
        } else {
            if (Validate.validate_typeofclient(client_jframe_update.eti_tipeclient_update.getText()) == false) {
                
                correct = false;
                
            } else {
               
                correct = true;
            }
        }
        return correct;
    }
       
       
       public static String dialogoSelectorImagen_update() {
        String img = "";

        String extensiones[] = {"jpg", "png", "gif"};
        int valor;

        Files_class filtro = new Files_class(extensiones, "Imagenes jpg, gif, png");

        JFileChooser selector = new JFileChooser();
        selector.setFileFilter(filtro);
        selector.setAcceptAllFileFilterUsed(false);

        valor = selector.showOpenDialog(null);

        if (valor == JFileChooser.APPROVE_OPTION) {
            img = selector.getSelectedFile().getPath();
            eti_avatar_create.setText(selector.getSelectedFile().getPath());
        }

        return img;
    }
       
       public static void giveavatar_update(String img){
           ImageIcon temporal=new ImageIcon(img);
           ImageIcon imagen=new ImageIcon(temporal.getImage().getScaledInstance(160, -1, Image.SCALE_DEFAULT));
            client_jframe_update.lab_avatar.setIcon(imagen);
       }   

        public static boolean state_update(){
            boolean correct=false;
            
            if(client_jframe_update.eti_state_co_update.isSelected())
                correct=true;
            if(client_jframe_update.eti_state_di_update.isSelected())
                correct=false;            
            return correct;
        }   

        public static boolean premium_update(){
            boolean correct=false;
            
            if(client_jframe_update.eti_premi_true_update.isSelected())
                correct=true;
            if(client_jframe_update.eti_premi_false_update.isSelected())
                correct=false;            
            return correct;
        }
}