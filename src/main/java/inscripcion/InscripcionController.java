package inscripcion;

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
	 * 
	 * 
	 * @param email
	 * @return
	 */
	public List<String> listarPorIds(String email) {
		List<String> result = new ArrayList<String>();
		
		
		return result;
	}
	
	/**
	 * Devuelve una lista de competiciones según las inscripciones de un atleta
	 * 
	 * @return la lista de competiciones
	 */
	public List<CompeticionDTO> obtenerCompeticiones() {
		List<CompeticionDTO> competiciones = new ArrayList<CompeticionDTO>();
		
		for(int i=0; i < idto.size(); i++) {
			competiciones.add(cm.obtenerCompeticion(idto.get(i).getId_competicion()));
		}
		
		return competiciones;
	}
	
	/**
	 * Almacena la lista de inscripciones según el email de un atleta
	 * 
	 * @param email, el email a analizar
	 */
	public void setIdto(String email) {
		this.idto = im.getListadoInscripciones(email);
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
