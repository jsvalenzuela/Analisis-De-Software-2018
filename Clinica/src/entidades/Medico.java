package entidades;

public class Medico {

	private int codigo;
	private String matricula;
	private String nombre;
	private String telefono;
	private String especialidad;

	public Medico(String especialidad, String nombre, String telefono, String matricula) {
		this.matricula = matricula;
		this.nombre = nombre;
		this.telefono = telefono;
		this.especialidad = especialidad;
	}

	public Medico() {
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return nombre;
	}
}
