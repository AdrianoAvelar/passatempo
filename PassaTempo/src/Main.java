
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.adrianoavelar.view.MainGUI;

public class Main {

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				e.printStackTrace();
			}
	}

}
