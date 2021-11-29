package metododepago;

import java.util.List;

import giis.demo.util.ApplicationException;
import giis.demo.util.Database;

public class MetodoDePagoModel {
	
	// Mensajes de error
	private static final String MSG_ID = "El id no puede ser nulo";
	
	private Database db=new Database();
	
	public static final String SQL_GET_PAGO = "SELECT * from MetodoDePago where id = ?";
	
	public static final String SQL_SET_METODO_DE_PAGO = "INSERT into MetodoDePago (id, tipo, estado) VALUES (?,?,?)";
	
	/**
	 * Obtiene la competición de un solo id
	 */
	public MetodoDePagoDTO getPago(int id) {
		validateNotNull(id, MSG_ID);	
		String sql = SQL_GET_PAGO;
		List<MetodoDePagoDTO> result = db.executeQueryPojo(MetodoDePagoDTO.class, sql, id);
		MetodoDePagoDTO pago = result.get(0);
		return pago;
	}

	
	private void validateNotNull(Object obj, String message) {
		if (obj==null)
			throw new ApplicationException(message);
	}


	public void setMetodoDePago(int id_metodopago, String metodoPago, boolean b) {
		String sql = SQL_SET_METODO_DE_PAGO;
		db.executeUpdate(sql, id_metodopago, metodoPago, b);
		
	}
}
