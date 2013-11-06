package com.adrianoavelar.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteHandler {
	
	private Connection c = null;
	private Statement stmt = null;
	
	public boolean openDB(){
		return openDB("banco01.sqlite");
	}
	
	public boolean openDB(String dbname){
		
		try {
			
			/*
			 * A declaração "Class.forName" carrega e registra a classe que implementa
			 * o JDBC driver (neste caso será a JDBC do sqlite).
			 */ 
			Class.forName("org.sqlite.JDBC");
			
			/*
			 * A declaração "DriverManager.getConnection" procura pelo
			 * driver registrado anteriormente. Se a classe não foi registrada 
			 * ou não foi encontrada, a conexão não será estabelecida.
			 * 
			 */
			c = DriverManager.getConnection("jdbc:sqlite:"+dbname);
			
			/*
			 * Crie um objeto do tipo Statement para executar
			 * as instruções no bando de dados.
			 */
			stmt = c.createStatement();
			return true;
			
			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		
		return false;
	}
	
	public void closeDB(){
		
		try {
			stmt.close();
			c.close();
		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		
	}
	
	public void executeUpdate(String sql) throws SQLException{
		stmt.executeUpdate(sql);
	
	}
	
	public ResultSet executeQuery(String sql) throws SQLException{
		return stmt.executeQuery(sql);
	}
	
	public static void main(String args[]) throws SQLException {
		
		SQLiteHandler sqlite = new SQLiteHandler();
		sqlite.openDB();
		
		String sql = "CREATE TABLE COMPANY "
				+ "(ID INT PRIMARY KEY     NOT NULL,"
				+ " NAME           TEXT    NOT NULL, "
				+ " AGE            INT     NOT NULL, "
				+ " ADDRESS        CHAR(50), " 
				+ " SALARY         REAL)";
		
		sqlite.executeUpdate(sql);
		sqlite.closeDB();
		
	}
	
	@Override
	protected void finalize() throws Throwable {
		stmt.close();
		c.close();
		
		super.finalize();
	}
}
