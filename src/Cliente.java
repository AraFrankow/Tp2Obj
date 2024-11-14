	import javax.swing.JOptionPane;

	public class Cliente extends Usuario {

		private String tipo;
		private Cuenta cuenta;
		public Cliente(String nombre, String dni, String contrasena, String tipo, Cuenta cuenta) {
			super(nombre, dni, contrasena);
			this.tipo = tipo;
			this.cuenta = cuenta;
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
		public boolean Transferir(Cliente cliente, int monto) {
			return false;
			
		}
		public boolean Depositar(int platita) {
			return false;
			
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
			
			String eleccion;
			do {
				eleccion = (String)JOptionPane.showInputDialog(null, "Que quiere hacer?", null, 0, null, OpcionesCliente.values(), OpcionesCliente.values()[0]);
				switch (eleccion) {
				case "Transferir":
					Transferir(null, 0);
					break;

				case "Depositar":
					Depositar(0);
					break;
					
				case "Retirar":
					Retirar(0);
					break;
					
				case "Salir":
					JOptionPane.showMessageDialog(null, "Saliendo...");
					break;
				}
			} while (!eleccion.equals("Salir"));
		}
		
		
		
	}

