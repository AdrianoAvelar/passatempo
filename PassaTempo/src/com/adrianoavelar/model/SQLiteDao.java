package com.adrianoavelar.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

/************
 * SQLite é uma biblioteca em linguagem C que implementa um banco de dados SQL embutido.
 * Os sistemas que usam a biblioteca SQLite podem ter acesso a banco de dados SQL sem executar um 
 * SGBD (Sistema Gerenciador de Banco de Dados) separado como MySQL, PostgreSQL, Oracle.
 * SQLite não é uma biblioteca cliente usada para conectar com um grande servidor de banco de dados, 
 * mas sim o próprio servidor. A biblioteca SQLite lê e escreve diretamente para e do arquivo do banco de dados no disco.
 * @author Adriano
 * @see Para mais informações {@Link http://www.sqlite.org/datatype3.html}
 ************/
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

	@Override
	public void salvar(Filme filme) throws SQLException {
	String sql = "";
		
		sql = "INSERT INTO main.filmes("
				+ "titulo_original,titulo_traduzido,duracao,ano,idioma,genero,classificacao,imagem) "
				+ "VALUES("+extractFilmeInfo(filme)+ ");";
		
		LOG.info("SQL Gerado: "+sql);
		sqlite.executeUpdate(sql);
	}

	private String extractFilmeInfo(Filme filme) {
		StringBuilder out = new StringBuilder();
		out.append("'"+filme.getTituloOriginal()+"',");
		out.append("'"+filme.getTituloTraduzido()+"',");
		out.append(filme.getDuracao()+",");
		out.append(filme.getAnoDeLancamento()+",");
		out.append("'"+filme.getIdioma()+"',");
		out.append("'"+filme.getGenero()+"',");
		out.append("'"+filme.getClassificacao()+"',");
		out.append("'"+filme.getImagemFilme()+"'");
		return out.toString();
	}

	@Override
	public Object pesquisaComRetorno(String table, String coluna, String criterio) {
		
		
		ResultSet rs = null;
		String sql = "SELECT * FROM main."+table;
		if(!criterio.equals("") ){
			sql += " WHERE "+coluna+" LIKE '%"+criterio+"%'";
		}
		
		LOG.info("Sql: "+sql);
		
		 try {
			rs = sqlite.executeQuery(sql);
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return rs;
	}

}
