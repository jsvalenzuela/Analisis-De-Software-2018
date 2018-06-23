package clinica;
import java. util. Scanner;


public class CentroMedico {

	private Paciente paciente;
	private Medico medico;
	private Diagnostico diag;
	
	
	public boolean login(String usser,String pass){
		return true;
	}
	
	public static void main(String[] args) {
		boolean login=true;
		CentroMedico centroMedico=new CentroMedico();
		Scanner entrada= new Scanner (System. in);
		int opc;
		

		//login= llamamos a el metodo login
		if(login==false){ //
			System.out.println("Usuario no valido");
			System.exit(0);
		}
		
		do
		{
				//se muestra por pantalla las diferentes opciones 
				System.out.println("   .............................................."+"\n");
				System.out.println("   :-:        C E N T R O  M E D I C O        :-:"+"\n");
				System.out.println("   :-:   >>>> L O S  L A U R E L E S <<<<     :-:"+"\n");
				System.out.println("   :-:  C O N T R O L  D E  P A C I E N T E S :-:"+"\n");
				System.out.println("   :-:........................................:-:"+"\n");
				System.out.println("   :-: 1.  Ingreso de datos                   :-:"+"\n");
				System.out.println("   :-: 2.  Informes                           :-:"+"\n");
				System.out.println("   :-: 3.  Salir                              :-:"+"\n");
				System.out.println("   .............................................."+"\n");
				System.out.println("   ....Elija la opcion deseada: ");
				
				//validar la opcion
				opc = entrada. nextInt();
				
				while(opc<1|| opc>3){
					System.out.println("opcion no valida. \n intentelo nuevamente.");
					//volver a mostrar la pantalla
					opc = entrada. nextInt();
				}
					
				switch (opc) {
				
				case 1://ingreso de datos
				{
					System.out.println("Ingreso a Datos");
					//limpiar pantalla
					
				     System.out.println("   ..............................................."+"\n");
				     System.out.println("   :-: -I N G R E S O  D E  P A C I E N T E S- :-:"+"\n");
				     System.out.println("   :-:.........................................:-:"+"\n");
				     System.out.println("   :-: 1.  Datos del paciente                  :-:"+"\n");
				     System.out.println("   :-: 2.  Situacion del paciente              :-:"+"\n");
				     System.out.println("   :-: 3.  Datos del medico                    :-:"+"\n");
				     System.out.println("   :-: 4.  Anterior                            :-:"+"\n");
				     System.out.println("   ..............................................."+"\n");
				     System.out.println("   ....Elija la opcion deseada: ");
				     
				     opc = entrada. nextInt();
				     
						while(opc<1|| opc>3){
							System.out.println("opcion no valida. \n intentelo nuevamente.");
							//volver a mostrar la pantalla
							opc = entrada. nextInt();
						}
						
				     switch (opc) {
				     
							case 1:{
								System.out.println("datos del paciente");
								//llamar a al metodo ingresar datos del paciente
								centroMedico.ingresarDatosPaciente();
							}
								
								break;
								
							case 2:{
								System.out.println("Situacion del paciente");
								//llamar a al metodo ingresar situacion del paciente: 
								centroMedico.ingresarSituacionDelPaciente();
							}
								
								break;
								
							case 3:{
								System.out.println("Datos del medico");
								centroMedico.ingresarDatosDelMedico();
								
							}
								
								break;
							case 4:{
								System.out.println("Anterior");
								
							}
				
							}
				     
				}
					break;
					
		
				case 2://informes //todo buscar en la base de datos(???)
				{
					System.out.println("Informes");
					//listado de pacientes por medico
					
					//enfermedades que atiende cada medico
				}
					break;
		
				}
	}while(opc!=3);
		
	}
	
	private void ingresarDatosPaciente() {
		//ingresar codigo del paciente 
	
	Scanner	entrada= new Scanner (System. in);
	String tipoSangre="", nombrePac="", fechaIngresoPac="", direPac="";
	int dniPac=0, codigoPac=0, telPac=0;
	
		
	System.out.println("   ..............................................."+"\n");
	System.out.println("   :-:  - D A T O S  D E L  P A C I E N T E -  :-:"+"\n");
	System.out.println("   :-:.........................................:-:"+"\n");
           
	System.out.println("Digite el codigo del paciente: ");
    codigoPac = entrada.nextInt();
    
    //escribir codigo en la base de datos.
    
    System.out.println("Digite el nombre del paciente: ");
    nombrePac = entrada.nextLine();
               
    //escribir nombre en la base de datos.
	
    //...asi con los demas atributos del paciente
    
    Paciente p= new Paciente(codigoPac, tipoSangre, dniPac, fechaIngresoPac, nombrePac, telPac, direPac); //genero un paciente con los datos ingresados.
    
	}
	
	private void ingresarSituacionDelPaciente() {
		// idem a metodo ingresarDatosPaciente()
		
	}

	private void ingresarDatosDelMedico() {
		// idem a metodo ingresarDatosPaciente()
		
	}

}
