package giis.demo.inscripcion;

import java.util.Date;

public class InscripcionDTO {
	
	Date inicio;
	Date fin;
	String categoriaSexo;
	String dorsal;
	int tiempo;
	String metodoPago;
	String email_atleta;
	String id_competicion;
	
	public InscripcionDTO() {
		
	}
	
	public InscripcionDTO(Date inicio, Date fin, String categoriaSexo, String dorsal, int tiempo,
			String metodoPago, String email_atleta, String id_competicion) {
		this.inicio = inicio;
		this.fin = fin;
		this.categoriaSexo = categoriaSexo;
		this.dorsal = dorsal;
		this.tiempo = tiempo;
		this.metodoPago = metodoPago;
		this.email_atleta = email_atleta;
		this.id_competicion = id_competicion;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public String getCategoriaSexo() {
		return categoriaSexo;
	}

	public void setCategoriaSexo(String categoriaSexo) {
		this.categoriaSexo = categoriaSexo;
	}

	public String getDorsal() {
		return dorsal;
	}

	public void setDorsal(String dorsal) {
		this.dorsal = dorsal;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public String getEmail_atleta() {
		return email_atleta;
	}

	public void setEmail_atleta(String email_atleta) {
		this.email_atleta = email_atleta;
	}

	public String getId_competicion() {
		return id_competicion;
	}

	public void setId_competicion(String id_competicion) {
		this.id_competicion = id_competicion;
	}

}
