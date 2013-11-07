package com.adrianoavelar.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.Logger;

import com.adrianoavelar.controller.CCadastroCliente;
import com.adrianoavelar.model.Cliente;
import com.adrianoavelar.util.EstadosBrasil;
import com.adrianoavelar.util.Resource;
import com.adrianoavelar.util.UtilGUI;

public class CadastroDeClientes extends JDialog {

	private static Logger LOG = Logger.getLogger(CadastroDeClientes.class);
	private static final long serialVersionUID = 1291150202905925767L;
	
	private JTextField tfNome;
	private JTextField tfEndereco;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private JTextField tfCep;
	private JTextField tfTelCel;

	private JButton btnSalvar;
	private JButton btnCancelar;
	private CCadastroCliente controller;
	private JPanel painel_centro;
	private JComboBox cbEstado;
	private JTextField tfCPF;
	private JRadioButton rdbtnFeminino;
	private JRadioButton rdbtnMasculino;

	public CadastroDeClientes() {
		ButtonHandler buttonHandler = new ButtonHandler();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(536, 320);
		setLocationRelativeTo(null);
		setTitle("Cadastro de Clientes");
		getContentPane().setLayout(new BorderLayout(0, 0));

		JLabel lblCadastroDeClientes = new JLabel("Cadastro de Clientes");
		Icon icon = new ImageIcon(Resource.getImageResourcePath()+"ib_cadastrar_usuario.png");
		lblCadastroDeClientes.setIcon(icon);

		getContentPane().add(lblCadastroDeClientes, BorderLayout.NORTH);

		JPanel painel_inferior = new JPanel();
		getContentPane().add(painel_inferior, BorderLayout.SOUTH);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(buttonHandler);
		painel_inferior.add(btnSalvar);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		painel_inferior.add(horizontalStrut);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(buttonHandler);
		painel_inferior.add(btnCancelar);

		painel_centro = new JPanel();
		getContentPane().add(painel_centro, BorderLayout.CENTER);
		painel_centro.setLayout(null);
		painel_centro.setBorder(BorderFactory
				.createTitledBorder("Dados Pessoais"));

		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setBounds(10, 65, 58, 14);
		painel_centro.add(lblEndereco);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 32, 58, 14);
		painel_centro.add(lblNome);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 131, 58, 14);
		painel_centro.add(lblBairro);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(229, 130, 57, 14);
		painel_centro.add(lblCidade);

		tfNome = new JTextField();
		tfNome.setBounds(75, 27, 430, 20);
		painel_centro.add(tfNome);
		tfNome.setColumns(10);

		tfEndereco = new JTextField();
		tfEndereco.setColumns(10);
		tfEndereco.setBounds(75, 61, 430, 20);
		painel_centro.add(tfEndereco);

		tfBairro = new JTextField();
		tfBairro.setColumns(10);
		tfBairro.setBounds(75, 129, 144, 20);
		painel_centro.add(tfBairro);

		tfCidade = new JTextField();
		tfCidade.setColumns(10);
		tfCidade.setBounds(281, 128, 102, 20);
		painel_centro.add(tfCidade);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(396, 131, 58, 14);
		painel_centro.add(lblEstado);
		/** @TODO Colocar genérico */
		cbEstado = new JComboBox(EstadosBrasil.names());

		cbEstado.setBounds(447, 127, 58, 20);
		painel_centro.add(cbEstado);

		JLabel lblCep = new JLabel("Cep:");
		lblCep.setBounds(10, 169, 58, 14);
		painel_centro.add(lblCep);

		tfCep = new JTextField();
		tfCep.setColumns(10);
		tfCep.setBounds(75, 163, 144, 20);
		painel_centro.add(tfCep);

		JLabel lblTelefone = new JLabel("Tel/Cel:");
		lblTelefone.setBounds(229, 169, 57, 14);
		painel_centro.add(lblTelefone);

		tfTelCel = new JTextField();
		tfTelCel.setColumns(10);
		tfTelCel.setBounds(281, 166, 102, 20);
		painel_centro.add(tfTelCel);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 98, 58, 14);
		painel_centro.add(lblCpf);

		tfCPF = new JTextField();
		tfCPF.setColumns(10);
		tfCPF.setBounds(75, 95, 144, 20);
		painel_centro.add(tfCPF);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(237, 98, 57, 14);
		painel_centro.add(lblSexo);

		rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBounds(281, 94, 80, 23);
		rdbtnFeminino.setSelected(true);
		painel_centro.add(rdbtnFeminino);

		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(396, 94, 109, 23);
		painel_centro.add(rdbtnMasculino);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnFeminino);
		bg.add(rdbtnMasculino);

	}

	/**
	 * Recebe um controlador para gerenciar questões do sistema que não estão
	 * relacionados com a Interface Gráfica com o usuário. O controlador irá
	 * trabalhar junto com os modelos para implementar a lógica de negócio da
	 * sua aplicação.
	 * 
	 * @param Implementação
	 *            concreta da interface IController
	 * @see {@link com.adrianoavelar.controller.IController}
	 */
	public void setContoller(CCadastroCliente controller) {
		this.controller = controller;
	}

	/**
	 * Limpa os JTextFields da janela.
	 * 
	 */
	public void limparCampos() {

		for (JTextField jtf : getTextFields()) {

			jtf.setText("");
		}
	}

	/**
	 * Pega todos os JTextFields do PAINEL_CENTRO, onde ficam os campos de
	 * cadastro do usuário.
	 * 
	 * @TODO não retorna o valor do combo box,
	 * 
	 * @return Array de JTextFields
	 */
	public JTextField[] getTextFields() {

		List<JTextField> fields = new ArrayList<JTextField>();

		for (Component C : painel_centro.getComponents()) {

			if (C instanceof JTextField) {
				fields.add(((JTextField) C));
			}
		}

		return fields.toArray(new JTextField[fields.size()]);
	}

	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnSalvar) {
				/***
				 * @TODO 1 - Validar os campos antes de criar o objeto cliente 2
				 *       - Checar se a conversão String/Inteiro são válidas (CEP
				 *       e TEL)
				 ***/
				Cliente cliente = new Cliente();
				cliente.setNome(tfNome.getText());
				cliente.setEndereco(tfEndereco.getText());
				cliente.setBairro(tfBairro.getText());
				cliente.setCidade(tfCidade.getText());
				cliente.setEstado(EstadosBrasil.valueOf(cbEstado
						.getSelectedItem().toString()));
				cliente.setCPF(Long.parseLong(tfCPF.getText()));
				cliente.setCEP(Integer.parseInt(tfCep.getText()));
				cliente.setTel(Long.parseLong(tfTelCel.getText()));
				cliente.setFeminino(rdbtnFeminino.isSelected());

				if (controller.cadastrarCliente(cliente)) {
					UtilGUI.successMessage("Cliente Cadastrado com Sucesso!");
					dispose();
				}

			} else if (e.getSource() == btnCancelar) {
				dispose();
			}

		}
	}

	// @Teste #Remover na versão final
	@Deprecated
	public void preencherCampos() {
		
		tfNome.setText("Adriano Avelar");
		tfEndereco.setText("Estrada do Bongi, 425 B");
		tfBairro.setText("Afogados");
		tfCidade.setText("Recife");
		tfCPF.setText("12345678934");
		tfCep.setText("50830260");
		tfTelCel.setText("8121288000");

	}

	// @Teste #Remover na versão final
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CadastroDeClientes cadastro = new CadastroDeClientes();
		cadastro.setContoller(new CCadastroCliente());
		cadastro.setVisible(true);
		cadastro.preencherCampos();

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			LOG.error(e.getMessage());
		}
	}
}
