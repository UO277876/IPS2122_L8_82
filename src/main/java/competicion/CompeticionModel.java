package competicion;

import java.util.Date;
import java.util.List;

import giis.demo.util.ApplicationException;
import giis.demo.util.Database;
import giis.demo.util.Util;

public class CompeticionModel {

	private static final String MSG_FECHA_INSCRIPCION_NO_NULA = "La fecha de inscripcion no puede ser nula";

	private Database db = new Database();

	// SQL para obtener la lista de carreras activas para una fecha dada,
	// se incluye aqui porque se usara en diferentes versiones de los metodos bajo
	// prueba
	public static final String SQL_LISTA_COMPETICIONES = "SELECT nombre,fecha,tipo,distancia,fin,numPlazas"
			+ " from Competicion  where fecha>=? order by fecha";

	/**
	 * Obtiene la lista de carreras futuras (posteriores a una fecha dada) con el id
	 * y descripcion.
	 */
	public List<Object[]> getListaCompeticionesArray(Date fechaInscripcion) {
		validateNotNull(fechaInscripcion, MSG_FECHA_INSCRIPCION_NO_NULA);
		String d = Util.dateToIsoString(fechaInscripcion);
		return db.executeQueryArray(SQL_LISTA_COMPETICIONES, d);
	}

	/**
	 * Obtiene la lista de carreras activas en forma objetos para una fecha de
	 * inscripcion dada
	 */
	public List<CompeticionDTO> getListaCarreras(Date fechaInscripcion) {
		validateNotNull(fechaInscripcion, MSG_FECHA_INSCRIPCION_NO_NULA);
		String d = Util.dateToIsoString(fechaInscripcion);
		return db.executeQueryPojo(CompeticionDTO.class, SQL_LISTA_COMPETICIONES, d);
	}

	/**
	 * Obtiene todos los datos de la competicion con el id indicado
	 */
	public CompeticionDTO getCompeticion(int id) {
		String sql = "SELECT id,inicio,fin,fecha,descr from carreras where id=?";
		List<CompeticionDTO> carreras = db.executeQueryPojo(CompeticionDTO.class, sql, id);
		validateCondition(!carreras.isEmpty(), "Id de carrera no encontrado: " + id);
		return carreras.get(0);
	}

	/**
	 * Actualiza las fechas de inscripcion de una carrera
	 */
	public void updateFechasInscripcion(int id, Date inicio, Date fin) {
		CompeticionDTO competicion = this.getCompeticion(id);
		validateFechasInscripcion(inicio, fin, Util.isoStringToDate(competicion.getFecha()));
		String sql = "UPDATE carreras SET inicio=?, fin=? WHERE id=?";
		db.executeUpdate(sql, Util.dateToIsoString(inicio), Util.dateToIsoString(fin), id);
	}

	private void validateFechasInscripcion(Date inicio, Date fin, Date fecha) {
		validateNotNull(inicio, "La fecha de inicio de inscripcion no puede ser nula");
		validateNotNull(fin, "La fecha de fin de inscripcion no puede ser nula");
		validateNotNull(fecha, "La fecha de fin de carrera no puede ser nula");
		validateCondition(inicio.compareTo(fin) <= 0, "La fecha de inicio no puede ser posterior a la de fin");
		validateCondition(fin.compareTo(fecha) <= 0, "La fecha de fin no puede ser posterior a la de la carrera");
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
