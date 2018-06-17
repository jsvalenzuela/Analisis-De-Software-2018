package metricas;

import java.util.List;

import principal.Metodo;
import principal.Nombrable;

public class CantidadLineas implements Metrica, Nombrable {
	
	private Integer cantidadLineas;
	
	public String getNombre() {
		return "Cantidad de lineas";
	}

	public void calcular(Metodo metodo) {
		List<String> codigo = metodo.getCodigo();
		this.cantidadLineas = codigo.size();
	}

	public ResultadoMetrica obtenerResultado() {
		return new ResultadoMetrica( this.getNombre(), this.cantidadLineas.toString() );
	}
}
