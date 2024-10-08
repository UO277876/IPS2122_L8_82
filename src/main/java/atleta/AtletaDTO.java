package atleta;

public class AtletaDTO {
	

	public final static String mas = "masculino";
	public final static String fem = "femenino";
	
	private String email;
	private String nombre;
	private String apellidos;
	private String genero;
	private String fechaNacimiento;
	private String dni;
	
	
	public AtletaDTO(String nombre, String apellidos, String email, String genero, String fechaNacimiento,
			String dni) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.genero = genero;
		this.fechaNacimiento = fechaNacimiento;
		this.dni = dni;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	

	  
}
