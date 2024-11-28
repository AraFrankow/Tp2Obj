import java.time.LocalDateTime;
import java.util.LinkedList;

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
			}
			return false;
			
		}
		public void Depositar(double depositar) {
			if (depositar>0) {
				DineroActual += depositar;
				return;
			}else {
				return;
			}			
		}
		
		public void Retirar(Double retirar) {
			if (retirar>0 && retirar <= DineroActual) {
				DineroActual -= retirar;
			}
			return;
			
		}
		
		@Override
		public String toString() {
			return "Cliente [tipo=" + tipo + ", NroCuenta=" + cuenta + "]";
		}
		@Override
		public void Menu() {
			int opcion, opcion2;
			Double transferir;
			Double retirar;
			do {
				opcion = JOptionPane.showOptionDialog(null,  "Bienvenido", tipo, 0, 0, null, OpcionesCliente.values(), OpcionesCliente.values());
				switch (opcion) {
				case 0:
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
					Transferir(getUsuarios().get(opcionDos), transferir);
					JOptionPane.showMessageDialog(null, "Transfiriendo a "+getUsuarios().get(opcionDos)+ " $"+ transferir);
					String detalle = JOptionPane.showInputDialog("Ingrese el motivo de la transferencia");
					Movimiento nuevaTransferencia = new Movimiento(LocalDateTime.now(), getUsuarios().get(opcionDos), detalle, transferir);
					Cuenta.getMovimientos().add(nuevaTransferencia);

					break;

				case 1:
					double depositar = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el dinero que quiera depositar"));
					if (depositar<=0) {
						do {
							depositar = Double.parseDouble(JOptionPane.showInputDialog("Error, ingrese nuevamente la cantidad que quiera depositar"));
						} while (depositar<=0);
					}
					Depositar(depositar);
					JOptionPane.showMessageDialog(null, "Depositando $"+depositar+"...");
					Movimiento nuevoDeposito = new Movimiento(LocalDateTime.now(), null, "Deposito", depositar);
					Cuenta.getMovimientos().add(nuevoDeposito);
					break;
					
				case 2:
					retirar = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el dinero que quiera retirar"));
					if (retirar<=0 || retirar>getDineroActual()) {
						do {
							retirar = Double.parseDouble(JOptionPane.showInputDialog("Error, ingrese nuevamente la cantidad que quiera retirar"));
						} while (retirar<=0 || retirar>getDineroActual());
					}	
					Retirar(retirar);
					JOptionPane.showMessageDialog(null, "Retirando...");
					Movimiento nuevoRetiro = new Movimiento(LocalDateTime.now(), null, "Retiro", retirar);
					Cuenta.getMovimientos().add(nuevoRetiro);
					break;
				case 3:
					opcion2 = JOptionPane.showOptionDialog(null,  "Que queres ver?", tipo, 0, 0, null, OpcionesVer.values(), OpcionesVer.values());
					switch (opcion2) {
						case 0:
							JOptionPane.showMessageDialog(null, getDineroActual());
							break;
							
						case 1:
							JOptionPane.showMessageDialog(null, Cuenta.getMovimientos());
							break;
							
						case 2:
							JOptionPane.showMessageDialog(null, Cuenta.getNroCuenta());
							break;
							
						case 3:
							JOptionPane.showMessageDialog(null, Cuenta.getTarjeta());
							break;
							
						case 4:
							JOptionPane.showMessageDialog(null, "Saliendo...");
							break;
					}
					
					break;
					
				case 4:
					JOptionPane.showMessageDialog(null, "Saliendo...");
					break;

				}
			} while (opcion!=4);
		}
		
		
		
	}

