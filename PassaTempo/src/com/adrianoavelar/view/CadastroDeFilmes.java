package com.adrianoavelar.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.logging.Logger;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.adrianoavelar.controller.CCadastroFilmes;
import com.adrianoavelar.util.ClassificacaoIndicativa;
import com.adrianoavelar.util.Generos;

public class CadastroDeFilmes extends JDialog {
	
	private static Logger LOG = Logger.getLogger(CadastroDeFilmes.class.getName());
	private JTextField tfTituloOriginal;
	private JTextField tfTituloTraduzido;
	private JTextField tfDuracao;
	private JTextField tfAnoLancamento;
	private ManipuladorEventos meventos;
	private JLabel lblCImagem;
	private JComboBox cbClassificacaoIndicativa;
	private JCheckBox chckbxTituloTrad;
	private JButton btnSalvar;
	private JButton btnCancelar; 
	private CCadastroFilmes controller;
	
	public CadastroDeFilmes() {
		
		meventos = new ManipuladorEventos();
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(527,260);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblCadastrarFilmes = new JLabel("Cadastrar Filmes");
		getContentPane().add(lblCadastrarFilmes, BorderLayout.NORTH);
		
		JPanel painelCentro = new JPanel();
		getContentPane().add(painelCentro, BorderLayout.CENTER);
		painelCentro.setLayout(null);
		
		JLabel lblNome = new JLabel("T\u00EDtulo Original:");
		lblNome.setBounds(10, 15, 103, 14);
		painelCentro.add(lblNome);
		
		JLabel lblDurao = new JLabel("Dura\u00E7\u00E3o:");
		lblDurao.setBounds(11, 75, 59, 14);
		painelCentro.add(lblDurao);
		
		JLabel lblAnoDeLanamento = new JLabel("Ano de Lan\u00E7amento:");
		lblAnoDeLanamento.setBounds(157, 75, 120, 14);
		painelCentro.add(lblAnoDeLanamento);
		
		tfTituloOriginal = new JTextField();
		tfTituloOriginal.setBounds(96, 9, 405, 20);
		painelCentro.add(tfTituloOriginal);
		tfTituloOriginal.setColumns(10);
		
		tfTituloTraduzido = new JTextField();
		tfTituloTraduzido.setEditable(false);
		tfTituloTraduzido.setColumns(10);
		tfTituloTraduzido.setBounds(128, 39, 373, 20);
		painelCentro.add(tfTituloTraduzido);
		
		tfDuracao = new JTextField();
		tfDuracao.setBounds(67, 69, 46, 20);
		painelCentro.add(tfDuracao);
		tfDuracao.setColumns(10);
		
		JLabel lblMin = new JLabel("min");
		lblMin.setBounds(120, 75, 27, 14);
		painelCentro.add(lblMin);
		
		tfAnoLancamento = new JTextField();
		tfAnoLancamento.setColumns(10);
		tfAnoLancamento.setBounds(275, 69, 59, 20);
		painelCentro.add(tfAnoLancamento);
		
		chckbxTituloTrad = new JCheckBox("T\u00EDtulo Traduzido:");
		chckbxTituloTrad.addItemListener(meventos);
		chckbxTituloTrad.setSelected(false);
		chckbxTituloTrad.setBounds(6, 36, 120, 23);
		painelCentro.add(chckbxTituloTrad);
		
		JComboBox cbGenero = new JComboBox(Generos.names());
		cbGenero.setBounds(66, 104, 157, 20);
		painelCentro.add(cbGenero);
		
		JLabel lblGnero = new JLabel("G\u00EAnero:");
		lblGnero.setBounds(10, 110, 59, 14);
		painelCentro.add(lblGnero);
		
		JLabel lblIdioma = new JLabel("Idioma:");
		lblIdioma.setBounds(344, 75, 60, 14);
		painelCentro.add(lblIdioma);
		
		String idiomas[] = {"Português","Inglês"};
		JComboBox cbIdioma = new JComboBox(idiomas);
		cbIdioma.setBounds(395, 69, 106, 20);
		painelCentro.add(cbIdioma);
		
		JLabel lblD = new JLabel("Classifica\u00E7\u00E3o:");
		lblD.setBounds(244, 110, 142, 14);
		painelCentro.add(lblD);
		
//		String ci[] = {"L","10","12","14","16","18"};
//		Icon ci_img[] = {new ImageIcon(ci[0]), new ImageIcon(ci[1]),
//				new ImageIcon(ci[2]),new ImageIcon(ci[3]),new ImageIcon(ci[4]),
//				new ImageIcon(ci[5])};
		
		cbClassificacaoIndicativa = new JComboBox(ClassificacaoIndicativa.names());
		cbClassificacaoIndicativa.addItemListener(meventos);
		
		cbClassificacaoIndicativa.setBounds(339, 107, 93, 20);
		painelCentro.add(cbClassificacaoIndicativa);
		
		lblCImagem = new JLabel("");
		ClassificacaoIndicativa ci = ClassificacaoIndicativa.valueOf(cbClassificacaoIndicativa.getSelectedItem().toString()); 
		lblCImagem.setIcon(ci.getImage());
		
		lblCImagem.setBounds(442, 104, 59, 56);
		painelCentro.add(lblCImagem);
		
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

	private class ManipuladorEventos implements ItemListener, ActionListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			
			if(e.getSource() == cbClassificacaoIndicativa){
				if(e.getStateChange() == ItemEvent.SELECTED){
					ClassificacaoIndicativa ci = ClassificacaoIndicativa.valueOf(cbClassificacaoIndicativa.getSelectedItem().toString()); 
					lblCImagem.setIcon(ci.getImage());
					LOG.info("Classificação Indicativa | Item Selecionado: "+ci);
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
				
			}else if(e.getSource() == btnCancelar){
				dispose();
			}
		}
		
	}
	
	/**
	 * Este método é usado apenas para testar a janela de cadastro de filmes
	 * sem a necessidade de rodar a aplicação inteira.
	 * @TODO Remover este método na versão final.
	 */
	public static void main(String[] args) {
		
		CadastroDeFilmes cadastrarFilmes = new CadastroDeFilmes();
		cadastrarFilmes.setVisible(true);
	}

	public void setContoller( CCadastroFilmes controller) {
		this.controller = controller;
	}

	@Deprecated
	public void preencherCampos() {
		
//		 tfTituloOriginal.setText("17 Anos, Outra Vez!");
//		 tfTituloTraduzido;
//		 tfDuracao;
//		 tfAnoLancamento;
		
		
	}
}
