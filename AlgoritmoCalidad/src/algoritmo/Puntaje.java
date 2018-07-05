package algoritmo;

import constantes.Constantes;

public class Puntaje {
	private Algoritmo algoritmo;
	
	public Puntaje() {
		this.algoritmo = new Algoritmo();
	}

	public void calcularPuntajeEficiencia(Integer valorUtilizacionRecursos, Integer valorComportamientoTiempo) {
		Integer puntajeRecursos;
		Integer puntajeComportamiento;
		Double valorUno;
		Double valorDos;
		
		if(valorUtilizacionRecursos.equals(new Integer(2))) {
			puntajeRecursos = Constantes.BUENA;
		} else {
			if(valorUtilizacionRecursos.equals(new Integer(0))) {
				puntajeRecursos = Constantes.MALA;
			} else {
				puntajeRecursos = Constantes.REGULAR;
			}
		}
		
		if(valorComportamientoTiempo.equals(new Integer(2))) {
			puntajeComportamiento = Constantes.BUENA;
		} else {
			if(valorComportamientoTiempo.equals(new Integer(0))) {
				puntajeComportamiento = Constantes.MALA;
			} else {
				puntajeComportamiento = Constantes.REGULAR;
			}
		}
		
		valorUno = ((puntajeRecursos.doubleValue()/Constantes.BUENA) * Constantes.PONDERACION_EFICIENCIA); // MAX 3;
		valorDos = ((puntajeComportamiento.doubleValue()/Constantes.BUENA) * Constantes.PONDERACION_EFICIENCIA); // MAX 3;
		
		algoritmo.setValores(Constantes.POSICION_EFICIENCIA, (valorUno+valorDos));
	}
	
	public void calcularPuntajeUsabilidad(Integer valorCapacidadEntendido, Integer valorCapacidadOperado, Integer valorCapacidadAtractivo) {
		Integer puntajeEntendido;
		Integer puntajeOperado;
		Integer puntajeAtractivo;
		Double valorUno;
		Double valorDos;
		Double valorTres;
		
		if(valorCapacidadEntendido.equals(new Integer(2))) {
			puntajeEntendido = Constantes.BUENA;
		} else {
			if(valorCapacidadEntendido.equals(new Integer(0))) {
				puntajeEntendido = Constantes.MALA;
			} else {
				puntajeEntendido = Constantes.REGULAR;
			}
		}
		
		if(valorCapacidadOperado.equals(new Integer(2))) {
			puntajeOperado = Constantes.BUENA;
		} else {
			if(valorCapacidadOperado.equals(new Integer(0))) {
				puntajeOperado = Constantes.MALA;
			} else {
				puntajeOperado = Constantes.REGULAR;
			}
		}
		
		if(valorCapacidadAtractivo.equals(new Integer(2))) {
			puntajeAtractivo = Constantes.BUENA;
		} else {
			if(valorCapacidadAtractivo.equals(new Integer(0))) {
				puntajeAtractivo = Constantes.MALA;
			} else {
				puntajeAtractivo = Constantes.REGULAR;
			}
		}
		
		valorUno = ((puntajeEntendido.doubleValue()/Constantes.BUENA) * Constantes.PONDERACION_USABILIDAD); // MAX 4;
		valorDos = ((puntajeOperado.doubleValue()/Constantes.BUENA) * Constantes.PONDERACION_USABILIDAD); // MAX 4;
		valorTres = ((puntajeAtractivo.doubleValue()/Constantes.BUENA) * Constantes.PONDERACION_USABILIDAD); // MAX 4;
		
		algoritmo.setValores(Constantes.POSICION_USABILIDAD, (valorUno+valorDos+valorTres));
	}
	
	public void calcularPuntajeFuncionabilidad(Integer valorSeguridadAcceso, Integer valorExactitudResultado) {
		Integer puntajeSeguridad;
		Integer puntajeExactitud;
		Double valorUno;
		Double valorDos;
		
		if(valorSeguridadAcceso.equals(new Integer(2))) {
			puntajeSeguridad = Constantes.BUENA;
		} else {
			if(valorSeguridadAcceso.equals(new Integer(0))) {
				puntajeSeguridad = Constantes.MALA;
			} else {
				puntajeSeguridad = Constantes.REGULAR;
			}
		}
			
		if(valorExactitudResultado.equals(new Integer(2))) {
			puntajeExactitud = Constantes.BUENA + 1;
		} else {
			if(valorExactitudResultado.equals(new Integer(0))) {
				puntajeExactitud = Constantes.MALA;
			} else {
				puntajeExactitud = Constantes.REGULAR;
			}
		}
		
		valorUno = ((puntajeSeguridad.doubleValue()/Constantes.BUENA) * Constantes.PONDERACION_FUNCIONABILIDAD); // MAX 7
		valorDos = ((puntajeExactitud.doubleValue()/Constantes.BUENA) * Constantes.PONDERACION_FUNCIONABILIDAD); // MAX 7
		
		algoritmo.setValores(Constantes.POSICION_FUNCIONALIDAD, (valorUno+valorDos));
	}
	
	public void calcularPuntajeFiabilidad(Integer valorToleranciaFallos, Integer valorRecuperacionErrores) {
		Integer puntajeFallos;
		Integer puntajeRecuperacion;
		Double valorUno;
		Double valorDos;
		
		if(valorToleranciaFallos.equals(new Integer(3))) {
			puntajeFallos = Constantes.BUENA + 1;
		} else {
			if(valorToleranciaFallos.equals(new Integer(0))) {
				puntajeFallos = Constantes.MALA;
			} else {
				if(valorToleranciaFallos.equals(new Integer(0))) {
					puntajeFallos = Constantes.REGULAR +1;
				} else {
					puntajeFallos = Constantes.REGULAR;
				}
			}
		}
		
		if(valorRecuperacionErrores.equals(new Integer(2))) {
			puntajeRecuperacion = Constantes.BUENA;
		} else {
			if(valorRecuperacionErrores.equals(new Integer(0))) {
				puntajeRecuperacion = Constantes.MALA;
			} else {
				puntajeRecuperacion = Constantes.REGULAR;
			}
		}
		
		valorUno = ((puntajeFallos.doubleValue()/(Constantes.BUENA + 1)) * Constantes.PONDERACION_FIABILIDAD); //MAX 6
		valorDos = ((puntajeRecuperacion.doubleValue()/Constantes.BUENA) * Constantes.PONDERACION_FIABILIDAD); //MAX 6
		
		algoritmo.setValores(Constantes.POSICION_FIABILIDAD, (valorUno+valorDos));
		
	}
	
	public void calcularPuntajeMantenibilidad(Integer valorCodigoAnalizado, Integer valorCodigoCambiado, Integer valorEstabilidad) {
		Integer puntajeCodigo;
		Integer puntajeCambiado;
		Integer puntajeEstabilidad;
		Double valorUno;
		Double valorDos;
		Double valorTres;
		
		if(valorCodigoAnalizado.equals(new Integer(2))) {
			puntajeCodigo = Constantes.BUENA + 1;
		} else {
			if(valorCodigoAnalizado.equals(new Integer(0))) {
				puntajeCodigo = Constantes.MALA;
			} else {
				puntajeCodigo = Constantes.REGULAR;
			}
		}
		
		if(valorCodigoCambiado.equals(new Integer(2))) {
			puntajeCambiado = Constantes.BUENA;
		} else {
			if(valorCodigoCambiado.equals(new Integer(0))) {
				puntajeCambiado = Constantes.MALA;
			} else {
				puntajeCambiado = Constantes.REGULAR;
			}
		}
		
		if(valorEstabilidad.equals(new Integer(2))) {
			puntajeEstabilidad = Constantes.BUENA + 1;
		} else {
			if(valorEstabilidad.equals(new Integer(0))) {
				puntajeEstabilidad = Constantes.MALA;
			} else {
				puntajeEstabilidad = Constantes.REGULAR;
			}
		}
		
		valorUno = ((puntajeCodigo.doubleValue()/(Constantes.BUENA + 1)) * Constantes.PONDERACION_MANTENIBILIDAD); //MAX 5
		valorDos = ((puntajeCambiado.doubleValue()/Constantes.BUENA) * Constantes.PONDERACION_MANTENIBILIDAD); //MAX 5
		valorTres = ((puntajeEstabilidad.doubleValue()/(Constantes.BUENA + 1)) * Constantes.PONDERACION_MANTENIBILIDAD); //MAX 5
		
		algoritmo.setValores(Constantes.POSICION_MANTENIBILIDAD, (valorUno+valorDos+valorTres));
	}
	
	public void calcularPuntajePortabilidad(Integer valorAdaptabilidad, Integer valorInstabilidad) {
		Integer puntajeAdaptabilidad;
		Integer puntajeInstabilidad;
		Double valorUno;
		Double valorDos;
		
		if(valorAdaptabilidad.intValue() >= 3) {
			puntajeAdaptabilidad = Constantes.BUENA;
		} else {
			if(valorAdaptabilidad.intValue() == 1) {
				puntajeAdaptabilidad = Constantes.MALA;
			} else {
				puntajeAdaptabilidad = Constantes.REGULAR;
			}
		}
		
		if(valorInstabilidad.equals(new Integer(2))) {
			puntajeInstabilidad = Constantes.BUENA;
		} else {
			if(valorInstabilidad.equals(new Integer(0))) {
				puntajeInstabilidad = Constantes.MALA;
			} else {
				puntajeInstabilidad = Constantes.REGULAR;
			}
		}
		
		valorUno = ((puntajeAdaptabilidad.doubleValue()/Constantes.BUENA) * Constantes.PONDERACION_PORTABILIDAD); //MAX 2
		valorDos = ((puntajeInstabilidad.doubleValue()/Constantes.BUENA) * Constantes.PONDERACION_PORTABILIDAD); //MAX 2
		
		algoritmo.setValores(Constantes.POSICION_PORTABILIDAD, (valorUno+valorDos));
	}

	public Algoritmo getAlgoritmo() {
		return algoritmo;
	}
}

