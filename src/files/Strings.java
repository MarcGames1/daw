package files;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Strings {

	private String _value;

	public String getValue(){
		return _value;
	}
	public Strings(String value) {
		value = value.trim();




//        System.out.println("Step1" + " " + s);

		_value = value;

//		System.out.println("Step2" + " " + bufferx);

	};

	public void process() {
		// TODO Auto-generated method stub
		StringBuffer processedString = new StringBuffer(_value);
		Pattern patt = Pattern.compile("\\*");

		Matcher m = patt.matcher(processedString);


		String x = m.replaceAll("y");
		x = x.replaceAll("o", "y");

		x = x.replaceFirst("y", "x");



//		System.out.println("Step3 " + " " + hashCode());

		processedString = new StringBuffer(x);
        processedString.reverse();
		processedString.trimToSize();



		_value = processedString.toString();


	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if(o instanceof String){
			return this._value.equals(o);
		}
		if (!(o instanceof Strings))
			return false;
		Strings other = (Strings) o;
        return (this._value == null && other._value == null)
				|| (this._value != null && this._value.equals(other._value));
	}
}


