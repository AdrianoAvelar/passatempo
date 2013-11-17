package com.adrianoavelar.util;

public enum Generos {
	ACAO("AÇÃO"),
	ANIMACAO("ANIMAÇÃO"),
	AVENTURA("AVENTURA"),
	COMEDIA("COMÉDIA"),
	COMEDIA_ROMANTICA("COMÉDIA ROMÂNTICA"),
	COMEDIA_DRAMATICA("COMÉDIA DRAMÁTICA"),
	CULT("CULT"),
	DANCA("DANÇA"),
	DOCUMENTÁRIOS("DOCUMENTÁRIOS"),
	DRAMA("DRAMA"),
	ESPIONAGEM("ESPIONAGEM"),
	EROTICO("ERÓTICO"),
	FANTASIA("FANTASIA"),
	FAROESTE("FAROESTE"),
	FICCAO_CIENTIFICA("FICÇÃO CIENTÍFICA"),
	SERIES("SÉRIES"),
	GUERRA("GUERRA"),
	MUSICAL("MUSICAL"),
	POLICIAL("POLICIAL"),
	PORNOGRAFICO("PORNOGRÁFICO"),
	ROMANCE("ROMANCE"),
	SUSPENSE("SUSPENSE"),
	TERROR("TERROR"),
	TRASH("TRASH");
	
	
	
	private String genero;
	
	private Generos(String genero )
	{
		this.genero = genero;
	}
	
	public String getGenero() {
		return genero;
	}
	
	private static String[] names = null;
    
    /**
     * Método criado para criar um vetor de Strings e preencher
     * com os nome dos enums da classe em questão.
     * 
     * @return Retorna uma String dos nome dos Enums.
     */
    public static String[] names() {
    	
    	if(names != null)
    		return names;
    	
    	Generos[] generos = values();
        names = new String[generos.length];

        for (int i = 0; i < generos.length; i++) {
            names[i] = generos[i].toString();
        }

        return names;
    }
    
    /**
     * Foi necessário criar o métodos getValueOf para pegar um enum a partir de uma String.
     * O Enum possui um método valueOf que retorna um enum a partir do nome do Enum, por exemplo,
     * Generos.valueOf(COMEDIA_ROMANTICA)
     * Retorna o Enum que define o gênero COMEDIA_ROMANTICA
     * Como eu não quero mostrar para o usuário COMEDIA_ROMANTICA no combobox, 
     * pois fica feio. Eu defino um nome para cada enum
     * COMEDIA_ROMANTICA("COMÉDIA ROMÂNTICA"),
     *  desta forma posso mostrar um nome COMÉDIA ROMÂNTICA no combobox 
     *  usando uma chamada para toString. Veja que você tem que criar 
     *  um construtor, definir um nome (private String genero) e retornar esse nome no toString.
     *  Esse nome não é obrigatório, o enum poderia existir apenas com COMEDIA_ROMANTICA. 
     *  Porém, a tentativa de criar um nome mais aprazível para o usuário gera um problema. 
     *  Como vou pegar um enum a partir de do valor que o usuário seleciona no combobox?
     *  Uma vez que tenho apenas o método valueOf do enum que recebe o nome exato do enum. 
     *  Por exemplo, 
     *  Generos.valueOf(COMEDIA_ROMANTICA) //Retorna o Enum Generos.COMEDIA_ROMANTICA
     *  Generos.valueOf("COMÉDIA ROMÂNTICA") // Gera um erro pois essa string não faz parte do conjunto de enums definidos, ela é apenas um parâmetro passados para o construtor daquela Enum.
     *  Por isso, é necessário fazer um métodos que pegue o Enum também com o nome melhorado que definidos para aquela enum
     *  Generos.getValueOf("COMÉDIA ROMÂNTICA") // Agora sim, o enum é retornado com se fosse chamado o método Generos.valueOf(COMEDIA_ROMANTICA)
     *  
     * @param string que será usada para recuperar o Enum em questão.
     * @return O Genero correspondente à String passada como parâmetro.
     */
    public static Generos getValueOf(String string){
    	Generos[] generos = values();
    	Generos ret = null;
    	 for (int i = 0; i < generos.length; i++) {
    		 if(string.equalsIgnoreCase(generos[i].toString()))
    		{
    			 ret= generos[i];
    			 break;
    		}
    	 }
		return ret;
    }
	
	@Override  
    public String toString() {  
        return genero;  
    }
	

}
