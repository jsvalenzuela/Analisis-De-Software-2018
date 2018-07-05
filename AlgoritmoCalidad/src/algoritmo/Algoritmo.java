package algoritmo;

import java.util.Hashtable;

import constantes.Constantes;

public class Algoritmo {
	private Hashtable<Integer, Double> valores;
	
	public Algoritmo() {
		this.valores = new Hashtable<>();
	}

	public Hashtable<Integer, Double> getValores() {
		return valores;
	}

	public void setValores(Integer hash, Double valor) {
		this.valores.put(hash, valor);
	}
	
	public Integer calcularResultadoFinal() {
		Double puntaje = calcularPuntajeAceptacion();
		
		if(puntaje.intValue() >= Constantes.MINIMO_SATISFACTORIO)
			return 1;
		
		if(puntaje.intValue() >= Constantes.MIN_ACEPTABLE && puntaje.intValue() <= Constantes.MAX_ACEPTABLE)
			return 2;
		
		return 3;
	}
	
	public Double calcularPuntajeAceptacion() {
		Double puntajeTotal = 0.00;
		
		for (int i = 0; i < valores.size(); i++) {
			puntajeTotal += this.valores.get(new Integer(i));
		}
		
		return puntajeTotal;
	}
	
	

}
