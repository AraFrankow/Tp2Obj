	import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

	public class Cliente extends Usuario {

		private String tipo;
		private Cuenta cuenta;
		private Double DineroActual;
		public Cliente(String nombre, String dni, String contrasena, String tipo, Cuenta cuenta, Double DineroActual) {
			super(nombre, dni, contrasena);
			this.tipo = tipo;
			this.cuenta = cuenta;
			this.DineroActual = DineroActual;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public Cuenta getCuenta() {
			return cuenta;
		}
		public void setCuenta(Cuenta cuenta) {
			this.cuenta = cuenta;
		}
				
		public Double getDineroActual() {
			return DineroActual;
		}
		public void setDineroActual(Double dineroActual) {
			DineroActual = dineroActual;
		}
		public boolean Transferir(Usuario usuario, Double transferir) {
			if (transferir>0 && transferir <= DineroActual ) {
				DineroActual -= transferir;
				JOptionPane.showMessageDialog(null, "Transfiriendo a "+ usuario+" $"+transferir);
			}
			return false;
			
		}
		public boolean Depositar(double depositar) {
			if (depositar>0) {
				DineroActual += depositar;
				return true;
			}else {
				return false;
			}			
		}
		
		public boolean Retirar(int platita) {
			return false;
			
		}
		
		@Override
		public String toString() {
			return "Cliente [tipo=" + tipo + ", cuenta=" + cuenta + "]";
		}
		@Override
		public void Menu() {
			//int opcion = JOptionPane.showOptionDialog(null,
			//		"Bienvenido", tipo, 0, 0, null, 
			//		OpcionesCliente.values(), OpcionesCliente.values());
			
			//String eleccion;
			int opcion;
			Double transferir;
			do {
				//eleccion = (String)JOptionPane.showInputDialog(null, "Que quiere hacer?", null, 0, null, OpcionesCliente.values(), OpcionesCliente.values()[0]);
				opcion = JOptionPane.showOptionDialog(null,  "Bienvenido", tipo, 0, 0, null, OpcionesCliente.values(), OpcionesCliente.values());
				switch (opcion) {
				case 0:
					String contrasena = JOptionPane.showInputDialog("Ingrese la contraseña de su cuenta");
					if (contrasena.equals(getContrasenia())) {
						transferir = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el dinero que quiera transferir"));
						if (transferir<=0 || transferir>getDineroActual()) {
							do {
								transferir = Double.parseDouble(JOptionPane.showInputDialog("Error, ingrese nuevamente la cantidad que quiera transferir"));
							} while (transferir<=0 || transferir>getDineroActual());
						}
						
						if (getUsuarios().isEmpty()) {
							JOptionPane.showMessageDialog(null, "No hay Usuarios registrados");
							break;
						}
						
						int opcionDos = JOptionPane.showOptionDialog(null, "Usuarios", null, 0, 0, null, getUsuarios().toArray(), getUsuarios().toArray()[0]);
						getUsuarios().get(opcionDos);
						Transferir(getUsuarios().get(opcion), transferir);
						JOptionPane.showMessageDialog(null, "Transfiriendo...", null, JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("img/transfiriendo.gif")));
						break;
					} else {
						JOptionPane.showMessageDialog(null, "Contraseña incorrecta, no puede hacer esta accion");
					}
					break;

				case 1:
					double depositar = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el dinero que quiera depositar"));
					if (depositar<=0) {
						do {
							depositar = Double.parseDouble(JOptionPane.showInputDialog("Error, ingrese nuevamente la cantidad que quiera depositar"));
						} while (depositar<=0);
					}
					Depositar(depositar);
					JOptionPane.showMessageDialog(null, "Depositando $"+depositar+"...", null, JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("img/depositando.png")));
					break;
					
				case 2:
					Retirar(0);
					break;
					
				case 3:
					JOptionPane.showMessageDialog(null, "Saliendo...");
					break;
				}
			} while (opcion!=3);
		}
		
		
		
	}

