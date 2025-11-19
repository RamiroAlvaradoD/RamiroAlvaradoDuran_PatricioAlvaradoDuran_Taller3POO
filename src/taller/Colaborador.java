package taller;
import sistema.MenuColab;

public class Colaborador extends Usuario {

	public Colaborador(String username, String password, String rol) {
		super(username, password, "Colaborador");
	}

	@Override
	public void mostrarMenu() {
		MenuColab menu = new MenuColab(this);
		menu.mostrarOpciones();
		
	}

}
