package competicion;

import java.util.Date;
import java.util.List;

import giis.demo.tkrun.CarreraDisplayDTO;
import giis.demo.tkrun.CarreraEntity;
import giis.demo.util.ApplicationException;
import giis.demo.util.Database;
import giis.demo.util.Util;

public class CompeticionModel {

	private static final String MSG_FECHA_INSCRIPCION_NO_NULA = "La fecha de inscripcion no puede ser nula";

	private Database db = new Database();

	// SQL para obtener la lista de carreras activas para una fecha dada,
	// se incluye aqui porque se usara en diferentes versiones de los metodos bajo
	// prueba
	public static final String SQL_LISTA_CARRERAS = "SELECT id,descr," + " case when ?<inicio then ''" // antes de
																										// inscripcion
			+ "   when ?<=fin then '(Abierta)'" // fase 1
			+ "   when ?<fecha then '(Abierta)'" // fase 2
			+ "   when ?=fecha then '(Abierta)'" // fase 3
			+ "   else '' " // despues de fin carrera
			+ " end as abierta" + " from carreras  where fecha>=? order by id";

	/**
	 * Obtiene la lista de carreras futuras (posteriores a una fecha dada) con el
	 * id, descripcion y la indicacion de si tienen inscripcion abierta.
	 * Implementacion usando la utilidad que obtiene una lista de arrays de objetos
	 * resultado de la ejecucion de una query sql
	 */
	public List<Object[]> getListaCarrerasArray(Date fechaInscripcion) {
		validateNotNull(fechaInscripcion, MSG_FECHA_INSCRIPCION_NO_NULA);
		// concatena los campos deseados en una unica columna pues el objetivo es
		// devolver una lista de strings
		String sql = "SELECT id || '-' || descr || ' ' || abierta as item from (" + SQL_LISTA_CARRERAS + ")";
		String d = Util.dateToIsoString(fechaInscripcion);
		return db.executeQueryArray(sql, d, d, d, d, d);
	}

	/**
	 * Obtiene la lista de carreras activas en forma objetos para una fecha de
	 * inscripcion dada
	 */
	public List<CarreraDisplayDTO> getListaCarreras(Date fechaInscripcion) {
		validateNotNull(fechaInscripcion, MSG_FECHA_INSCRIPCION_NO_NULA);
		String sql = "SELECT id,descr," + " case when ?<inicio then ''" // antes de inscripcion
				+ "   when ?<=fin then '(Abierta)'" // fase 1
				+ "   when ?<fecha then '(Abierta)'" // fase 2
				+ "   when ?=fecha then '(Abierta)'" // fase 3
				+ "   else '' " // despues de fin carrera
				+ " end as abierta" + " from carreras  where fecha>=? order by id";
		String d = Util.dateToIsoString(fechaInscripcion);
		return db.executeQueryPojo(CarreraDisplayDTO.class, sql, d, d, d, d, d);
	}

	/**
	 * Obtiene todos los datos de la competicion con el id indicado
	 */
	public CarreraEntity getCarrera(int id) {
		String sql = "SELECT id,inicio,fin,fecha,descr from carreras where id=?";
		List<CarreraEntity> carreras = db.executeQueryPojo(CarreraEntity.class, sql, id);
		validateCondition(!carreras.isEmpty(), "Id de carrera no encontrado: " + id);
		return carreras.get(0);
	}

	/**
	 * Actualiza las fechas de inscripcion de una carrera
	 */
	public void updateFechasInscripcion(int id, Date inicio, Date fin) {
		CarreraEntity carrera = this.getCarrera(id);
		validateFechasInscripcion(inicio, fin, Util.isoStringToDate(carrera.getFecha()));
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
