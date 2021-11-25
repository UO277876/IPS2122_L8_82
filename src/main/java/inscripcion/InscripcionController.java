package inscripcion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import atleta.AtletaController;
import atleta.AtletaDTO;
import clasificacion.CategoriasDTO;
import competiciones.CompeticionController;
import competiciones.CompeticionDTO;
import metododepago.MetodoDePagoController;

public class InscripcionController {
	
	private static final String characters = "1234567890OPQRSTUVWXYZ";
		
	private InscripcionModel im;

	private AtletaController ac;
	private CompeticionController cm;
	private MetodoDePagoController pc;

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
		this.pc = new MetodoDePagoController();
		
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
		} else if (tipo.equals(CategoriasDTO.SENIOR) || tipo.equals(CategoriasDTO.VETA)
				|| tipo.equals(CategoriasDTO.VETB) || tipo.equals(CategoriasDTO.VETC)
				|| tipo.equals(CategoriasDTO.VETD) || tipo.equals(CategoriasDTO.VETE)) 
			return clasifCategoria(tipo, nombre);
		else
			return clasifAbs(nombre);
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
	 * Clasifica dependiendo de la categoria
	 * 
	 * @param id, el id de la carrera
	 * @return una lista de String con la clasificación
	 */
	private List<ClasificacionDTO> clasifCategoria(String tipo, String nombre) {
		rellenarNombreAbs(nombre);
		List<ClasificacionDTO> aux = rellenarConAtletas();
		List<ClasificacionDTO> result = new ArrayList<ClasificacionDTO>();
		
		for(ClasificacionDTO clasif : aux) {
			if(clasif.getCategoria().equals(tipo))
				result.add(clasif);
		}

		return result;
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
	
	/**
	 * Rellena la clasificación con atletas
	 * 
	 * @return una lista de ClasificacionDTO
	 */
	private List<ClasificacionDTO> rellenarConAtletas() {
		AtletaDTO am = new AtletaDTO();
		
		List<ClasificacionDTO> result = new ArrayList<ClasificacionDTO>();
		int index = 1;
		
		for(InscripcionDTO ic : this.idto) {
			am = obtenerAtleta(ic.getEmail_atleta());

			ClasificacionDTO clasif = new ClasificacionDTO(index,am.getNombre(),ic.categoriaSexo,ic.getTiempo(),ic.getCategoria());
			
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
	
	/**
	 * Primer método para añadir un carácter al dorsal
	 * @return
	 */
	public String getNewDorsal() {
		Random rng = new Random();
		char[] text = new char[1];
	    for (int i = 0; i < 1; i++)
	    {
	        text[i] = characters.charAt(rng.nextInt(characters.length()));
	    }
	    return new String(text);
	}
	
	public void inscribirAtleta(AtletaDTO atleta, int id_competicion, String dorsal, int precio, String metodoPago) {
		im.inscribirse(atleta, id_competicion, dorsal, precio, getActualDate(), metodoPago);
		asignarDorsal(atleta.getEmail(), id_competicion);
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

	/**
	 * Obtiene todas las inscripciones de una competición
	 * @param id
	 */
	public List<InscripcionDTO> getAtletasCompeticion(int id) {
		return im.getInscripcionesPorDorsal(id);
	}
	
	/**
	 * Asigna un dorsal a un atleta en concreto, recién inscrito
	 */
	public void asignarDorsal(String email, int id_competicion) {
		CompeticionDTO competicion = cm.obtenerCompeticion(id_competicion);
		
		if(pc.getEstado(email)) {
			String dorsal = obtenerDorsal(competicion);
			im.actualizarDorsal(dorsal, email, id_competicion);
		}
		
	}
	
	/**
	 * Crea un número random como dorsal 
	 * El mínimo es el reservado, y el máximo el número de plazas de la competición
	 */
	private String obtenerDorsal(CompeticionDTO competicion) {
		Random random = new Random();
		// El número de dorsales va de mínimo los reservados
		// y por último el maximo de plazas
		int dorsal = random.nextInt((competicion.getNumPlazas() - competicion.getDorsalesReservados())
				+ competicion.getDorsalesReservados());
		while(im.verificarDorsal(String.valueOf(dorsal), competicion.getId())) {
			dorsal = random.nextInt((competicion.getNumPlazas() - competicion.getDorsalesReservados())
					+ competicion.getDorsalesReservados());
		}
		
		return String.valueOf(dorsal);
	}
	
	/**
	 * Se revisan si los dorsales de los demás ya están asignados, si falta alguno se actualiza también
	 */
	public void revisarDorsales(int id_competicion) {
		List<InscripcionDTO> inscripciones = im.getInscripcionesPorCompeticion(id_competicion);
		
		for(InscripcionDTO incr : inscripciones) {
			// Verifica si la inscripcion tiene dorsal asociado
			if(im.verificarDorsal(incr.getDorsal(), id_competicion)) {
				asignarDorsal(incr.getEmail_atleta(), id_competicion);
			}
		}
		
	}

	public float getPrecioInscripcion(int id_competicion) {
		float cantidad = 0.0f;
		List<InscripcionDTO> inscripciones = im.getInscripcionesPorCompeticion(id_competicion);
		if(inscripciones.size() > 0) {
			cantidad = inscripciones.get(0).getPrecio();
		}
		return cantidad;
	}
	
	
	public void setMetodoDePago() {
		

	}
	
	/*
	public void ChangePaidMethod(String email, String id, String newPaidMethod) {
		im.changePaidMethodForInscripcion(email, id, newPaidMethod);
	}
	*/
}
