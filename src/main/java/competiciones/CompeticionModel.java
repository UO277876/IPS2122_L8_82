package competiciones;

import java.util.List;

import giis.demo.util.ApplicationException;
import giis.demo.util.Database;

public class CompeticionModel {
	
	// Mensajes de error
	private static final String MSG_ID_NO_NULO = "El id no puede ser nulo";
	private static final String MSG_NOMBRE = "El nombre no puede ser nulo o vacío";
	
	private Database db=new Database();
	public static String listado_competiciones = "SELECT * FROM Competicion c WHERE id = ? ";
	public static String GET_COMPETICIONES = "SELECT * FROM Competicion c ";
	public static final String SQL_GET_LISTA_NOMBRE = "SELECT * from Competicion where nombre = ?";
	
	/**
	 * Obtiene la competición de un solo id
	 */
	public List<CompeticionDTO> getListadoCompeticiones(int id) {
		validateNotNull(id,MSG_ID_NO_NULO);
		
		List<CompeticionDTO> result = db.executeQueryPojo(CompeticionDTO.class, listado_competiciones, id);
		return result;
	}
	
	/**
	 * Obtiene la competición de un solo id
	 */
	public List<CompeticionDTO> getCompeticiones() {
		List<CompeticionDTO> result = db.executeQueryPojo(CompeticionDTO.class, GET_COMPETICIONES);
		return result;
	}
	
	/**
	 * Obtiene la lista de carreras de un nombre en concreto
	 * y descripcion.
	 */
	public List<CompeticionDTO> getListaCompeticionesName(String name) {
		validateNotNull(name,MSG_NOMBRE);
		validateNotEmpty(name,MSG_NOMBRE);
		
		List<CompeticionDTO> result = db.executeQueryPojo(CompeticionDTO.class, SQL_GET_LISTA_NOMBRE, name);
		return result;
	}
	
	/**
	 * Obtiene la lista de carreras de un nombre en concreto
	 * y descripcion.
	 */
	public boolean getListaCompeticionesNameBool(String name) {
		validateNotNull(name,MSG_NOMBRE);
		validateNotEmpty(name,MSG_NOMBRE);
		
		List<CompeticionDTO> result = db.executeQueryPojo(CompeticionDTO.class, SQL_GET_LISTA_NOMBRE, name);
		if(result.size() > 0) {
			return true;
		}
		
		return false;
	}
	
	/* De uso general para validacion de objetos */
	private void validateNotNull(Object obj, String message) {
		if (obj==null)
			throw new ApplicationException(message);
	}
	
	private void validateNotEmpty(String obj, String message) {
		if (obj.equals(""))
			throw new ApplicationException(message);
	}
	
	

}
