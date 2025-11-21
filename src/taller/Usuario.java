package taller;

/**
 * Clase abstracta que representa a un usuario del sistema. Un usuario posee un
 * nombre de usuario, contraseña y rol.
 * 
 * Esta clase es la base para los tipos de usuario: - Administrador -
 * Colaborador
 * 
 * Cada subclase debe implementar su propio menú mediante el método
 * mostrarMenu().
 * 
 * @author Ramiro Alvarado - Patricio Alvarado
 */
public abstract class Usuario {

	/** Nombre de usuario para iniciar sesión */
	protected String username;

	/** Contraseña del usuario */
	protected String password;

	/** Rol del usuario (Administrador o Colaborador) */
	protected String rol;

	/**
	 * Constructor base para un usuario del sistema.
	 * 
	 * @param username nombre del usuario
	 * @param password contraseña asociada
	 * @param rol      rol del usuario dentro del sistema
	 */
	public Usuario(String username, String password, String rol) {
		this.username = username;
		this.password = password;
		this.rol = rol;
	}

	/**
	 * Obtiene el nombre del usuario.
	 * 
	 * @return username
	 */
	
	public String getUsername() {
		return username;
	}

	/**
	 * Obtiene el rol del usuario.
	 * 
	 * @return rol
	 */
	public String getRol() {
		return rol;
	}

	/**
     * Obtiene la contraseña del usuario.
     * 
     * @return password
     */
	public String getPassword() {
		return password;
	}

	/**
     * Método abstracto que cada tipo de usuario debe implementar
     * para mostrar su menú correspondiente.
     */
	public abstract void mostrarMenu();

}
