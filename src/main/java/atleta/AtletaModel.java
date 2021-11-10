package atleta;

import java.util.List;

import giis.demo.util.ApplicationException;
import giis.demo.util.Database;
import giis.demo.util.Util;

public class AtletaModel {
	
	private static Database db = new Database();
	
	private static final String MSG_EMAIL_NO_NULO = "El email no puede ser nulo";
	private static final String MSG_EMAIL_NOT_EMPTY = "El email no puede ser nulo o vacío";
	
	
	private static final String obtener_atleta_email = 
			"SELECT * from Atleta where email = ?";
	
	private static final String añadir_atleta = "INSERT INTO Atleta(email,genero,nombre,apellidos,fechaNacimiento,dni) VALUES(?,?,?,?,?,?)";
	
	private String obtener_todos_los_atletas = 
			"SELECT * from Atleta";

	
	public List<AtletaDTO> getAtletaByEmail(String email_atleta) {
		validateNotNull(email_atleta,MSG_EMAIL_NO_NULO);
		//validateNotEmpty(email_atleta,MSG_EMAIL_NOT_EMPTY);
		
		List<AtletaDTO> result = db.executeQueryPojo(AtletaDTO.class, obtener_atleta_email, email_atleta);
		return result;
	}
	
	/**
	 * Añadir atleta
	 */
	public void añadirAtleta(AtletaDTO atleta) {
		validateNotNull(atleta,"El atleta no puede ser null");
		
		db.executeUpdate(añadir_atleta, atleta.getEmail(), atleta.getGenero(), atleta.getNombre(), atleta.getApellidos(),
				Util.isoStringToDate(atleta.getFechaNacimiento()), atleta.getDni());
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
