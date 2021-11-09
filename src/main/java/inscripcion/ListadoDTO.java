package inscripcion;

public class ListadoDTO {
	
	private String nombre;
	private String estado;
	private String fecha;
	
	public ListadoDTO(String name, String estado, String date) {
		this.nombre = name;
		this.estado = estado;
		this.fecha = date;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String name) {
		this.nombre = name;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String date) {
		this.fecha = date;
	}
	
	

}
