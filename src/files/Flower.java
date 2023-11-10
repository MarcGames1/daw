package files;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Flower {
	private String name;
	private int length;
	
	public Flower(String name, int length) {
		this.name = name;
		this.length = length;
	}


	// ...
	@Override
	public boolean equals (Object  obj){
        return (obj instanceof Flower) && ((Flower) obj).name == this.name && ((Flower) obj).length == this.length;


	}

	public String getName() {
		return this.name;
	}
	public int getLength(){
		return this.length;
	}


	public boolean contains(Flower fl) {

		return this.hasTheSameValues(fl);
	}
	public final  boolean hasTheSameValues(@NotNull Flower fl){
		return this.name.equals(fl.getName()) && this.length == fl.getLength();

	}

	@Override
	public int hashCode() {
		return Objects.hash(name, length);
	}
}


