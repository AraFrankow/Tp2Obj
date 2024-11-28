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
        
		
		
		StringBuilder nroCuenta = new StringBuilder(); //Para concatenar los numero que le doy con el int de abajo
        for (int i = 0; i < 22; i++) {
            int digito = (int) (Math.random() * 10);
            nroCuenta.append(digito); // Lo añade al final del int
        }
        
        StringBuilder nroTarjeta = new StringBuilder(); //Para concatenar los numero que le doy con el int de abajo
        for (int i = 0; i < 16; i++) {
            int digitoTar = (int) (Math.random() * 10);
            nroTarjeta.append(digitoTar); // Lo añade al final del int
        }
                
		//String tarjeta = JOptionPane.showInputDialog("Ingrese el numero de su tarjeta");
		//if (ValidarTarjeta(tarjeta)==false) {
		//	do {
		//		tarjeta = JOptionPane.showInputDialog("Ingrese el numero de su tarjeta otra vez");
		//	} while (ValidarTarjeta(tarjeta)==false);
		//}
        
		Cuenta unica = new Cuenta(nroCuenta.toString(), 0, nroTarjeta.toString());
		Cliente nuevo = new Cliente(nombre, dni, contrasenia, eleccionTipo, unica, 0.0);
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
		int opcion;
		do {
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
	
	
		
}
