package visitor;
import taller.Bug;
import taller.Documentacion;
import taller.Feature;

public interface TareaVisitor {
	public void visitar(Bug b);
	public void visitar(Feature f);
	public void visitar(Documentacion d);

}
