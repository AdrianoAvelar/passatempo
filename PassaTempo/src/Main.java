
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.Logger;

import com.adrianoavelar.util.Util;
import com.adrianoavelar.view.MainGUI;

public class Main {
	private static Logger LOG = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		
		String msg = "Inicializando o sistema "+Util.getPropriedade("system_name")+
				" v "+Util.getPropriedade("version")+
				"\n@autor: "+Util.getPropriedade("author")+"\n"
				+"@Contato: "+Util.getPropriedade("contact");
		
		
		LOG.info(msg );
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			LOG.error(e.getMessage());
		}
		
//		SplashJProgressBar sp = new SplashJProgressBar();
//		sp.start(4);
		
		SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	        		
	            	MainGUI gui = new MainGUI();
	            	gui.setVisible(true);
	            }
	        });
		 
		 try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				LOG.error(e.getMessage());
			}
	}

}
