package blocks;

public class ExceptionThrowerClass {
	public ExceptionThrowerClass() {
		
	}
	
	public void method (int x) throws Exception{
		if (x != 3)
		{
			if (x==2)
				throw new IllegalArgumentException();
			else if (x==1) 
			{
				throw new RuntimeException();
			
			}
			else if (x==0)
				throw new Exception();
			
		}
	}
}


