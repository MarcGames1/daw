package files;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
public class MyCollection {
	private List<Dog> dogList = new ArrayList<>();

	public Supplier<List<Dog>> getSupplier() {

		return () -> new ArrayList<>(dogList);
	}

	public Consumer<List<Dog>> getSorter() {
		Comparator<Dog> dc1 = (Dog d1, Dog d2) -> { return d1.getId() - d2.getId(); };
		return (i) -> Collections.sort(i, dc1);
	}

	public void populate() {
		for (int i=1; i <5; i++)
			dogList.add(new Dog(i));

		// TODO Auto-generated method stub
	}

	public void filter(Predicate<Dog> evenDogs) {
	dogList.removeIf(evenDogs.negate());
		
	}

}
