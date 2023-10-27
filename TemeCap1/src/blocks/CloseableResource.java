package blocks;

public class CloseableResource implements AutoCloseable {
	private static boolean _closed = false; 
	int _n;
	
	public CloseableResource(int n) {
		// ...
		_n = n;
	}
	
	public void use () {
		// ...
		if (_n == 2)
			throw new RuntimeException();
	}

	@Override
	public void close() throws Exception {
		_closed = true;
	}
	
	public static boolean isClosed() {
		return _closed;
	}

}
