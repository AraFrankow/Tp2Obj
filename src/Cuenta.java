import java.util.LinkedList;

public class Cuenta {

	private static  String nroCuenta;
	private double saldo;
	private static String tarjeta;
	private static LinkedList<Movimiento> movimientos = new LinkedList<Movimiento>();

	public Cuenta(String string, double saldo, String tarjeta) {
		super();
		Cuenta.nroCuenta = string;
		this.saldo = saldo;
		Cuenta.tarjeta = tarjeta;
		this.movimientos = movimientos;
	}

	public static String getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(String nroCuenta) {
		Cuenta.nroCuenta = nroCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public static String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		Cuenta.tarjeta = tarjeta;
	}

	public static LinkedList<Movimiento> getMovimientos() {
		return movimientos;
	}


	public static void setMovimientos(LinkedList<Movimiento> movimientos) {
		Cuenta.movimientos = movimientos;
	}

	@Override
	public String toString() {
		return nroCuenta ;
	}

}