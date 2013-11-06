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
