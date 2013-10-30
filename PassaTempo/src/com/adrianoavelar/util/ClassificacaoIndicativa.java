package com.adrianoavelar.util;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public enum ClassificacaoIndicativa {

	LIVRE("LIVRE"),
	DEZ("Dez"),
	DOZE("Doze"),
	QUATORZE("Quatorze"),
	DEZESSEIS("Dezesseis"),
	DEZOITE("Dezoito");
	
	private String ci;
	private static String names[];
	private Icon icon;
	private String resourepath = Resource.getImageResourcePath();
	
	private ClassificacaoIndicativa(String ci){
		this.ci = ci;
		String imgpath = resourepath+"ci_"+ci.toLowerCase()+".png";
		this.icon = new ImageIcon(imgpath);
	}
	
	public Icon getImage(){
		return icon;
	}
	
	public static String[] names(){
		
		if(names != null)
			return names;
		
		ClassificacaoIndicativa values[] = values();
		names = new String[values.length];
		
		for(int i = 0; i < values.length; i++){
			names[i] = values[i].name();
		}
		
		return names;
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ci;
	}
}
