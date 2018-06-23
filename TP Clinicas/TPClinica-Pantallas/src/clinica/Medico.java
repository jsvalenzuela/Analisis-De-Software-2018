package clinica;

import java.util.ArrayList;

public class Medico {

	private int codigoMed;
	private String matricula;
	private String nombreMed;
	private ArrayList <String> enfermedades; //Lista de todas las enfermedades que trata el medico
	private String fechaIngresoMed;
	private int telMed;
	
	
	public Medico(int codigoMed, String matricula, String nombreMed, ArrayList<String> especialidad, String fechaIngresoMed, int telMed) {
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
	public ArrayList<String> getEspecialidad() {
		return enfermedades;
	}
	public void setEspecialidad(ArrayList<String> especialidad) {
		this.enfermedades = especialidad;
	}
	public String getFechaIngresoMed() {
		return fechaIngresoMed;
	}
	public void setFechaIngresoMed(String fechaIngresoMed) {
		this.fechaIngresoMed = fechaIngresoMed;
	}
	public int getTelMed() {
		return telMed;
	}
	public void setTelMed(int telMed) {
		this.telMed = telMed;
	}
	
	
}
