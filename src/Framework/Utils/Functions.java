package Framework.Utils;

import javax.swing.JOptionPane;

public class Functions {

	/**GIVENUMBER*/
		public static int givenumber(String missage, String title){
			int num1=0;
			String s1=" ";
			boolean correct=true;
			
			do{
				try{
					s1=JOptionPane.showInputDialog(null,missage,title,JOptionPane.QUESTION_MESSAGE);
					if(s1==null){
					}else{
							num1=Integer.parseInt(s1);
							correct=true;
					}
				}catch(Exception e){
					JOptionPane.showMessageDialog(null,"You don't enter any number","Error",JOptionPane.ERROR_MESSAGE);
					correct=false;
				}
			}while(correct==false);
						
			return num1;
		}
	
	/**GIVEDISTINCT 0*/
		public static int givedistinct0(String missage, String title){
			int num1=0;
			String s1=" ";
			boolean correct=false;
			
			do{
				try{
					s1=JOptionPane.showInputDialog(null,missage,title,JOptionPane.QUESTION_MESSAGE);
					num1=Integer.parseInt(s1);
					if (num1==0){
						JOptionPane.showMessageDialog(null, "You can't divided by zero");
					}else{
						correct=true;
					}
				}catch(Exception e){
					JOptionPane.showMessageDialog(null,"You don't enter any number","Error",JOptionPane.ERROR_MESSAGE);
					correct=false;
				}
			}while(correct==false);
			
			return num1;
		}
	
	/**GIVECHARACTER*/
		public static char givecharacter(String missage, String title){
			char c= ' ';
			String s=" ";
			boolean correct=true;

			do{
				try{
					s=JOptionPane.showInputDialog(null, missage,title,JOptionPane.QUESTION_MESSAGE);
					if(s==null){
						//JOptionPane.showMessageDialog(null, "Saliendo de la aplicacion","Saliendo",JOptionPane.INFORMATION_MESSAGE);
						//System.exit(0);
					}else {
						c=s.charAt(0);
						c= Character.toUpperCase(c);
						correct=true;
					}
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "You don't enter any letter", "Error",JOptionPane.ERROR_MESSAGE);
					correct=false;
				}
			}while(correct==false);
					
			return c;
		}
	
	/**GIVESTRING*/
		public static String givestring(String missage, String title){
			String s="";
			boolean correct=true;

			do{
				try{
					s=JOptionPane.showInputDialog(null, missage,title,JOptionPane.QUESTION_MESSAGE);
					correct=true;
					if (s==null){
						//JOptionPane.showMessageDialog(null, "Saliendo de la aplicacion","Saliendo",JOptionPane.INFORMATION_MESSAGE);
						//System.exit(0);
					}
					if(s.equals("")){
						JOptionPane.showMessageDialog(null, "You must enter a string","Error",JOptionPane.ERROR_MESSAGE);
						correct=false;
					}
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "You don't enter any string", "Error",JOptionPane.ERROR_MESSAGE);
					correct=false;
				}
			}while(correct==false);
					
			return s;
		}
	
	/**GIVEFLOAT*/
		public static float givefloat(String missage, String title){
			float a=0.0f;
			String s=" ";
			boolean correct=true;

			do{
				try{
					s=JOptionPane.showInputDialog(null, missage,title,JOptionPane.QUESTION_MESSAGE);
					if(s==null){
						//JOptionPane.showMessageDialog(null, "Saliendo de la aplicacion","Saliendo",JOptionPane.INFORMATION_MESSAGE);
						//System.exit(0);
					}else {
						a=Float.parseFloat(s);
						correct=true;
					}
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "You don't enter any float", "Error",JOptionPane.ERROR_MESSAGE);
					correct=false;
				}
			}while(correct==false);	
			
			return a;
		}
	
	/**GIVEBOOLEAN*/
		public static boolean giveboolean(String[]operations, String message, String title){
			int election=0;
			boolean option=false;
			
			election=JOptionPane.showOptionDialog(null,message, title, 0,JOptionPane.QUESTION_MESSAGE,
					null,operations,operations[0]);
			
			if (election==0)
				option=true;
						
			return option	;
		}		
}