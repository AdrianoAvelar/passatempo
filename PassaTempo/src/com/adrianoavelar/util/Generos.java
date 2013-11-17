package com.adrianoavelar.util;

public enum Generos {
	ACAO("A��O"),
	ANIMACAO("ANIMA��O"),
	AVENTURA("AVENTURA"),
	COMEDIA("COM�DIA"),
	COMEDIA_ROMANTICA("COM�DIA ROM�NTICA"),
	COMEDIA_DRAMATICA("COM�DIA DRAM�TICA"),
	CULT("CULT"),
	DANCA("DAN�A"),
	DOCUMENT�RIOS("DOCUMENT�RIOS"),
	DRAMA("DRAMA"),
	ESPIONAGEM("ESPIONAGEM"),
	EROTICO("ER�TICO"),
	FANTASIA("FANTASIA"),
	FAROESTE("FAROESTE"),
	FICCAO_CIENTIFICA("FIC��O CIENT�FICA"),
	SERIES("S�RIES"),
	GUERRA("GUERRA"),
	MUSICAL("MUSICAL"),
	POLICIAL("POLICIAL"),
	PORNOGRAFICO("PORNOGR�FICO"),
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
     * M�todo criado para criar um vetor de Strings e preencher
     * com os nome dos enums da classe em quest�o.
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
     * Foi necess�rio criar o m�todos getValueOf para pegar um enum a partir de uma String.
     * O Enum possui um m�todo valueOf que retorna um enum a partir do nome do Enum, por exemplo,
     * Generos.valueOf(COMEDIA_ROMANTICA)
     * Retorna o Enum que define o g�nero COMEDIA_ROMANTICA
     * Como eu n�o quero mostrar para o usu�rio COMEDIA_ROMANTICA no combobox, 
     * pois fica feio. Eu defino um nome para cada enum
     * COMEDIA_ROMANTICA("COM�DIA ROM�NTICA"),
     *  desta forma posso mostrar um nome COM�DIA ROM�NTICA no combobox 
     *  usando uma chamada para toString. Veja que voc� tem que criar 
     *  um construtor, definir um nome (private String genero) e retornar esse nome no toString.
     *  Esse nome n�o � obrigat�rio, o enum poderia existir apenas com COMEDIA_ROMANTICA. 
     *  Por�m, a tentativa de criar um nome mais apraz�vel para o usu�rio gera um problema. 
     *  Como vou pegar um enum a partir de do valor que o usu�rio seleciona no combobox?
     *  Uma vez que tenho apenas o m�todo valueOf do enum que recebe o nome exato do enum. 
     *  Por exemplo, 
     *  Generos.valueOf(COMEDIA_ROMANTICA) //Retorna o Enum Generos.COMEDIA_ROMANTICA
     *  Generos.valueOf("COM�DIA ROM�NTICA") // Gera um erro pois essa string n�o faz parte do conjunto de enums definidos, ela � apenas um par�metro passados para o construtor daquela Enum.
     *  Por isso, � necess�rio fazer um m�todos que pegue o Enum tamb�m com o nome melhorado que definidos para aquela enum
     *  Generos.getValueOf("COM�DIA ROM�NTICA") // Agora sim, o enum � retornado com se fosse chamado o m�todo Generos.valueOf(COMEDIA_ROMANTICA)
     *  
     * @param string que ser� usada para recuperar o Enum em quest�o.
     * @return O Genero correspondente � String passada como par�metro.
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
