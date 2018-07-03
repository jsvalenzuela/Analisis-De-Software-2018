package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entidades.Medico;
import utilities.Log;

public class MedicoRepository {

	private DBAccess dbAccess;

	public MedicoRepository() {
		this.dbAccess = new DBAccess();
		dbAccess.connect();
	}

	public boolean guardarMedico(Medico medico) {

		try {
			// Query para insert en BD
			PreparedStatement st = dbAccess.connect.prepareStatement(
					"insert into Medico(Codigo, Nombre, Telefono, Matricula,Especialidad) values (?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);

			st.setString(1, obtenerSiguienteCod());
			st.setString(2, medico.getNombre());
			st.setString(3, medico.getTelefono());
			st.setString(4, medico.getMatricula());
			st.setString(5, medico.getEspecialidad());

			st.execute();

			ResultSet rs = st.getGeneratedKeys();

			if (rs != null && rs.next()) {
				// Se inserto correctamente el medico
				int idMedico = rs.getInt(1);
				return true;
			}
			return false;

		} catch (SQLException e) {
			Log.getInstance().error(e.getSQLState());
			return false;
		}
	}

	public void borrarMedico(Medico medico) {
		try {
			PreparedStatement st = dbAccess.connect.prepareStatement("delete from Medico where codigo=?");
			st.setInt(1, medico.getCodigo());
			st.executeQuery();
		} catch (SQLException e) {
			Log.getInstance().error("Error borrarMedico: " + e.getMessage());
		}
	}

	public boolean existeMedico(String codigoMedico) {
		ResultSet result = null;
		try {
			PreparedStatement st = dbAccess.connect.prepareStatement("select * from Medico where Codigo = ? ");
			st.setString(1, codigoMedico);
			result = st.executeQuery();

			if (result.next()) {
				return true;
			}
			return false;

		} catch (SQLException e) {
			Log.getInstance().error(e.getMessage());
			return false;
		}
	}

	private String obtenerSiguienteCod() throws SQLException {
		PreparedStatement st = dbAccess.connect.prepareStatement("select max(codigo) as cant from Medico");
		ResultSet result = st.executeQuery();
		int cant = result.getInt("cant");
		cant++;
		result.close();
		st.close();
		return String.valueOf(cant);
	}

	public List<Medico> listadoMedicos(String filtro) {
		java.util.List<Medico> medicos = new java.util.ArrayList<Medico>();
		ResultSet result = null;
		Medico medico;
		try {

			PreparedStatement st = dbAccess.connect.prepareStatement("select * from Medico where Nombre like ?");
			st.setString(1, "%" + filtro + "%");
			result = st.executeQuery();

			while (result.next()) {
				medico = new Medico();
				medico.setCodigo(result.getInt("Codigo"));
				medico.setNombre(result.getString("Nombre"));
				medico.setTelefono(result.getString("Telefono"));
				medico.setEspecialidad(result.getString("Especialidad"));
				medico.setMatricula(result.getString("Matricula"));
				medicos.add(medico);

			}
			result.close();
			st.close();
		} catch (Exception e) {
			Log.getInstance().error("Error listadoMedicos: " + e.getMessage());
		}
		return medicos;
	}
}
