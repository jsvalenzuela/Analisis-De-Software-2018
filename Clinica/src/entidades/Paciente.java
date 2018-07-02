package entidades;

import java.util.Date;

public class Paciente {

	private int codigo;
	private int dni;
	private Date fechaIngreso;
	private String nombre;
	private String telefono;
	private String direccion;

	public Paciente(int codigo, int dni, Date fechaIngreso, String nombre, String telefono, String direccion) {
		this.codigo = codigo;
		this.dni = dni;
		this.fechaIngreso = fechaIngreso;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public Paciente() {
		// TODO Auto-generated constructor stub
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
