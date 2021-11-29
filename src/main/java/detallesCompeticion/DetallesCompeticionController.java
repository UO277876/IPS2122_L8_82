package detallesCompeticion;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import atleta.AtletaDTO;
import atleta.AtletaModel;
import inscripcion.InscripcionDTO;
import inscripcion.InscripcionModel;
import metododepago.MetodoDePagoDTO;
import metododepago.MetodoDePagoModel;

public class DetallesCompeticionController {
	
	private int id_competicion;
	
	private List<AtletaDTO> atletas;
	private List<InscripcionDTO> inscripciones;
	
	private List<DetallesCompeticionDTO> detalles;
	
	private InscripcionModel im;
	private AtletaModel am;
	private MetodoDePagoModel mm;
	
	private String[] columnNames = {"DNI",
            "Nombre",
            "Categoria",
            "Fecha de Inscripcion",
            "Estado de la Inscripcion"};
	
	private String[][] data;
	
	public DetallesCompeticionController(int id_competicion) {
		this.id_competicion = id_competicion;
		
		this.inscripciones = new ArrayList<InscripcionDTO>();
		this.atletas = new ArrayList<AtletaDTO>();
		
		this.detalles = new ArrayList<DetallesCompeticionDTO>();
		
		this.im = new InscripcionModel();
		this.am = new AtletaModel();
		this.mm = new MetodoDePagoModel();
		

		fillDetalles();

		data = new String[detalles.size()][5];
		for(int i = 0; i < detalles.size(); i++) {
			data[i][0] = detalles.get(i).getDNI();
			data[i][1] = detalles.get(i).getNombre();
			data[i][2] = detalles.get(i).getCategoria();
			data[i][3] = detalles.get(i).getFecha();
			data[i][4] = detalles.get(i).getEstado();
		}
	}
	
	
	public String[][] getData(){
		return this.data;
	}
	
	public String[] getColumnNames() {
		return this.columnNames;
	}

	public AtletaDTO getAtleta(String email) {
		List<AtletaDTO> ats= am.getAtletaByEmail(email);
		return ats.get(0);
	}
	
	public void getInscripciones() {
		inscripciones = im.getInscripcionesPorCompeticion(id_competicion);
	}
	
	public void fillAtletasList() {
		for(InscripcionDTO ins : inscripciones) {
			atletas.add(getAtleta(ins.getEmail_atleta()));
		}
	}
	
	public void fillDetalles() {
		getInscripciones();
		fillAtletasList();
		for(InscripcionDTO ins : inscripciones) {
			AtletaDTO atleta = getAtleta(ins.getEmail_atleta());
			System.out.println(ins.getIEstado());
			MetodoDePagoDTO mp = mm.getPago(ins.getId_metodoPago());
			detalles.add(new DetallesCompeticionDTO(atleta.getDni(), atleta.getNombre(), ins.getCategoria(), ins.getUltFechaModif(), mp.getTipo()));
		}
	}
	
	
	
}
