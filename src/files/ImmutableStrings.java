package files;

public class ImmutableStrings {
	// ...
	private String _value;
	public  ImmutableStrings(String value) {
		_value = value;
	}
	
	public void add(String val) {
		this._value += val;
	}
	
	public String getValue() {
		// ...
		return _value;
	}

	public void setTo(String string, boolean check) {
		// ...
		if(check) {
			_value= string;
		}
		else {
			_value = new String(string);
		}


	}
}
