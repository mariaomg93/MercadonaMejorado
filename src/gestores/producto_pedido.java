package gestores;

public class producto_pedido {
	
	String idProd;
	String cantidad;
	
	
	
	public producto_pedido(String idProd, String cantidad) {
		super();
		this.idProd = idProd;
		this.cantidad = cantidad;
	}
	public String getIdProd() {
		return idProd;
	}
	public void setIdProd(String idProd) {
		this.idProd = idProd;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
