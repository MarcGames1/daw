package tests;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.junit.Test;

import files.Cat;
import files.FileClass;
import files.ImmutableStrings;
import files.MyWriter;
import files.ParsingClass;
import files.Strings;

public class DiverseTest {
	
	@Test
	public void testImmutableString() {
		ImmutableStrings is = new ImmutableStrings("abc");
		assertTrue(is.getValue() == "abc");
		is.add("def");
		System.out.println(is.getValue());
		assertTrue(is.getValue().equals("abcdef"));
		assertTrue(is.getValue() != "abcdef");
		
		is.setTo("abcdef", true);
		assertTrue(is.getValue() == "abcdef");
		assertTrue(is.getValue().equals("abcdef"));
		
		is.setTo("abcdef", false);
		assertTrue(is.getValue() != "abcdef");
		assertTrue(is.getValue().equals("abcdef"));
	}
	
	@Test
	public void testStrings() {
		Strings s1 = new Strings(" a*b*c*d ");
		s1.process();
		assertTrue(s1.equals("dycybxa"));
		
		Strings s2 = new Strings(" \ncocoroc \t ");
		s2.process();
		assertTrue(s2.equals("cyrycxc"));
	}
	
	@Test
	public void testFiles() {
		FileClass f = new FileClass("test.txt");
		assertTrue(f.getFile().exists() == false);
		
		f.write("hello\nworld\n");
		assertTrue(f.getFile().exists() == true);
		
		boolean failed = false;
		FileReader fr = null;
		try {
			fr = new FileReader(new File("test.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			failed = true;
		}
		assertTrue(failed == false);
		assertTrue(fr != null);
		
		char[] in = new char[50];
		int size = 0;
		failed = false;
		try {
			size = fr.read(in);
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
			failed = true;
		}
		assertTrue(failed == false);
		assertTrue(String.valueOf(in, 0, size).equals("hello\nworld\n"));
		
		f.clean();
		assertTrue(f.getFile().exists() == false);
	}
	
	@Test
	public void testReader() throws IOException {
		MyWriter mw = new MyWriter();
		assertTrue(mw.write("a file\nwith\nfour\nlines\n") == 23);
		mw.close();
		
		File dir = new File("myDir");
		assertTrue(dir.exists());
		
		File dirFile = new File(dir, "bar.txt");
		assertTrue(dirFile.exists());
		
		FileReader fr = null;
		boolean failed = false;
		try {
			fr = new FileReader(dirFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			failed = true;
		}
		assert(failed == false);
		
		BufferedReader br = new BufferedReader(fr);
		
		int i = 0;
		String s = br.readLine();
		while( s != null ) {
			assert(i == 0 ? s.equals("a file") : true);
			assert(i == 1 ? s.equals("with") : true);
			assert(i == 2 ? s.equals("four") : true);
			assert(i == 3 ? s.equals("lines") : true);
			
			s = br.readLine();
			i ++;
		}
		br.close();
		
		mw.remove();
		dir = new File("myDir");
		assertTrue(dir.exists() == false);
	}
	
	@Test
	public void testSerializer() {
		Cat c = new Cat();
//		System.out.println(c.getLegs());
		assertTrue(c.getLegs() == 4);
		
		c.setLegs(5);
		c.setName("Tom");
		
		try {
			FileOutputStream fs = new FileOutputStream("cat.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(c);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertTrue(c.getLegs() == 5);
		assertTrue(c.getName().equals("Tom"));

		try {
			FileInputStream fis = new FileInputStream("cat.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			c = (Cat) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(c.getLegs() == 4);
		assertTrue(c.getName().equals("Tom"));

	}
	
	@Test
	public void testParse() {
		String xml = "<album>";
		xml += "<artist>Pink Floyd</artist>";
		xml += "<name>The Wall</name>";
		xml += "<list>";
		xml += "<track>Another Brick in the Wall</track>";
		xml += "<track>Empty Spaces</track>";
		xml += "<track>Hey You</track>";
		xml += "</list></album>";
		ParsingClass pc = new ParsingClass(xml);
		pc.parse();
		
		assertTrue(pc.getArtist().equals("Pink Floyd"));
		assertTrue(pc.getName().equals("The Wall"));
		
		// A short introduction to lists:
		// http://tutorials.jenkov.com/java-collections/list.html
		// List<String> l = new ArrayList();
		// l.add("cat");
		// l.contains("cat") == true
		List<String> list = pc.getTracks();
		assertTrue(list.size() == 3);
		assertTrue(list.contains("Another Brick in the Wall"));
		assertTrue(list.contains("Empty Spaces"));
		assertTrue(list.contains("Hey You"));
	}
}
