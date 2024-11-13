import java.util.LinkedList;

public class Cuenta {

	private int nroCuenta;
	private double saldo;
	private String tarjeta;
	private LinkedList<Movimiento> movimientos = new LinkedList<Movimiento>();

	public Cuenta(int nroCuenta, double saldo, String tarjeta) {
		super();
		this.nroCuenta = nroCuenta;
		this.saldo = saldo;
		this.tarjeta = tarjeta;
		this.movimientos = movimientos;
	}

	public int getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(int nroCuenta) {
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
		return "Cuenta [nroCuenta=" + nroCuenta + ", saldo=" + saldo + ", tarjeta=" + tarjeta + ", movimientos="
				+ movimientos + "]";
	}

}