package com.adrianoavelar.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.log4j.Logger;

import com.adrianoavelar.model.IDAO;
import com.adrianoavelar.model.SQLiteDao;
import com.adrianoavelar.model.Transacao;
import com.adrianoavelar.util.Util;
import com.adrianoavelar.util.UtilGUI;

public class CAluguel {

	private static Logger LOG = Logger.getLogger(CCadastroFilmes.class);

	private IDAO dao;

	public CAluguel() {
		dao = new SQLiteDao();
	}

	public Map<String,String> getClienteInfoById(int parseInt) {
		
		Map<String,String> resultMap = null;
		
		ResultSet rs = (ResultSet) dao.pesquisaComRetorno("clientes","id_cliente", String.valueOf(parseInt),false);
		
		try{
			resultMap = Util.getMapFromResultSet(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error(e.getMessage());
		}
	
		return resultMap;
		
	}

	public Map<String, String> getFilmeInfoById(int parseInt) {
		Map<String,String> resultMap = null;
		
		ResultSet rs = (ResultSet) dao.pesquisaComRetorno("filmes","id_filme", String.valueOf(parseInt),false);
		
		try{
			resultMap = Util.getMapFromResultSet(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error(e.getMessage());
		}
	
		return resultMap;
	}

	public boolean cadastrarTransacao(Transacao aluguel) {
		
		LOG.debug("Cadastrando Transação:" + aluguel );
		
		boolean res = false;
		
		try {
			dao.cadastrarTransacao(aluguel);
			res =  true;
		} catch (Exception e) {
			LOG.error("Erro ao cadastrar cliente: "+e.getMessage());
			UtilGUI.errorMessage("Erro ao cadastrar cliente: "+e.getMessage());
		}
		
		return res;
	}
}
