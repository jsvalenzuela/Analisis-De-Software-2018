package clinica;

public class Medico {

	private int codigoMed;
	private String matricula;
	private String nombreMed;
	private String [] enfermedades; //Lista de todas las enfermedades que trata el medico
	private String fechaIngresoMed;
	private String telMed;
	
	
	public Medico(int codigoMed, String matricula, String nombreMed, String [] especialidad, String fechaIngresoMed, String telMed) {
		this.codigoMed = codigoMed;
		this.matricula = matricula;
		this.nombreMed = nombreMed;
		this.enfermedades = especialidad;
		this.fechaIngresoMed = fechaIngresoMed;
		this.telMed = telMed;
	}
	
	public int getCodigoMed() {
		return codigoMed;
	}
	public void setCodigoMed(int codigoMed) {
		this.codigoMed = codigoMed;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNombreMed() {
		return nombreMed;
	}
	public void setNombreMed(String nombreMed) {
		this.nombreMed = nombreMed;
	}
	public String [] getEspecialidad() {
		return enfermedades;
	}
	public void setEspecialidad(String [] especialidad) {
		this.enfermedades = especialidad;
	}
	public String getFechaIngresoMed() {
		return fechaIngresoMed;
	}
	public void setFechaIngresoMed(String fechaIngresoMed) {
		this.fechaIngresoMed = fechaIngresoMed;
	}
	public String getTelMed() {
		return telMed;
	}
	public void setTelMed(String telMed) {
		this.telMed = telMed;
	}

	@Override
	public String toString() {
		return  "" + codigoMed  + " " + matricula
				+ " "+escribirNombre()
				+ " "+escribirEnfermedades() + " "
				+ fechaIngresoMed + " " + telMed;
	}
	
	public String escribirNombre(){
		String[] datos;
		
		datos=this.nombreMed.split(" ");
		String nombre=datos[0];
		int i=1;
		while(i<datos.length){
			nombre+="-"+datos[i];
			i++;
		}
		return nombre;
	}
	
	public String escribirEnfermedades(){
		String enfer=enfermedades[0];
		int i=1;
		while(i<enfermedades.length){
			
			if (!(enfermedades[i].equals(" "))) {
				enfer+="-"+enfermedades[i];
			}
				
			i++;
		}
		return enfer;
	}
	
}
