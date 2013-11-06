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
    
    public static Generos getValueOf(String str){
    	Generos[] generos = values();
    	Generos ret = null;
    	 for (int i = 0; i < generos.length; i++) {
    		 if(str.equals(generos[i].toString()))
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
