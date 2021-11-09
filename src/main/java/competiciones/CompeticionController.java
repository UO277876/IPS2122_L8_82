package competiciones;

import java.util.Date;
import java.util.List;

import giis.demo.util.Util;
import inscripcion.InscripcionController;
import inscripcion.InscripcionDTO;

public class CompeticionController {
	
	private CompeticionModel cm;
	private InscripcionController im;
	
	
	/**
	 * Constructor sin parámetros de la clase CompeticionController
	 */
	public CompeticionController() {
		this.cm = new CompeticionModel();
		this.im = new InscripcionController();
		asignarDorsales();
	}
	
	/**
	 * Constructor con un parámetro de la clase CompeticionController
	 * 
	 * @param cm, una CompeticionModel
	 */
	public CompeticionController(CompeticionModel cm) {
		this.cm = cm;
	};
	
	/**
	 * Asigna los dorsales de las competiciones que ya estan iniciadas solo si 
	 * la asignacion se produce tras el cierre de inscripciones
	 */
	private void asignarDorsales() {
		// 1. Se obtienen todas las competiciones
		List<CompeticionDTO> competiciones = cm.getCompeticiones();
		for(CompeticionDTO competicion : competiciones) {
			// 2. Se mira si los plazos de inscripción estan terminados
			Date actual = new Date();
			if(Util.isoStringToDate(competicion.getFin()).before(actual)){
				// 3. Se obtienen todas las inscripciones de la competicion y se asignan los dorsales
				List<InscripcionDTO> atletas = im.getAtletasCompeticion(competicion.getId());
				for(InscripcionDTO atleta : atletas) {
					im.asignarDorsal(atleta.getEmail_atleta(),competicion.getId());
				}
			}
			
		}
	}
	
	/**
	 * Devuelve los datos de una inscripcion usando su id para realizar su busqueda
	 * 
	 * @param id, el id de la competicion deseada
	 * @return Los datos de la competicion
	 */
	public CompeticionDTO obtenerCompeticion(int id) {
		return cm.getListadoCompeticiones(id).get(0);
	}
	
	/**
	 * Devuelve los datos de una inscripcion usando su nombre para realizar su busqueda
	 * 
	 * @param name, el nombre de la competicion deseada
	 * @return Los datos de la competicion
	 */
	public CompeticionDTO obtenerCompeticionName(String name) {
		return cm.getListaCompeticionesName(name.toLowerCase()).get(0);
	}
	
	/**
	 * Devuelve los datos de una inscripcion usando su nombre para realizar su busqueda
	 * 
	 * @param name, el nombre de la competicion deseada
	 * @return Los datos de la competicion
	 */
	public boolean obtenerCompeticionNameBool(String name) {
		return cm.getListaCompeticionesNameBool(name.toLowerCase());
	}
	
	
	//NECESITO IMPLEMENTAR PRECIO EN LA COMPETICION 
	/*public int getPrecioCompeticion(String id) {
		List<CompeticionDTO> competiciones = cm.getListadoCompeticiones(id);
		CompeticionDTO competicion = competiciones.get(0);
		return competicion.getPrecio();
	}*/

}
