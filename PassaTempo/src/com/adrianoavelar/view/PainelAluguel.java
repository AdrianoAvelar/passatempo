package com.adrianoavelar.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.log4j.Logger;
import org.apache.log4j.pattern.IntegerPatternConverter;

import com.adrianoavelar.controller.CAluguel;
import com.adrianoavelar.model.Transacao;
import com.adrianoavelar.util.ClassificacaoIndicativa;
import com.adrianoavelar.util.Resource;
import com.adrianoavelar.util.UtilGUI;

public class PainelAluguel extends JPanel{

	private static final long serialVersionUID = -4779448161880083820L;

	private static Logger LOG = Logger.getLogger(PainelAluguel.class);
	
	//Campos de texto
	private JTextField jtfCodigoCliente;
	private JTextField jtfNomeCliente;
	private JTextField jtfEndereco;
	private JTextField jtfCidade;
	private JTextField jtfSituacao;
	private JTextField jtfCodigoFilme;
	private JTextField jtfTitulo;
	private JTextField jtfTituloTraduzido;
	private JTextField jtfGenero;
	private JTextField jtfAno;
	private JTextField jtfEstado;
	
	//Botões
	private JButton btnAdicionarFilme;
	private JButton btnBuscarCliente;
	private JButton btnBuscarFilme;
	private JButton btnFinalizar;
	
	//outros
	private CAluguel controller = null;
	private Icon icone;
	private TratadorEventos tratadorEventos = null;

	private JLabel lblImagemclassificacao;

	private JLabel lblImagemFilme;

	private JList<String> listaFilmes;
	private DefaultListModel<String> listModel ;
	private JButton btnRemover;
	
	private Transacao aluguel ;
	
	public Icon getIcone() {
		return icone;
	}
	
	private void init(){
		aluguel = new Transacao();
		listModel = new DefaultListModel<>();
		tratadorEventos = new TratadorEventos();
		icone = new ImageIcon(Resource.getImageResourcePath()+"ic_tab_aluguel.png");
	}
		
	public PainelAluguel() {
		
		init();
		
		setLayout(null);
		
		JPanel painelCliente = new JPanel();
		painelCliente.setBorder(BorderFactory.createTitledBorder("Lista de Filmes"));
		painelCliente.setBounds(10, 11, 761, 121);
		add(painelCliente);
		painelCliente.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 26, 46, 14);
		painelCliente.add(lblCodigo);
		
		jtfCodigoCliente = new JTextField();
		jtfCodigoCliente.setBounds(55, 23, 153, 20);
		painelCliente.add(jtfCodigoCliente);
		jtfCodigoCliente.setColumns(10);
		
		btnBuscarCliente = new JButton("Buscar Cliente");
		btnBuscarCliente.setIcon(new ImageIcon(Resource.getImageResourcePath()+"ib_procurar_add.png"));
		btnBuscarCliente.setBounds(10, 51, 200, 48);
		btnBuscarCliente.addActionListener(tratadorEventos);
		painelCliente.add(btnBuscarCliente);
		
		JPanel painelDadosCliente = new JPanel();
		painelDadosCliente.setBorder(BorderFactory.createTitledBorder("Dados"));
		painelDadosCliente.setBounds(220, 11, 520, 99);
		painelCliente.add(painelDadosCliente);
		painelDadosCliente.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 22, 46, 14);
		painelDadosCliente.add(lblNome);
		
		jtfNomeCliente = new JTextField();
		jtfNomeCliente.setEditable(false);
		jtfNomeCliente.setBounds(76, 19, 434, 20);
		painelDadosCliente.add(jtfNomeCliente);
		jtfNomeCliente.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setBounds(10, 47, 62, 14);
		painelDadosCliente.add(lblEndereco);
		
		jtfEndereco = new JTextField();
		jtfEndereco.setEditable(false);
		jtfEndereco.setColumns(10);
		jtfEndereco.setBounds(76, 44, 434, 20);
		painelDadosCliente.add(jtfEndereco);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 72, 62, 14);
		painelDadosCliente.add(lblCidade);
		
		jtfCidade = new JTextField();
		jtfCidade.setEditable(false);
		jtfCidade.setColumns(10);
		jtfCidade.setBounds(76, 69, 86, 20);
		painelDadosCliente.add(jtfCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(171, 74, 62, 14);
		painelDadosCliente.add(lblEstado);
		
		jtfSituacao = new JTextField();
		jtfSituacao.setEditable(false);
		jtfSituacao.setColumns(10);
		jtfSituacao.setBounds(376, 69, 134, 20);
		painelDadosCliente.add(jtfSituacao);
		
		JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o:");
		lblSituao.setBounds(327, 74, 62, 14);
		painelDadosCliente.add(lblSituao);
		
		jtfEstado = new JTextField();
		jtfEstado.setEditable(false);
		jtfEstado.setColumns(10);
		jtfEstado.setBounds(219, 69, 82, 20);
		painelDadosCliente.add(jtfEstado);
		
		JPanel painelFilme = new JPanel();
		painelFilme.setBorder(BorderFactory.createTitledBorder("Filmes"));
		painelFilme.setBounds(10, 134, 463, 303);
		add(painelFilme);
		painelFilme.setLayout(null);
		
		JLabel lblCodigoFilme = new JLabel("Codigo:");
		lblCodigoFilme.setBounds(14, 21, 46, 14);
		painelFilme.add(lblCodigoFilme);
		
		jtfCodigoFilme = new JTextField();
		jtfCodigoFilme.setColumns(10);
		jtfCodigoFilme.setBounds(71, 18, 124, 20);
		painelFilme.add(jtfCodigoFilme);
		
		btnBuscarFilme = new JButton("Buscar Filme");
		btnBuscarFilme.setEnabled(false);
		btnBuscarFilme.setIcon(new ImageIcon(Resource.getImageResourcePath()+"ib_procurar.png"));
		btnBuscarFilme.setBounds(253, 11, 200, 49);
		btnBuscarFilme.addActionListener(tratadorEventos);
		painelFilme.add(btnBuscarFilme);
		
		JLabel lblNome_1 = new JLabel("T\u00EDtulo");
		lblNome_1.setBounds(256, 71, 46, 14);
		painelFilme.add(lblNome_1);
		
		JLabel lblTtuloTraduzido = new JLabel("T\u00EDtulo Traduzido");
		lblTtuloTraduzido.setBounds(257, 109, 93, 14);
		painelFilme.add(lblTtuloTraduzido);
		
		lblImagemFilme = new JLabel("Imagem Filme");
		lblImagemFilme.setBounds(10, 46, 237, 246);
		painelFilme.add(lblImagemFilme);
		
		jtfTitulo = new JTextField();
		jtfTitulo.setEditable(false);
		jtfTitulo.setColumns(10);
		jtfTitulo.setBounds(256, 86, 196, 20);
		painelFilme.add(jtfTitulo);
		
		jtfTituloTraduzido = new JTextField();
		jtfTituloTraduzido.setEditable(false);
		jtfTituloTraduzido.setColumns(10);
		jtfTituloTraduzido.setBounds(257, 125, 196, 20);
		painelFilme.add(jtfTituloTraduzido);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(257, 156, 93, 14);
		painelFilme.add(lblGenero);
		
		jtfGenero = new JTextField();
		jtfGenero.setEditable(false);
		jtfGenero.setColumns(10);
		jtfGenero.setBounds(303, 153, 150, 20);
		painelFilme.add(jtfGenero);
		
		JLabel lblAno = new JLabel("ano:");
		lblAno.setBounds(257, 181, 93, 14);
		painelFilme.add(lblAno);
		
		JLabel lblClassificacao = new JLabel("Classificacao Indicativa:");
		lblClassificacao.setBounds(257, 206, 116, 14);
		painelFilme.add(lblClassificacao);
		
		lblImagemclassificacao = new JLabel("Imagem Class");
		lblImagemclassificacao.setBounds(382, 184, 71, 68);
		painelFilme.add(lblImagemclassificacao);
		
		jtfAno = new JTextField();
		jtfAno.setEditable(false);
		jtfAno.setColumns(10);
		jtfAno.setBounds(303, 178, 71, 20);
		painelFilme.add(jtfAno);
		
		btnAdicionarFilme = new JButton("Adicionar Filme");
		btnAdicionarFilme.setEnabled(false);
		btnAdicionarFilme.setIcon(new ImageIcon(Resource.getImageResourcePath()+"ib_add.png"));
		btnAdicionarFilme.setBounds(257, 254, 196, 38);
		btnAdicionarFilme.addActionListener(tratadorEventos);
		painelFilme.add(btnAdicionarFilme);
		
		JPanel painelLista = new JPanel();
		painelLista.setBorder(BorderFactory.createTitledBorder("Lista de Filmes"));
		painelLista.setBounds(485, 134, 286, 303);
		add(painelLista);
		painelLista.setLayout(new BorderLayout(0, 0));
		
		listaFilmes = new JList<>();
		listaFilmes.addListSelectionListener(tratadorEventos);
		painelLista.add(new JScrollPane(listaFilmes), BorderLayout.CENTER);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setEnabled(false);
		btnFinalizar.setIcon(new ImageIcon(Resource.getImageResourcePath()+"ib_ok.png"));
		btnFinalizar.addActionListener(tratadorEventos);
		
		JPanel listFilmes = new JPanel();
		listFilmes.add(btnFinalizar);
		
		painelLista.add(listFilmes, BorderLayout.SOUTH);
		
		btnRemover = new JButton("Remover");
		btnRemover.setEnabled(false);
		btnRemover.setIcon(new ImageIcon(Resource.getImageResourcePath()+"ib_remover.png"));
		btnRemover.addActionListener(tratadorEventos);
		listFilmes.add(btnRemover);
		
		
		// TODO Auto-generated constructor stub
	}
	
	private class TratadorEventos implements ActionListener,ListSelectionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == btnBuscarCliente && !jtfCodigoCliente.getText().equals("")){
				
				
				int codigCliente = Integer.parseInt(jtfCodigoCliente.getText());
				
				Map<String,String> resultMap = controller.getClienteInfoById(codigCliente);
				
				LOG.debug("getClienteInfoById: "+Arrays.toString(resultMap.entrySet().toArray()) );
			
				if(resultMap.size() > 0){
					jtfNomeCliente.setText(resultMap.get("nome"));
					jtfEndereco.setText(resultMap.get("endereco"));
					jtfCidade.setText(resultMap.get("cidade"));
					jtfEstado.setText(resultMap.get("estado"));
					jtfSituacao.setText("OK");
					
					btnBuscarFilme.setEnabled(true);
					
				}else{
					LOG.error("Cliente com Código = "+codigCliente + " não foi encontrado");
					UtilGUI.errorMessage("Cliente com Código = "+codigCliente + " não foi encontrado");
					
				}
				
				
			}else if(e.getSource() == btnBuscarFilme && !jtfCodigoFilme.getText().equals("")){
				
				int codigoFilme = Integer.parseInt(jtfCodigoFilme.getText());
				
				Map<String,String> resultMap = controller.getFilmeInfoById(codigoFilme);
				
				LOG.debug("getClienteInfoById: "+Arrays.toString(resultMap.entrySet().toArray()) );
			
				if(resultMap.size() > 0){
					
					jtfTitulo.setText(resultMap.get("titulo_original"));
					jtfTituloTraduzido.setText(resultMap.get("titulo_traduzido"));
					jtfGenero.setText(resultMap.get("genero"));
					jtfAno.setText(resultMap.get("ano"));
					
					lblImagemclassificacao.setText("");
					lblImagemclassificacao.setIcon((ClassificacaoIndicativa.getValueOf(resultMap.get("classificacao")).getImage()));
					
					lblImagemFilme.setText("");
					lblImagemFilme.setIcon(new ImageIcon(resultMap.get("imagem")));
					
					btnAdicionarFilme.setEnabled(true);
					
				}else{
					LOG.error("Filme com Código = "+codigoFilme + " não foi encontrado");
					UtilGUI.errorMessage("Filme com Código = "+codigoFilme + " não foi encontrado");
					
				}
			}else if(e.getSource() == btnAdicionarFilme){
				
				String filme = jtfTitulo.getText();
	
				if(!listModel.contains(filme)){
					
					LOG.debug("Adicionando filme a lista de compras: "+filme);
					
					aluguel.addFilme(filme,Integer.parseInt(jtfCodigoFilme.getText()));
					
					listModel.addElement(filme);
					listaFilmes.setModel(listModel);
				}
				
				btnFinalizar.setEnabled(true);
				
			}else if(e.getSource() == btnRemover){
				
				int index = listaFilmes.getSelectedIndex();
				
				if(index >= 0 ){
					
					
					aluguel.removeFilme(listaFilmes.getSelectedValue());
					
					listModel.remove(listaFilmes.getSelectedIndex());
					listaFilmes.setModel(listModel);
					btnRemover.setEnabled(false);
					btnBuscarFilme.requestFocus();
					
					if(listModel.isEmpty()){
						btnFinalizar.setEnabled(false);
					}
				}
			
			}else if(e.getSource() == btnFinalizar){
				
				int idCliente = Integer.parseInt(jtfCodigoCliente.getText());
				aluguel.setIdCliente(idCliente);
				
				if (controller.cadastrarTransacao(aluguel)) {
					UtilGUI.successMessage("Locação concluida com sucesso");
					
				}
				
				
			}
		}

		@Override
		public void valueChanged(ListSelectionEvent e) {
			
			if(e.getSource() == listaFilmes){
				
				btnRemover.setEnabled(true);
			}
		}
		
	}

	public void setController(CAluguel controller) {
		this.controller  = controller;
		
	}
}
