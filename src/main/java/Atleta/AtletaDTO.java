package atleta;

public class AtletaDTO {
	

	public enum genero{masculino, femenino};
	
	private String email;
	private String name;
	private String surname;
	private genero gender;
	private String fechaNacimiento;
	
	
	public AtletaDTO(String name, String surname, String email, genero gender, String fechaNacimiento) {
		setName(name);
		setSurname(surname);
		setEmail(email);
		setGender(gender);
		setFechaNacimiento(fechaNacimiento);
	}
	
	public AtletaDTO() {	}


	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getFechaNacimiento() {
		return this.fechaNacimiento;
	}
	
	
	public void setGender(genero gender) {
		this.gender = gender;
	}
	
	public genero getGender() {
		return this.gender;
	}

	  
}
