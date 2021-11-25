package resultados;

import java.util.ArrayList;
import java.util.List;

public class ResultadosParser {
	private String idCompeticion;

	public List<ResultadosDTO> parse(List<String> lines) {
		List<ResultadosDTO> resultados = new ArrayList<>();
		idCompeticion = lines.get(0);
		for (String line : lines) {
			ResultadosDTO resultado = parseLine(line);
			if(resultado != null)
				resultados.add(parseLine(line));
		}
		return resultados;
	}

	private ResultadosDTO parseLine(String line) {
		try {
			if (line.length() > idCompeticion.length()) {
				String[] partes = line.split("-");
				int idCompeticion = Integer.parseInt(this.idCompeticion);
				String dorsal = partes[0];
				String tInicio = partes[1];
				String tFin = partes[2];
				return new ResultadosDTO(tInicio, tFin, dorsal, idCompeticion);
			} else
				return null;
		} catch (Exception e) {
			return null;
		}
	}

}
