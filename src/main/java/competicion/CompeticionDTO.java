package competicion;

public class CompeticionDTO {
	private int id;
	private int distancia;
	private int numPlazas;
	private String inicio; // las fechas son string (vienen de sqlite)
	private String fin;
	private String fecha;
	private String descr;
	private String nombre;
	private int cuota;
	private String tipo;

	public int getId() {
		return this.id;
	}

	public String getInicio() {
		return this.inicio;
	}

	public String getFin() {
		return this.fin;
	}

	public String getFecha() {
		return this.fecha;
	}

	public String getDescr() {
		return this.descr;
	}

	public void setId(int value) {
		this.id = value;
	}

	public void setInicio(String value) {
		this.inicio = value;
	}

	public void setFin(String value) {
		this.fin = value;
	}

	public void setFecha(String value) {
		this.fecha = value;
	}

	public void setDescr(String value) {
		this.descr = value;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public int getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCuota() {
		return cuota;
	}

	public void setCuota(int cuota) {
		this.cuota = cuota;
	}
}
