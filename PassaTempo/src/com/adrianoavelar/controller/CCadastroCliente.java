package com.adrianoavelar.controller;


import java.util.logging.Level;
import java.util.logging.Logger;

import com.adrianoavelar.model.Cliente;
import com.adrianoavelar.model.IDAO;
import com.adrianoavelar.model.SQLiteDao;
import com.adrianoavelar.view.UtilGUI;

/**
 * Controlador que gerencia o cadastro de novos usu�rios no banco de dados.
 * Ele usa um DAO (Data Access Object) para gerenciar a comunica��o com o 
 * banco de dados. 
 * Desta forma, a Interface Gr�fica n�o precisa se preocupar como
 * os dados dos usu�rios ser�o acessados, ou como ser� a grava��o no
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


}
