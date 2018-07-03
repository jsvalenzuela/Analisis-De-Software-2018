package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Usuario;
import utilities.Log;

public class UsuarioRepository {

	private DBAccess dbAccess;

	public UsuarioRepository() {
		this.dbAccess = new DBAccess();
		dbAccess.connect();
	}

	public boolean loguearUsuario(Usuario user) {
		ResultSet result = null;
		try {

			PreparedStatement st = dbAccess.connect
					.prepareStatement("select * from USUARIO where Usuario = ? AND Contrasena = ? ");
			st.setString(1, user.getNombreUsuario().toUpperCase());
			st.setString(2, user.getPassword());
			result = st.executeQuery();

			if (result.next()) {
				result.close();
				st.close();
				return true;
			}
			result.close();
			st.close();
			return false;

		} catch (SQLException e) {
			Log.getInstance().error(e.getMessage());
			return false;
		}
	}

	public boolean registrarUsuario(Usuario user) {
		ResultSet result = null;

		try {
			PreparedStatement st1 = dbAccess.connect.prepareStatement("select * from USUARIO where Usuario= ?");
			st1.setString(1, user.getNombreUsuario().toUpperCase());
			result = st1.executeQuery();

			if (!result.next()) {

				// 1) INSERTO EL USUARIO
				PreparedStatement st = dbAccess.connect
						.prepareStatement("insert into USUARIO (Codigo,Usuario, Contrasena) values (?,?,?)");
				st.setString(1, obtenerSiguienteCod());
				st.setString(2, user.getNombreUsuario().toUpperCase());
				st.setString(3, user.getPassword());
				st.execute();
				ResultSet rs = st.getGeneratedKeys();
				if (rs != null) {
					rs.close();
					st.close();
					return true;

				}
			}
			return false;
		} catch (SQLException e) {
			Log.getInstance().error("Error al registrar usuario: " + e.getMessage());
			return false;
		}
	}

	private String obtenerSiguienteCod() throws SQLException {
		PreparedStatement st = dbAccess.connect.prepareStatement("select max(codigo) as cant from USUARIO");
		ResultSet result = st.executeQuery();
		int cant = result.getInt("cant");
		cant++;
		result.close();
		st.close();
		return String.valueOf(cant);
	}

	public boolean existeUsuario(Usuario user) {
		ResultSet result = null;
		try {
			PreparedStatement st = dbAccess.connect.prepareStatement("select * from USUARIO where Usuario = ? ");
			st.setString(1, user.getNombreUsuario().toUpperCase());
			result = st.executeQuery();
			if (result.next()) {
				st.close();
				result.close();
				return true;
			}
			st.close();
			result.close();
			return false;

		} catch (SQLException e) {
			Log.getInstance().error(e.getMessage());
			return false;
		}
	}
}
