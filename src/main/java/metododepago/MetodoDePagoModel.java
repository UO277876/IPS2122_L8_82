package metododepago;

import java.util.List;

import giis.demo.util.ApplicationException;
import giis.demo.util.Database;

public class MetodoDePagoModel {
	
	// Mensajes de error
	private static final String MSG_ID = "El id no puede ser nulo";
	
	private Database db=new Database();
	
	public static final String SQL_GET_PAGO = "SELECT * from MetodoDePago where id = ?";
	public static final String SQL_SET_METODO_DE_PAGO =
			"INSERT into MetodoDePago (id, tipo, estado) values (?,?,?)";
	public static final String OBTENER_TODO = "SELECT * FROM MetodoDePago";
	
	/**
	 * Obtiene la competición de un solo id
	 */
	public MetodoDePagoDTO getPago(int id) {
		validateNotNull(id, MSG_ID);
		List<MetodoDePagoDTO> result = db.executeQueryPojo(MetodoDePagoDTO.class, SQL_GET_PAGO, id);
		return result.get(0);
	}
	
	public void setMetodoDePago(int id, String tipo, boolean estado) {
		String sql = SQL_SET_METODO_DE_PAGO;
		db.executeUpdate(sql, id, tipo, estado);
	}
	
	private void validateNotNull(Object obj, String message) {
		if (obj==null)
			throw new ApplicationException(message);
	}
}
