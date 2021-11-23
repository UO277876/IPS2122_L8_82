package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractFileUtil {

	public AbstractFileUtil() {
		super();
	}

	public List<String> readLines(String inFileName) throws FileNotFoundException {
		List<String> res = new LinkedList<>();
		String line;
	
		BufferedReader reader;
		try {
			reader = this.createReader(inFileName);
			try {
				while ((line = reader.readLine()) != null) {
					res.add(line);
				}
			} finally {
				reader.close();
			}
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	
		return res;
	}

	public void writeLines(String outZippedFileName, List<String> lines) throws FileNotFoundException {
		BufferedWriter writer;
		try {
			writer = this.createWriter(outZippedFileName);
			try {
				for (String line : lines) {
					writer.write(line);
					writer.newLine();
				}
			} finally {
				writer.close();
			}
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected abstract BufferedWriter createWriter(String outZippedFileName) throws IOException;

	protected abstract BufferedReader createReader(String inFileName) throws IOException;

}