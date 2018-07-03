package entidades;

public class Diagnostico {

	private String codigo;
	private String idPaciente;
	private String idMedico;
	private String diagnostico;

	public Diagnostico() {

	}

	public Diagnostico(String idPaciente, String idMedico, String diagnostico) {
		this.idPaciente = idPaciente;
		this.idMedico = idMedico;
		this.diagnostico = diagnostico;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(String idMedico) {
		this.idMedico = idMedico;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

}
