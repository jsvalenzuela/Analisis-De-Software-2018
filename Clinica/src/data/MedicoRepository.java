package data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Medico;
import utilities.Log;

public class MedicoRepository {

	private DBAccess dbAccess;

	public MedicoRepository() {
		this.dbAccess = new DBAccess();
	}

	public boolean insertarMedico(Medico medico) {

		try {
			// Query para insert en BD
			PreparedStatement st = dbAccess.connect.prepareStatement(
					"insert into Medico( Nombre, Telefono, FechaIngreso, " + "Matricula) values (?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);

			st.setString(1, medico.getNombre());
			st.setInt(2, medico.getTelefono());
			st.setDate(3, (Date) medico.getFechaIngreso());
			st.setString(4, medico.getMatricula());

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
}
