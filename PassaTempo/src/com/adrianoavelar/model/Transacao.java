package com.adrianoavelar.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transacao {

	private int idCliente; 
	private Map<String,Integer> transacoes;
	
	public Transacao(int idCliente) {
		super();
		this.idCliente = idCliente;
	}

	public Transacao() {
		transacoes = new HashMap<>();
		// TODO Auto-generated constructor stub
	}

	
	public void addFilme(String nome, int id){
		transacoes.put(nome, id);
		
	}
	
	public void removeFilme(String key){
		transacoes.remove(key);
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public int getIdCliente() {
		return idCliente;
	}

	public int[] getFilmesIds() {
		
		int array[] = new int[transacoes.size()];
		int i = 0;
		for (Object name: transacoes.keySet()){
			 array[i++] = (int)transacoes.get(name);
		}
		
		return array;
	}

	
	@Override
	public String toString() {
		
		StringBuilder out = new StringBuilder();
		for (Object name: transacoes.keySet()){
            out.append(String.format("Cliente Id: [%s] = Filme Id: %s", name.toString(),transacoes.get(name).toString() ));
		}
		
		return out.toString();
	}
	
	public String[] getCampos() {
		String campos[] = {"id_transacao","id_cliente","nome","titulo_original","titulo_traduzido","data"};
		return campos;
	}
	
}
