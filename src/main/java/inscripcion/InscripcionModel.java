package inscripcion;

import java.util.List;

import atleta.AtletaDTO;
import giis.demo.util.ApplicationException;
import giis.demo.util.Database;
import metododepago.MetodoDePagoDTO;

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
	private static final String obtener_por_dorsal = "SELECT * FROM Inscripcion WHERE dorsal = ? and id_competicion = ?";
	private static final String obtener_inscripcion = "SELECT * FROM Inscripcion WHERE email_atleta = ? and id_competicion = ?";
	
	/*private static final String SQL_GET_INSCRIPCION = 
			"SELECT * FROM Inscripcion WHERE email_atleta = ? AND id_competicion = ?";*/
	
	private static final String SQL_OBTENER_DORSALES = 
			"SELECT * FROM Inscripcion WHERE id_competicion = ?";
	
	public static final String SQL_INSCRIBIRSE = 
			"INSERT into Inscripcion (email_atleta, id_competicion, dorsal, tiempo, precio, ultFechaModif, categoriaSexo, metodoPago, id_metodoPago) VALUES (?,?,?,?,?,?,?,?,?)";
	
	public static final String SQL_BORRAR_INSCRIPCION = 
			"DELETE from Inscripcion (email_atleta, id_competicion) VALUES (?,?)";
	
	public static final String SQL_INSCRIPCIONES_POR_COMPETICION = 
			"SELECT * FROM Inscripcion WHERE id_competicion = ?";
	
	public static final String SQL_LISTADO_METODOS_DE_PAGO =
			"SELECT * FROM Competicion c WHERE id = ? ";
	
	public static final String SQL_SET_METODO_DE_PAGO =
			"INSERT into MetodoDePago (id, tipo, estado) values (?,?,?)";
	
	public static final String SQL_UPDATE_METODO_DE_PAGO = 
			"UPDATE MetodoDePago set tipo = ?, estado = ? where id = ?";
	
	public static final String SQL_UPDATE_ESTADO_PAGO = 
			"UPDATE Inscripcion set metodoPago = ? where id_metodoPago = ?";
	public static final String ELIMINAR_INSCRIPCION = "DELETE FROM Inscripcion WHERE email_atleta = ? and id_competicion = ?";
	
	/**
	 * Elimina una inscripcion
	 */
	public void eliminarInscripcion(InscripcionDTO dto) {		
		db.executeUpdate(ELIMINAR_INSCRIPCION, dto.getEmail_atleta(), dto.getId_competicion());
	}
	
	/**
	 * Obtiene todas las inscripciones de un atleta mediante el id de una carrera, ordenadas por categoria sexo
	 */
	public List<InscripcionDTO> getListadoInsIdGen(int id, String genero) {
		validateNotNull(id,MSG_ID_NO_NULO);
		validateNotNull(genero,MSG_GENERO_NO_NULO);
		
		List<InscripcionDTO> result = db.executeQueryPojo(InscripcionDTO.class, listado_inscr_id_genero, id, genero);
		return result;
	}
	
	public int getMetodoPago(String email, int id_competicion) {
		validateNotNull(email,MSG_EMAIL_NO_NULO);
		validateNotNull(id_competicion,MSG_ID_NO_NULO);
		
		List<InscripcionDTO> result = db.executeQueryPojo(InscripcionDTO.class, obtener_inscripcion, email, id_competicion);
		return result.get(0).getId_metodoPago();
	}
	
	public InscripcionDTO getInscripcion(String email, int id_competicion) {
		validateNotNull(email,MSG_EMAIL_NO_NULO);
		validateNotNull(id_competicion,MSG_ID_NO_NULO);
		
		List<InscripcionDTO> result = db.executeQueryPojo(InscripcionDTO.class, obtener_inscripcion, email, id_competicion);
		return result.get(0);
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
	
	

	public List<MetodoDePagoDTO> getListadoMetodosDePago(int id){
		validateNotNull(id,MSG_ID_NO_NULO);
		
		List<MetodoDePagoDTO> result = db.executeQueryPojo(MetodoDePagoDTO.class, SQL_LISTADO_METODOS_DE_PAGO, id);
		return result;
	}
	
	
	/**
	 * Inscribe a un atleta en una competicion, o dicho de otra forma, crea una nueva fila en la tabla inscripcion
	 * 
	 * @param email_atleta
	 * @param id_competicion
	 * @return 
	 */
	public void inscribirse(AtletaDTO atleta, int id_competicion, String dorsal, int precio, String ultFechaModif, String metodoPago, int id_metodoPago) {
		String sql = SQL_INSCRIBIRSE;
		db.executeUpdate(sql, atleta.getEmail(), id_competicion, dorsal, "---" , precio, ultFechaModif, atleta.getGenero(), metodoPago, id_metodoPago);
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
	public boolean verificarDorsal(String dorsal, int id_competicion) {
		validateNotNull(dorsal,MSG_DORSAL_NO_NULO);
		
		List<InscripcionDTO> result = db.executeQueryPojo(InscripcionDTO.class, obtener_por_dorsal, dorsal, id_competicion);
		return result.size() > 0;
	}
	
	public List<InscripcionDTO> getInscripcionesPorCompeticion(int id_competicion){
		validateNotNull(id_competicion ,MSG_ID_NO_NULO);
		String sql = SQL_INSCRIPCIONES_POR_COMPETICION;
		List<InscripcionDTO> result = db.executeQueryPojo(InscripcionDTO.class, sql, id_competicion);
		return result;
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
	
	public void actualizaMetodoDePago(int id, String tipo, boolean estado) {
		String sql = SQL_UPDATE_METODO_DE_PAGO;
		db.executeUpdate(sql, tipo,estado, id);
	}
	
	public void actualizaEstadoPago(int id_metodoPago, String estado) {
		String sql = SQL_UPDATE_ESTADO_PAGO;
		db.executeUpdate(sql, estado, id_metodoPago);

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
