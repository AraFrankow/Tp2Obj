import java.util.LinkedList;

import javax.swing.JOptionPane;

public abstract class Usuario {
	private String nombre;
	private String dni;
	private String contrasenia;
	private static LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
	private static LinkedList<Cliente> clientes = new LinkedList<Cliente>();

	public Usuario(String nombre, String dni, String contrasenia) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.contrasenia = contrasenia;
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

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public static LinkedList<Usuario> getUsuarios() {
		return usuarios;
	}

	public static void setUsuarios(LinkedList<Usuario> usuarios) {
		Usuario.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", dni=" + dni + ", contrasenia=" + contrasenia + "]";
	}
	public static boolean Login(String nombre,String contrasenia) {
		for (Usuario usuario : usuarios) {
			if (usuario.getNombre().equals(nombre) && usuario.getContrasenia().equals(contrasenia)) {
				JOptionPane.showMessageDialog(null, "Ingresando...");
				return true;
			} 
		}
		return false;
	}
	public void Menu() {
			
	}
}
