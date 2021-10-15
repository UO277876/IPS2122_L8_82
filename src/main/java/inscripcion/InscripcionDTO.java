package inscripcion;

public class InscripcionDTO {
	
	String dorsal;
	int tiempo;
	int precio;
	String email_atleta;
	String categoriaSexo;
	String metodoPago;
	int id_competicion;
	
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
	
	
}
