package taller;

public abstract class Usuario {
	protected String username;
	protected String password;
	protected String rol;
	
	public Usuario(String username, String password, String rol) {
		this.username = username;
		this.password = password;
		this.rol = rol;
	}

	public String getUsername() {
		return username;
	}

	public String getRol() {
		return rol;
	}
	
	public abstract void mostrarMenu();
	

}
