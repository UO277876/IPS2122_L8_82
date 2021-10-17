package inscripcion;

import java.util.List;

import giis.demo.util.ApplicationException;
import giis.demo.util.Database;

public class InscripcionModel {
	
	// Mensajes de error
	private static final String MSG_ID_NO_NULO = "El id no puede ser nulo";
	
	private Database db=new Database();
	private String listado_inscripciones_id = "SELECT * FROM Inscripcion WHERE id_competicion = ? ORDER BY tiempo";
	
	/**
	 * Obtiene todas las inscripciones de un atleta mediante el id de una carrera
	 */
	public List<InscripcionDTO> getListadoInsId(int id) {
		validateNotNull(id,MSG_ID_NO_NULO);
		
		List<InscripcionDTO> result = db.executeQueryPojo(InscripcionDTO.class, listado_inscripciones_id, id);
		return result;
	}
	
	/* De uso general para validacion de objetos */
	private void validateNotNull(Object obj, String message) {
		if (obj==null)
			throw new ApplicationException(message);
	}

}
