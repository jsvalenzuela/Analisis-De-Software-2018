package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entidades.Paciente;
import utilities.Log;

public class PacienteRepository {

	private DBAccess dbAccess;

	public PacienteRepository() {
		this.dbAccess = new DBAccess();
		dbAccess.connect();
	}

	public boolean guardarPaciente(Paciente paciente) {

		try {
			// Query para insert en BD
			PreparedStatement st = dbAccess.connect.prepareStatement(
					"insert into Paciente( Codigo,Dni, Nombre,Telefono, Direccion,TipoSangre) values (?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			st.setString(1, obtenerSiguienteCod());
			st.setString(2, paciente.getDni());
			st.setString(3, paciente.getNombre());
			st.setString(4, paciente.getTelefono());
			st.setString(5, paciente.getDireccion());
			st.setString(6, paciente.getTipoSangre());

			st.execute();

			ResultSet rs = st.getGeneratedKeys();

			if (rs != null && rs.next()) {
				// Se inserto correctamente el medico
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

	public java.util.List<Paciente> listadoPacientes(String filtro) {
		java.util.List<Paciente> pacientes = new java.util.ArrayList<Paciente>();
		ResultSet result = null;
		Paciente paciente;
		try {

			PreparedStatement st = dbAccess.connect.prepareStatement("select * from Paciente where Nombre like ?");
			st.setString(1, "%" + filtro + "%");
			result = st.executeQuery();

			while (result.next()) {
				paciente = new Paciente();
				paciente.setCodigo(result.getInt("Codigo"));
				paciente.setDni(result.getString("Dni"));
				paciente.setNombre(result.getString("Nombre"));
				paciente.setTelefono(result.getString("Telefono"));
				paciente.setDireccion(result.getString("Direccion"));
				paciente.setTipoSangre(result.getString("TipoSangre"));
				pacientes.add(paciente);
			}
			result.close();
			st.close();
		} catch (Exception e) {
			Log.getInstance().error("Error listadoPacientes: " + e.getMessage());
		}
		return pacientes;
	}

	private String obtenerSiguienteCod() throws SQLException {
		PreparedStatement st = dbAccess.connect.prepareStatement("select max(codigo) as cant from Paciente");
		ResultSet result = st.executeQuery();
		int cant = result.getInt("cant");
		cant++;
		result.close();
		st.close();
		return String.valueOf(cant);
	}

	public String obtenerNombrePaciente(String idPaciente) {
		ResultSet result = null;
		try {
			PreparedStatement st = dbAccess.connect.prepareStatement("select * from Paciente where Codigo = ? ");
			st.setString(1, idPaciente);
			result = st.executeQuery();

			if (result != null && result.next()) {
				return result.getString("Nombre");
			}
		} catch (SQLException e) {
			Log.getInstance().error(e.getMessage());
		}
		return idPaciente;
	}
}
