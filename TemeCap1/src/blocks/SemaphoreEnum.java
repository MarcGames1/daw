package blocks;

public enum SemaphoreEnum {
RED(3),
YELLOW(2),
GREEN(1);

private  int _value;
	
	SemaphoreEnum(int value){
		this._value = value;
	}
	public int getValue() {
		return _value;
	}
	public boolean isSafeToEnterCrossing() {
		return this != RED;
	}
}
