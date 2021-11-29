package resultados;

import java.util.List;

import giis.demo.util.Database;

public class ResultadosModel {

	public static final String SQL_AÑADIR = "INSERT into Resultados (id_competicion, dorsal, "
			+ "tiempoInicio, cortes, tiempoFin, estado) VALUES (?,?,?,?,?,?)";
	private Database db = new Database();

	public void añadir(ResultadosDTO resultado) {
		String inicio = parseToString(resultado.getTInicio());
		String fin = parseToString(resultado.getTFin());
		String cortes = toStringCortes(resultado.getCortes());
		db.executeUpdate(SQL_AÑADIR, resultado.getIdCompeticion(), resultado.getDorsalAtleta(), inicio, cortes, fin,
				resultado.getEstado());
	}

	public void añadir(List<ResultadosDTO> resultados) {
		for (ResultadosDTO resultado : resultados) {
			añadir(resultado);
		}
	}

	private String parseToString(int integer) {
		return Integer.toString(integer);
	}

	private String toStringCortes(int[] cortes) {
		String sCortes = parseToString(cortes[0]);
		for (int i = 1; i < cortes.length; i++)
			sCortes += "," + cortes[i];

		return sCortes;
	}
}
