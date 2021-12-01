package competiciones;

import clasificacion.CategoriasDTO;

public class CompeticionDTO {

	private int id;
	private String tipo;
	private String inicio;
	private String fin;
	private int numPlazas;
	private String nombre;
	private String descr;

	private String fecha;

	private int distancia;

	private int dorsalesReservados;
	private CategoriasDTO categorias;

	private boolean hayCancelacion;
	private int porcentajeDevuelto;
	private String fechaLimite;

	public CompeticionDTO() {
	};

	public CompeticionDTO(int id, String tipo, String inicio, String fin, int numPlazas, String nombre,
			String descr, int distancia, String fecha, boolean hayCancelacion, int porcentajeDevuelto,
			String fechaLimite, int dorsalesReservados) {
		this.id = id;
		this.inicio = inicio;
		this.fin = fin;
		this.numPlazas = numPlazas;
		this.nombre = nombre;
		this.descr = descr;
		this.distancia = distancia;
		this.fecha = fecha;
		this.dorsalesReservados = dorsalesReservados;
		this.hayCancelacion = hayCancelacion;
		this.categorias = new CategoriasDTO();
		this.porcentajeDevuelto = porcentajeDevuelto;
		this.fechaLimite = fechaLimite;

	};
	
	public CompeticionDTO(int id, String tipo, String inicio, String fin, int numPlazas, String nombre,
			String descr, int distancia, String fecha, boolean hayCancelacion, int dorsalesReservados) {
		this.id = id;
		this.inicio = inicio;
		this.fin = fin;
		this.numPlazas = numPlazas;
		this.nombre = nombre;
		this.descr = descr;
		this.distancia = distancia;
		this.fecha = fecha;
		this.dorsalesReservados = dorsalesReservados;
		this.hayCancelacion = hayCancelacion;
		this.categorias = new CategoriasDTO();

	};

	public int getDorsalesReservados() {
		return dorsalesReservados;
	}

	public void setDorsalesReservados(int dorsalesReservados) {
		this.dorsalesReservados = dorsalesReservados;
	}

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

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
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

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getFecha() {
		return fecha;
	}

	public boolean isHayCancelacion() {
		return hayCancelacion;
	}

	public void setHayCancelacion(boolean hayCancelacion) {
		this.hayCancelacion = hayCancelacion;
	}

	public int getPorcentajeDevuelto() {
		return porcentajeDevuelto;
	}

	public void setPorcentajeDevuelto(int porcentajeDevuelto) {
		this.porcentajeDevuelto = porcentajeDevuelto;
	}

	public String getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(String fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public CategoriasDTO getCategorias() {
		if (categorias == null)
			categorias = new CategoriasDTO();
		return this.categorias;
	}

	public void setCategorias(CategoriasDTO categorias) {
		if (categorias != null)
			this.categorias = categorias;
	}

}
