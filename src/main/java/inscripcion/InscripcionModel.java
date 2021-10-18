package inscripcion;

import java.util.List;

import giis.demo.util.ApplicationException;
import giis.demo.util.Database;

public class InscripcionModel {
	
	// Mensajes de error
	private static final String MSG_ID_NO_NULO = "El id no puede ser nulo";
	private static final String MSG_GENERO_NO_NULO = "El genero no puede ser nulo";
	
	private Database db=new Database();
	private String listado_inscr_id_genero = "SELECT * FROM Inscripcion WHERE id_competicion = ? and categoriaSexo = ? ORDER BY tiempo";
	private String listado_inscr_id_absoluta = "SELECT * FROM Inscripcion WHERE id_competicion = ? ORDER BY tiempo";
	
	/**
	 * Obtiene todas las inscripciones de un atleta mediante el id de una carrera, ordenadas por categoria sexo
	 */
	public List<InscripcionDTO> getListadoInsIdGen(int id, String genero) {
		validateNotNull(id,MSG_ID_NO_NULO);
		validateNotNull(genero,MSG_GENERO_NO_NULO);
		
		List<InscripcionDTO> result = db.executeQueryPojo(InscripcionDTO.class, listado_inscr_id_genero, id, genero);
		return result;
	}
	
	/**
	 * Obtiene todas las inscripciones de un atleta mediante el id de una carrera, ordenadas por categoria absoluta
	 */
	public List<InscripcionDTO> getListadoInsIdAbs(int id) {
		validateNotNull(id,MSG_ID_NO_NULO);
		
		List<InscripcionDTO> result = db.executeQueryPojo(InscripcionDTO.class, listado_inscr_id_absoluta, id);
		return result;
	}
	
	/* De uso general para validacion de objetos */
	private void validateNotNull(Object obj, String message) {
		if (obj==null)
			throw new ApplicationException(message);
	}

}
