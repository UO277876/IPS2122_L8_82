package competiciones;

import java.util.List;

import giis.demo.util.ApplicationException;
import giis.demo.util.Database;

public class CompeticionModel {
	
	// Mensajes de error
	private static final String MSG_ID_NO_NULO = "El id no puede ser nulo";
	
	private Database db=new Database();
	public String listado_competiciones = "SELECT * FROM Competicion c WHERE id = ? ";
	
	/**
	 * Obtiene la competición de un solo id
	 */
	public List<CompeticionDTO> getListadoCompeticiones(int id) {
		validateNotNull(id,MSG_ID_NO_NULO);
		
		List<CompeticionDTO> result = db.executeQueryPojo(CompeticionDTO.class, listado_competiciones, id);
		return result;
	}
	
	/* De uso general para validacion de objetos */
	private void validateNotNull(Object obj, String message) {
		if (obj==null)
			throw new ApplicationException(message);
	}

}
