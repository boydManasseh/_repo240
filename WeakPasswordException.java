
public class WeakPasswordException extends Exception {
	
	public WeakPasswordException() {
		super("The password is OK but weak - it cointains fewer than 10 characters.");
	}

}
