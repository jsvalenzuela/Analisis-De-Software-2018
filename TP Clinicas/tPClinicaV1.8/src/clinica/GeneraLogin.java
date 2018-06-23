package clinica;

import java.io.FileWriter;
import java.io.PrintWriter;

public class GeneraLogin {

	public static void main(String[] args) {
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("./bin\\Login.txt"); //Con pasarle por parametro el true agrega al final sin borrar el contenido
            pw = new PrintWriter(fichero);
            
            String linea = "Los_Laureles" + " " + "123456789"; 
            
            pw.println(encriptar(linea));
            
  

        } catch (Exception e1) {
            e1.printStackTrace();
    
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();

           }
        }

	}

	private static String encriptar(String linea) {
		char array[]=linea.toCharArray(); 
	     
	    for(int i=0;i<array.length;i++){ 
	        array[i]=(char)(array[i]+(char)5); 
	    } 
	    String encriptado =String.valueOf(array);
	    
		return encriptado;
	}

}
