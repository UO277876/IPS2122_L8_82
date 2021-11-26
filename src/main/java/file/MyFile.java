package file;

import java.io.File;

public class MyFile {

	private File theFile;
	
	public MyFile(File newTheFile) {
		this.theFile = newTheFile;
	}
	
	public File getTheFile() {
		return this.theFile;
	}
	
	public String toString() {
		return this.theFile.getName();
	}
}
