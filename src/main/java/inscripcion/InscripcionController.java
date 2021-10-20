package inscripcion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import atleta.AtletaController;
import atleta.AtletaDTO;

import competiciones.CompeticionController;
import competiciones.CompeticionDTO;

public class InscripcionController {
	

	private static final String characters = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	
	private InscripcionModel im;

	private AtletaController ac;
	private CompeticionController cm;

	private List<InscripcionDTO> idto;
	
	
	private String emailProvisionalParaPago;
	private int idProvisionalParaPago;
	
	
	/**
	 * Constructor sin parámetros de la clase InscripcionController
	 */
	public InscripcionController() {
		this.im = new InscripcionModel();
		this.ac = new AtletaController();
		this.cm = new CompeticionController();
		
		this.idto = new ArrayList<InscripcionDTO>();
	}
	
	/**
	 * Constructor con un parámetro de la clase InscripcionController
	 * 
	 * @param im, una inscripcionModel
	 */
	public InscripcionController(InscripcionModel im) {
		this.im = im;
		this.ac = new AtletaController();
		this.cm = new CompeticionController();
		
		this.idto = new ArrayList<InscripcionDTO>();
	}
	
	
	
	public void setEmailProvisionalParaPago(String email) {
		this.emailProvisionalParaPago = email;
	}
	
	
	public String getEmailProvisionalParaPago() {
		return this.emailProvisionalParaPago;
	}
	
	public void setIdProvisionalParaPago(int id) {
		this.idProvisionalParaPago = id;
	}
	
	public int getIdProvisionalParaPago() {
		return this.idProvisionalParaPago;
	}
	
	
	
	/**
	 * Crea la lista de inscripciones usando los id de una carrera ordenando por tiempo y genero
	 * 
	 * @param id, el id de la carrera
	 */
	public void rellenarIdGen(int id, String genero) {
		this.idto = im.getListadoInsIdGen(id, genero);
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
	 * Devuelve una lista de cadenas de texto con la información:
	 * Nombre competicion + estado actual inscripcion + fecha ult. cambio de estado
	 * 
	 * @param email, el email de la persona a buscar las inscripciones
	 * @return una lista de cadenas de texto con toda la información
	 * @throws ParseException 
	 */
	public List<String> listarPorIds(String email) {
		setIdto(email);
		CompeticionDTO lm = new CompeticionDTO();
		
		List<String> result = new ArrayList<String>();
		String linea = "";
		
		for(InscripcionDTO ic : this.idto) {
			lm = obtenerCompeticion(ic.id_competicion);
			linea = lm.getNombre() + " - " + ic.getIEstado() + " - " + ic.getUltFechaModif();
			
			result.add(linea);
		}
		
		return result;
	}
	
	/**
	 * Devuelve la competicion de id pasado como parámetro. Para ello,
	 * llama al CompeticionController
	 * 
	 * @return la competición
	 */
	public CompeticionDTO obtenerCompeticion(int id) {
		return cm.obtenerCompeticion(id);
	}
	
	/**
	 * Imprime el listado en el formato 
	 * Nombre competicion + estado actual inscripcion + fecha ult. cambio de estado
	 * De un solo String
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
		rellenarIdGen(id,"masculino");
		List<String> result1 = rellenarConAtletas();
		result1.add(0, "MASCULINO");
		
		
		rellenarIdGen(id,"femenino");
		List<String> result2 = rellenarConAtletas();
		result2.add(0, "FEMENINO");
		
		result1.addAll(result2);
		
		return result1;
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

	public String imprimirListado(List<String> listadoIns) {
		String listado = "";
		for(int i=0; i < listadoIns.size(); i++) {
			listado += "> " + listadoIns.get(i) + "\n";
		}
		return listado;
	}
	
	/**
	 * Almacena la lista de inscripciones según el email de un atleta
	 * 
	 * @param email, el email a analizar
	 */
	private void setIdto(String email) {
		this.idto = im.getListadoInscripciones(email);
		
		for(InscripcionDTO ic : this.idto ) {
			ic.actualizaEstado();
		}
	}
	
	/**
	 * Devuelve la lista de inscripciones actual según el email de un atleta
	 * 
	 * @return la lista de inscripciones
	 */
	public List<InscripcionDTO> getIdto() {
		return idto;
	}
	
	
	
	public String getNewDorsal() {
		Random rng = new Random();
		char[] text = new char[4];
	    for (int i = 0; i < 4; i++)
	    {
	        text[i] = characters.charAt(rng.nextInt(characters.length()));
	    }
	    return new String(text);
	}
	
	
	public void inscribirAtleta(AtletaDTO atleta, int id_competicion, String dorsal, int precio, String metodoPago) {
		im.inscribirse(atleta, id_competicion, dorsal, precio, getActualDate(), metodoPago);
	}
	
	
	public String getActualDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
		Date dateAct = new Date();
		return dateFormat.format(dateAct);
	}
	
	
	
	/*
	public void ChangePaidMethod(String email, String id, String newPaidMethod) {
		im.changePaidMethodForInscripcion(email, id, newPaidMethod);
	}
	*/
}
