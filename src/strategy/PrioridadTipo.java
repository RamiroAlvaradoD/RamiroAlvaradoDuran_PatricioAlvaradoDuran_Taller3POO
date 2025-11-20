package strategy;
import java.util.ArrayList;
import taller.Tarea;

public class PrioridadTipo implements PrioridadStrategy {

	@Override
	public void ordenar(ArrayList<Tarea> lista) {
		lista.sort((t1, t2) -> t1.getClass().getSimpleName().compareTo(t2.getClass().getSimpleName()));
		
		
	}

}
