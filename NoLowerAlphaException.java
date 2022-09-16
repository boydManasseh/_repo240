
public class NoLowerAlphaException extends Exception {
	
	public NoLowerAlphaException() {
		super("The passsword must contain at least one lowercase alphabetic character");
	}

}
