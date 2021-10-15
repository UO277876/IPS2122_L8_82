package inscripcion;

import java.util.ArrayList;
import java.util.List;

public class InscripcionController {
	
	private InscripcionModel im;
	
	public InscripcionController() {
		this.im = new InscripcionModel();
	}
	
	public InscripcionController(InscripcionModel im) {
		this.im = im;
	}
	
	/**
	 * Devuelve la lista de inscripciones de un atleta
	 * 
	 * @param email, el email a analizar
	 * @return Un listado de 
	 */
	public List<String> listarPorIds(String email) {
		List<Object[]> li = im.getListadoInscripciones(email);
		List<String> listado = new ArrayList<String>();
		
		for(Object[] obj : li) {
			listado.add(obj.toString());
		}
		
		return listado;
	}
	
	/**
	 * Mira si hay inscripciones del email pasado como parámetro
	 * 
	 * @param email, el email a analizar
	 * @return
	 * True si hay inscripciones
	 * False si no
	 */
	public boolean emailExists(String email) {
		return im.getNumInscripciones(email) > 0;
	}
	
	// Getters y setters
	
}
