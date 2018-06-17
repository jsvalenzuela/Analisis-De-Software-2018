package principal;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Cadenas {

	public static String normalizar(String line){
		String lineaNormalizada = line;
		
		//borrar comentarios
		if(line.contains("//")){
			lineaNormalizada = lineaNormalizada.substring( 0, lineaNormalizada.indexOf("//") );
		}
		
		return lineaNormalizada
			.trim()
			.toLowerCase()
			.replaceAll("\\t", "")
			.replaceAll("\\n", "")
			//borrar todo entre comillas
			.replaceAll("\".*?\"", "\"\"")
			//aseguramos al menos un espacio antes y después de los siguientes caracteres
			.replaceAll("\\(", " ( ")
			.replaceAll("\\)", " ) ")
			.replaceAll("\\{", " { ")
			.replaceAll("\\}", " } ")
			.replaceAll("\\,", " , ")
			.replaceAll("\\;", " ; ")
			.replaceAll("\\&\\&", " && ")
			.replaceAll("\\|\\|", " || ")
			.replaceAll("\\?", " ? ")
			//unificar multiples espacios
			.replaceAll("( )+", " ");
	}
	
	public static Integer cantOcurrencias(String nombreMetodo, List<String> codigo){
		Integer cant = 0;
		for(String linea : codigo){
			cant += StringUtils.countMatches(
					normalizar(linea), 
					nombreMetodo.toLowerCase().trim().concat(" (")
				);
		}
		return cant;
	}
	
}
