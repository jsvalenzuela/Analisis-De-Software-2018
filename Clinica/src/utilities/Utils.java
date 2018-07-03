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
		Pattern p = Pattern.compile("(\\w(\\s)?)+");
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

	public static void esNumeroValido(String value) {
		if (!Utils.validarNumero(value)) {
			JOptionPane.showMessageDialog(null, "Ingrese un numero válido.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void esTextoValido(String text) {
		if (!Utils.validarTexto(text)) {
			JOptionPane.showMessageDialog(null, "Solo se aceptan caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
