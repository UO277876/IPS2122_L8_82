package competiciones;

import java.util.Random;

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
	
	/**
	 * Devuelve True si existe una competicion con el id pasado como parámetro y False si no
	 * 
	 * @param id, el id de la competicion deseada
	 * @return Los datos de la competicion
	 */
	public boolean existeCompeticion(int id) {
		return cm.getListadoCompeticiones(id).size() < 0;
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
	
	/**
	 * Añade una competición nueva 
	 * 
	 * @return True si se ha añadido correctamente y False si no
	 */
	public boolean addCompeticion(String nombre, String descripcion, String fecha, int numPlazas, int distancia, String tipo) {
		// 1. Crear ID
		Random random = new Random();
		int id = random.nextInt(4735);
		
		while(existeCompeticion(id)) {
			id = random.nextInt(4735);
		}
		
		// 2. Crear datos de la competición
		CompeticionDTO competi = new CompeticionDTO();
		competi.setId(id);
		competi.setNombre(nombre);
		competi.setDescripcion(descripcion);
		competi.setNumPlazas(numPlazas);
		competi.setTipo(tipo);
		competi.setDistancia(distancia);
		
		// Falta inicio y fin
		cm.addCompeticion(competi);
		
		// Para comprobar que ha sido creada correctamente
		if(existeCompeticion(id)) {
			return true;
		}
		
		return false;
	}
	
	
	//NECESITO IMPLEMENTAR PRECIO EN LA COMPETICION 
	/*public int getPrecioCompeticion(String id) {
		List<CompeticionDTO> competiciones = cm.getListadoCompeticiones(id);
		CompeticionDTO competicion = competiciones.get(0);
		return competicion.getPrecio();
	}*/

}
