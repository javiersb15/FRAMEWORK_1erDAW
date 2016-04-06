package Framework.Utils;

import javax.swing.JOptionPane;

public class Menus {

/**MENU OPTIONS BUTTON*/
	/**GENERAL MENU*/
	public static int menubutton(String []operations, String message, String title){
		int position=0;
		
		position=JOptionPane.showOptionDialog(null, message, title, 0, JOptionPane.QUESTION_MESSAGE, null, operations, operations[0]);
		return position;
	}
	/**SUBMENU*/
	public static int continuar(String s){
		int position=0;
		String[] tipo= { s, "Continue", "Finish" };
		
		position=JOptionPane.showOptionDialog(null,"What do you want?", "Choosing",0, JOptionPane.QUESTION_MESSAGE,null,tipo,tipo[0]);
		switch(position){
			case 0:		/**Continue*/
				position = 0;
				break;
			case 1:		/**Menu*/
				position = 1;
				break;
			case 2:		/**Finish or exit*/
				JOptionPane.showMessageDialog(null, "Bye");
				System.exit(0);
				break;
			default:	/**Close window*/
				JOptionPane.showMessageDialog(null, "Bye");
				System.exit(0);
				break;
		}
		return position;
	}
	
/**MENU OPTIONS COMBOBOX*/
	public static String menucombobox(String[]operations, String message, String title) {
	Object selection=null;
	
	selection=JOptionPane.showInputDialog(null,message, title, JOptionPane.QUESTION_MESSAGE,null,operations,operations[0]);
				
	return selection.toString();
}
}