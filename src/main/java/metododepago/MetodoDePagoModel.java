package metododepago;

import java.util.List;

import giis.demo.util.ApplicationException;
import giis.demo.util.Database;

public class MetodoDePagoModel {
	
	// Mensajes de error
	private static final String MSG_EMAIL = "El email no puede ser nulo o vacío";
	
	private Database db=new Database();
	
	public static final String SQL_GET_PAGO = "SELECT * from MetodoDePago where email_atleta = ?";
	
	/**
	 * Obtiene la competición de un solo id
	 */
	public MetodoDePagoDTO getPago(String email) {
		validateNotNull(email,MSG_EMAIL);
		validateNotEmpty(email, MSG_EMAIL);
		
		List<MetodoDePagoDTO> result = db.executeQueryPojo(MetodoDePagoDTO.class, SQL_GET_PAGO, email);
		return result.get(0);
	}
	
	private void validateNotEmpty(String obj, String message) {
		if (obj.equals(""))
			throw new ApplicationException(message);
	}
	
	private void validateNotNull(Object obj, String message) {
		if (obj==null)
			throw new ApplicationException(message);
	}
}
