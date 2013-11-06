package com.adrianoavelar.util;

import javax.swing.JOptionPane;

public class UtilGUI {

	public UtilGUI() {
		// TODO Auto-generated constructor stub
	}
	
	public final static void successMessage(String message){
		JOptionPane.showMessageDialog(null, message,"Sucesso",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public final static void errorMessage(String message){
		JOptionPane.showMessageDialog(null, message,"Erro",JOptionPane.ERROR_MESSAGE);

	}

}
