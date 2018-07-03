package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Diagnostico;
import utilities.Log;

public class DiagnosticoRepository {

	private DBAccess dbAccess;

	public DiagnosticoRepository() {
		this.dbAccess = new DBAccess();
		dbAccess.connect();
	}

	public boolean guardarDiagnostico(Diagnostico diagnostico) {

		try {
			// Query para insert en BD
			PreparedStatement st = dbAccess.connect.prepareStatement(
					"insert into Diagnostico( Codigo,IdPaciente,IdMedico,Diagnostico) values (?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);

			st.setString(1, obtenerSiguienteCod());
			st.setString(2, diagnostico.getIdPaciente());
			st.setString(3, diagnostico.getIdMedico());
			st.setString(4, diagnostico.getDiagnostico());

			st.execute();

			ResultSet rs = st.getGeneratedKeys();

			if (rs != null && rs.next()) {
				// Se inserto correctamente el medico
				int id = rs.getInt(1);
				rs.close();
				st.close();
				return true;
			}
			rs.close();
			st.close();
			dbAccess.close();
			return false;

		} catch (SQLException e) {
			Log.getInstance().error(e.getSQLState());
			return false;
		}
	}

	public java.util.List<Diagnostico> listadoDiagnosticoMedico(String codMedico) {
		java.util.List<Diagnostico> diagnosticos = new java.util.ArrayList<Diagnostico>();
		ResultSet result = null;
		Diagnostico diagnostico;
		try {

			PreparedStatement st = dbAccess.connect.prepareStatement("select * from Diagnostico where IdMedico=?");
			st.setString(1, codMedico);
			result = st.executeQuery();

			while (result.next()) {
				diagnostico = new Diagnostico();
				diagnostico.setCodigo(result.getString("Codigo"));
				diagnostico.setIdPaciente(result.getString("IdPaciente"));
				diagnostico.setIdMedico(result.getString("IdMedico"));
				diagnostico.setDiagnostico(result.getString("Diagnostico"));
				diagnosticos.add(diagnostico);
			}
			result.close();
			st.close();
		} catch (Exception e) {
			Log.getInstance().error("Error listadoDiagnosticoMedico: " + e.getMessage());
		}
		return diagnosticos;
	}

	private String obtenerSiguienteCod() throws SQLException {
		PreparedStatement st = dbAccess.connect.prepareStatement("select max(codigo) as cant from Diagnostico");
		ResultSet result = st.executeQuery();
		int cant = result.getInt("cant");
		cant++;
		result.close();
		st.close();
		return String.valueOf(cant);
	}

}
