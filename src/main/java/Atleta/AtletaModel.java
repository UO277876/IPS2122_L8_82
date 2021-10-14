package Atleta;

import giis.demo.util.Database;

public class AtletaModel {
	
	private static Database db = new Database();
	
	
	public static final String SQL_INSCRIBIRSE = 
			"INSERT into Inscripcion (email_atleta, id_competicion) VALUES (?,?)";

	
	public static void inscribirse(String email_atleta, int id_competicion) {
		String sql = SQL_INSCRIBIRSE;
		db.executeUpdate(sql, email_atleta, id_competicion);
	}
	
}
