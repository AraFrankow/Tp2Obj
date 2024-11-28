import java.util.LinkedList;

public class Cuenta {

	private String nroCuenta;
	private double saldo;
	private String tarjeta;
	private LinkedList<Movimiento> movimientos = new LinkedList<Movimiento>();

	public Cuenta(String string, double saldo, String tarjeta) {
		super();
		this.nroCuenta = string;
		this.saldo = saldo;
		this.tarjeta = tarjeta;
		this.movimientos = movimientos;
	}

	public String getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	public LinkedList<Movimiento> getMovimientos() {
		return movimientos;
	}


	public void setMovimientos(LinkedList<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	@Override
	public String toString() {
		return nroCuenta ;
	}

}