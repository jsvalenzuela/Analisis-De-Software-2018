package clinica;

public class Paciente {

	private int codigoPac;
	private String tipoSangre;
	private int dniPac;
	private String fechaIngresoPac;
	private String nombrePac;
	private int telPac;
	private String direPac;
	private String numDir;
	
	public Paciente(int codigoPac,String tipoSangre,int dniPac,String fechaIngresoPac,String nombrePac,int telPac,String direPac){
		this.codigoPac=codigoPac;
		this.tipoSangre=tipoSangre;
		this.dniPac=dniPac;
		this.fechaIngresoPac=fechaIngresoPac;
		this.nombrePac=nombrePac;
		this.telPac=telPac;
		this.direPac=direPac;
	}
	public int getCodigo() {
		return codigoPac;
	}
	public void setCodigo(int codigo) {
		this.codigoPac = codigo;
	}
	public String getTipoSangre() {
		return tipoSangre;
	}
	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}
	public int getDni() {
		return dniPac;
	}
	public void setDni(int dni) {
		this.dniPac = dni;
	}
	public String getFechaIngreso() {
		return fechaIngresoPac;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngresoPac = fechaIngreso;
	}
	public String getNombre() {
		return nombrePac;
	}
	public void setNombre(String nombre) {
		this.nombrePac = nombre;
	}
	public int getTelefono() {
		return telPac;
	}
	public void setTelefono(int telefono) {
		this.telPac = telefono;
	}
	public String getDireccion() {
		return direPac;
	}
	public void setDireccion(String direccion) {
		this.direPac = direccion;
	}
	
	@Override
	public String toString() {
		return "" + codigoPac + " "
				+ tipoSangre + " " + dniPac + " "
				+ fechaIngresoPac + " "+ escribirNombre()+" "
				+ telPac +" "+ escribirDireccion()+" "+this.numDir;
	} 
	
	public String escribirNombre(){
		String[] datos;
		
		datos=this.nombrePac.split(" ");
		String nombre=datos[0];
		int i=1;
		while(i<datos.length){
			nombre+="-"+datos[i];
			i++;
		}
		return nombre;
	}
	
	public String escribirDireccion(){
		String[] datos;
		
		datos=this.direPac.split(" ");
		String nombre=datos[0];
		int i=1;
		while(i<datos.length-1){
			nombre+="-"+datos[i];
			i++;
		}
		this.numDir=datos[i];
		
		return nombre;
	}
	
}
