package giis.demo.inscripcion;

import java.util.List;

import giis.demo.util.ApplicationException;
import giis.demo.util.Database;

public class InscripcionModel {
	
	// Mensajes de error
	private static final String MSG_EMAIL_NO_NULO = "El email no puede ser nulo";
	
	private Database db=new Database();
	public String listado_inscripciones = "SELECT *  FROM Inscripcion WHERE i.atleta_email = ?";
	
	/**
	 * Obtiene todas las inscripciones de un 
	 */
	public List<Object[]> getListadoInscripciones(String email) {
		validateNotNull(email,MSG_EMAIL_NO_NULO);
		
		return db.executeQueryArray(listado_inscripciones, email);
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
