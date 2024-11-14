import java.time.LocalDateTime;

public class Movimiento {

	private LocalDateTime fechaHora;
	private Cliente cliente;
	private String detalle;
	private int movimiento;
	public Movimiento(LocalDateTime fechaHora, Cliente cliente, String detalle, int movimiento) {
		super();
		this.fechaHora = fechaHora;
		this.cliente = cliente;
		this.detalle = detalle;
		this.movimiento = movimiento;
	}
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	public int getMovimiento() {
		return movimiento;
	}
	public void setMovimiento(int movimiento) {
		this.movimiento = movimiento;
	}
	@Override
	public String toString() {
		return "Movimiento [fechaHora=" + fechaHora + ", cliente=" + cliente + ", detalle=" + detalle + ", movimiento="
				+ movimiento + "]";
	}
	
	
	
	

}
