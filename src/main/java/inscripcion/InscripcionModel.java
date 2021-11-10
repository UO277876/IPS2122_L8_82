package inscripcion;

import java.util.List;

import atleta.AtletaDTO;
import giis.demo.util.ApplicationException;
import giis.demo.util.Database;

public class InscripcionModel {
	
	// Mensajes de error
	private static final String MSG_ID_NO_NULO = "El id no puede ser nulo";
	private static final String MSG_GENERO_NO_NULO = "El genero no puede ser nulo";
	private static final String MSG_EMAIL_NO_NULO = "El email no puede ser nulo o vacio";
	private static final String MSG_DORSAL_NO_NULO = "El email no puede ser nulo o vacio";
	
	// Sentencias
	private Database db=new Database();
	private static final String listado_inscr_id_genero = "SELECT * FROM Inscripcion WHERE id_competicion = ? and categoriaSexo = ? ORDER BY tiempo";
	private static final String listado_inscr_id_absoluta = "SELECT * FROM Inscripcion WHERE id_competicion = ? ORDER BY tiempo";
	private static final String listado_inscripciones = "SELECT * FROM Inscripcion WHERE email_atleta = ? ORDER BY ultFechaModif";
	private static final String actualizar_dorsal = "UPDATE Inscripcion SET dorsal = ? WHERE email_atleta = ? and id_competicion = ?";
	private static final String obtener_por_dorsal = "SELECT * FROM Inscripcion WHERE dorsal = ? and email_atleta = ? and id_competicion = ?";
	
	/*private static final String SQL_GET_INSCRIPCION = 
			"SELECT * FROM Inscripcion WHERE email_atleta = ? AND id_competicion = ?";*/
	
	private static final String SQL_OBTENER_DORSALES = 
			"SELECT * FROM Inscripcion WHERE id_competicion = ?";
	
	public static final String SQL_INSCRIBIRSE = 
			"INSERT into Inscripcion (email_atleta, id_competicion, dorsal, tiempo, precio, ultFechaModif, categoriaSexo, metodoPago) VALUES (?,?,?,?,?,?,?,?)";
	
	public static final String SQL_BORRAR_INSCRIPCION = 
			"DELETE from Inscripcion (email_atleta, id_competicion) VALUES (?,?)";
	
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
	
	/**
	 * Actualiza el dorsal de un atleta de una competición en concreto
	 * @param email_atleta
	 * @param id_competicion
	 */
	public void actualizarDorsal(String dorsal, String email, int id_competicion) {
		VerificarCondicionesDorsal(dorsal, email, id_competicion);
		
		db.executeUpdate(actualizar_dorsal, dorsal, email, id_competicion);
	}
	
	/**
	 * Verifica si una inscripcion tiene ya dorsal asociado
	 */
	public boolean verificarDorsal(String dorsal, String email, int id_competicion) {
		validateNotNull(email,MSG_EMAIL_NO_NULO);
		
		List<InscripcionDTO> result = db.executeQueryPojo(InscripcionDTO.class, obtener_por_dorsal, dorsal, email, id_competicion);
		return result.size() > 0;
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
	
	/**
	 * Verifica las condiciones de dorsal, email e id_competicion
	 * - Que no sean null
	 * - Que las cadenas no sean vacías
	 */
	private void VerificarCondicionesDorsal(String dorsal, String email, int id_competicion) {
		validateNotNull(email, MSG_EMAIL_NO_NULO);
		validateNotNull(id_competicion, MSG_ID_NO_NULO);
		validateNotEmpty(email, MSG_EMAIL_NO_NULO);
		validateNotNull(dorsal, MSG_DORSAL_NO_NULO);
		validateNotEmpty(dorsal, MSG_DORSAL_NO_NULO);
	}

	
	//METODOS PARA CAMBIAR LA FORMA DE PAGO DE UNA COMPETICION YA INSCRITA HECHOS SIN QUERER (OSCAR)
	/*
	public InscripcionDTO getInscripcion(String email, String id) {
		String sql = SQL_GET_INSCRIPCION;
		List<InscripcionDTO> result = db.executeQueryPojo(InscripcionDTO.class, sql, email, id);
		return result.get(0);
	}
	
	public void changePaidMethodForInscripcion(String email, String id, String paidMethod) {
		String borrarInscripcion = SQL_BORRAR_INSCRIPCION;
		String inscribirse = SQL_INSCRIBIRSE;
		InscripcionDTO inscripcion = getInscripcion(email, id);
		db.executeUpdate(borrarInscripcion, email, id);
		db.executeUpdate(inscribirse,email, id, inscripcion.getDorsal(), inscripcion.getTiempo() , inscripcion.getPrecio(), inscripcion.getUltFechaModif(), inscripcion.getCategoriaSexo(), paidMethod);
	}*/
	
}
