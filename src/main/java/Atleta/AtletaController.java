package Atleta;

import java.util.List;

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
	public AtletaDTO obtenerAtletaByEmail(String email) {
		AtletaDTO atleta = new AtletaDTO();
		List<AtletaDTO> atletas = am.getAtletaByEmail(email);
		for(AtletaDTO a : atletas) {
			if(a.getEmail().equals(email)) {
				atleta = a;
			}
		}
		
		if(atleta.getNombre() == null) {
			return null;
		}
		
		return atleta;
	}
	
	
	
	


}
