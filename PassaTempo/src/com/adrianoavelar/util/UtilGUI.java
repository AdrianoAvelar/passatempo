package com.adrianoavelar.util;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class UtilGUI {

	
	private static Icon successIcon = new ImageIcon(Resource.getImageResourcePath()+"ic_msg_success.png");
	private static Icon errorIcon = new ImageIcon(Resource.getImageResourcePath()+"ic_msg_error.png");
	
	public UtilGUI() {
		// TODO Auto-generated constructor stub
	}
	
	public final static void successMessage(String message){
		JOptionPane.showMessageDialog(null, message,"Sucesso",0,successIcon);
	}
	
	public final static void errorMessage(String message){
		
		JOptionPane.showMessageDialog(null, message,"Erro",0,errorIcon);

	}

}
