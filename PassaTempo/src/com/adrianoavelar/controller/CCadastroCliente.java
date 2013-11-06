package com.adrianoavelar.controller;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

import com.adrianoavelar.model.Cliente;
import com.adrianoavelar.model.IDAO;
import com.adrianoavelar.model.SQLiteDao;
import com.adrianoavelar.util.Util;
import com.adrianoavelar.view.UtilGUI;

/**
 * Controlador que gerencia o cadastro de novos usuários no banco de dados.
 * Ele usa um DAO (Data Access Object) para gerenciar a comunicação com o 
 * banco de dados. 
 * Desta forma, a Interface Gráfica não precisa se preocupar como
 * os dados dos usuários serão acessados, ou como será a gravação no
 * bando de dados.
 *  
 * @author Adriano Avelar
 */

public class CCadastroCliente  {

	private static final Logger LOG = Logger.getLogger(CCadastroCliente.class.getName());
	
	private IDAO dao;
	public CCadastroCliente() {
		dao = new SQLiteDao();
	}

	public boolean cadastrarCliente(Cliente cliente) {
		LOG.info("Cadastrando Cliente:\n" + cliente);
				
		boolean res = false;
		
		try {
			dao.salvar(cliente);
			res =  true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			LOG.severe("Erro ao cadastrar cliente: "+e.getMessage());
			UtilGUI.errorMessage("Erro ao cadastrar cliente: "+e.getMessage());
		}
		
		return res;
	}

	public boolean atualizarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return false;
	}

	public DefaultTableModel procurarCliente(String coluna, String criterio){
		
		ResultSet rs = (ResultSet) dao.pesquisaComRetorno("clientes",coluna, criterio);
		DefaultTableModel model = null;
		
		try {
			model =  Util.buildTableModel(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return model;
	}
	
	

}
