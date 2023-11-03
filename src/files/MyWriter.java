package files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyWriter {
private BufferedWriter _writer;
private File _file;


//constructor
	public MyWriter() throws IOException {
		File myDir = new File("myDir");
		boolean folderExists = myDir.exists();
		if(!folderExists){
			myDir.mkdir();
		}
		this._file = new File(myDir, "bar.txt");
		this._writer =  new BufferedWriter(new FileWriter(_file));

	}
	public int write(String content) throws IOException {
		// TODO Auto-generated method stub
		_writer.write(content);
		_writer.flush();
		this.close();

		return content.length();
	}

	public void close() throws IOException {
	_writer.close();
		
	}

	public void remove() {
		// TODO Auto-generated method stub
		if (_file.exists()){
			_file.delete();
			_file.getParentFile().delete();
		}
	System.out.println("FILE REMOVED");
	}

}
