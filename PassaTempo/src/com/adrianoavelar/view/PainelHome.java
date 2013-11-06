package com.adrianoavelar.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.adrianoavelar.util.Resource;

public class PainelHome extends JPanel {

	private static final long serialVersionUID = -1045421666221440186L;
	
	private Icon backgroundIcon;
	private Icon icone;
	
	public Icon getIcone() {
		return icone;
	}
	
	
	
	/**
	 * @param 
	 * 		imagePath - Caminho da imagem que ficará 
	 * como background no JPanel.
	 */
	public PainelHome(String imagePath ) {
		backgroundIcon = new ImageIcon(imagePath );
		icone = new ImageIcon(Resource.getImageResourcePath()+"ic_tab_home.png");
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		backgroundIcon.paintIcon(this, g, 0, 0);
	}
	
	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(backgroundIcon.getIconWidth(), backgroundIcon.getIconHeight());
	}

}
