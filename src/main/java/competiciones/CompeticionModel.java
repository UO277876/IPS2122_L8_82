package competiciones;

import java.util.Date;
import java.util.List;

import giis.demo.util.ApplicationException;
import giis.demo.util.Database;
import giis.demo.util.Util;

public class CompeticionModel {

	// Mensajes de error
	private static final String MSG_ID_NO_NULO = "El id no puede ser nulo";
	private static final String MSG_NOMBRE = "El nombre no puede ser nulo o vacío";
	private static final String MSG_DTO = "La competicion no puede ser nula o vacía";
	private Database db = new Database();
	private static final String LISTADO_COMPETICIONES = "SELECT * FROM Competicion c WHERE id = ? ";
	private static final String SQL_GET_LISTA_NOMBRE = "SELECT * from Competicion where nombre = ?";
	private static final String GET_COMPETICIONES = "SELECT * from Competicion";
	//private static final String INTRODUCIR_COMPETICION_SIN_CANCELACION = "INSERT INTO Competicion(id, inicio, fin, tipo, numPlazas, fecha, nombre, descr, distancia, hayCancelacion, dorsalesReservados) "
	//		+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

	private static final String INTRODUCIR_COMPETICION_CON_CANCELACION = "INSERT INTO Competicion(id, inicio, fin, tipo, numPlazas, fecha, nombre, descr, distancia, hayCancelacion, porcentajeDevuelto, fechaLimite, dorsalesReservados) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	private static final String UPDATE_PLAZAS = "UPDATE Competicion SET numPlazas = ? WHERE id = ?";
	
	/**
	 * Actualiza las plazas
	 */
	public void actualizarPlazas(int id, int plazas) {
		validateNotNull(id, MSG_ID_NO_NULO);

		db.executeUpdate(UPDATE_PLAZAS, plazas, id);
	}

	/**
	 * Obtiene la competición de un solo id
	 */
	public List<CompeticionDTO> getListadoCompeticiones(int id) {
		validateNotNull(id, MSG_ID_NO_NULO);

		List<CompeticionDTO> result = db.executeQueryPojo(CompeticionDTO.class, LISTADO_COMPETICIONES, id);
		return result;
	}

	/**
	 * Obtiene la competición de un solo id
	 */
	public List<CompeticionDTO> getCompeticiones() {
		List<CompeticionDTO> result = db.executeQueryPojo(CompeticionDTO.class, GET_COMPETICIONES);
		return result;
	}
	
	/**
	 * Añade una competicion sin cancelacion
	 */
	// public void addCompeticion(CompeticionDTO dto) {
	// 	validateNotNull(dto, MSG_DTO);
	// 	validateFechasInscripcion(Util.isoStringToDate(dto.getInicio()), Util.isoStringToDate(dto.getFin()),
	// 			Util.isoStringToDate(dto.getFecha()));

	// 	db.executeUpdate(INTRODUCIR_COMPETICION_SIN_CANCELACION, dto.getId(), Util.isoStringToDate(dto.getInicio()),
	// 			Util.isoStringToDate(dto.getFin()), dto.getTipo(), dto.getNumPlazas(),
	// 			Util.isoStringToDate(dto.getFecha()), dto.getNombre(), dto.getDescripcion(), dto.getDistancia(),
	// 			dto.isHayCancelacion(), dto.getDorsalesReservados());
	
	/**
	 * Añade una competicion con politica de cancelaciones
	 */
	public void addCompeticionConCancelacion(CompeticionDTO dto) {
		validateNotNull(dto, MSG_DTO);
		validateFechasInscripcion(Util.isoStringToDate(dto.getInicio()), Util.isoStringToDate(dto.getFin()),
				Util.isoStringToDate(dto.getFecha()));

		db.executeUpdate(INTRODUCIR_COMPETICION_CON_CANCELACION, dto.getId(), Util.isoStringToDate(dto.getInicio()),
				Util.isoStringToDate(dto.getFin()), dto.getTipo(), dto.getNumPlazas(),
				Util.isoStringToDate(dto.getFecha()), dto.getNombre(), dto.getDescr(), dto.getDistancia(),
				dto.isHayCancelacion(),dto.getPorcentajeDevuelto(),Util.isoStringToDate(dto.getFechaLimite()), dto.getDorsalesReservados());
	}

	/**
	 * Obtiene la lista de carreras de un nombre en concreto y descripcion.
	 */
	public List<CompeticionDTO> getListaCompeticionesName(String name) {
		validateNotNull(name, MSG_NOMBRE);

		List<CompeticionDTO> result = db.executeQueryPojo(CompeticionDTO.class, SQL_GET_LISTA_NOMBRE, name);
		
		return result;
	}

	/**
	 * Obtiene la lista de carreras de un nombre en concreto y descripcion.
	 */
	public boolean getListaCompeticionesNameBool(String name) {
		validateNotNull(name, MSG_NOMBRE);
		validateNotEmpty(name, MSG_NOMBRE);

		List<CompeticionDTO> result = db.executeQueryPojo(CompeticionDTO.class, SQL_GET_LISTA_NOMBRE, name);
		if (result.size() > 0) {
			return true;
		}

		return false;
	}

	/* De uso general para validacion de objetos */
	private void validateNotNull(Object obj, String message) {
		if (obj == null)
			throw new ApplicationException(message);
	}

	private void validateNotEmpty(String obj, String message) {
		if (obj.equals(""))
			throw new ApplicationException(message);
	}

	private void validateCondition(boolean condition, String message) {
		if (!condition)
			throw new ApplicationException(message);
	}

	private void validateFechasInscripcion(Date inicio, Date fin, Date fecha) {
		validateNotNull(inicio, "La fecha de inicio de inscripcion no puede ser nula");
		validateNotNull(fin, "La fecha de fin de inscripcion no puede ser nula");
		validateNotNull(fecha, "La fecha de fin de competicion no puede ser nula");
		validateCondition(inicio.compareTo(fin) <= 0, "La fecha de inicio no puede ser posterior a la de fin");
		validateCondition(fin.compareTo(fecha) <= 0, "La fecha de fin no puede ser posterior a la de la competicion");
	}

}
