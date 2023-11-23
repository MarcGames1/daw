package tests;

import static org.junit.Assert.assertTrue;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

import files.Dog;
import files.HelperClass;
import files.MyAnnotation;
import files.MyAnnotation2;
import files.MyClass;
import files.MyCollection;
import files.PersonsMap;


public class DiverseTest {
	public static class PrivateClass {
		private int id = 0;
		
		@SuppressWarnings("unused")
		private void set() { id = 1; }
		
		public int getId() { return id; }
	}
	
					
	@Test
	public void testCollection() {
		MyCollection myc = new MyCollection();
		
		Supplier<List<Dog>> supplier = myc.getSupplier();
		
		myc.populate();
		
		Predicate<Dog> greaterZero = d -> d.getId() > 0;
		Predicate<Dog> lessFive = d -> d.getId() < 5;
		
		assertTrue(supplier.get().size() == 4);		
		supplier.get().forEach(d -> assertTrue( greaterZero.and(lessFive).test(d)) );
		
		Consumer<List<Dog>> sorter = myc.getSorter();
		sorter.accept(supplier.get());
		
		int x = 5;
		BiPredicate<Dog, Integer> it = (d, i) -> { 
			boolean res = (x > d.getId());
			i = d.getId();
			return res;
		};
		
		assertTrue(supplier.get().size() == 4);
		supplier.get().forEach(d -> assertTrue(it.test(d, x)));
		
		Predicate<Dog> evenDogs = d -> (d.getId() % 2 == 0);
		
		myc.filter(evenDogs);
		assertTrue(supplier.get().size() == 2);
		supplier.get().forEach(d -> assertTrue(evenDogs.test(d)));
	}
	
	@Test
	public void testMap() {
		PersonsMap pm = new PersonsMap();
		
		Map<String, Integer> map = pm.getMap();
		assertTrue(map.size() == 0);
		
		Function<String, Integer> mapperCreator = pm.getMapperCreator();
		map.computeIfAbsent("Larry", mapperCreator);
		map.computeIfAbsent("Moe", mapperCreator);
		map.computeIfAbsent("Curley", mapperCreator);
		assertTrue(map.size() == 3);
		
		BiFunction<String, Integer, Integer> mapperModifier = pm.getMapperModifier();
		map.computeIfPresent("Larry", mapperModifier);
		map.computeIfPresent("Moe", mapperModifier);
		map.computeIfPresent("Curley", mapperModifier);
		assertTrue(map.size() == 2);		
		
		Predicate<Integer> larry = i -> i == 'l';
		Predicate<Integer> moe = i -> i == 'm';
		map.forEach((k, v) -> assertTrue(larry.or(moe).test(v)));
	}
	
	@Test
	public void testReflection() {
		PrivateClass pc = new PrivateClass();
		
		HelperClass.callSetWithReflection(pc);
		assertTrue(pc.getId() == 1);
		
		HelperClass.modifyWithReflection(pc);
		assertTrue(pc.getId() == 5);
	}
	
	@Test
	public void testAnnotation() {
		Class aClass = MyClass.class;
//		Annotation[] annotations = aClass.getAnnotations();
//
//		for(Annotation annotation : annotations){
//		    if(annotation instanceof MyAnnotation){
//		        MyAnnotation myAnnotation = (MyAnnotation) annotation;
//		        System.out.println("name: " + myAnnotation.name());
//		        System.out.println("value: " + myAnnotation.value());
//		    }
//		}
		
		Annotation annotation = aClass.getAnnotation(MyAnnotation.class);
		assertTrue(annotation instanceof MyAnnotation);
		
		MyAnnotation myAnnotation = (MyAnnotation) annotation;
		assertTrue(myAnnotation.name().equals("myName"));
		assertTrue(myAnnotation.value().equals("my value"));
		
		Annotation annotation2 = aClass.getAnnotation(MyAnnotation2.class);
		assertTrue(annotation2 instanceof MyAnnotation2);
		
		MyAnnotation2 myAnnotation2 = (MyAnnotation2) annotation2;
		assertTrue(myAnnotation2.author().equals("Vasile"));
		assertTrue(myAnnotation2.majorVersion() == 1);
		assertTrue(myAnnotation2.minorVersion() == 5);
		
	}

}
