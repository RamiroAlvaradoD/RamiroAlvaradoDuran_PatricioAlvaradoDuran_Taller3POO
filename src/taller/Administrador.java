package taller;
import sistema.MenuAdmin;

public class Administrador extends Usuario {

	public Administrador(String username, String password, String rol) {
		super(username, password, "Administrador");
	}

	@Override
	public void mostrarMenu() {
		MenuAdmin menu = new MenuAdmin(this);
		menu.mostrarOpciones();
		
	}

}
