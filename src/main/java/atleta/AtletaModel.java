package atleta;

import java.util.List;

import giis.demo.util.ApplicationException;
import giis.demo.util.Database;

public class AtletaModel {
	
	// Mensajes de error
	private static final String MSG_EMAIL_NO_NULO = "El email no puede ser nulo";
	
	private Database db=new Database();
	private String obtener_atleta_email = "SELECT * FROM Atleta WHERE email = ?";
	
	/**
	 * Obtiene toda la informacion de un atleta segun su email
	 */
	public List<AtletaDTO> getAtletaEmail(String email) {
		validateNotNull(email,MSG_EMAIL_NO_NULO);
		
		List<AtletaDTO> result = db.executeQueryPojo(AtletaDTO.class, obtener_atleta_email, email);
		return result;
	}
	
	/* De uso general para validacion de objetos */
	private void validateNotNull(Object obj, String message) {
		if (obj==null)
			throw new ApplicationException(message);
	}

}
