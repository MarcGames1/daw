package files;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serial;
import java.io.Serializable;

class Animal implements Serializable {
	private int _legs = 4;
	private String _name;
	public Animal(){
		_legs = 4;
		String _name="";
	}
	//DUpa deserializare nu se apeleaza constructorul
	// clasei parinte
	public Animal(String name){
		_legs = 4;
		_name = name;
	}






	public int getLegs() {
		return this._legs;

	}

	public String getName() {
		return this._name;
	}

	public void setName(String name){
		_name = name;
	}
	public void setLegs(int legs){
		_legs = legs;
	}
}

public class Cat extends Animal {

	public Cat(String name) {
		super(name);
		this.setLegs(4);
	}

	public Cat() {

	}



	@Serial
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException, IOException {
		in.defaultReadObject(); // Se realizează deserializarea obiectului

		// Inițializează valoarea membrului _legs corect după deserializare
		this.setLegs(4);
	}
}




