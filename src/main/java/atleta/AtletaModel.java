package atleta;

import java.util.List;

import giis.demo.util.ApplicationException;
import giis.demo.util.Database;

public class AtletaModel {
	
	private static Database db = new Database();
	
	private static final String MSG_EMAIL_NO_NULO = "El email no puede ser nulo";
	private static final String MSG_EMAIL_NOT_EMPTY = "El email no puede ser nulo o vacío";
	
	
	private String obtener_atleta_email = 
			"SELECT * from Atleta where email = ?";
	
	
	private String obtener_todos_los_atletas = 
			"SELECT * from Atleta";

	
	public List<AtletaDTO> getAtletaByEmail(String email_atleta) {
		validateNotNull(email_atleta,MSG_EMAIL_NO_NULO);
		validateNotEmpty(email_atleta,MSG_EMAIL_NOT_EMPTY);
		
		List<AtletaDTO> result = db.executeQueryPojo(AtletaDTO.class, obtener_atleta_email, email_atleta);
		return result;
	}
	
	
	public List<AtletaDTO> getAtletas(){
		List<AtletaDTO> result = db.executeQueryPojo(AtletaDTO.class, obtener_todos_los_atletas);
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
	
}
