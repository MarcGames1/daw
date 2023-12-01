package files;

import tests.DiverseTest;
import tests.DiverseTest.PrivateClass;

public class HelperClass {

	public static void callSetWithReflection(DiverseTest.PrivateClass pc) {
		try {
			java.lang.reflect.Field field = PrivateClass.class.getDeclaredField("id");
			field.setAccessible(true);
			field.set(pc, 1);
		} catch(NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	/** TODO Auto-generated method stub
	 Modify the access for this id  page 44 second biography course 4
	 See fields from biography (Access private fields) */

	public static void modifyWithReflection(PrivateClass pc) {
		try {
			java.lang.reflect.Field field = PrivateClass.class.getDeclaredField("id");
			field.setAccessible(true);
			field.set(pc, 5);
		} catch(NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

}
