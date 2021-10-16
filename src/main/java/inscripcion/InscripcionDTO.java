package inscripcion;

import java.text.ParseException;
import java.util.Date;

public class InscripcionDTO {
	
	private final String ESTADO1 = "solicitado";
	private final String ESTADO2 = "inscrito";
	private final String ESTADO3 = "participado";
	
	private final String tc = "tarjeta";
	private final String transf = "transferencia";
	
	String dorsal;
	String tiempo;
	int precio;
	String email_atleta;
	String categoriaSexo;
	String metodoPago;
	int id_competicion;
	String estado;
	String ultFechaModif;
	
	public InscripcionDTO() {
		
	}
	
	public InscripcionDTO(String dorsal, String tiempo, int precio,
			String categoriaSexo, String email_atleta, String metodoPago, int id_competicion) {
		this.dorsal = dorsal;
		this.tiempo = tiempo;
		this.precio = precio;
		this.categoriaSexo = categoriaSexo;
		this.email_atleta = email_atleta;
		this.metodoPago = metodoPago;
		this.id_competicion = id_competicion;
	}

	public String getDorsal() { return dorsal; }

	public void setDorsal(String dorsal) { this.dorsal = dorsal; }

	public String getTiempo() { return tiempo; }

	public void setTiempo(String tiempo) { this.tiempo = tiempo; }

	public int getPrecio() { return precio; }

	public void setPrecio(int precio) { this.precio = precio; }

	public String getEmail_atleta() { return email_atleta; }

	public void setEmail_atleta(String email_atleta) { this.email_atleta = email_atleta; }

	public String getCategoriaSexo() { return categoriaSexo; }

	public void setCategoriaSexo(String categoriaSexo) { this.categoriaSexo = categoriaSexo; }

	public String getMetodoPago() { return metodoPago; }

	public void setMetodoPago(String metodoPago) {
		if(metodoPago.equals(tc) || metodoPago.equals(transf)) {
			this.metodoPago = metodoPago;
		} 
	}

	public int getId_competicion() {return id_competicion; }

	public void setId_competicion(int id_competicion) { this.id_competicion = id_competicion; }
	
	public String getIEstado() { return estado; }

	public void setEstado(String estado) {
		if(estado.equals(ESTADO1) || estado.equals(ESTADO2) || estado.equals(ESTADO3) ) {
			this.estado = estado;
			this.ultFechaModif = new Date().toString();
		} 
	}
	
	public void actualizaEstado() {
		if(tiempo.equals("---")) {
			setEstado(ESTADO1);
		} else if(metodoPago.equals(tc)) {
			setEstado(ESTADO2);
		} else {
			setEstado(ESTADO3);
		} 
		
		this.ultFechaModif = new Date().toString();
	}
	
	public String getUltFechaModif() throws ParseException { return ultFechaModif; }
	
	
}
