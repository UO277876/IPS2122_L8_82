package inscripcion;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import competiciones.CompeticionController;
import competiciones.CompeticionDTO;

public class InscripcionController {
	
	private InscripcionModel im;
	private CompeticionController cm;
	private List<InscripcionDTO> idto;
	
	/**
	 * Constructor sin parámetros de la clase InscripcionController
	 */
	public InscripcionController() {
		this.im = new InscripcionModel();
		this.cm = new CompeticionController();
		
		this.idto = new ArrayList<InscripcionDTO>();
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
	 * Devuelve una lista de cadenas de texto con la información:
	 * Nombre competicion + estado actual inscripcion + fecha ult. cambio de estado
	 * 
	 * @param email, el email de la persona a buscar las inscripciones
	 * @return una lista de cadenas de texto con toda la información
	 * @throws ParseException 
	 */
	public List<String> listarPorIds(String email) throws ParseException {
		setIdto(email);
		CompeticionDTO lm = new CompeticionDTO();
		
		List<String> result = new ArrayList<String>();
		String linea = "";
		
		for(InscripcionDTO ic : this.idto) {
			lm = obtenerCompeticion(ic.id_competicion);
			linea = lm.getNombre() + " - " + ic.getIEstado() + " - " + ic.getUltFechaModif();
			
			result.add(linea);
		}
		
		return result;
	}
	
	/**
	 * Devuelve la competicion de id pasado como parámetro. Para ello,
	 * llama al CompeticionController
	 * 
	 * @return la competición
	 */
	public CompeticionDTO obtenerCompeticion(int id) {
		return cm.obtenerCompeticion(id);
	}
	
	/**
	 * Imprime el listado en el formato 
	 * Nombre competicion + estado actual inscripcion + fecha ult. cambio de estado
	 * De un solo String
	 * 
	 * @param listadoIns, la lista de String a concatenar
	 * @return un string con todo el listado
	 */
	public String imprimirListado(List<String> listadoIns) {
		String listado = "";
		for(int i=0; i < listadoIns.size(); i++) {
			listado += "> " + listadoIns.get(i) + "\n";
		}
		return listado;
	}
	
	/**
	 * Almacena la lista de inscripciones según el email de un atleta
	 * 
	 * @param email, el email a analizar
	 */
	private void setIdto(String email) {
		this.idto = im.getListadoInscripciones(email);
		
		for(InscripcionDTO ic : this.idto ) {
			ic.actualizaEstado();
		}
	}
	
	/**
	 * Devuelve la lista de inscripciones actual según el email de un atleta
	 * 
	 * @return la lista de inscripciones
	 */
	public List<InscripcionDTO> getIdto() {
		return idto;
	}
	
}
