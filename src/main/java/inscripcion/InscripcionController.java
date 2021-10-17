package inscripcion;

import java.util.ArrayList;
import java.util.List;

import competiciones.CompeticionController;

public class InscripcionController {
	
	private InscripcionModel im;
	private CompeticionController cm;
	private List<InscripcionDTO> idto;
	private String[] tipoClasif;
	
	/**
	 * Constructor sin parámetros de la clase InscripcionController
	 */
	public InscripcionController() {
		this.im = new InscripcionModel();
		this.cm = new CompeticionController();
		
		this.idto = new ArrayList<InscripcionDTO>();
		this.tipoClasif = new String[2];
		tipoClasif[0] = "Absoluta";
		tipoClasif[1] = "Sexo";
	}
	
	/**
	 * Constructor con un parámetro de la clase InscripcionController
	 * 
	 * @param im, una inscripcionModel
	 */
	public InscripcionController(InscripcionModel im) {
		this.im = im;
		this.cm = new CompeticionController();
		
		this.idto = new ArrayList<InscripcionDTO>();
	}
	
	/**
	 * Crea la lista de inscripciones usando los id de una carrera
	 * 
	 * @param id, el id de la carrera
	 */
	public void rellenarId(int id) {
		this.idto = im.getListadoInsId(id);
	}
	
	/**
	 * Devuelve una lista de cadenas de texto con la información:
	 * Nombre competicion + estado actual inscripcion + fecha ult. cambio de estado
	 * 
	 * @param email, el email de la persona a buscar las inscripciones
	 * @return una lista de cadenas de texto con toda la información
	 */
	public List<String> clasificacion(String tipo, int id) {
		rellenarId(id);
		AtletaDTO am = new AtletaDTO();
		
		List<String> result = new ArrayList<String>();
		String linea = "";
		int index = 0;
		
		for(InscripcionDTO ic : this.idto) {
			am = obtenerAtleta(ic.email_atleta);
			linea = index + " - " + ic.categoriaSexo + " - " + am.getNombre() + ic.getTiempo();
			
			result.add(linea);
			index++;
		}
		
		return result;
	}
	
	/**
	 * Devuelve la lista de inscripciones actual según el email de un atleta
	 * 
	 * @return la lista de inscripciones
	 */
	public List<InscripcionDTO> getIdto() {
		return idto;
	}
	
	/**
	 * Devuelve los tipos de clasificaciones disponibles
	 * 
	 * @return la lista de tipos de clasificacion 
	 */
	public String[] getTipoClasif() {
		return tipoClasif;
	}
	
}
