package files;

import java.io.Serializable;

class Animal implements Serializable {
	private int _legs;
	private String _name;

	public Animal(){
		_legs = 4;
		_name="";
	}


	public int getLegs() {
		return this._legs;

	}

	public String getName() {
		return _name;
	}

	public void setName(String name){
		_name = name;
	}
	public void setLegs(int legs){
		_legs = legs;
	}
}

public class Cat extends Animal {


	}




