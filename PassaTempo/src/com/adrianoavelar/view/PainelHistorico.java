package com.adrianoavelar.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Logger;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.adrianoavelar.controller.CHistorico;
import com.adrianoavelar.model.Filme;
import com.adrianoavelar.util.Resource;
import com.adrianoavelar.util.Util;

public class PainelHistorico extends JPanel {
	
	private static Logger LOG = Logger.getLogger(PainelHistorico.class.getName());
	private static final long serialVersionUID = 7879116841216780795L;
	private JTextField tfCriterio;
	private JTable jtFilmes;
	private JButton btnProcurar;
	private TratadorDeEventos tratador;
	private CHistorico controller;
	private JComboBox cbCriterio;
	
	private Icon icone;
	
	
	public Icon getIcone() {
		return icone;
	}
	
	public PainelHistorico() {
		icone = new ImageIcon(Resource.getImageResourcePath()+"ic_tab_historico.png");
		
		tratador = new TratadorDeEventos();
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		String campos[] = (new Filme()).getCampos();
		cbCriterio = new JComboBox(campos);
		panel.add(cbCriterio);
		
		tfCriterio = new JTextField();
		panel.add(tfCriterio);
		tfCriterio.setColumns(40);
		
		btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(tratador);
		btnProcurar.setIcon(new ImageIcon(Resource.getImageResourcePath()+"ib_lupa.png"));
		panel.add(btnProcurar);
		
		jtFilmes = new JTable();
		jtFilmes.addMouseListener(tratador);
		TableModel dataModel = new DefaultTableModel(
				new Object [][] {},campos);
		
		jtFilmes.setModel(dataModel);
		JScrollPane scrollPane = new JScrollPane( jtFilmes );
		
		add(scrollPane, BorderLayout.CENTER);
		
	}
	
	private class TratadorDeEventos extends MouseAdapter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == btnProcurar){
				DefaultTableModel model = controller.procurarHistorico(
						cbCriterio.getSelectedItem().toString().toLowerCase(),tfCriterio.getText());
				
				if(model != null){
					jtFilmes.setModel(model);
				}
				
			}
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
			if(e.getSource() == jtFilmes && e.getClickCount() == 2) {
		         
		         int row = jtFilmes.getSelectedRow();
		         int column = jtFilmes.getSelectedColumn();
		         
		         LOG.info("row: "+ row + " column: "+column);
		         
		         String valores[] = new String[jtFilmes.getColumnCount()];
		         for(int i = 0; i < valores.length; i++){
		        	 valores[i] = ""+jtFilmes.getValueAt(row, i);
		         }
		         Util.printArray(valores);
		   }
		   
		}
		
	}
	
	public void setController(CHistorico cHistorico){
		this.controller = cHistorico;
	}
	
}
