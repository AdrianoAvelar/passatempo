package com.adrianoavelar.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import com.adrianoavelar.util.Resource;

@SuppressWarnings("serial")
public class SplashScreen extends javax.swing.JWindow {
	private JLabel jLabelSplashImage;
	private JLabel jLabelTextoCarregamento;
	private  JLabel jLabelTextoDinamicoPlugins;
	private  JProgressBar jProgressBarSistema;
	private String ssImagePath = Resource.getImageResourcePath()+"splashscreen.png";

	public SplashScreen() {
		criandoComponentes();
		this.setVisible(true);
	}

	private void criandoComponentes() {
		
		Container container = getContentPane();
		
		/**
		 * Inicializando as variavaeis utilizadas
		 */
		jProgressBarSistema = new JProgressBar();
		jLabelSplashImage = new JLabel();
		jLabelTextoCarregamento = new JLabel();
		jLabelTextoDinamicoPlugins = new JLabel();
		/**
		 * Carregando a imagem do Splash e adicionando a imagem ao componente
		 * jLabelSplashImage
		 */
		ImageIcon imageIcon = new ImageIcon(ssImagePath);
		jLabelSplashImage.setIcon(imageIcon);
		/**
		 * Definindo dinamicamente o tamando do container segundo o tamanho da
		 * imagem.
		 */
		this.setMinimumSize(new java.awt.Dimension(imageIcon.getIconWidth(),
				imageIcon.getIconHeight()));
		jLabelSplashImage.setBounds(0, 0, imageIcon.getIconWidth(),
				imageIcon.getIconHeight());
		/**
		 * A definicao do layout=null e importante para possibilitar que os
		 * componentes fiquem sobrescritros em tempo de execucao
		 */
		container.setLayout(null);
		/**
		 * Definindo a localizacao do splash no centro da tela
		 */
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screen.width - this.getSize().width) / 2,
				(screen.height - this.getSize().height) / 2);

		/**
		 * Setando parametros da variavel jProgressBarSistema
		 */
		jProgressBarSistema.setForeground(new Color(204, 0,0 ));
		jProgressBarSistema.setPreferredSize(new java.awt.Dimension(50, 5));
		jProgressBarSistema.setBounds(0, 225, imageIcon.getIconWidth(), 8);
		jProgressBarSistema.setBorderPainted(false);
		jProgressBarSistema.setIndeterminate(true);
		/**
		 * Adicionando o jProgressBarSistema a classe SplashJProgressBar
		 */
		container.add(jProgressBarSistema);

		/**
		 * Setando parametros da variavel jProgressBarSistema
		 */
		jLabelTextoCarregamento.setForeground(new java.awt.Color(0, 0, 125));
		jLabelTextoCarregamento
				.setFont(new java.awt.Font("DialogInput", 0, 11));
		//jLabelTextoCarregamento.setText("Loading ...");
		jLabelTextoCarregamento.setBounds(280, 285, 80, 20);
		/**
		 * Adicionando o jProgressBarSistema a classe SplashJProgressBar
		 */
		container.add(jLabelTextoCarregamento);

		/**
		 * Setando parametros da variavel jProgressBarSistema
		 */
		jLabelTextoDinamicoPlugins.setForeground(new java.awt.Color(255, 255, 255));
		jLabelTextoDinamicoPlugins.setFont(new java.awt.Font("DialogInput", 0,
				11));
		jLabelTextoDinamicoPlugins.setBounds(55, 130, 230, 20);
		/**
		 * Adicionando o jProgressBarSistema a classe SplashJProgressBar
		 */
		container.add(jLabelTextoDinamicoPlugins);

		/**
		 * O Ultimo item adicionado no conteiner deve ser o componente que
		 * comtem a imagem do Splah
		 */
		container.add(jLabelSplashImage);
		this.pack();

	}
	
	public  void setjLabelTextoDinamicoPlugins(String txt) {
		jLabelTextoDinamicoPlugins.setText(txt);
	}
	
	public void start(int i) {

		//for (int j = 1; j < i+1; j++) {
		float parte = (float)100/i;
		int total = 0;
		do{
			total +=parte;
			jLabelTextoDinamicoPlugins.setText("Carregando... " + total +" %");
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {

			}

		}while(total < 100);

		dispose();

	}
	

	//Somente para Teste
	public static void main(String args[]) {

		SplashScreen ssb = new SplashScreen();

		/**
		 * Rotina para exibicao de um texto qualquer no carregamento do seu
		 * sistema
		 */
		int i = 3;
		for (int j = 1; j <= 1000; j++) {

			if (j == (1000 / i)) {

				ssb.setjLabelTextoDinamicoPlugins("Exibicao Texto Qualquer: "
						+ i);
				i--;
				try {
					Thread.sleep(1200);
				} catch (Exception e) {

				}

			}

		}

		System.exit(0);
	}

}
