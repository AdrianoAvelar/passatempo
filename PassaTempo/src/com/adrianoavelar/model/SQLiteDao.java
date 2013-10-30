package com.adrianoavelar.model;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import com.adrianoavelar.controller.CCadastroCliente;

public class SQLiteDao  implements IDAO {

	private static final Logger LOG = Logger.getLogger(SQLiteDao.class.getName());
	private SQLiteHandler sqlite;
	public SQLiteDao() {
		sqlite = new SQLiteHandler();
		sqlite.openDB("main.sqlite");
	}

	/* (non-Javadoc)
	 * @see com.adrianoavelar.model.IDAO#salvar(com.adrianoavelar.controller.Cliente)
	 */
	@Override
	public void salvar(Cliente client) throws SQLException {

		String sql = "";
		
		sql = "INSERT INTO main.clientes("
				+ "nome,endereco,bairro,cidade,estado,cpf,cep,tel,sexo) "
				+ "VALUES("+extractClienteInfo(client)+ ");";
		
		LOG.info("SQL Gerado: "+sql);
		sqlite.executeUpdate(sql);
	}
	
	/**
	 * Este método extrai informações de um cliente para colocar
	 * no bando de dados.
	 * @param 
	 * Object da classe {@link com.adrianoavelar.model.Cliente}
	 * @return
	 * String formatada com os valores a serem colocados no bando de dados.
	 */
	private String extractClienteInfo(Cliente client){
		
		StringBuilder out = new StringBuilder();
		out.append("'"+client.getNome()+"',");
		out.append("'"+client.getEndereco()+"',");
		out.append("'"+client.getBairro()+"',");
		out.append("'"+client.getCidade()+"',");
		out.append("'"+client.getEstado()+"',");
		out.append(client.getCPF()+",");
		out.append(client.getCEP()+",");
		out.append(client.getTel()+",");
		out.append("'"+client.getSexo().toUpperCase()+"'");
		return out.toString();
	}

	@Override
	public void atualizar(Cliente client) {
		// TODO Auto-generated method stub
	}

	@Override
	public void remover(Cliente client) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Cliente> pesquisar(Cliente client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void finalize() throws Throwable {
		sqlite.closeDB();
		super.finalize();
	}
}
