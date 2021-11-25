package metododepago;

public class MetodoDePagoDTO {
	
	public final static String trans = "transferencia";
	public final static String tc = "tc";
	public final static String pre = "preinscrito";
	
	private int id_metodopago;
	private String tipo;
	private boolean estado;
	private String email_atleta;
	
	public MetodoDePagoDTO(int id_metodopago, String tipo, boolean estado, String email_atleta) {
		this.id_metodopago = id_metodopago;
		this.tipo = tipo;
		this.estado = estado;
		this.email_atleta = email_atleta;
	}

	public int getId_metodopago() {
		return id_metodopago;
	}

	public void setId_metodopago(int id_metodopago) {
		this.id_metodopago = id_metodopago;
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

	public String getEmail_atleta() {
		return email_atleta;
	}

	public void setEmail_atleta(String email_atleta) {
		this.email_atleta = email_atleta;
	}
	
	
	

}
