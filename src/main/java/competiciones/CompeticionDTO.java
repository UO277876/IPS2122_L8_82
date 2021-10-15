package competiciones;

import java.util.Date;

public class CompeticionDTO {
	
	int id;
	String tipo;
	Date inicio;
	Date fin;
	int numPlazas;
	String nombre;
	String descripcion;
	int distancia;
	
	public CompeticionDTO(){};
	
	public CompeticionDTO(int id, String tipo, Date inicio, Date fin, int numPlazas, String nombre, String descripcion
			, int distancia){
		this.id = id;
		this.inicio = inicio;
		this.fin = fin;
		this.numPlazas = numPlazas;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.distancia = distancia;
	};
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Date getInicion() {
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
	public int getNumPlazas() {
		return numPlazas;
	}
	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getDistancia() {
		return distancia;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
	
	

}
