package competicion;

import java.util.Date;
import java.util.List;

import giis.demo.util.ApplicationException;
import giis.demo.util.Database;
import giis.demo.util.Util;

public class CompeticionModel {

	private static final String MSG_FECHA_INSCRIPCION_NO_NULA = "La fecha de inscripcion no puede ser nula";

	private Database db = new Database();

	// SQL para obtener la lista de competiciones
	public static final String SQL_LISTA_COMPETICIONES = "SELECT * from Competicion where fecha>=? order by fecha";
	public static final String SQL_GET_LISTA_NOMBRE = "SELECT * from Competicion where nombre = ?";

	public CompeticionModel() {
		db.loadDatabase();
	}

	/**
	 * Obtiene la lista de carreras futuras (posteriores a una fecha dada) con el id
	 * y descripcion.
	 */
	public List<Object[]> getListaCompeticionesArray(Date fechaInscripcion) {
		validateNotNull(fechaInscripcion, MSG_FECHA_INSCRIPCION_NO_NULA);
		String d = Util.dateToIsoString(fechaInscripcion);
		List<Object[]> competiciones = db.executeQueryArray(SQL_LISTA_COMPETICIONES, d);
		return competiciones;
	}

	/**
	 * Obtiene la lista de carreras activas en forma objetos para una fecha de
	 * inscripcion dada
	 */
	public List<CompeticionDTO> getListaCompeticiones(Date fechaInscripcion) {
		validateNotNull(fechaInscripcion, MSG_FECHA_INSCRIPCION_NO_NULA);
		String d = Util.dateToIsoString(fechaInscripcion);
		List<CompeticionDTO> competiciones = db.executeQueryPojo(CompeticionDTO.class, SQL_LISTA_COMPETICIONES, d);
		return competiciones;
	}

	/**
	 * Obtiene todos los datos de la competicion con el id indicado
	 */
	public CompeticionDTO getCompeticion(int id) {
		String sql = "SELECT * from Competicion where id=?";
		List<CompeticionDTO> competicion = db.executeQueryPojo(CompeticionDTO.class, sql, id);
		validateCondition(!competicion.isEmpty(), "Id de competicion no encontrado: " + id);
		return competicion.get(0);
	}

	/**
	 * Actualiza las fechas de inscripcion de una competicion
	 */
	public void updateFechasInscripcion(int id, Date inicio, Date fin) {

		CompeticionDTO competicion = this.getCompeticion(id);
		validateFechasInscripcion(inicio, fin, Util.isoStringToDate(competicion.getFecha()));
		String sql = "UPDATE Competicion SET inicio=?, fin=? WHERE id=?";
		db.executeUpdate(sql, Util.dateToIsoString(inicio), Util.dateToIsoString(fin), id);
	}

	private void validateFechasInscripcion(Date inicio, Date fin, Date fecha) {
		validateNotNull(inicio, "La fecha de inicio de inscripcion no puede ser nula");
		validateNotNull(fin, "La fecha de fin de inscripcion no puede ser nula");
		validateNotNull(fecha, "La fecha de fin de competicion no puede ser nula");
		validateCondition(inicio.compareTo(fin) <= 0, "La fecha de inicio no puede ser posterior a la de fin");
		validateCondition(fin.compareTo(fecha) <= 0, "La fecha de fin no puede ser posterior a la de la competicion");
	}

	/* De uso general para validacion de objetos */
	private void validateNotNull(Object obj, String message) {
		if (obj == null)
			throw new ApplicationException(message);
	}

	private void validateCondition(boolean condition, String message) {
		if (!condition)
			throw new ApplicationException(message);
	}
	
}
