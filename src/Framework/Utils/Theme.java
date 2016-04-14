package Framework.Utils;

import Framework.Modules.Menu.Model.Clases.Class_config;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class Theme {
	public static void select_theme(String theme) {
		try {
            switch (theme) {
                case "Metal":
                	UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                    break;

                case "Windows":
                	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;

                case "Motif":
                	UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    break;

                case "Nimbus":
                	UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    break;

            }
                } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "No pudo cargarse la apariencia deseada\n" + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        }
}