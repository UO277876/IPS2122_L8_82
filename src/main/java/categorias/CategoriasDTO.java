package categorias;

import java.time.LocalDate;

import atleta.AtletaDTO;
import giis.demo.util.Util;

public class CategoriasDTO {

	public final static String SENIOR = "Senior";
	public final static String VETA = "VetA";
	public final static String VETB = "VetB";
	public final static String VETC = "VetC";
	public final static String VETD = "VetD";
	public final static String VETE = "VetE";

	private int edadSenior;
	private int edadVetA;
	private int edadVetB;
	private int edadVetC;
	private int edadVetD;

	public CategoriasDTO() {
		edadSenior = 35;
		edadVetA = 40;
		edadVetB = 45;
		edadVetC = 50;
		edadVetD = 55;
	}

	public CategoriasDTO(int edadSenior, int edadVetA, int edadVetB, int edadVetC, int edadVetD) {
		this.edadSenior = edadSenior;
		this.edadVetA = edadVetA;
		this.edadVetB = edadVetB;
		this.edadVetC = edadVetC;
		this.edadVetD = edadVetD;
	}

	/**
	 * Calcula la categoria del atleta dado.
	 * 
	 * @param atleta
	 * @return
	 */
	public String calculaCategoria(AtletaDTO atleta) {
		// calcula la edad del atleta
		int edad = LocalDate.now().getYear() - Util.isoStringToDate(atleta.getFechaNacimiento()).getYear() - 1900;

		// obtiene la ultima categoria posible (en caso de que no llegue a vetE)
		String ultimaCategoria = getUltimaCategoria();
		if (edad < edadSenior || CategoriasDTO.SENIOR.equals(ultimaCategoria))
			return CategoriasDTO.SENIOR;
		if (edad < edadVetA || CategoriasDTO.VETA.equals(ultimaCategoria))
			return CategoriasDTO.VETA;
		if (edad < edadVetB || CategoriasDTO.VETB.equals(ultimaCategoria))
			return CategoriasDTO.VETB;
		if (edad < edadVetC || CategoriasDTO.VETC.equals(ultimaCategoria))
			return CategoriasDTO.VETC;
		if (edad < edadVetD || CategoriasDTO.VETD.equals(ultimaCategoria))
			return CategoriasDTO.VETD;
		return CategoriasDTO.VETE;
	}

	//obtiene cual es la ultima categoria en función de cuál es la que no tiene ningún límite de edad
	private String getUltimaCategoria() {
		if (edadSenior < 0)
			return CategoriasDTO.SENIOR;
		if (edadVetA < 0)
			return CategoriasDTO.VETA;
		if (edadVetB < 0)
			return CategoriasDTO.VETB;
		if (edadVetC < 0)
			return CategoriasDTO.VETC;
		if (edadVetD < 0)
			return CategoriasDTO.VETD;
		return CategoriasDTO.VETE;
	}
}
