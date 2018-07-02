package entidades;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import utilities.Log;

public class Usuario {

	private String nombreUsuario;
	private String password;

	public Usuario(String nombreUsuario, String password) {
		this.nombreUsuario = nombreUsuario;
		hashPassword(password);
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		hashPassword(password);
	}
	
	private void hashPassword(String pas) {
		String passwordToHash = pas;
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(passwordToHash.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			Log.getInstance().error("Error en hashPassword "+e.getMessage());
		}
		this.password = generatedPassword;
	}
}
