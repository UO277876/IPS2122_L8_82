package inscripcion;

public class ListadoDTO {
	
	private String nombre;
	private String estado;
	private String fecha;
	private String hayCancelacion;
	
	public ListadoDTO(String name, String estado, String date, boolean hayCancelacion) {
		this.nombre = name;
		this.estado = estado;
		this.fecha = date;
		
		if(hayCancelacion) {
			setHayCancelacion("si");
		} else {
			setHayCancelacion("no");
		}
	}
	
	public ListadoDTO(String name, String estado, String date, String hayCancelacion) {
		this.nombre = name;
		this.estado = estado;
		this.fecha = date;		
		this.hayCancelacion = hayCancelacion;
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

	public String getHayCancelacion() {
		return hayCancelacion;
	}

	public void setHayCancelacion(String hayCancelacion) {
		this.hayCancelacion = hayCancelacion;
	}
	

}
