package com.adrianoavelar.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import org.apache.log4j.Logger;

//Não pode ser herdada
public final class Util {

	private static Logger LOG = Logger.getLogger(Util.class);
	private static Properties prop = null; 
	
	//Ninguem pode criar um instancia dela. Apenas através de chamadas estáticas.
	private Util() {

	}
	

	public static String getFileName(String fullname) {
		return fullname.substring(fullname.lastIndexOf("\\") + 1);
	}

	/**
	 * Cria uma mascara para Telefone. A mascara é no formato (###) ###-#### e o
	 * caractere substitutivo é o "_" (underline)
	 * 
	 * @return retorna a mascara de telefone criada.
	 * 
	 */
	public static MaskFormatter getTelMask() {
		MaskFormatter mask = null;
		try {
			// Cria um MaskFormatter para telefone. o simbolo # significa que
			// o JFormattedTextField aceita apenas numeros
			mask = new MaskFormatter("(###) ###-####");
			mask.setPlaceholderCharacter('_'); // Caracter substitutivo
		} catch (ParseException e) {
			LOG.error("Erro ao obter a mascara para telefone: "
					+ e.getMessage());
		}

		return mask;
	}

	/**
	 * Cria um MaskFormatter para inserção de 4 numeros (Pode ser usado para
	 * Ano). o simbolo # significa que o JFormattedTextField aceita apenas
	 * numeros
	 * 
	 * @return o maskFormatter criado
	 */
	public static MaskFormatter get4NumMask() {
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter("####");
			mask.setPlaceholderCharacter('_'); // Caracter substitutivo
		} catch (ParseException e) {
			LOG.error("Erro ao obter a mascara para 4 digitos: "
					+ e.getMessage());
		}

		return mask;
	}

	/**
	 * Cria um MaskFormatter para inserção de 3 numeros. o simbolo # significa
	 * que o JFormattedTextField aceita apenas numeros
	 * 
	 * @return o MaskFormatter criado
	 */
	public static MaskFormatter get3NumMask() {
		MaskFormatter mask = null;
		try {

			mask = new MaskFormatter("###");
			mask.setPlaceholderCharacter('_'); // Caracter substitutivo
		} catch (ParseException e) {
			LOG.error("Erro ao obter a mascara Numerica de 3 digitos: "
					+ e.getMessage());
		}

		return mask;
	}

	/**
	 * Imprime um array de Objetos como String.
	 * 
	 * @param array
	 */
	public static void printArray(Object array[]) {

		StringBuilder out = new StringBuilder("\n");

		for (int i = 0; i < array.length; i++) {
			out.append(array.getClass().getSimpleName() + " - [" + i + "] = "
					+ array[i] + "\n");
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

	public static Map<String,String> getMapFromResultSet(ResultSet rs) throws SQLException{

		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		
		Map<String,String> resultMap = new HashMap<>();
		
		
		if(rs.next()){
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				resultMap.put(String.valueOf(metaData.getColumnName(columnIndex)), 
						String.valueOf(rs.getObject(columnIndex)));
			}
		}
		return resultMap;
	}

	/**
	 * Método que devolver converte um MAP em String Key,Value.
	 * O método usa o coring "?" para dizer que ele pode 
	 * receber um método de qualquer class que herde de Object,
	 * ou seja, ele imprime maps de String, Ints, Doubles etc.
	 * @param filmesIds
	 * @return
	 */
	public static String toString(Map<? extends Object,? extends Object>  filmesIds) {
		
		StringBuilder out = new StringBuilder();
		for (Object name: filmesIds.keySet()){
            out.append(String.format("[%s] = %s", name.toString(),filmesIds.get(name).toString() ));
		}
		
		return out.toString();
	}
	
	public static void initProperties(){
		try {
			prop = new Properties();
			//set the properties value   		
			prop.load(new FileInputStream("config.properties"));
			
		} catch (FileNotFoundException e) {
			LOG.error("Arquivo de propriedades do sistema não encontrado.");
		} catch (IOException e) {
			LOG.error("Arquivo de propriedades do sistema não pode ser aberto.");
		}
	}

	
	public static String getPropriedade(String propriedades){
		if(prop == null)
			initProperties();
		
		return prop.getProperty(propriedades);
	}


	/**
	 * Cria um sequencia de caracteres com tamanho e padrão 
	 * 
	 * @param size - tamanho da string
	 * @param txt - padrão a ser impresso
	 * @return 
	 * createStringPattern(3,"#") - gera: ###
	 * createStringPattern(6,"%") - gera: %%%%%%
	 */
	public static String createStringPattern(int size,String txt) {
		String out = "";
		
		for(int i = 0; i < size; i++)
			out+=txt;
		
		return out;
	}
	
	/**
	 * @see {@link com.adrianoavelar.util.Util#createStringPattern(int, String)}
	 * @param size - tamanho da string
	 * @return chamada para createStringPattern(size,"-")
	 */
	public static String createStringPattern(int size) {
		return createStringPattern(size,"-");
	}
	

}
