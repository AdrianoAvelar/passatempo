package com.adrianoavelar.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

import com.adrianoavelar.model.Filme;
import com.adrianoavelar.model.IDAO;
import com.adrianoavelar.model.SQLiteDao;
import com.adrianoavelar.util.Util;
import com.adrianoavelar.util.UtilGUI;

public class CCadastroFilmes {

	private IDAO dao;
	private static Logger LOG = Logger.getLogger(CCadastroFilmes.class);
	
	public CCadastroFilmes() {
		dao = new SQLiteDao();
	}

	public boolean cadastrarFilme(Filme filme) {
		
		LOG.debug(filme);
		
		boolean res = false;
		
		try {
			dao.salvar(filme);
			res =  true;
		} catch (SQLException e) {
			LOG.error("Erro ao cadastrar filme: "+e.getMessage());
			UtilGUI.errorMessage("Erro ao cadastrar filme: "+e.getMessage());
		}
		
		return res;
	}
	
	public DefaultTableModel procurarFilme(String coluna, String criterio){
		
		ResultSet rs = (ResultSet) dao.pesquisaComRetorno("filmes",coluna, criterio,true);
		DefaultTableModel model = null;
		
		try {
			model =  Util.buildTableModel(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error(e.getMessage());
		}
		return model;
	}
	
}
