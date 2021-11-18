package resultados;

public class ResultadosDTO {

	public final static String ESTADO_NO_FINALIZADO = "DNF";
	public final static String ESTADO_NO_COMENZADO = "DNS";
	
	private int tInicio;
	private int tFin;
	private int idCompeticion;
	private String estado;
	private String dorsalAtleta;
	
	public ResultadosDTO(int tInicio, int tFin, String dorsalAtleta, int idCompeticion) {
		this.tInicio = tInicio;
		this.tFin = tFin;
		this.dorsalAtleta = dorsalAtleta;
		this.idCompeticion = idCompeticion;
		asignaEstado();
	}
	
	public void asignaEstado() {
		if(tInicio < 0)
			estado = ResultadosDTO.ESTADO_NO_COMENZADO;
		else if(tFin <0)
			estado = ResultadosDTO.ESTADO_NO_FINALIZADO;
	}

	public int getIdCompeticion() {
		return idCompeticion;
	}

	public String getEstado() {
		return estado;
	}

	public String getDorsalAtleta() {
		return dorsalAtleta;
	}
}
