package files;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Strings {

	private StringBuffer _value;

	public Strings(String value) {
		value = value.trim();




//        System.out.println("Step1" + " " + s);

		_value = new StringBuffer(value);

//		System.out.println("Step2" + " " + bufferx);

	};

	public void process() {
		// TODO Auto-generated method stub
		StringBuffer processedString = _value;
		Pattern patt = Pattern.compile("\\*");
		Matcher m = patt.matcher(processedString);

		String x = m.replaceAll("y");
//		bufferx = new StringBuffer(x);
		x = x.replaceFirst("y", "x");



//		System.out.println("Step3 " + " " + hashCode());

		processedString = new StringBuffer(x);
		processedString = processedString.reverse();

//		System.out.println("Step4 " + " " + hashCode());
		System.out.println("x: " + processedString) ;
		processedString = _value;
		System.out.println("HashCode => "+ _value.hashCode());
	}

	// ...


}