package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import utilities.Log;

public class DBAccess {

	private String bdd = "Clinica.db";
	Connection connect;

	public void connect() {
		try {
			connect = DriverManager.getConnection("jdbc:sqlite:" + bdd);
			if (connect != null) {
				Log.getInstance().info("Conectado");
			}
		} catch (SQLException ex) {
			Log.getInstance().error("No se ha podido conectar a la base de datos\n" + ex.getMessage());
		}
	}

	public void close() {
		try {
			connect.close();
		} catch (SQLException e) {
			Log.getInstance().error("Error al cerrar conexion: " + e.getMessage());
		}
	}
}
