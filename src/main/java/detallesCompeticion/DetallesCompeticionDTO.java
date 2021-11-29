package detallesCompeticion;

public class DetallesCompeticionDTO {
	private String dni;
	private String nombre;
	private String categoria;
	private String fecha;
	private String estado;
	
	public DetallesCompeticionDTO(String DNIAtleta, String nombreAtleta, String categoriaAtleta, String fechaInscripcion, String estadoInscripcion) {
		this.nombre = nombreAtleta;
		this.dni = DNIAtleta;
		this.fecha = fechaInscripcion;
		this.estado = estadoInscripcion;
		this.categoria = categoriaAtleta;
	}
	
	public String getCategoria() {
		return this.categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getDNI() {
		return dni;
	}
	
	public void setDNI(String dni) {
		this.dni = dni;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
