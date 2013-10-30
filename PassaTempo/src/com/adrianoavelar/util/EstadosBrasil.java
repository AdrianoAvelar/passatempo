package com.adrianoavelar.util;

import java.util.ArrayList;

public enum EstadosBrasil {
	    AC("Acre"),  
	    AL("Alagoas"),  
	    AM("Amazonas"),  
	    AP("Amapá"),  
	    BA("Bahia"),  
	    CE("Ceará"),  
	    DF("Distrito Federal"),  
	    ES("Espirito Santo"),  
	    GO("Goias"),  
	    MA("Maranhão"),  
	    MG("Minas Gerais"),  
	    MS("Mato Grosso Sul"),  
	    MT("Mato Grosso"),  
	    PA("Pará"),  
	    PB("Paraiba"),  
	    PE("Pernanbuco"),  
	    PI("Piaui"),  
	    PR("Parana"),  
	    RJ("Rio de Janeiro"),  
	    RN("Rio Grande do Norte"),  
	    RO("Rondônia"),  
	    RR("Roraima"),  
	    RS("Rio Grande do Sul"),  
	    SC("Santa Catarina"),  
	    SE("Sergipe"),  
	    SP("São Paulo"),  
	    TO("Tocantins");  
	    
	    private String estado;  
	    private static String[] names = null;
	    
	    public static String[] names() {
	    	
	    	if(names != null)
	    		return names;
	    	
	    	EstadosBrasil[] states = values();
	        names = new String[states.length];

	        for (int i = 0; i < states.length; i++) {
	            names[i] = states[i].name();
	        }

	        return names;
	    }
	    
	    EstadosBrasil(String estado) {  
	        this.estado = estado; 
	    }  
	  
	    public String getEstado() {  
	        return estado;  
	    }  
	  
	    @Override  
	    public String toString() {  
	        return estado;  
	    }  
}