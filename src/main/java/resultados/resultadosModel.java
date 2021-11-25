package resultados;

import giis.demo.util.Database;

public class resultadosModel {

	public static final String SQL_AÑADIR = 
			"INSERT into Resultados (id_competicion, dorsal, tiempoInicio, tiempoFin, estado) VALUES (?,?,?,?,?)";
	private Database db=new Database();
	
	public void añadir(ResultadosDTO resultado) {
		String inicio = Integer.toString(resultado.getTInicio());
		String fin = Integer.toString(resultado.getTFin());
		db.executeUpdate(SQL_AÑADIR, resultado.getIdCompeticion(), resultado.getDorsalAtleta(), inicio, fin, resultado.getEstado());
	}
}
