package inscripcion;

import java.util.ArrayList;
import java.util.List;

import atleta.AtletaController;
import atleta.AtletaDTO;

public class InscripcionController {
	
	private InscripcionModel im;
	private AtletaController ac;
	private List<InscripcionDTO> idto;
	private String[] tipoClasif;
	
	/**
	 * Constructor sin parámetros de la clase InscripcionController
	 */
	public InscripcionController() {
		this.im = new InscripcionModel();
		this.ac = new AtletaController();
		
		this.idto = new ArrayList<InscripcionDTO>();
		this.tipoClasif = new String[2];
		tipoClasif[0] = "Absoluta";
		tipoClasif[1] = "Genero";
	}
	
	/**
	 * Constructor con un parámetro de la clase InscripcionController
	 * 
	 * @param im, una inscripcionModel
	 */
	public InscripcionController(InscripcionModel im) {
		this.im = im;
		this.ac = new AtletaController();
		
		this.idto = new ArrayList<InscripcionDTO>();
		this.tipoClasif = new String[2];
		tipoClasif[0] = "Absoluta";
		tipoClasif[1] = "Genero";
	}
	
	/**
	 * Crea la lista de inscripciones usando los id de una carrera ordenando por tiempo y genero
	 * 
	 * @param id, el id de la carrera
	 */
	public void rellenarIdGen(int id) {
		this.idto = im.getListadoInsIdGen(id);
	}
	
	/**
	 * Crea la lista de inscripciones usando los id de una carrera ordenando por tiempo y clasif abs
	 * 
	 * @param id, el id de la carrera
	 */
	public void rellenarIdAbs(int id) {
		this.idto = im.getListadoInsIdAbs(id);
	}
	
	/**
	 * Devuelve una lista de cadenas de texto con la clasificacion correspondiente
	 * 
	 * @param id, el id de la carrera
	 * @return una lista de cadenas de texto con toda la información
	 */
	public List<String> clasificacion(String tipo, int id) {
		if(tipo.equals("Genero")) {
			return clasifGenero(id);
		} else {
			return clasifAbs(id);
		}
	}
	
	/**
	 * Imprime la clasificación dependiendo del tipo seleccionado (genero o absoluta)
	 * 
	 * @param listadoIns, la lista de String a concatenar
	 * @return un string con todo el listado
	 */
	public String imprimirListadoClasif(List<String> listadoIns) {
		String listado = "";
		for(int i=0; i < listadoIns.size(); i++) {
			listado += listadoIns.get(i) + "\n";
		}
		return listado;

	}
	
	/**
	 * Clasifica dependiendo del sexo
	 * 
	 * @param id, el id de la carrera
	 * @return una lista de String con la clasificación
	 */
	private List<String> clasifGenero(int id) {
		rellenarIdGen(id);
		List<String> result = rellenarConAtletas();
		
		return result;
	}
	
	/**
	 * Clasifica independientemente del sexo
	 * 
	 * @param id, el id de la carrera
	 * @return una lista de String con la clasificación
	 */
	private List<String> clasifAbs(int id) {
		rellenarIdAbs(id);
		List<String> result = rellenarConAtletas();
		
		return result;
	}

	/**
	 * Relelna la clasificación con atletas
	 * 
	 * @return una lista de String
	 */
	private List<String> rellenarConAtletas() {
		AtletaDTO am = new AtletaDTO();
		
		List<String> result = new ArrayList<String>();
		String linea = "";
		int index = 1;
		
		for(InscripcionDTO ic : this.idto) {
			am = obtenerAtleta(ic.getEmail_atleta());
			linea = index + ", " + ic.categoriaSexo + ", " + am.getNombre() + ", " + ic.getTiempo();
			
			result.add(linea);
			index++;
		}
		return result;
	}

	/**
	 * Obtiene el atleta deseado introduciendo su email
	 * 
	 * @param email_atleta, el email del atleta
	 * @return un AtletaDTO
	 */
	private AtletaDTO obtenerAtleta(String email_atleta) {
		AtletaDTO result = ac.obtenerAtletaEmail(email_atleta);
		return result;
	}

	/**
	 * Devuelve la lista de inscripciones actual según el email de un atleta
	 * 
	 * @return la lista de inscripciones
	 */
	public List<InscripcionDTO> getIdto() {
		return idto;
	}
	
	/**
	 * Devuelve los tipos de clasificaciones disponibles
	 * 
	 * @return la lista de tipos de clasificacion 
	 */
	public String[] getTipoClasif() {
		return tipoClasif;
	}
	
}
