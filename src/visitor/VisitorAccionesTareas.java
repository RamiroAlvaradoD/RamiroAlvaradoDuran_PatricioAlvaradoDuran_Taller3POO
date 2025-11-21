package visitor;

import taller.Bug;
import taller.Documentacion;
import taller.Feature;

public class VisitorAccionesTareas implements TareaVisitor {

	@Override
	public void visitar(Bug b) {
		System.out.println("Visitando BUG: "+b.getDescripcion() + " - Estado: " + b.getEstado() +
		" - Complejidad: " + b.getComplejidad() + " - Responsable: " + b.getResponsable());
		
	}

	@Override
	public void visitar(Feature f) {
		System.out.println("Visitando FEATURE: "+f.getDescripcion() + " - Estado: " + f.getEstado() +
		" - Fecha limite: " + f.getFecha() + " - Responsable: " + f.getResponsable());
		
	}

	@Override
	public void visitar(Documentacion d) {
		System.out.println("Visitando DOCUMENTACIÓN: "+d.getDescripcion( ) + " - Estado: " + d.getEstado() +
				" - Entregar antes de: " + d.getFecha());
		
	}
	

}
