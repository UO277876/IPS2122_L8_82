package formularioclubs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import atleta.AtletaController;
import atleta.AtletaDTO;
import inscripcion.InscripcionController;

public class LeerFicheroClubs {
	
	File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    
    private InscripcionController ic;
    private AtletaController ac;
    
    
    private List<String> lineas;
    
    public LeerFicheroClubs() throws IOException {
    	
    	this.ac = new AtletaController();
    	this.ic = new InscripcionController();
    	lineas = new ArrayList<String>();
    	
    	archivo = new File ("InscribirAtletas");
    	System.out.println(archivo.getAbsolutePath());
        fr = new FileReader (archivo);
        br = new BufferedReader(fr);
        
        String linea;
        
        while((linea=br.readLine())!=null) {

        	lineas.add(linea);
        	System.out.println(linea);
        	
        }
        
        if(fr != null) {

            fr.close();  
        }
        
    }
    
    
    public void registrarAtletas(int id_competicion) {
    	for(int i = 0; i < lineas.size(); i++) {
    		
    		String[] trozos = lineas.get(i).split("/");
    		String email = trozos[0];
    		String nombre = trozos[1];
    		String apellidos = trozos[2];
    		String genero = trozos[3];
    		String fecha = trozos[4];
    		String dni = trozos[5];

        	AtletaDTO atleta = new AtletaDTO(nombre,apellidos,email,genero,fecha,dni);
        	
    		ic.setEmailProvisionalParaPago(email);
			ic.setIdProvisionalParaPago(id_competicion);
			ic.setIdMetodoDePagoProvisional(ic.getNewIdMetodoPago());
    		
			if(control(trozos)) {
				boolean añadido = ac.crearAtletaFechaSinModificar(email,nombre,apellidos,dni,genero,fecha);
				
				ic.inscribirAtleta(ac.obtenerAtletaByEmail(ic.getEmailProvisionalParaPago()), ic.getIdProvisionalParaPago(), ic.getNewDorsal(), 13, "club");
				ic.revisarDorsales(id_competicion);
				
				
			}
		
			else {

				JOptionPane.showMessageDialog(null, "El formato del fichero es incorrecto, por favor reviselo y vuelva a intentarlo");
			}
			
    	}
    	
    	JOptionPane.showMessageDialog(null, "La inscripcion ha tenido exito");
    }
    
    
    private boolean control(String[] trozos) {
		boolean correcto = true;
		if(trozos[0].equals("") ) {
			correcto = false;
		}
		
		if(trozos[1].equals("") ) {
			correcto = false;
		}
		
		if(trozos[2].equals("")) {
			correcto = false;
		}
		
		if(trozos[3].equals("")) {
			correcto = false;
		}
		if(trozos[5].equals("")) {
			correcto = false;
		}
		if(!controlarFecha(trozos[4])) {
			correcto = false;
		}
		
		return correcto;
	}
	
	private boolean controlarFecha(String fecha) {
		try {
			String edad = fecha;
			String[] parts = edad.split("-");
			int año = Integer.valueOf(parts[0]);
			int mes = Integer.valueOf(parts[1]);
			int dia = Integer.valueOf(parts[2]);
			
			if(año >= 1920 && mes <= 12 && mes > 0 && dia <= 31 && dia > 0 ) {
				return true;
			} else {
				return false;
			}
		
		} catch(NumberFormatException e ) {
			return false;
		}
	}
}

