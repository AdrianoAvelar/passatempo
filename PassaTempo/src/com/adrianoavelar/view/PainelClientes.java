package com.adrianoavelar.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.apache.log4j.Logger;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.adrianoavelar.controller.CCadastroCliente;
import com.adrianoavelar.controller.CCadastroFilmes;
import com.adrianoavelar.model.Cliente;
import com.adrianoavelar.util.Resource;
import com.adrianoavelar.util.Util;

public class PainelClientes extends JPanel {
	
	private static Logger LOG = Logger.getLogger(PainelClientes.class);
	private static final long serialVersionUID = 7879116841216780795L;
	private JTextField tfCriterio;
	private JTable jtClientes;
	private JButton btnProcurar;
	private TratadorDeEventos tratador;
	private CCadastroCliente controller;
	private JComboBox cbCriterio;
	private Icon icone;
	
	
	public Icon getIcone() {
		return icone;
	}

	public PainelClientes() {
		
		icone = new ImageIcon(Resource.getImageResourcePath()+"ic_tab_clientes.png");
		tratador = new TratadorDeEventos();
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		String campos[] = (new Cliente()).getCampos();
		cbCriterio = new JComboBox(campos);
		panel.add(cbCriterio);
		
		tfCriterio = new JTextField();
		panel.add(tfCriterio);
		tfCriterio.setColumns(40);
		
		btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(tratador);
		btnProcurar.setIcon(new ImageIcon(Resource.getImageResourcePath()+"ib_lupa.png"));
		panel.add(btnProcurar);
		
		jtClientes = new JTable();
		jtClientes.addMouseListener(tratador);
		TableModel dataModel = new DefaultTableModel(
				new Object [][] {},campos);
		
		jtClientes.setModel(dataModel);
		JScrollPane scrollPane = new JScrollPane( jtClientes );
		
		add(scrollPane, BorderLayout.CENTER);
		
	}
	
	private class TratadorDeEventos extends MouseAdapter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == btnProcurar){
				DefaultTableModel model = controller.procurarCliente(
						cbCriterio.getSelectedItem().toString().toLowerCase(),tfCriterio.getText());
				
				if(model != null){
					jtClientes.setModel(model);
				}
				
			}
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
			if(e.getSource() == jtClientes && e.getClickCount() == 2) {
		         
		         int row = jtClientes.getSelectedRow();
		         int column = jtClientes.getSelectedColumn();
		         
		         LOG.debug("row: "+ row + " column: "+column);
		         
		         String valores[] = new String[jtClientes.getColumnCount()];
		         for(int i = 0; i < valores.length; i++){
		        	 valores[i] = ""+jtClientes.getValueAt(row, i);
		         }
		         Util.printArray(valores);
		   }
		   
		}
		
	}
	
	public void setController(CCadastroCliente controller){
		this.controller = controller;
	}
	
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		PainelClientes painel = new PainelClientes();
		painel.setController(new CCadastroCliente());
		jf.getContentPane().add(painel);
		jf.setSize(800, 600);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
