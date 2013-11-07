package com.adrianoavelar.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import com.adrianoavelar.controller.CAluguel;
import com.adrianoavelar.controller.CCadastroCliente;
import com.adrianoavelar.controller.CCadastroFilmes;
import com.adrianoavelar.controller.CHistorico;
import com.adrianoavelar.util.Resource;
import com.adrianoavelar.util.Util;

/**
 * Mais sobre ToolBar {@link http://zetcode.com/tutorials/javaswingtutorial/menusandtoolbars/} 
 * @author Adriano Avelar
 * 
 */
@SuppressWarnings("serial")
public final class MainGUI extends JFrame {

	/*
	 * ib (Image Button)
	 */
	private static final String path = Resource.getImageResourcePath();
	
	private static final String ib_cadastrar_usuario = path+"ib_cadastrar_usuario.png";
	private static final String ib_cadastrar_filmes = path+"ib_cadastrar_filmes.png";
	private static final String ib_consultar_historico = path+"ib_consultar_historico.png";
	private static final String ib_consultar_videos = path+"ib_consultar_videos.png";
	private static final String ib_consultar_usuarios = path+"ib_consultar_usuarios.png";
	private static final String ib_sair = path+"ib_sair.png";
	private static final String ib_alugar_filme = path+"ib_alugar_filme.png";

	// Componentes Globais

	private JButton jbCadastrarUsuario;
	private JButton jbCadastrarVideos;

	private JButton jbConsultarUsuarios;
	private JButton jbConsultarVideos;
	private JButton jbConsultarHistorico;
	private JButton jbAlugarFilme;
	private JButton jbSair;
	
	private JMenuItem jmiSobre;
	
	private PainelClientes painelConsultaClientes = null;
	private PainelFilmes painelConsultaFilmes = null;
	private PainelHistorico painelHistorico = null;
	private PainelAluguel painelAluguel = null;
	
	public MainGUI() {
		super("Locadora PassaTempo");
		init();
		initUI();
	}
	
	public void init(){
		//Instanciando painal de consulta de clientes
		painelConsultaClientes = new PainelClientes();
		painelConsultaClientes.setController(new CCadastroCliente());
		
		//Instanciando painel de consulta de filmes
		painelConsultaFilmes = new PainelFilmes();
		painelConsultaFilmes.setController(new CCadastroFilmes());
		
		//Instanciando painel de consulta do historico
		painelHistorico = new PainelHistorico();
		painelHistorico.setController(new CHistorico());
		
		//Instanciando painel de Locação de Filmes
		painelAluguel = new PainelAluguel();
		painelAluguel.setController(new CAluguel());
	}
	
	public void initUI() {
		
		Handler handler = new Handler();
		Container container = getContentPane();
		
		container.setLayout(new BorderLayout());
		//Barra de Menus
		JMenuBar menubar = new JMenuBar();
		//Menu AJUDA
        JMenu ajuda = new JMenu("Ajuda");
        menubar.add(ajuda);
        setJMenuBar(menubar);
        
        jmiSobre = new JMenuItem("Sobre PassaTempo");
        jmiSobre.addActionListener(handler);
        ajuda.add(jmiSobre);
     
		//Criando e configurando os butões da barra de ferramentas
		ImageIcon icon = new ImageIcon(ib_cadastrar_usuario);
		jbCadastrarUsuario = new JButton("Cadastrar Usuário", icon);
		jbCadastrarUsuario.setHorizontalTextPosition(SwingUtilities.CENTER);
		jbCadastrarUsuario.setVerticalTextPosition(SwingUtilities.BOTTOM);
		jbCadastrarUsuario.addActionListener(handler);

		icon = new ImageIcon(ib_cadastrar_filmes);
		jbCadastrarVideos = new JButton("Cadastrar Filmes", icon);
		jbCadastrarVideos.setHorizontalTextPosition(SwingUtilities.CENTER);
		jbCadastrarVideos.setVerticalTextPosition(SwingUtilities.BOTTOM);
		jbCadastrarVideos.addActionListener(handler);
		
		icon = new ImageIcon(ib_consultar_usuarios);
		jbConsultarUsuarios = new JButton("Consultar Usuários", icon);
		jbConsultarUsuarios.setHorizontalTextPosition(SwingUtilities.CENTER);
		jbConsultarUsuarios.setVerticalTextPosition(SwingUtilities.BOTTOM);
		jbConsultarUsuarios.addActionListener(handler);
		
		icon = new ImageIcon(ib_consultar_videos);
		jbConsultarVideos = new JButton("Consultar Videos", icon);
		jbConsultarVideos.setHorizontalTextPosition(SwingUtilities.CENTER);
		jbConsultarVideos.setVerticalTextPosition(SwingUtilities.BOTTOM);
		jbConsultarVideos.addActionListener(handler);
		
		icon = new ImageIcon(ib_consultar_historico);
		jbConsultarHistorico = new JButton("Consultar Histórico", icon);
		jbConsultarHistorico.setHorizontalTextPosition(SwingUtilities.CENTER);
		jbConsultarHistorico.setVerticalTextPosition(SwingUtilities.BOTTOM);
		jbConsultarHistorico.addActionListener(handler);
		
		icon = new ImageIcon(ib_alugar_filme);
		jbAlugarFilme = new JButton("   Alugar Filme   ", icon);
		jbAlugarFilme.setHorizontalTextPosition(SwingUtilities.CENTER);
		jbAlugarFilme.setVerticalTextPosition(SwingUtilities.BOTTOM);
		jbAlugarFilme.addActionListener(handler);
		
		
		icon = new ImageIcon(ib_sair);
		jbSair = new JButton("Sair", icon);
		jbSair.setHorizontalTextPosition(SwingUtilities.CENTER);
		jbSair.setVerticalTextPosition(SwingUtilities.BOTTOM);
		jbSair.addActionListener(handler);
		

		//Adicionando os butões à barra de ferramenta.
		JToolBar toolbar = new JToolBar();
		toolbar.setFloatable(false);
		toolbar.add(jbCadastrarUsuario);
		toolbar.add(jbCadastrarVideos);
		toolbar.addSeparator();
		toolbar.add(jbConsultarUsuarios);
		toolbar.add(jbConsultarVideos);
		toolbar.add(jbConsultarHistorico);
		toolbar.addSeparator();
		toolbar.add(jbAlugarFilme);
		toolbar.addSeparator(new Dimension(180, 0));
		toolbar.add(jbSair);

		//Adcionando a barra de ferramenta ao painel de conteudo.
		container.add(toolbar, BorderLayout.NORTH);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		PainelHome painelHome = new PainelHome(Resource.getImageResourcePath()+"main_background.png");
		tabbedPane.addTab("Home", painelHome.getIcone(), painelHome);
		tabbedPane.addTab("Consultar Clientes",painelConsultaClientes.getIcone(),painelConsultaClientes);
		tabbedPane.addTab("Consultar Filmes",painelConsultaFilmes.getIcone(),painelConsultaFilmes);
		tabbedPane.addTab("Historico",painelHistorico.getIcone(),painelHistorico);
		tabbedPane.addTab("Aluguel de Filmes",painelAluguel.getIcone(),painelAluguel);
		
		container.add(tabbedPane, BorderLayout.CENTER);
		
		//Configurando a Janela
		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	/**
	 * Classe Interna responsável por tratar os eventos dos botões.
	 *
	 */
	private class Handler implements ActionListener{
		
		private CadastroDeClientes cadastro_cliente = null;
		private CadastroDeFilmes cadastro_filmes = null;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			if(e.getSource() == jbCadastrarUsuario){
				
				if(cadastro_cliente == null){
					cadastro_cliente = new CadastroDeClientes();
					cadastro_cliente.setContoller(new CCadastroCliente());
					cadastro_cliente.setModal(true);
					cadastro_cliente.preencherCampos();
					cadastro_cliente.setVisible(true);
					cadastro_cliente = null;
				}
				
			}else if(e.getSource() == jbCadastrarVideos){
				
				if(cadastro_filmes == null){
					cadastro_filmes = new CadastroDeFilmes();
					cadastro_filmes.setContoller(new CCadastroFilmes());
					cadastro_filmes.setModal(true);
					cadastro_filmes.preencherCampos();
					cadastro_filmes.setVisible(true);
					cadastro_filmes = null;
				}
				
			}else if(e.getSource() == jbConsultarUsuarios){
			
					
					JFrame painelUsuario = new JFrame();
					PainelClientes janelaExternaCliente = new PainelClientes();
					janelaExternaCliente.setController(new CCadastroCliente());
					painelUsuario.add(janelaExternaCliente);
					painelUsuario.setSize(800, 600);
					painelUsuario.setVisible(true);
					painelUsuario.setLocationRelativeTo(null);
					painelUsuario.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					
//					consulta_clientes.setController(new CCadastroCliente());
//					consulta_clientes.setVisible(true);
//					consulta_clientes = null;
				
			}else if(e.getSource() == jbConsultarVideos){
				
				JFrame painelFilme = new JFrame();
				PainelFilmes janelaExternaCliente = new PainelFilmes();
				janelaExternaCliente.setController(new CCadastroFilmes());
				painelFilme.add(janelaExternaCliente);
				painelFilme.setSize(800, 600);
				painelFilme.setVisible(true);
				painelFilme.setLocationRelativeTo(null);
				painelFilme.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
			}else if(e.getSource() == jbConsultarHistorico){
				
				JFrame painelHistorico = new JFrame();
				PainelHistorico janelaExternaCliente = new PainelHistorico();
				janelaExternaCliente.setController(new CHistorico());
				painelHistorico.add(janelaExternaCliente);
				painelHistorico.setSize(800, 600);
				painelHistorico.setVisible(true);
				painelHistorico.setLocationRelativeTo(null);
				painelHistorico.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
			}else if(e.getSource() == jbAlugarFilme){
				
				JFrame painelAlugar = new JFrame();
				PainelAluguel janelaExternaCliente = new PainelAluguel();
				janelaExternaCliente.setController(new CAluguel());
				painelAlugar.add(janelaExternaCliente);
				painelAlugar.setSize(800, 500);
				painelAlugar.setVisible(true);
				painelAlugar.setLocationRelativeTo(null);
				painelAlugar.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
			}else if(e.getSource() == jbSair){
				System.exit(0);
			}else if(e.getSource() == jmiSobre){
				
				String about = "Sistema " +Util.getPropriedade("system_name")+"\n"
						+ Util.createStringPattern(20)
						+ "\nEste Sistema foi desenvolvido \n"
						+ "para estudo dos alunos da Faculdade Nova Roma.\n"
						+ "É um sistema bem simples de aluguel de filmes que\n"
						+ "possui a funcionalidade de cadastro de usuário,\n"
						+ "cadastro de filmes e aluguel de filmes por um\n "
						+ "usuário cadastrado no sistema.\n"
						+ Util.createStringPattern(20)
						+ "\n@author: "+ Util.getPropriedade("author")
						+ "\n@versão"+ Util.getPropriedade("vertion")
						+ "\n@site: "+ Util.getPropriedade("contact");
				
				JTextArea output = new JTextArea();
				output.setEditable(false);
				output.setEnabled(false);
				output.setText(about);
				JOptionPane.showMessageDialog(null, output,"Locadora Passa Tempo",JOptionPane.INFORMATION_MESSAGE);
				
			}
	
		}
		
	}

}
