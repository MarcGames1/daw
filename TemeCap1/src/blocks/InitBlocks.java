package blocks;

public class InitBlocks {
    public static int counter;
    
    // static initialization block
    static {
    	// ...
    }

    // initialization block
    {
        // counter = ...
    }

    public InitBlocks() {
        // counter *= ... ;
    }
    
}
