package com.adrianoavelar.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Vector;
import org.apache.log4j.Logger;

import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.adrianoavelar.controller.CCadastroFilmes;

public class Util {

	private static Logger LOG = Logger.getLogger(CCadastroFilmes.class);
	
	public Util() {
		// TODO Auto-generated constructor stub
	}
	
	public static String getFileName(String fullname){
		return fullname.substring(fullname.lastIndexOf("\\")+1);
	}

	/**
	 * Cria uma mascara para Telefone.
	 * A mascara é no formato (###) ###-####
	 * e o caractere substitutivo é o "_" (underline)
	 * @return
	 * 	retorna a mascara de telefone criada.
	 * 
	 */
	public static MaskFormatter getTelMask(){
		MaskFormatter mask = null;
        try {
            // Cria um MaskFormatter para telefone. o simbolo # significa que 
        	// o JFormattedTextField aceita apenas numeros
            mask = new MaskFormatter("(###) ###-####");
            mask.setPlaceholderCharacter('_'); //Caracter substitutivo
        } catch (ParseException e) {
            LOG.error("Erro ao obter a mascara para telefone: "+e.getMessage());
        }
        
        return mask;
	}
	
	/**
	 *  Cria um MaskFormatter para inserção de 4 numeros (Pode ser usado para Ano). 
	 *  o simbolo # significa que o JFormattedTextField
	 *   aceita apenas numeros
	 * 
	 * @return o maskFormatter criado
	 */
	public static MaskFormatter get4NumMask(){
		MaskFormatter mask = null;
        try {
            mask = new MaskFormatter("####");
            mask.setPlaceholderCharacter('_'); //Caracter substitutivo
        } catch (ParseException e) {
            LOG.error("Erro ao obter a mascara para 4 digitos: "+e.getMessage());
        }
        
        return mask;
	}
	
	/**
	 * Cria um MaskFormatter para inserção de 3 numeros. 
	 *  o simbolo # significa que 
     * o JFormattedTextField aceita apenas numeros
	 * @return o MaskFormatter criado
	 */
	public static MaskFormatter get3NumMask(){
		MaskFormatter mask = null;
        try {
           
            mask = new MaskFormatter("###");
            mask.setPlaceholderCharacter('_'); //Caracter substitutivo
        } catch (ParseException e) {
            LOG.error("Erro ao obter a mascara Numerica de 3 digitos: "+e.getMessage());
        }
        
        return mask;
	}
	
	/**
	 * Imprime um array de Objetos como String.
	 * @param array
	 */
	public static void printArray(Object array[]){
		
		StringBuilder out = new StringBuilder("\n");
		
		for(int i = 0 ; i < array.length; i++){
			out.append(array.getClass().getSimpleName()+" - [" + i + "] = "+array[i] +"\n");
		}
		
		LOG.debug(out.toString());
	}
	
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // nomes das colunas
	    Vector<String> colunas = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        colunas.add(metaData.getColumnName(column));
	    }

	    // dados da tabela
	    Vector<Vector<Object>> dados = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        dados.add(vector);
	    }

	    return new NotEditableTableModel(dados, colunas);

	}

}
