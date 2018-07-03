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
					"insert into Paciente( Codigo,Dni, FechaIngreso, Nombre,Telefono, Direccion,TipoSangre) values (?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);

			java.sql.Date fechaing = new java.sql.Date(paciente.getFechaIngreso().getTime().getTime());
			st.setString(1, obtenerSiguienteCod());
			st.setString(2, paciente.getDni());
			st.setDate(3, fechaing);
			st.setString(4, paciente.getNombre());
			st.setString(5, paciente.getTelefono());
			st.setString(6, paciente.getDireccion());
			st.setString(7, paciente.getTipoSangre());

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

	public java.util.List<Paciente> listadoPacientes() {
		java.util.List<Paciente> pacientes = new java.util.ArrayList<Paciente>();
		ResultSet result = null;
		Paciente paciente;
		try {

			PreparedStatement st = dbAccess.connect.prepareStatement("select * from Paciente");
			result = st.executeQuery();

			while (result.next()) {
				paciente = new Paciente();
				paciente.setCodigo(result.getInt("Codigo"));
				paciente.setDni(result.getString("Dni"));
				paciente.setFechaIngreso(result.getDate("fechaIngreso"));
				paciente.setNombre(result.getString("Nombre"));
				paciente.setTelefono(result.getString("Telefono"));
				paciente.setDireccion(result.getString("Direccion"));
				paciente.setTipoSangre(result.getString("TipoSangre"));
				pacientes.add(paciente);
			}
			result.close();
			st.close();
			dbAccess.close();
		} catch (Exception e) {
			Log.getInstance().error("Error listadoPacientes: " + e.getMessage());
		}
		return pacientes;
	}

	private String obtenerSiguienteCod() throws SQLException {
		PreparedStatement st = dbAccess.connect.prepareStatement("select count(*) as cant from Paciente");
		ResultSet result = st.executeQuery();
		int cant = result.getInt("cant");
		cant++;
		result.close();
		st.close();
		return String.valueOf(cant);
	}

}
