import java.time.LocalDateTime;

public class Movimiento {

	private LocalDateTime fechaHora;
	private Usuario usuario;
	private String detalle;
	private Double movimiento;
	public Movimiento(LocalDateTime fechaHora, Usuario usuario, String detalle, Double transferir) {
		super();
		this.fechaHora = fechaHora;
		this.usuario = usuario;
		this.detalle = detalle;
		this.movimiento = transferir;
	}
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	public Double getMovimiento() {
		return movimiento;
	}
	public void setMovimiento(Double movimiento) {
		this.movimiento = movimiento;
	}
	@Override
	public String toString() {
		return "Movimiento [fechaHora=" + fechaHora + ", usuario=" + usuario + ", detalle=" + detalle + ", movimiento="
				+ movimiento + "]";
	}
	
	
	
	

}
