package atleta;

public class AtletaController {
	
	private AtletaModel am;
	
	/**
	 * Constructor sin parámetros de la clase AtletaController
	 */
	public AtletaController() {
		this.am= new AtletaModel();
	}

	/**
	 * Constructor con un parámetro de la clase AtletaController
	 * 
	 * @param am, una atletaModel
	 */
	public AtletaController(AtletaModel am) {
		this.am = am;
	}
	
	/**
	 * Deuvleve un AtletaDTO del email pasado como parámetro, buscándolo en la BD
	 * 
	 * @param email, el email del atleta
	 * @return un atletaDTO
	 */
	public AtletaDTO obtenerAtletaEmail(String email) {
		return am.getAtletaEmail(email).get(0);
	}
	

}
