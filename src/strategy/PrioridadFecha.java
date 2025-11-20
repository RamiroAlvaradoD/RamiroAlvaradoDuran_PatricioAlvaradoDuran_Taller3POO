package strategy;
import taller.Tarea;
import java.util.ArrayList;

public class PrioridadFecha implements PrioridadStrategy {
	
	@Override 
	public void ordenar(ArrayList <Tarea> lista) {
		lista.sort((t1, t2) -> t1.getFecha().compareTo(t2.getFecha()));
		
	}

}
