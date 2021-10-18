package atleta;

import java.util.List;

import giis.demo.util.ApplicationException;
import giis.demo.util.Database;

public class AtletaModel {
	
	private static Database db = new Database();
	
	private static final String MSG_EMAIL_NO_NULO = "El email no puede ser nulo";
	
	
	public static final String SQL_INSCRIBIRSE = 
			"INSERT into Inscripcion (email_atleta, id_competicion) VALUES (?,?)";
	private String obtener_atleta_email = "SELECT * from Atleta where email = ?";

	
	public static void inscribirse(String email_atleta, int id_competicion) {
		String sql = SQL_INSCRIBIRSE;
		db.executeUpdate(sql, email_atleta, id_competicion);
	}
	
	public List<AtletaDTO> getAtletaEmail(String email_atleta) {
		validateNotNull(obtener_atleta_email,MSG_EMAIL_NO_NULO);
		
		List<AtletaDTO> result = db.executeQueryPojo(AtletaDTO.class, obtener_atleta_email, email_atleta);
		return result;
	}
	
	/* De uso general para validacion de objetos */
	private void validateNotNull(Object obj, String message) {
		if (obj==null)
			throw new ApplicationException(message);
	}

	
}
