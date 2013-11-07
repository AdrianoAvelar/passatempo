package com.adrianoavelar.model;

import javax.swing.Icon;

import com.adrianoavelar.util.ClassificacaoIndicativa;
import com.adrianoavelar.util.Generos;

public class Filme {

	private String tituloOriginal;
	private String tituloTraduzido;
	private int duracao;
	private int anoDeLancamento;
	private String idioma;
	private Generos genero;
	private ClassificacaoIndicativa classificacao;
	private String imagemFilme;
	
	public Filme() {
	}

	public Filme(String tituloOriginal, String tituloTraduzido, int duracao,
			int anoDeLancamento, String idioma, Generos genero,
			ClassificacaoIndicativa classificacao, String imagemFilme) {
		super();
		this.tituloOriginal = tituloOriginal;
		this.tituloTraduzido = tituloTraduzido;
		this.duracao = duracao;
		this.anoDeLancamento = anoDeLancamento;
		this.idioma = idioma;
		this.genero = genero;
		this.classificacao = classificacao;
		this.imagemFilme = imagemFilme;
	}

	public String getImagemFilme() {
		return imagemFilme;
	}

	public void setImagemFilme(String imagemFilme) {
		this.imagemFilme = imagemFilme;
	}

	public String getTituloOriginal() {
		return tituloOriginal;
	}

	public void setTituloOriginal(String tituloOriginal) {
		this.tituloOriginal = tituloOriginal;
	}

	public String getTituloTraduzido() {
		return tituloTraduzido;
	}

	public void setTituloTraduzido(String tituloTraduzido) {
		this.tituloTraduzido = tituloTraduzido;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public int getAnoDeLancamento() {
		return anoDeLancamento;
	}

	public void setAnoDeLancamento(int anoDeLancamento) {
		this.anoDeLancamento = anoDeLancamento;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public Generos getGenero() {
		return genero;
	}

	public void setGenero(Generos genero) {
		this.genero = genero;
	}

	public ClassificacaoIndicativa getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(ClassificacaoIndicativa classificacao) {
		this.classificacao = classificacao;
	}
	
	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		
		out.append("Titulo Original: "+tituloOriginal+"\n");
		out.append("Titulo Traduzido: "+tituloTraduzido+"\n");
		out.append("Duracao: "+duracao+"\n");
		out.append("Ano de Lancamento: "+anoDeLancamento+"\n");
		out.append("Idioma: "+idioma+"\n");
		out.append("Genero: "+genero+"\n");
		out.append("Classificacao: "+classificacao+"\n");
		out.append("Imagem: "+imagemFilme);
		return out.toString();
	}

	public String[] getCampos() {
		String campos[] = {"Id_Filme","titulo_original","titulo_traduzido","duracao","ano","idioma","genero","cassificacao","imagem"};
		return campos;
	}

}
