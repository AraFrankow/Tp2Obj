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
	
	public void agregar_usuario() {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario");
		if (ValidarString(nombre)==false) {
			do {
				nombre = JOptionPane.showInputDialog("Ingrese el nombre del libro otra vez");
			} while (ValidarString(nombre)==false);
		}
		String dni = JOptionPane.showInputDialog("Ingrese el dni del usuario");
		if (ValidarString(dni)==false) {
			do {
				dni = JOptionPane.showInputDialog("Ingrese el dni del usuario otra vez");
			} while (ValidarString(dni)==false);
		}
		String contrasenia = JOptionPane.showInputDialog("Ingrese la contrasenia del usuario");
		if (ValidarString(contrasenia)==false) {
			do {
				contrasenia = JOptionPane.showInputDialog("Ingrese la contrasenia del usuario otra vez");
			} while (ValidarString(contrasenia)==false);
		}
		String[] tipo = { "Normal", "Ejecutivo", "Premium"};
		String eleccionTipo = (String)JOptionPane.showInputDialog(null, "Que quiere hacer?", null, 0, null, tipo, tipo[0]);
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
		String eleccion;
		do {
			eleccion = (String)JOptionPane.showInputDialog(null, "Que quiere hacer?", null, 0, null, OpcionesAdmin.values(), OpcionesAdmin.values()[0]);
			switch (eleccion) {
			case "Transferir":
				
				break;

			case "Borrar usuario":
				eliminar_usuario();
				break;
				
			case "Salir":
				JOptionPane.showMessageDialog(null, "Saliendo...");
				break;
			}
		} while (!eleccion.equals("Salir"));
	}
	@Override
	public String toString() {
		return "Admin [NroAdmin=" + NroAdmin + "]";
	}
	
	public static boolean ValidarString(String escrito) {
		boolean numero = false;
		if (escrito.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Está vacio el campo");
			return false;
		} else {
			for (int i = 0; i < escrito.length(); i++) {
				if (Character.isDigit(escrito.charAt(i))) {
					numero=true;
				}
			}
			if (numero==true) {
				JOptionPane.showMessageDialog(null, "No puede tener numeros en este campo");
				return false;
			} else {
				return true;
			}
		}
	}
}
