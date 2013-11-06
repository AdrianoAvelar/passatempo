package com.adrianoavelar.model;

import com.adrianoavelar.util.EstadosBrasil;

/**
 * POJO para um Cliente
 * @author Adriano
 *
 */
public class Cliente {
	
	private String nome;
	private String endereco;
	private String bairro;
	private String cidade;
	private EstadosBrasil estado;
	private int cep;
	private long tel;
	private long cpf;
	private boolean isFeminino;
	
	public Cliente() {
		this.nome = "";
		this.endereco="";
		this.bairro="";
		this.cidade="";
		this.estado=null;
		this.cep=0;
		this.tel=0;
		this.cpf=0;
		this.isFeminino = true;
	}

	public Cliente(String nome, String endereco, String bairro, String cidade,
			EstadosBrasil estado, int cep, long tel, long cpf, boolean isFeminino) {
		super();
		setNome(nome);
		setEndereco(endereco);
		setBairro(bairro);
		setCidade(cidade);
		setEstado(estado);
		setCEP(cep);
		setTel(tel);
		setFeminino(isFeminino);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public EstadosBrasil getEstado() {
		return estado;
	}
	public void setEstado(EstadosBrasil estado) {
		this.estado = estado;
	}
	public int getCEP() {
		return cep;
	}
	public void setCEP(int cep) {
		this.cep = cep;
	}
	public long getTel() {
		return tel;
	}
	public void setTel(long tel) {
		this.tel = tel;
	}
	
	public long getCPF() {
		return cpf;
	}

	public void setCPF(long cpf) {
		this.cpf = cpf;
	}

	public boolean isFeminino() {
		return isFeminino;
	}

	public void setFeminino(boolean isFeminino) {
		this.isFeminino = isFeminino;
	}
	
	public boolean equals(Cliente cliente) {
		boolean res = false;
		
		if(cliente.getCPF() == this.getCPF()){
			res = true;
		}
		
		return res;
	}
	
	public String getSexo(){
		return isFeminino() ? "Feminino" : "Masculiuno";
	}

	@Override
	public String toString() {

		StringBuilder output = new StringBuilder();
		output.append("Nome: "+getNome() +"\n");
		output.append("Endereço: "+getEndereco()+"\n");
		output.append("CPF: "+getCPF()+"\n");
		output.append("Sexo: "+ getSexo()+"\n");
		output.append("Bairro: "+getBairro()+"\n");
		output.append("Cidade: "+getCidade()+"\n");
		output.append("Estado: "+getEstado()+"\n");
		output.append("CEP: "+getCEP()+"\n");
		output.append("Tel: "+getTel()+"\n");
		
		return output.toString();
	}
	
	public String[] getCampos(){
		String campos[] = {"Id","Nome","Endereco","CPF","Sexo","Bairro","Cidade","Estado","CEP","Telefone","Data_Cadastro"};
		return campos;
	}
	
}
