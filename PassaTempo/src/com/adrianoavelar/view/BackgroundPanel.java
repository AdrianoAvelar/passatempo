package com.adrianoavelar.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {

	private static final long serialVersionUID = -1045421666221440186L;
	
	private ImageIcon backgroundIcon;
	
	/**
	 * @param 
	 * 		imagePath - Caminho da imagem que ficará 
	 * como background no JPanel.
	 */
	public BackgroundPanel(String imagePath ) {
		backgroundIcon = new ImageIcon(imagePath );
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
