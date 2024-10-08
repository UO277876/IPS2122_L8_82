package inscripcion;

public class ClasificacionDTO {
	
	private int numero;
	private String genero;
	private String nombre;
	private String tiempo;
	private String categoria;
	
	public ClasificacionDTO(int numero, String genero, String nombre, String tiempo, String categoria) {
		this.nombre = nombre;
		this.numero = numero;
		this.tiempo = tiempo;
		this.genero = genero;
		this.categoria = categoria;
	}
	
	public String getCategoria() {
		return this.categoria;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTiempo() {
		return tiempo;
	}

}
