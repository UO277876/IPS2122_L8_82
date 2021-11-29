package metododepago;

public class MetodoDePagoDTO {
	
	public final static String trans = "transferencia";
	public final static String tc = "tc";
	public final static String pre = "preinscrito";
	
	private int id;
	private String tipo;
	private boolean estado;
	
	public MetodoDePagoDTO() {
		
	}
	
	public MetodoDePagoDTO(int id, String tipo, boolean estado) {
		this.id = id;
		this.tipo = tipo;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		if(tipo.equals(trans) || tipo.equals(tc) || tipo.equals(pre)) {
			this.tipo = tipo;
		}
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}		

}
