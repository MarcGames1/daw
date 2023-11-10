package files;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class FlowerCollection {
	// ...
private final List<Flower> _collection = new ArrayList<>();
private final HashSet<Flower> _flowerSet = new HashSet<>();
	public void add(Flower fl) {
		// ...
		_collection.add(fl);
		if(this._flowerSet.add(fl)){
			this._flowerSet.add(fl);
		}
	}

	public HashSet<Flower> getHashSet() {
		return this._flowerSet;
	}

	public List<Flower> getSortedList() {
		// TODO: change this to your needs
		// Sortează colecția de flori în funcție de nume
		List<Flower> sortedList = new ArrayList<>(this._flowerSet);
		Comparator nameComparator = Comparator.comparing(Flower::getName);
		Comparator lengthComparator = Comparator.comparing(Flower::getLength);

		sortedList.sort(nameComparator);
		sortedList.sort(lengthComparator);



//		sortedList.sort(Comparator.comparing(Flower::getLength));
		return sortedList;
	}

		public List<Flower> getReverseSortedList() {
		// TODO: change this to your needs
		// Sortează colecția de flori în ordine inversă (descrescătoare) în funcție de nume
		return this.getSortedList().reversed();
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
