package inscripcion;

import java.util.List;

import atleta.AtletaDTO;
import competiciones.CompeticionDTO;
import giis.demo.util.ApplicationException;
import giis.demo.util.Database;
import metododepago.MetodoDePagoDTO;

public class InscripcionModel {
	
	
	
	
	// Mensajes de error
	private static final String MSG_ID_NO_NULO = "El id no puede ser nulo";
	private static final String MSG_GENERO_NO_NULO = "El genero no puede ser nulo";
	private static final String MSG_EMAIL_NO_NULO = "El email no puede ser nulo";
	
	private Database db=new Database();
	private String listado_inscr_id_genero = "SELECT * FROM Inscripcion WHERE id_competicion = ? and categoriaSexo = ? ORDER BY tiempo";
	private String listado_inscr_id_absoluta = "SELECT * FROM Inscripcion WHERE id_competicion = ? ORDER BY tiempo";
	private String listado_inscripciones = "SELECT * FROM Inscripcion WHERE email_atleta = ? ORDER BY ultFechaModif";
	
	
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
	 */
	public void inscribirse(AtletaDTO atleta, int id_competicion, String dorsal, int precio, String ultFechaModif, String metodoPago, int id_metodoPago) {
		String sql = SQL_INSCRIBIRSE;
		db.executeUpdate(sql, atleta.getEmail(), id_competicion, dorsal, "---" , precio, ultFechaModif, atleta.getGenero(), metodoPago, id_metodoPago);
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

	
	
	public void setMetodoDePago(int id, String tipo, boolean estado) {
		String sql = SQL_SET_METODO_DE_PAGO;
		db.executeUpdate(sql, id, tipo, estado);
	}
	
	
	public void actualizaMetodoDePago(int id, String tipo, boolean estado) {
		String sql = SQL_UPDATE_METODO_DE_PAGO;
		db.executeUpdate(sql, tipo,estado, id);
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
