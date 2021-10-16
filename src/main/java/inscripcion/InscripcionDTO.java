package inscripcion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InscripcionDTO {
	
	private final String ESTADO1 = "solicitado";
	private final String ESTADO2 = "inscrito";
	private final String ESTADO3 = "participado";
	
	String dorsal;
	int tiempo;
	int precio;
	String email_atleta;
	String categoriaSexo;
	String metodoPago;
	int id_competicion;
	String estado;
	Date ultFechaModif;
	
	public InscripcionDTO() {
		
	}
	
	public InscripcionDTO(String dorsal, int tiempo, int precio,
			String categoriaSexo, String email_atleta, String metodoPago, int id_competicion) {
		this.dorsal = dorsal;
		this.tiempo = tiempo;
		this.precio = precio;
		this.categoriaSexo = categoriaSexo;
		this.email_atleta = email_atleta;
		this.metodoPago = metodoPago;
		this.id_competicion = id_competicion;
		
		setEstado(ESTADO1);
	}

	public String getDorsal() {
		return dorsal;
	}

	protected void setDorsal(String dorsal) {
		this.dorsal = dorsal;
	}

	public int getTiempo() {
		return tiempo;
	}

	protected void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public int getPrecio() {
		return precio;
	}

	protected void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getEmail_atleta() {
		return email_atleta;
	}

	protected void setEmail_atleta(String email_atleta) {
		this.email_atleta = email_atleta;
	}

	public String getCategoriaSexo() {
		return categoriaSexo;
	}

	protected void setCategoriaSexo(String categoriaSexo) {
		this.categoriaSexo = categoriaSexo;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	protected void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public int getId_competicion() {
		return id_competicion;
	}

	protected void setId_competicion(int id_competicion) {
		this.id_competicion = id_competicion;
	}
	
	public String getIEstado() {
		return estado;
	}

	protected void setEstado(String estado) {
		if(estado.equals(ESTADO1) || estado.equals(ESTADO2) || estado.equals(ESTADO3) ) {
			this.estado = estado;
			this.ultFechaModif = new Date();
		} 
	}
	
	public Date getUltFechaModif() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String result = "";
		this.ultFechaModif = dateFormat.parse(result);
		return ultFechaModif;
	}
	
	
}
