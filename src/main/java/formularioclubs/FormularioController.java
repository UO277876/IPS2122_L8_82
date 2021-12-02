package formularioclubs;

import java.util.ArrayList;
import java.util.List;

import atleta.AtletaDTO;
import atleta.AtletaModel;
import detallesCompeticion.DetallesCompeticionDTO;
import inscripcion.InscripcionDTO;
import inscripcion.InscripcionModel;
import metododepago.MetodoDePagoDTO;
import metododepago.MetodoDePagoModel;

public class FormularioController {
	
	private int id_competicion;
	
	private List<AtletaDTO> atletas;
	
	private InscripcionModel im;
	private AtletaModel am;
	private MetodoDePagoModel mm;
	
	private int numeroAtletas;
	
	private String[] columnNames = {"Email",
            "Nombre",
            "Apellidos",
            "DNI",
            "Fecha de Nacimiento",
            "Genero"};
	
	private String[][] data;
	

	
	public FormularioController(int id_competicion, int numAtletas) {
		this.id_competicion = id_competicion;
		this.numeroAtletas = numAtletas;
		createTable();
		
		this.atletas = new ArrayList<AtletaDTO>();
		
		this.im = new InscripcionModel();
		this.am = new AtletaModel();
		this.mm = new MetodoDePagoModel();
		

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
	
	
	public int getNumeroAtletas() {
		return this.numeroAtletas;
	}
	
	public void setNumeroAtletas(int numeroAtletas) {
		this.numeroAtletas = numeroAtletas;
	}
	
	
	public void createTable() {
		data = new String[numeroAtletas][6];
	}
	
	
	
	
	
}
