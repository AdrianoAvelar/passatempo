package com.adrianoavelar.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

import com.adrianoavelar.model.SQLiteDao;
import com.adrianoavelar.model.SQLiteHandler;
import com.adrianoavelar.util.Util;

public class CHistorico {

	private static Logger LOG = Logger.getLogger(CHistorico.class);
	
	private SQLiteDao dao;
	public CHistorico() {

		dao = new SQLiteDao();
				
	}

	public DefaultTableModel procurarHistorico(String coluna, String criterio) {
		
		
		ResultSet rs = (ResultSet) dao.pesquisaComRetorno(coluna,criterio,true);
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
