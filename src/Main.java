import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Admin yo = new Admin("Ara", "11111121", "OlaAdmin1", 1);
		Usuario.getUsuarios().add(yo);
		Cliente otro = new Cliente(null, null, null, null, null);
		
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre para el login");
		String contra = JOptionPane.showInputDialog("Ingrese su contraseña");

		if (Usuario.Login(nombre, contra)==true) {
			if (nombre.equals("Ara") && contra.equals("OlaAdmin1")) {
				yo.Menu();
			}else {
				otro.Menu();
			}
		}
		
	}

}
