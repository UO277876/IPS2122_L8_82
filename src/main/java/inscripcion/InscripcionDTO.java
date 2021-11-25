package inscripcion;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import atleta.AtletaDTO;
import atleta.AtletaModel;
import competiciones.CompeticionDTO;
import competiciones.CompeticionModel;
import giis.demo.util.Util;

public class InscripcionDTO {
	
	private final String ESTADO1 = "solicitado";
	private final String ESTADO2 = "inscrito";
	private final String ESTADO3 = "participado";
	private final String ESTADO4 = "Pre-inscrito";
	
	private final String metalic = "metalico";
	private final String tc = "tarjeta";
	private final String transf = "transferencia";
	
	String dorsal;
	String tiempo;
	int precio;
	String email_atleta;
	String ultFechaModif;
	String categoriaSexo;
	String metodoPago;
	int id_competicion;
	String estado;

	public InscripcionDTO() {
		
	}
	
	public InscripcionDTO(String dorsal, String tiempo, int precio, String categoriaSexo, 
			String ultFechaModif, String email_atleta, String metodoPago, int id_competicion) {
		this.dorsal = dorsal;
		this.tiempo = tiempo;
		this.precio = precio;
		this.ultFechaModif = ultFechaModif;
		this.categoriaSexo = categoriaSexo;
		this.email_atleta = email_atleta;
		this.metodoPago = metodoPago;
		this.id_competicion = id_competicion;
	}

	public String getDorsal() { return dorsal; }

	public void setDorsal(String dorsal) { this.dorsal = dorsal; }

	public String getTiempo() { return tiempo; }

	public void setTiempo(String tiempo) { this.tiempo = tiempo; }

	public int getPrecio() { return precio; }

	public void setPrecio(int precio) { this.precio = precio; }

	public String getEmail_atleta() { return email_atleta; }

	public void setEmail_atleta(String email_atleta) { this.email_atleta = email_atleta; }

	public String getCategoriaSexo() { return categoriaSexo; }

	public void setCategoriaSexo(String categoriaSexo) { this.categoriaSexo = categoriaSexo; }

	public String getMetodoPago() { return metodoPago; }
	
	public String getCategoria() {
		return this.calculaCategoria();
	}

	public void setMetodoPago(String metodoPago) {
		if(metodoPago.equals(tc) || metodoPago.equals(transf) || metodoPago.equals(metalic)) {
			this.metodoPago = metodoPago;
		} 
	}

	public int getId_competicion() {return id_competicion; }

	public void setId_competicion(int id_competicion) { this.id_competicion = id_competicion; }
	
	public String getIEstado() { return estado; }

	public void setEstado(String estado) {
		if(estado.equals(ESTADO1) || estado.equals(ESTADO2) || estado.equals(ESTADO3) || estado.equals(ESTADO4) ) {
			this.estado = estado;
		} 
	}
	
	/**
	 * Actualiza el estado de la inscripción según se ha pagado, o ha acabado la carrera,
	 * incluyendo la fecha de modificación
	 */
	public void actualizaEstado() {
		if(!tiempo.equals("---")) {
			SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
			setEstado(ESTADO1);
			Date dateAct = new Date();
			this.ultFechaModif = dateFormat.format(dateAct);
		} 
		else if(metodoPago.equals(metalic)) {
			SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
			setEstado(ESTADO4);
			Date dateAct = new Date();
			this.ultFechaModif = dateFormat.format(dateAct);
		}
		else if(metodoPago.equals(transf)) {
			SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
			setEstado(ESTADO3);
			Date dateAct = new Date();
			this.ultFechaModif = dateFormat.format(dateAct);
		} else {
			setEstado(ESTADO2);
		}
	}
	
	public String getUltFechaModif() { return ultFechaModif; }
	
	public void setUltFechaModif(String ultFechaModif) { this.ultFechaModif = ultFechaModif; }
	
	public String calculaCategoria() {
		// obtiene el atleta
		AtletaModel amodel = new AtletaModel();
		List<AtletaDTO> atleta = amodel.getAtletaByEmail(email_atleta);
		
		//obtiene la competicion
		CompeticionModel cmodel = new CompeticionModel();
		List<CompeticionDTO> competicion = cmodel.getListadoCompeticiones(id_competicion);
		
		//obtiene la categoria
		String categoria = competicion.get(0).getCategorias().calculaCategoria(atleta.get(0)); 
		return categoria;
	}
}
