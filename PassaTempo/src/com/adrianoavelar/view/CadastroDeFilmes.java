package com.adrianoavelar.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.adrianoavelar.controller.CCadastroFilmes;
import com.adrianoavelar.model.Filme;
import com.adrianoavelar.util.ClassificacaoIndicativa;
import com.adrianoavelar.util.Generos;
import com.adrianoavelar.util.OpenFileFilter;
import com.adrianoavelar.util.Resource;
import com.adrianoavelar.util.Util;
import com.adrianoavelar.util.UtilGUI;

public class CadastroDeFilmes extends JDialog {
	
	private static Logger LOG = Logger.getLogger(CadastroDeFilmes.class);
	private JTextField tfTituloOriginal;
	private JTextField tfTituloTraduzido;
	private JFormattedTextField tfDuracao;
	private JFormattedTextField tfAnoLancamento;
	private ManipuladorEventos meventos;
	private JLabel lblCImagem;
	private JComboBox cbClassificacaoIndicativa;
	private JCheckBox chckbxTituloTrad;
	private JButton btnSalvar;
	private JButton btnCancelar; 
	private CCadastroFilmes controller;
	private JTextField tfFilmeImagem;
	private JComboBox cbIdioma;
	private JComboBox cbGenero;
	
	public CadastroDeFilmes() {
		
		setTitle("Cadastro de Filme");
		meventos = new ManipuladorEventos();
		setResizable(false); 
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(527,300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblCadastrarFilmes = new JLabel("Cadastrar Filmes");
		lblCadastrarFilmes.setIcon(new ImageIcon(Resource.getImageResourcePath()+"ib_cadastrar_filmes.png"));
		getContentPane().add(lblCadastrarFilmes, BorderLayout.NORTH);
		
		JPanel painelCentro = new JPanel();
		painelCentro.setBorder(BorderFactory.createTitledBorder("Dados do Filme"));
		getContentPane().add(painelCentro, BorderLayout.CENTER);
		painelCentro.setLayout(null);
		
		JLabel lblNome = new JLabel("T\u00EDtulo Original:");
		lblNome.setBounds(10, 23, 103, 14);
		painelCentro.add(lblNome);
		
		JLabel lblDurao = new JLabel("Dura\u00E7\u00E3o:");
		lblDurao.setBounds(11, 83, 59, 14);
		painelCentro.add(lblDurao);
		
		JLabel lblAnoDeLanamento = new JLabel("Ano de Lan\u00E7amento:");
		lblAnoDeLanamento.setBounds(157, 83, 120, 14);
		painelCentro.add(lblAnoDeLanamento);
		
		tfTituloOriginal = new JTextField();
		tfTituloOriginal.setBounds(96, 17, 405, 20);
		painelCentro.add(tfTituloOriginal);
		tfTituloOriginal.setColumns(10);
		
		tfTituloTraduzido = new JTextField();
		tfTituloTraduzido.setEditable(false);
		tfTituloTraduzido.setColumns(10);
		tfTituloTraduzido.setBounds(128, 47, 373, 20);
		painelCentro.add(tfTituloTraduzido);
		
		tfDuracao = new JFormattedTextField(Util.get3NumMask());
		tfDuracao.setBounds(67, 77, 46, 20);
		painelCentro.add(tfDuracao);
		tfDuracao.setColumns(10);
		
		JLabel lblMin = new JLabel("min");
		lblMin.setBounds(120, 83, 27, 14);
		painelCentro.add(lblMin);
		
		tfAnoLancamento = new JFormattedTextField(Util.get4NumMask());
		tfAnoLancamento.setColumns(10);
		tfAnoLancamento.setBounds(275, 77, 59, 20);
		painelCentro.add(tfAnoLancamento);
		
		chckbxTituloTrad = new JCheckBox("T\u00EDtulo Traduzido:");
		chckbxTituloTrad.addItemListener(meventos);
		chckbxTituloTrad.setSelected(false);
		chckbxTituloTrad.setBounds(6, 44, 120, 23);
		painelCentro.add(chckbxTituloTrad);
		
		cbGenero = new JComboBox(Generos.names());
		cbGenero.setBounds(66, 112, 157, 20);
		painelCentro.add(cbGenero);
		
		JLabel lblGnero = new JLabel("G\u00EAnero:");
		lblGnero.setBounds(10, 118, 59, 14);
		painelCentro.add(lblGnero);
		
		JLabel lblIdioma = new JLabel("Idioma:");
		lblIdioma.setBounds(344, 83, 60, 14);
		painelCentro.add(lblIdioma);
		
		String idiomas[] = {"Português","Inglês"};
		cbIdioma = new JComboBox(idiomas);
		cbIdioma.setBounds(395, 77, 106, 20);
		painelCentro.add(cbIdioma);
		
		JLabel lblD = new JLabel("Classifica\u00E7\u00E3o:");
		lblD.setBounds(244, 118, 142, 14);
		painelCentro.add(lblD);
		
//		String ci[] = {"L","10","12","14","16","18"};
//		Icon ci_img[] = {new ImageIcon(ci[0]), new ImageIcon(ci[1]),
//				new ImageIcon(ci[2]),new ImageIcon(ci[3]),new ImageIcon(ci[4]),
//				new ImageIcon(ci[5])};
		
		cbClassificacaoIndicativa = new JComboBox(ClassificacaoIndicativa.names());
		cbClassificacaoIndicativa.addItemListener(meventos);
		
		cbClassificacaoIndicativa.setBounds(339, 115, 93, 20);
		painelCentro.add(cbClassificacaoIndicativa);
		
		lblCImagem = new JLabel("");
		ClassificacaoIndicativa ci = ClassificacaoIndicativa.valueOf(cbClassificacaoIndicativa.getSelectedItem().toString()); 
		lblCImagem.setIcon(ci.getImage());
		
		lblCImagem.setBounds(442, 112, 59, 56);
		painelCentro.add(lblCImagem);
		
		JLabel lblImage = new JLabel("Image:");
		lblImage.setBounds(10, 151, 46, 14);
		painelCentro.add(lblImage);
		
		tfFilmeImagem = new JTextField();
		tfFilmeImagem.addMouseListener(meventos);
		tfFilmeImagem.setText("<Selecione uma Imagem>");
		tfFilmeImagem.setEditable(false);
		tfFilmeImagem.setColumns(10);
		tfFilmeImagem.setBounds(64, 145, 368, 20);
		painelCentro.add(tfFilmeImagem);
		
		JPanel painelInferior = new JPanel();
		getContentPane().add(painelInferior, BorderLayout.SOUTH);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(meventos);
		painelInferior.add(btnSalvar);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		painelInferior.add(horizontalStrut);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(meventos);
		painelInferior.add(btnCancelar);
		// TODO Auto-generated constructor stub
	}

	private class ManipuladorEventos extends MouseAdapter implements ItemListener, ActionListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			
			if(e.getSource() == cbClassificacaoIndicativa){
				if(e.getStateChange() == ItemEvent.SELECTED){
					ClassificacaoIndicativa ci = ClassificacaoIndicativa.valueOf(cbClassificacaoIndicativa.getSelectedItem().toString()); 
					lblCImagem.setIcon(ci.getImage());
					LOG.debug("Classificação Indicativa | Item Selecionado: "+ci);
				}
			}else if(e.getSource() == chckbxTituloTrad){
				if(!chckbxTituloTrad.isSelected()){
					tfTituloTraduzido.setEditable(false);
					tfTituloTraduzido.setText("");
				}else{
					tfTituloTraduzido.setEditable(true);
				}
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			
			if(e.getSource() == btnSalvar){
				
				Filme filme = new Filme();
				filme.setTituloOriginal(tfTituloOriginal.getText());
				filme.setTituloTraduzido(tfTituloTraduzido.getText());
				filme.setImagemFilme(tfFilmeImagem.getText());
				filme.setIdioma(cbIdioma.getSelectedItem().toString());
				filme.setGenero(Generos.getValueOf(cbGenero.getSelectedItem().toString()));
				filme.setDuracao(Integer.parseInt(tfDuracao.getText()));
				filme.setClassificacao(ClassificacaoIndicativa.valueOf(
						cbClassificacaoIndicativa.getSelectedItem().toString()));
				filme.setAnoDeLancamento(Integer.parseInt(tfAnoLancamento.getText()));
				
				if (controller.cadastrarFilme(filme)) {
					UtilGUI.successMessage("Filme Cadastrado com Sucesso!");
					dispose();
				}
				
			}else if(e.getSource() == btnCancelar){
				dispose();
			}
		}

		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
			if(e.getSource() == tfFilmeImagem){
				
				File fileimg;
				JFileChooser chooser = new JFileChooser(new File(System.getProperty("user.dir")));
				//Seleciona a extensão PNG como padrão.
				chooser.setFileFilter(new OpenFileFilter(".png","Imagens em PNG") );
				//Adciona outras possibildiade de extenção.
				chooser.addChoosableFileFilter(new OpenFileFilter(".jpeg","Imagens em JPEG") );
				chooser.addChoosableFileFilter(new OpenFileFilter(".jpg","Imagens em JPEG") );
				
				int returnVal = chooser.showSaveDialog(CadastroDeFilmes.this);
				
				if (returnVal == JFileChooser.APPROVE_OPTION) {
				     fileimg = chooser.getSelectedFile();
				     String filename = fileimg.getPath();
				     
				   	LOG.debug("File Choosed: "+ filename);
				   	
				   	int dialogResult ;
				   	
				   	dialogResult = JOptionPane.showConfirmDialog(null,
				   			Util.getFileName(filename) ,"Capa do Filme",0,0, new ImageIcon(filename));
				   	
				   	//Usa a imagem selecionada apenas se houver confirmação SIM(YES)
				   	if(dialogResult == JOptionPane.YES_OPTION){
				   		LOG.debug("File Choosed: "+ filename);
				   		tfFilmeImagem.setText(filename);
				   	}
				}
				
			}
		}


	}

	public void setContoller( CCadastroFilmes controller) {
		this.controller = controller;
	}

	@Deprecated
	public void preencherCampos() {
		
		 tfTituloOriginal.setText("A Ocasião faz o ladrão!");
		 tfTituloTraduzido.setEditable(true);
		 tfTituloTraduzido.setText("The opportunitie makes the thief");;
		 
		 tfDuracao.setText("180");
		 tfAnoLancamento.setText("1986");
		 tfFilmeImagem.setText("C:\\Users\\Adriano\\git\\PassaTempo\\PassaTempo\\res\\FilmesImagens\\a_ocasiao_faz_o_ladrao.png");
		
	}
	

	
	
	/**
	 * Este método é usado apenas para testar a janela de cadastro de filmes
	 * sem a necessidade de rodar a aplicação inteira.
	 * @TODO Remover este método na versão final.
	 */
	public static void main(String[] args) {
		
		CadastroDeFilmes cadastrarFilmes = new CadastroDeFilmes();
		cadastrarFilmes.setContoller(new CCadastroFilmes());
		cadastrarFilmes.preencherCampos();
		cadastrarFilmes.setVisible(true);
	}
}
