package com.adrianoavelar.model;

import java.util.List;

public interface IDAO {
	/**
	 * Salva o cliente em um meio de persist�ncia.
	 * Este meio ser� devinido pela classe concreta que implementar
	 * est� interface. 
	 * A classe {@link com.adrianoavelar.model.SQLiteDao} implementa a persist�ncia via bando de dados
	 * e a classe {@link com.adrianoavelar.model.FileDAO} implementa a persist�ncia via arquivo
	 * @param cliente
	 */
	public abstract void salvar(Cliente cliente) throws Exception;
	public abstract void atualizar(Cliente cliente) ;
	public abstract void remover(Cliente cliente);
	public abstract List<Cliente> pesquisar(Cliente cliente);
	
}
