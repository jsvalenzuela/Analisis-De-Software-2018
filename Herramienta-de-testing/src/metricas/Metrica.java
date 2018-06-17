package metricas;

import principal.Metodo;

public interface Metrica {

	public void calcular(Metodo metodo);
	public ResultadoMetrica obtenerResultado();
	
}
