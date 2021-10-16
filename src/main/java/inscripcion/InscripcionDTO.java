package inscripcion;

import java.util.Date;

import competicion.CompeticionDTO.Sexo;

public class InscripcionDTO {

	private String inicio;
	private String fin;
	private String dorsal;
	private int tiempo;
	private String email_atleta;
	private Sexo categoría;
	private Pago metodoPago;
	private int id_competicion;
	
	
	public InscripcionDTO(String inicio, String fin, Sexo categoría, String dorsal, int tiempo,
			Pago metodoPago, String email_atleta, int id_competicion) {
		this.inicio = inicio;
		this.fin = fin;
		this.categoría = categoría;
		this.dorsal = dorsal;
		this.tiempo = tiempo;
		this.metodoPago = metodoPago;
		this.email_atleta = email_atleta;
		this.id_competicion = id_competicion;
	}
	
	public enum Pago{TRANSFERENCIA, EFECTIVO, TARJETA}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public String getDorsal() {
		return dorsal;
	}

	public void setDorsal(String dorsal) {
		this.dorsal = dorsal;
	}

	public float getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public String getEmail_atleta() {
		return email_atleta;
	}

	public void setEmail_atleta(String email_atleta) {
		this.email_atleta = email_atleta;
	}

	public Sexo getCategoría() {
		return categoría;
	}

	public void setCategoría(Sexo categoría) {
		this.categoría = categoría;
	}

	public Pago getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(Pago metodoPago) {
		this.metodoPago = metodoPago;
	}

	public int getId_competicion() {
		return id_competicion;
	}

	public void setId_competicion(int id_competicion) {
		this.id_competicion = id_competicion;
	}
	
}
