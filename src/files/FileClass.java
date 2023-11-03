package files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileClass {
	private final File _file;
	public FileClass(String fileName) {
		this._file = new File(fileName);
	}

	public File getFile() {

		return _file;
	}

	public void write(String string) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(_file));
			writer.write(string);
			writer.flush();
			writer.close();
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
	}

	public void clean() {
		if(_file.exists()){
			_file.delete();
		}
	}
}
