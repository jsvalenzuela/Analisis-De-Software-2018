package entidades;

import java.util.Date;

public class Medico {

	private int codigo;
	private String matricula;
	private String nombre;
	private Date fechaIngreso;
	private int telefono;

	public Medico(int codigo, String matricula, String nombre, Date fechaIngreso, int telefono) {
		this.codigo = codigo;
		this.matricula = matricula;
		this.nombre = nombre;
		this.fechaIngreso = fechaIngreso;
		this.telefono = telefono;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

}
