package atleta;

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
	
	/**
	 * Encuentra un atleta y devuleve true y está, false si no
	 */
	public boolean encontrarAtleta(String email) {
		return am.getAtletaByEmail(email).size() > 0;
	}
	
	public boolean crearAtleta(String email, String nombre, String apellidos, String dni, String genero, String edad) {
		AtletaDTO atleta = new AtletaDTO();
		atleta.setEmail(email);
		atleta.setDni(dni);
		atleta.setFechaNacimiento(edad);
		atleta.setGenero(genero);
		atleta.setNombre(nombre);
		atleta.setApellidos(apellidos);
		am.añadirAtleta(atleta);
		
		if(am.getAtletaByEmail(email).size() > 0) {
			return true;
		}
		
		return false;
	}
	
	public boolean crearAtletaFechaSinModificar(String email, String nombre, String apellidos, String dni, String genero, String edad) {
		AtletaDTO atleta = new AtletaDTO();
		atleta.setEmail(email);
		atleta.setDni(dni);
		atleta.setFechaNacimiento(edad);
		atleta.setGenero(genero);
		atleta.setNombre(nombre);
		atleta.setApellidos(apellidos);
		
		am.añadirAtletaFechaSinModificar(atleta);
		
		if(am.getAtletaByEmail(email).size() > 0) {
			return true;
		}
		
		return false;
	}
	

}
