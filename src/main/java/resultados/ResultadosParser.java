package resultados;

import java.util.ArrayList;
import java.util.List;

public class ResultadosParser {

	public List<ResultadosDTO> parse(List<String> lines) {
		List<ResultadosDTO> resultados = new ArrayList<>();
		for (String line : lines) {
			resultados.add(parseLine(line));
		}
		return resultados;
	}

	private ResultadosDTO parseLine(String line) {
		String[] partes = line.split("-");
		int idCompeticion = Integer.parseInt(partes[0]);
		String dorsal = partes[1];
		String tInicio = partes[2];
		String tFin = partes[3];
		return new ResultadosDTO(tInicio, tFin, dorsal, idCompeticion);
	}

}
