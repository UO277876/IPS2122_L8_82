package atleta;

public class AtletaDTO {
	

	private final static String mas = "masculino";
	private final static String fem = "femenino";
	
	private String email;
	private String nombre;
	private String apellidos;
	private String genero;
	private String fechaNacimiento;
	
	
	public AtletaDTO(String nombre, String apellidos, String email, String genero, String fechaNacimiento) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.genero = genero;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public AtletaDTO() {	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		if(genero.equals(mas) || genero.equals(fem)) {
			this.genero = genero;
		}
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	  
}
