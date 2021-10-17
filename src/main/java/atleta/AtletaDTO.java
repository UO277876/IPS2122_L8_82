package atleta;

public class AtletaDTO {
	
	private final String fem = "femenino";
	private final String mas = "masculino";
	
	private String email;
	private String genero;
	private String nombre;
	private String apellidos;
	private String fechaNacimiento;
	
	public AtletaDTO() { };
	
	public AtletaDTO(String email, String genero, String nombre, String apellidos, String fechaNacimiento) {
		this.email = email;
		this.genero = genero;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEmail() { return email; }

	public void setEmail(String email) { this.email = email; }

	public String getGenero() { return genero; }

	public void setGenero(String genero) { 
		if(genero.equals(fem) || genero.equals(mas)) {
			this.genero = genero; 
		}
	}

	public String getNombre() { return nombre; }

	public void setNombre(String nombre) { this.nombre = nombre; }

	public String getApellidos() { return apellidos; }

	public void setApellidos(String apellidos) { this.apellidos = apellidos; }

	public String getFechaNacimiento() { return fechaNacimiento; }

	public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
	

}
