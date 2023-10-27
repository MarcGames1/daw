package blocks;

public class InitBlocks {
    public static int counter;
    
    // static initialization block
    static {
    	// ...
    	counter = 1;
    }

    // initialization block
    {
        // counter = ...
    	counter += 1;
    }

    public InitBlocks() {
        // counter *= ... ;
    	counter *= 2;
    }
    
}