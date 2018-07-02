package entidades;

import java.util.Calendar;
import java.util.Date;

import utilities.Utils;

public class Paciente {

	private int codigo;
	private String dni;
	private Calendar fechaIngreso;
	private String nombre;
	private String telefono;
	private String direccion;
	private String tipoSangre;
	private String dia;
	private String mes;
	private String anio;

	public Paciente(String dni, Calendar fechaIngreso, String nombre, String telefono, String direccion,
			String tipoDeSangre) {
		this.dni = dni;
		this.fechaIngreso = fechaIngreso;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.tipoSangre = tipoSangre;

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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = Utils.toCalendar(fechaIngreso);
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

	public String getTipoSangre() {
		return tipoSangre;
	}

	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}

	public boolean validaCampos() {
		dia = Integer.toString(this.fechaIngreso.get(java.util.Calendar.DATE));
		mes = Integer.toString(this.fechaIngreso.get(java.util.Calendar.MONTH) + 1);
		anio = Integer.toString(this.fechaIngreso.get(java.util.Calendar.YEAR));

		return !this.nombre.isEmpty() || !this.telefono.isEmpty() || !this.tipoSangre.isEmpty()
				|| !this.direccion.isEmpty() || !dia.isEmpty() || !mes.isEmpty() || !anio.isEmpty();
	}
}