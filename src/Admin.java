import javax.swing.JOptionPane;

public class Admin extends Usuario{
	private int NroAdmin;

	public Admin(String nombre, String dni, String contrasenia, int nroAdmin) {
		super(nombre, dni, contrasenia);
		NroAdmin = nroAdmin;
	}

	public int getNroAdmin() {
		return NroAdmin;
	}

	public void setNroAdmin(int nroAdmin) {
		NroAdmin = nroAdmin;
	}
	
	public static void AgregarCliente() {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario");
		if (ValidarNombre(nombre)==false) {
			do {
				nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario otra vez");
			} while (ValidarNombre(nombre)==false);
		}
		String dni = JOptionPane.showInputDialog("Ingrese el dni del usuario");
		if (ValidarDni(dni)==false) {
			do {
				dni = JOptionPane.showInputDialog("Ingrese el dni del usuario otra vez");
			} while (ValidarDni(dni)==false);
		}
		String contrasenia = JOptionPane.showInputDialog("Ingrese la contraseña del usuario");
		if (ValidarContrasenia(contrasenia)==false) {
			do {
				contrasenia = JOptionPane.showInputDialog("Ingrese la contraseña del usuario otra vez");
			} while (ValidarContrasenia(contrasenia)==false);
		}
		String[] tipo = { "Normal", "Ejecutivo", "Premium"};
		String eleccionTipo = (String)JOptionPane.showInputDialog(null, "Que tipo de cliente quiere ser?", null, 0, null, tipo, tipo[0]);
		Cliente nuevo = new Cliente(nombre, dni, contrasenia, eleccionTipo, null);
		for (Usuario item : Usuario.getUsuarios()) {
			if (item.getDni().equals(nuevo.getDni())) {
				JOptionPane.showMessageDialog(null, "Este usuario ya se registró antes");
				return;
			} 
		}
		Usuario.getUsuarios().add(nuevo);
		JOptionPane.showMessageDialog(null, "Se agregó!");
	}
	
	public Usuario eliminar_usuario() {
		if (Usuario.getUsuarios().isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay usuarios para eliminar");
			return null;
		}
		int opcion = JOptionPane.showOptionDialog(null, "Menu", null, 0, 0, null, Usuario.getUsuarios().toArray(), Usuario.getUsuarios().toArray()[0]);
		
		return Usuario.getUsuarios().remove(opcion);
	}

	@Override
	public void Menu() {
		//String eleccion;
		int opcion;
		do {
			//eleccion = (String)JOptionPane.showInputDialog(null, "Que quiere hacer?", null, 0, null, OpcionesAdmin.values(), OpcionesAdmin.values()[0]);
			opcion = JOptionPane.showOptionDialog(null, "Bienvenido", null, 0, 0, null, OpcionesAdmin.values(), OpcionesAdmin.values());
			switch (opcion) {
			case 0:
				AgregarCliente();
				break;

			case 1:
				eliminar_usuario();
				break;
				
			case 2:
				JOptionPane.showMessageDialog(null, "Saliendo...");
				break;
			}
		} while (opcion!=2);
	}
	@Override
	public String toString() {
		return "Admin [NroAdmin=" + NroAdmin + "]";
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
}
