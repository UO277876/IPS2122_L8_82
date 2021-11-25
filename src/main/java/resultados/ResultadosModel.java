package resultados;

import java.util.List;

import giis.demo.util.Database;

public class ResultadosModel {

	public static final String SQL_AÑADIR = "INSERT into Resultados (id_competicion, dorsal, tiempoInicio, tiempoFin, estado) VALUES (?,?,?,?,?)";
	private Database db = new Database();

	public void añadir(ResultadosDTO resultado) {
		String inicio = Integer.toString(resultado.getTInicio());
		String fin = Integer.toString(resultado.getTFin());
		db.executeUpdate(SQL_AÑADIR, resultado.getIdCompeticion(), resultado.getDorsalAtleta(), inicio, fin,
				resultado.getEstado());
	}

	public void añadir(List<ResultadosDTO> resultados) {
		for (ResultadosDTO resultado : resultados) {
			String inicio = Integer.toString(resultado.getTInicio());
			String fin = Integer.toString(resultado.getTFin());
			db.executeUpdate(SQL_AÑADIR, resultado.getIdCompeticion(), resultado.getDorsalAtleta(), inicio, fin,
					resultado.getEstado());
		}
	}
}
