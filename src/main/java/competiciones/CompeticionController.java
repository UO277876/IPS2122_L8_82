package competiciones;

import java.util.Random;

public class CompeticionController {
	
	private CompeticionModel cm;
	
	
	/**
	 * Constructor sin parámetros de la clase CompeticionController
	 */
	public CompeticionController() {
		cm = new CompeticionModel();
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
	 * Devuelve True si existe una competicion con el id pasado como parámetro y False si no
	 * 
	 * @param id, el id de la competicion deseada
	 * @return Los datos de la competicion
	 */
	public boolean existeCompeticion(int id) {
		return cm.getListadoCompeticiones(id).size() > 0;
	}
	
	// PARA CANCELACIONES 
	public CompeticionDTO obtenerCompeticionNombre(String nombre) {
		return cm.getListaCompeticionesName(nombre).get(0);
	}
	
	public void actualizarPlazas(int id, int plazas) {
		cm.actualizarPlazas(id, plazas);
	}
	// -------------
	
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
	public boolean addCompeticion(String nombre, String descripcion, String fecha, int numPlazas, int distancia, String tipo,
			String inicio, String fin, boolean hayCancelacion, int dorsalesReservados) {
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
		competi.setDescr(descripcion);
		competi.setNumPlazas(numPlazas);
		competi.setTipo(tipo);
		competi.setDistancia(distancia);
		competi.setFin(fin);
		competi.setInicio(inicio);
		competi.setFecha(fecha);
		competi.setDorsalesReservados(dorsalesReservados);
		competi.setHayCancelacion(hayCancelacion);
		
		cm.addCompeticionConCancelacion(competi);
		
		// Para comprobar que ha sido creada correctamente
		if(existeCompeticion(id)) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Añade una competición nueva 
	 * 
	 * @return True si se ha añadido correctamente y False si no
	 */
	public boolean addCompeticionConCancelacion(String nombre, String descripcion, String fecha, int numPlazas, int distancia, String tipo,
			String inicio, String fin, boolean hayCancelacion, int porcentaje, String fechaLimite, int dorsalesReservados) {
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
		competi.setDescr(descripcion);
		competi.setNumPlazas(numPlazas);
		competi.setTipo(tipo);
		competi.setDistancia(distancia);
		competi.setFin(fin);
		competi.setInicio(inicio);
		competi.setFecha(fecha);
		competi.setHayCancelacion(hayCancelacion);
		competi.setPorcentajeDevuelto(porcentaje);
		competi.setFechaLimite(fechaLimite);
		competi.setDorsalesReservados(dorsalesReservados);
		
		cm.addCompeticionConCancelacion(competi);
		
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
