package formularioclubs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerFicheroClubs {
	
	File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    
    public LeerFicheroClubs() throws IOException {
    	
    	archivo = new File ("C:\\archivo.txt");
        fr = new FileReader (archivo);
        br = new BufferedReader(fr);
        
        String linea;
        
        while((linea=br.readLine())!=null)
           System.out.println(linea);
        
        if(fr != null) {

            fr.close();  
        }
        
    }
    
}

