package Atleta;

import java.util.Date;

public class AtletaDTO {
	

	public enum genero{masculino, femenino};
	
	private String email;
	private String name;
	private String surname;
	private genero gender;
	private Date fechaNacimiento;
	
	
	public AtletaDTO(String name, String surname, String email, genero gender, Date fechaNacimiento) {
		setName(name);
		setSurname(surname);
		setEmail(email);
		setGender(gender);
		setFechaNacimiento(fechaNacimiento);
	}
	
	
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
	
	
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}
	
	
	public void setGender(genero gender) {
		this.gender = gender;
	}
	
	public genero getGender() {
		return this.gender;
	}

	  
}
