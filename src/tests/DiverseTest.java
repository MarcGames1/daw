package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import files.*;

public class DiverseTest {
	
	/**
	 *  as usual: DO NOT change anything in the test
	 */
	@Test
	public void testFlowers() {
		Flower fl1 = new Flower("lalea", 20);
		Flower fl2 = new Flower("lalea", 20);
		Flower fl3 = new Flower("trandafir", 20);
		Flower fl4 = new Flower("margareta", 35);
		
		assertTrue(fl1.equals(fl2));
		assertTrue(fl1 != fl2);
		assertTrue(!fl1.equals(fl3));
		assertTrue(!fl1.equals(null));
		assertTrue(!fl1.equals(new String("lalea")));
		
		FlowerCollection fc = new FlowerCollection();
		fc.add(fl1);
		fc.add(fl2);
		fc.add(fl3);
		fc.add(fl4);
		
		HashSet<Flower> flowerSet = fc.getHashSet();
		assertTrue(flowerSet.size() == 3);
		assertTrue(flowerSet.contains(new Flower("lalea", 20)));
		assertTrue(!flowerSet.contains(new Flower("trandafir", 35)));
				
		List<Flower> listFlower = fc.getSortedList();
		System.out.println(listFlower);
		assertTrue(listFlower.get(0).equals(fl2));
		assertTrue(listFlower.get(1).equals(fl3));
		assertTrue(listFlower.get(2).equals(fl4));
		
		List<Flower> reverseListFlower = fc.getReverseSortedList();
		System.out.println(reverseListFlower);
		assertTrue(reverseListFlower.get(0).equals(fl4));
		assertTrue(reverseListFlower.get(1).equals(fl3));
		assertTrue(reverseListFlower.get(2).equals(fl1));
		
		Comparator<Flower> comparator = fc.getReverseFlowerComparator();
		Flower fl5 = new Flower("anemona", 40);
		int pos = Collections.binarySearch(reverseListFlower, fl5, comparator);
		fc.add(fl5);
		
		reverseListFlower = fc.getReverseSortedList();
		assertTrue(reverseListFlower.get(0).equals(fl5));
		assertTrue(reverseListFlower.get(Math.abs(pos) - 1).equals(fl5));
	}
	
	/**
	 * uncomment the test parts and make it compile,
	 * but DO NOT change anything else in the test!
	 */
	@Test
	public void testGenerics() {
		List<Animal> animals = new ArrayList<Animal>();
//		Animal.addAnimal(animals, new Animal());
//		Animal.addCat(animals, new Cat());
//		Animal.addFish(animals, new Fish());
		
		assertTrue(animals.size() == 3);
//		assertTrue(Animal.sum(animals) == 11);
		
		List<Cat> cats = new ArrayList<Cat>();
//		Animal.addCat(cats, new Cat());
//		Animal.addCat(cats, new Cat());
//		Animal.sum(cats);
		
		assertTrue(cats.size() == 2);
//		assertTrue(Animal.sum(cats) == 14);
		
		List<Fish> fishes = new ArrayList<Fish>();
//		Animal.addFish(fishes, new Fish());
//		Animal.addFish(fishes, new Fish());
		assertTrue(fishes.size() == 2);
//		assertTrue(Animal.sum(fishes) == 6);
	}
}
