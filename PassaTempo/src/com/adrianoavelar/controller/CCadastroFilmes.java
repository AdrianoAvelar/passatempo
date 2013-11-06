package com.adrianoavelar.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

import com.adrianoavelar.model.Filme;
import com.adrianoavelar.model.IDAO;
import com.adrianoavelar.model.SQLiteDao;
import com.adrianoavelar.util.Util;
import com.adrianoavelar.view.UtilGUI;

public class CCadastroFilmes {

	private IDAO dao;
	private static Logger LOG = Logger.getLogger(CCadastroFilmes.class.getName());
	public CCadastroFilmes() {
		dao = new SQLiteDao();
	}

	public boolean cadastrarFilme(Filme filme) {
		LOG.info("Cadastrar Filme: \n"+filme);
		
		
		boolean res = false;
		
		try {
			dao.salvar(filme);
			res =  true;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			LOG.severe("Erro ao cadastrar filme: "+e.getMessage());
			UtilGUI.errorMessage("Erro ao cadastrar filme: "+e.getMessage());
		}
		
		return res;
		
	}
	
	public DefaultTableModel procurarFilme(String coluna, String criterio){
		
		ResultSet rs = (ResultSet) dao.pesquisaComRetorno("filmes",coluna, criterio);
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
