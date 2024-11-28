import java.util.LinkedList;

import javax.swing.JOptionPane;

public abstract class Usuario {
	private String nombre;
	private String dni;
	private String contrasenia;
	protected static LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
	private static LinkedList<Cliente> clientes = new LinkedList<Cliente>();
	
	public static Usuario usuarioLogueado = null;
	
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
	
	public static LinkedList<Cliente> getClientes() {
		return clientes;
	}

	public static void setClientes(LinkedList<Cliente> clientes) {
		Usuario.clientes = clientes;
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
	
	//Validaciones
			public static boolean ValidarNombre(String nombre) {
				boolean numero = false;
				if (nombre.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Está vacio el nombre");
					return false;
				} else {
					for (int i = 0; i < nombre.length(); i++) {
						if (Character.isDigit(nombre.charAt(i))) {
							numero=true;
						}
					}
					if (numero==true) {
						JOptionPane.showMessageDialog(null, "No puede tener numeros el nombre");
						return false;
					} else {
						return true;
					}
				}
			}
			
			public static boolean ValidarContrasenia(String contra) {
				boolean mayus = false;
				boolean minus = false;
				boolean num = false;
				
				if (contra.length()>=6) {
					for (int i = 0; i < contra.length(); i++) {
						if (Character.isUpperCase(contra.charAt(i))) {
							mayus=true;
						}
						if (Character.isLowerCase(contra.charAt(i))) {
							minus=true;
						}
						if (Character.isDigit(contra.charAt(i))) {
							num=true;
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "La contraseña debe tener minimo 6 caracteres");
					return false;
				}
				if (mayus && minus && num) {
					JOptionPane.showMessageDialog(null, "Es correcta");
					return true;
				} else {
					JOptionPane.showMessageDialog(null, "No cumple con lo pedido");
					return false;
				}
			}
			
			public static boolean ValidarDni(String dni) {
				boolean letra = false;
				if (dni.length()<7 || dni.length()>8) {
					return false;
				} else {
					for (int i = 0; i < dni.length(); i++) {
						if (Character.isLetter(dni.charAt(i))) {
							letra=true;
						}
					}
					if (letra==true) {
						JOptionPane.showMessageDialog(null, "No puede tener letras el DNI");
						return false;
					} else {
						return true;
					}
				}	
				
			}
			public static boolean ValidarTarjeta(String tarjeta) {
				boolean letra = false;
				if (tarjeta.length()==16) {
					for (int i = 0; i < tarjeta.length(); i++) {
						if (Character.isLetter(tarjeta.charAt(i))) {
							letra=true;
						}
					}
					if (letra==true) {
						JOptionPane.showMessageDialog(null, "No puede tener letras la tarjeta");
						return false;
					} else {
						return true;
					}
				} else {
					return false;
				}	
				
			}
}
