package inscripcion;

import java.util.List;
import java.util.Random;

import atleta.AtletaDTO;
import giis.demo.util.ApplicationException;
import giis.demo.util.Database;

public class InscripcionModel {
	
	
	
	
	// Mensajes de error
	private static final String MSG_ID_NO_NULO = "El id no puede ser nulo";
	private static final String MSG_GENERO_NO_NULO = "El genero no puede ser nulo";
	private static final String MSG_EMAIL_NO_NULO = "El email no puede ser nulo";
	
	private Database db=new Database();
	private String listado_inscr_id_genero = "SELECT * FROM Inscripcion WHERE id_competicion = ? and categoriaSexo = ? ORDER BY tiempo";
	private String listado_inscr_id_absoluta = "SELECT * FROM Inscripcion WHERE id_competicion = ? ORDER BY tiempo";
	private String listado_inscripciones = "SELECT * FROM Inscripcion WHERE email_atleta = ? ORDER BY ultFechaModif";
	
	private static final String SQL_OBTENER_DORSALES = "SELECT * FROM Inscripcion WHERE id_competicion = ?";
	
	public static final String SQL_INSCRIBIRSE = 
			"INSERT into Inscripcion (email_atleta, id_competicion, dorsal, tiempo, precio, ultFechaModif, categoriaSexo, metodoPago) VALUES (?,?,?,?,?,?,?,?)";
	
	
	
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
	
	/**
	 * Obtiene todas las inscripciones de un atleta
	 */
	public List<InscripcionDTO> getListadoInscripciones(String email) {
		validateNotNull(email,MSG_EMAIL_NO_NULO);
		
		List<InscripcionDTO> result = db.executeQueryPojo(InscripcionDTO.class, listado_inscripciones, email);
		return result;
	}
	

	
	public List<InscripcionDTO> getInscripcionesPorDorsal(int id_competicion){
		validateNotNull(id_competicion, MSG_ID_NO_NULO);
		List<InscripcionDTO> result = db.executeQueryPojo(InscripcionDTO.class, SQL_OBTENER_DORSALES, id_competicion);
		return result;
	}
	
	/**
	 * Inscribe a un atleta en una competicion, o dicho de otra forma, crea una nueva fila en la tabla inscripcion
	 * 
	 * @param email_atleta
	 * @param id_competicion
	 */
	public void inscribirse(AtletaDTO atleta, int id_competicion, String dorsal, int precio, String ultFechaModif, String metodoPago) {
		String sql = SQL_INSCRIBIRSE;
		db.executeUpdate(sql, atleta.getEmail(), id_competicion, dorsal, "---" , precio, ultFechaModif, atleta.getGenero(), metodoPago);
	}
	
	
	
	/* De uso general para validacion de objetos */
	private void validateNotNull(Object obj, String message) {
		if (obj==null)
			throw new ApplicationException(message);
	}

}
