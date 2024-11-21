import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Admin yo = new Admin("Ara", "11111121", "OlaAdmin1", 1);
		Usuario.getUsuarios().add(yo);
		Cliente otro = new Cliente(null, null, null, null, null, 0.0);
		String nombre, contra, eleccion;
		String[] opc = { "Loguearse", "Salir"};
		
		do {
			eleccion = (String)JOptionPane.showInputDialog(null, "Que quiere hacer?", null, 0, null, opc, opc[0]);
			switch (eleccion) {
			case "Loguearse":
				nombre = JOptionPane.showInputDialog("Ingrese el nombre para el login");
				contra = JOptionPane.showInputDialog("Ingrese su contraseña");

				if (Usuario.Login(nombre, contra)==true) {
					if (nombre.equals("Ara") && contra.equals("OlaAdmin1")) {
						yo.Menu();
					}else {
						otro.Menu();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Usuario no registrado, pidale a un admin que lo registre");
				}
				break;

			case "Salir":
				JOptionPane.showMessageDialog(null, "Saliendo...");
				break;
			}
			
		} while (!eleccion.equals("Salir"));
		
		
	}

}
