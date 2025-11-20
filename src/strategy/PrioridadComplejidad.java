package strategy;

import java.util.ArrayList;

import taller.Tarea;

public class PrioridadComplejidad implements PrioridadStrategy {

	@Override
	public void ordenar(ArrayList<Tarea> lista) {
		lista.sort((t1, t2) -> t1.getComplejidad().compareTo(t2.getComplejidad()));
		
	}

}
