package files;


import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Animal {
	protected int value = 1;

	public Animal() {

	}
	public Animal(int value) {
	this.value = value;
	}
	public static  <T extends Animal> void addCat(List<T> animals, Cat cat) {

		animals.add((T) cat);
	}


	public static <T extends Animal> void addFish(List<T> animals, Fish fish) {
		animals.add((T) fish);
	}

	public int getValue() { return this.value; }

	static public void addAnimal(
			List<Animal> animalList, Animal animal
	) {
		animalList.add(animal);
	}


	static public <T extends Animal> int sum(List<T> animals) {
		int result = 0;
		for (Animal animal : animals) {
			result += animal.getValue();
		}
		return  result;
	}

}
