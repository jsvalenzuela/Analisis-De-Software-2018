package clinica;

public class Diagnostico {

	private int codPaciente;
	private int codMedico;
	private String descripcion;
	private String fecha;
	private String hora;
	
	public Diagnostico(int codPaciente, int codMedico, String descripcion, String fecha, String hora) {
		this.codPaciente = codPaciente;
		this.codMedico = codMedico;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.hora = hora;
	}
	
	
	public int getCodPaciente() {
		return codPaciente;
	}
	public void setCodPaciente(int codPaciente) {
		this.codPaciente = codPaciente;
	}
	public int getCodMedico() {
		return codMedico;
	}
	public void setCodMedico(int codMedico) {
		this.codMedico = codMedico;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
	
}
