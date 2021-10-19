package competiciones;

import java.util.List;

public class CompeticionController {
	
	private CompeticionModel cm;
	
	/**
	 * Constructor sin parámetros de la clase CompeticionController
	 */
	public CompeticionController() {
		this.cm = new CompeticionModel();
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
	 * Devuelve los datos de una inscripcion usando su id para realizar su busqueda
	 * 
	 * @param id, el id de la competicion deseada
	 * @return Los datos de la competicion
	 */
	public CompeticionDTO obtenerCompeticion(int id) {
		return cm.getListadoCompeticiones(id).get(0);
	}
	
	
	//NECESITO IMPLEMENTAR PRECIO EN LA COMPETICION 
	/*public int getPrecioCompeticion(String id) {
		List<CompeticionDTO> competiciones = cm.getListadoCompeticiones(id);
		CompeticionDTO competicion = competiciones.get(0);
		return competicion.getPrecio();
	}*/

}
