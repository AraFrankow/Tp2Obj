import java.util.LinkedList;

public abstract class Usuario {
	private String nombre;
	private String dni;
	private String contrasena;
	private static LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
	private static LinkedList<Cliente> clientes = new LinkedList<Cliente>();

	public Usuario(String nombre, String dni, String contrasena) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public static LinkedList<Usuario> getUsuarios() {
		return usuarios;
	}

	public static void setUsuarios(LinkedList<Usuario> usuarios) {
		Usuario.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", dni=" + dni + ", contrasena=" + contrasena + "]";
	}
	public static void Login(String nombre,String contrasena) {
		for (Usuario usuario : usuarios) {
			if (usuario.getNombre().equals(nombre) && usuario.getContrasena().equals(contrasena)) {
				//clientes.contains(usuario);
				//o puede ser admin
			} 
		}
	}
	public void Menu() {
		
	}

}
