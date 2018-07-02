package data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Paciente;
import utilities.Log;

public class PacienteRepository {

	private DBAccess dbAccess;

	public PacienteRepository() {
		this.dbAccess = new DBAccess();

	}

	public boolean guardarPaciente(Paciente paciente) {

		try {
			// Query para insert en BD
			PreparedStatement st = dbAccess.connect.prepareStatement(
					"insert into Paciente( Codigo,Dni, FechaIngreso, Nombre,Telefono, Direccion) values (?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);

			st.setString(1, obtenerSiguienteCod());
			st.setString(2, paciente.getDni());
			st.setDate(3, (Date) paciente.getFechaIngreso().getTime());
			st.setString(4, paciente.getNombre());
			st.setString(5, paciente.getTelefono());
			st.setString(6, paciente.getDireccion());

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

	public ArrayList<Paciente> listadoPacientes() {
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
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
				paciente.setNombre(result.getString("nombre"));
				paciente.setTelefono(result.getString("Telefono"));
				paciente.setDireccion(result.getString("direccion"));
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
