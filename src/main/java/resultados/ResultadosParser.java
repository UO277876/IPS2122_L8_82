package resultados;

import java.util.ArrayList;
import java.util.List;

public class ResultadosParser {
	private String idCompeticion;
	private int idNC;

	public List<ResultadosDTO> parse(List<String> lines) {
		List<ResultadosDTO> resultados = new ArrayList<>();
		idCompeticion = lines.get(0);
		idNC = Integer.parseInt(this.idCompeticion);
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
				String dorsal = partes[0];
				String tInicio = partes[1];
				String tFin = partes[2];
				return new ResultadosDTO(tInicio, tFin, dorsal, idNC);
			} else
				return null;
		} catch (Exception e) {
			return null;
		}
	}

}
