package atleta;

import java.util.List;

import giis.demo.util.ApplicationException;
import giis.demo.util.Database;

public class AtletaModel {
	
	private static Database db = new Database();
	
	private static final String MSG_EMAIL_NO_NULO = "El email no puede ser nulo";
	
	
	private static final String obtener_atleta_email = 
			"SELECT * from Atleta where email = ?";
	
	private static final String añadir_atleta = "INSERT INTO Atleta(email,genero,nombre,fechaDeNacimiento,dni) VALUES(?,?,?,?,?)";

	
	public List<AtletaDTO> getAtletaEmail(String email_atleta) {
		validateNotNull(obtener_atleta_email,MSG_EMAIL_NO_NULO);
		
		List<AtletaDTO> result = db.executeQueryPojo(AtletaDTO.class, obtener_atleta_email, email_atleta);
		return result;
	}
	
	/**
	 * Añadir atleta
	 */
	public void añadirAtleta(AtletaDTO atleta) {
		validateNotNull(atleta,"El atleta no puede ser null");
		
		db.executeUpdate(añadir_atleta, atleta.getEmail(), atleta.getGenero(), atleta.getNombre(), atleta.getFechaNacimiento(),
				atleta.getDni());
	}
	
	/* De uso general para validacion de objetos */
	private void validateNotNull(Object obj, String message) {
		if (obj==null)
			throw new ApplicationException(message);
	}

	
}
