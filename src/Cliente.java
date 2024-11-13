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
		@Override
		public String toString() {
			return "Cliente [tipo=" + tipo + "]";
		}
		@Override
		public void Menu() {
			int opcion = JOptionPane.showOptionDialog(null,
					"Bienvenido", tipo, 0, 0, null, 
					OpcionesCliente.values(), OpcionesCliente.values());
		}
		
		
		
	}

