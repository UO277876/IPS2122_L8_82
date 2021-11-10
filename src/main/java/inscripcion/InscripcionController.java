package inscripcion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import Atleta.AtletaController;
import Atleta.AtletaDTO;
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
	public void rellenarNombreGen(String nombre, String genero) {
		int id = this.cm.obtenerCompeticionName(nombre).getId();
		this.idto = im.getListadoInsIdGen(id, genero);
	}
	
	/**
	 * Crea la lista de inscripciones usando los id de una carrera ordenando por tiempo y clasif abs
	 * 
	 * @param id, el id de la carrera
	 */
	public void rellenarNombreAbs(String nombre) {
		int id = this.cm.obtenerCompeticionName(nombre).getId();
		this.idto = im.getListadoInsIdAbs(id);
	}
	
	/**
	 * Devuelve una lista de cadenas de texto con la clasificacion correspondiente
	 * 
	 * @param id, el id de la carrera
	 * @return una lista de cadenas de texto con toda la información
	 */
	public List<ClasificacionDTO> clasificacion(String tipo, String nombre) {
		if(tipo.equals("Genero")) {
			return clasifGenero(nombre);
		} else {
			return clasifAbs(nombre);
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
	public List<ListadoDTO> listarPorIds(String email) {
		setIdto(email);
		CompeticionDTO lm = new CompeticionDTO();
		
		List<ListadoDTO> result = new ArrayList<ListadoDTO>();
		//String linea = "";
		
		for(InscripcionDTO ic : this.idto) {
			lm = obtenerCompeticion(ic.id_competicion);
			ListadoDTO list = new ListadoDTO(lm.getNombre(), ic.getIEstado(), ic.getUltFechaModif());
			//linea = lm.getNombre() + " - " + ic.getIEstado() + " - " + ic.getUltFechaModif();
			
			result.add(list);
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
	 * Clasifica dependiendo del sexo
	 * 
	 * @param id, el id de la carrera
	 * @return una lista de String con la clasificación
	 */
	private List<ClasificacionDTO> clasifGenero(String nombre) {
		rellenarNombreGen(nombre,"masculino");
		List<ClasificacionDTO> result1 = rellenarConAtletas();
		//result1.add(0, "MASCULINO");
		
		
		rellenarNombreGen(nombre,"femenino");
		List<ClasificacionDTO> result2 = rellenarConAtletas();
		//result2.add(0, "FEMENINO");
		
		result1.addAll(result2);
		
		return result1;
	}
	
	/**
	 * Clasifica independientemente del sexo
	 * 
	 * @param id, el id de la carrera
	 * @return una lista de String con la clasificación
	 */
	private List<ClasificacionDTO> clasifAbs(String nombre) {
		rellenarNombreAbs(nombre);
		List<ClasificacionDTO> result = rellenarConAtletas();
		
		return result;
	}

//	/**
//	 * Relelna la clasificación con atletas
//	 * 
//	 * @return una lista de ClasificacionDTO
//	 */
//	private List<ClasificacionDTO> rellenarConAtletas() {
//		AtletaDTO am = new AtletaDTO();
//		
//		List<String> result = new ArrayList<String>();
//		String linea = "";
//		int index = 1;
//		
//		for(InscripcionDTO ic : this.idto) {
//			am = obtenerAtleta(ic.getEmail_atleta());
//			linea = index + ", " + ic.categoriaSexo + ", " + am.getNombre() + ", " + ic.getTiempo();
//			
//			result.add(linea);
//			index++;
//		}
//		return result;
//	}
	
	/**
	 * Relelna la clasificación con atletas
	 * 
	 * @return una lista de ClasificacionDTO
	 */
	private List<ClasificacionDTO> rellenarConAtletas() {
		AtletaDTO am = new AtletaDTO();
		
		List<ClasificacionDTO> result = new ArrayList<ClasificacionDTO>();
		int index = 1;
		
		for(InscripcionDTO ic : this.idto) {
			am = obtenerAtleta(ic.getEmail_atleta());

			ClasificacionDTO clasif = new ClasificacionDTO(index,am.getNombre(),ic.categoriaSexo,ic.getTiempo());
			
			result.add(clasif);
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
		AtletaDTO result = ac.obtenerAtletaByEmail(email_atleta);
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
		im.inscribirse(atleta, id_competicion, dorsal, precio, getActualDate(), metodoPago, 0);
	}
	
	public boolean checkAtletaInscrito(AtletaDTO atleta, int id_competicion) {
		boolean isAtletaInscrito = false;
		List<InscripcionDTO> inscripciones = im.getInscripcionesPorCompeticion(id_competicion);
		for(InscripcionDTO inscripcion : inscripciones) {
			if(inscripcion.getEmail_atleta().equals(atleta.getEmail())) {
				isAtletaInscrito = true;
			}
		}
		
		
		return isAtletaInscrito;
	}
	
	
	public String getActualDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
		Date dateAct = new Date();
		return dateFormat.format(dateAct);
	}
	
	public float getPrecioInscripcion(int id_competicion) {
		float cantidad = 0.0f;
		List<InscripcionDTO> inscripciones = im.getInscripcionesPorCompeticion(id_competicion);
		if(inscripciones.size() > 0) {
			cantidad = inscripciones.get(0).getPrecio();
		}
		return cantidad;
	}
	
	
	public void setMetodoDePago(String email, int id_competicion, String metodoDePago) {
		if(metodoDePago.equals("Tarjeta")) {
			im.changePaidMethodForInscripcion(getEmailProvisionalParaPago(), getIdProvisionalParaPago(), metodoDePago, 1);
		}
		else if(metodoDePago.equals("Transferencia")) {
			im.changePaidMethodForInscripcion(getEmailProvisionalParaPago(), getIdProvisionalParaPago(), metodoDePago, 2);
		}
		else {
			System.out.println("Algo ha salido mal");
		}
	}
	
	/*
	public void ChangePaidMethod(String email, String id, String newPaidMethod) {
		im.changePaidMethodForInscripcion(email, id, newPaidMethod);
	}
	*/
}
