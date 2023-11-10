package files;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class FlowerCollection {
	// ...
private final List<Flower> _collection = new ArrayList<>();
	public void add(Flower fl) {
		// ...
		_collection.add(fl);
	}

	public HashSet<Flower> getHashSet() {
		// TODO: change this to your needs
		HashSet<Flower> flowerSet = new HashSet<>();
		for (Flower fl : this._collection) {
			boolean isinSet = false;
			for (Flower existingFlower : flowerSet) {
				if (fl.hasTheSameValues(existingFlower)) {
					isinSet = true;

				}
			}
		if (!isinSet) flowerSet.add(fl) ;
		}
		return flowerSet;
	}

	public List<Flower> getSortedList() {
		// TODO: change this to your needs
		// Sortează colecția de flori în funcție de nume
		return _collection.stream()
				.sorted(Comparator.comparing(Flower::getName))
				.collect(Collectors.toList());
	}

	public List<Flower> getReverseSortedList() {
		// TODO: change this to your needs
		// Sortează colecția de flori în ordine inversă (descrescătoare) în funcție de nume
		return _collection.stream()
				.sorted(Comparator.comparing(Flower::getName).reversed())
				.collect(Collectors.toList());
	}

	public Comparator<Flower> getReverseFlowerComparator() {
		// TODO: change this to your needs
		// Comparator pentru a sorta flori în ordine inversă în funcție de lungime
		return Comparator.comparing(Flower::getLength).reversed();
	}





	public boolean contains(Object o) {
		if(o instanceof HashSet<?>){
			for (Flower fl : this._collection) {
				return fl.getName().equals(((Flower) o).getName());
			}
		}
		return false;
	}
}
