package utilities;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import java.util.Calendar;

public class Utils {

	public static Calendar toCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	public static boolean validarTexto(String text) {
		Pattern p = Pattern.compile("^[_A-z]*((-|\\s)*[_A-z])*$");
		Matcher m = p.matcher(text);
		if (m.find())
			return true;
		return false;
	}

	public static boolean validarNumero(String numero) {
		Pattern p = Pattern.compile("^[0-9]+$");
		Matcher m = p.matcher(numero);
		if (m.find())
			return true;
		return false;
	}

	public static boolean esNumeroValido(String value, String campo) {
		if (!Utils.validarNumero(value)) {
			JOptionPane.showMessageDialog(null, campo +" solo acepta números.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public static boolean esTextoValido(String text,String campo) {
		if (!Utils.validarTexto(text)) {
			JOptionPane.showMessageDialog(null, campo + " solo se aceptan caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public static String obtenerUrlAyuda() {
		return "Ayuda.chm";
	}

}
