package competiciones;

import java.util.List;

import giis.demo.util.ApplicationException;
import giis.demo.util.Database;

public class CompeticionModel {
	
	// Mensajes de error
	private static final String MSG_ID_NO_NULO = "El id no puede ser nulo";
	
	private Database db=new Database();
	public String listado_competiciones = "SELECT * FROM Competicion c WHERE i.competicion_id = ? ";
	
	/**
	 * Obtiene todas las inscripciones de un 
	 */
	public List<Object[]> getListadoCompeticiones(int id) {
		validateNotNull(id,MSG_ID_NO_NULO);
		
		return db.executeQueryArray(listado_competiciones, id);
	}
	
	/* De uso general para validacion de objetos */
	private void validateNotNull(Object obj, String message) {
		if (obj==null)
			throw new ApplicationException(message);
	}
	private void validateCondition(boolean condition, String message) {
		if (!condition)
			throw new ApplicationException(message);
	}

}
