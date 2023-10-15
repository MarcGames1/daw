package blocks;

public class ExceptionThrowerClass {
	public ExceptionThrowerClass() {}
	
	
	 public void method(int x) throws Exception {
		 try {
			 // 
			 System.out.println(x);
			   if (x == 3) {
		            // Aruncăm o IllegalArgumentException când x este 3
		            throw new IllegalArgumentException("IllegalArgumentException");
		        } else if (x == 2) {
		            // Aruncăm o RuntimeException când x este 2
		            throw new RuntimeException("RuntimeException");
		        } else if (x == 1) {
		            // Aruncăm o altă excepție oarecare când x este 1
		            throw new Exception("Altă excepție");
		        }
		 }
		 catch(RuntimeException e){
			 throw e;
		 }
		 catch(Exception e) {
			throw e;
		 }
	 }       
}
