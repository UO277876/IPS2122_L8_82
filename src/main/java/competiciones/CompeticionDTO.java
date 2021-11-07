package competiciones;

public class CompeticionDTO {
	
	int id;
	String tipo;
	String inicio;
	String fin;
	int numPlazas;
	String nombre;
	String descripcion;
	String fecha;
	int distancia;
	
	public CompeticionDTO(){};
	
	public CompeticionDTO(int id, String tipo, String inicio, String fin, int numPlazas, String nombre, String descripcion
			, int distancia, String fecha){
		this.id = id;
		this.inicio = inicio;
		this.fin = fin;
		this.numPlazas = numPlazas;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.distancia = distancia;
		this.fecha = fecha;
	};
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getTipo() { return tipo; }
	public void setTipo(String tipo) { this.tipo = tipo; }
	public String getInicio() { return inicio; }
	public void setInicio(String inicio) { this.inicio = inicio; }
	public String getFin() { return fin; }
	public void setFin(String fin) { this.fin = fin; }
	public int getNumPlazas() { return numPlazas; }
	public void setNumPlazas(int numPlazas) { this.numPlazas = numPlazas; }
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	public String getDescripcion() { return descripcion; }
	public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
	public int getDistancia() { return distancia; }
	public void setDistancia(int distancia) { this.distancia = distancia; }
	public void setFecha(String fecha) { this.fecha = fecha; }
	public String getFecha() { return fecha; }
	
	

}
