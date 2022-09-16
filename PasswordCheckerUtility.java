import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {
	
	
	public PasswordCheckerUtility() {
		
	}
	
	
	/**
	 * 
	 * @author boyd1
	 * @param password
	 * @param passwordConfirm
	 * @throws UnmatchedException
	 * compares passwords
	 */
	public static void comparePasswords(java.lang.String password, java.lang.String passwordConfirm) throws UnmatchedException {
		
		password.contentEquals(passwordConfirm);
		
	}
	
	
	/**
	 * 
	 * @author boyd1
	 * @param password
	 * @param passwordConfirm
	 * @return
	 * compares passwords with return 
	 * 
	 */
	public static boolean comparePasswordsWithReturn(java.lang.String password, java.lang.String passwordConfirm) {
		
		if(password.equals(passwordConfirm)) 
			return true;
		
			
		return false;
		
	}
	
	/**
	 * 
	 * @author boyd1
	 * @param password
	 * @return
	 * @throws LengthException
	 * checks that password length is  more than 6  characters
	 * 
	 */
	public static boolean isValidLength(java.lang.String password) throws LengthException {
		
		if(password.length() < 6) 
			throw new LengthException();
		
		
		return true;
		
		
	}
	
	/**
	 * 
	 * @author boyd1
	 * @param password
	 * @return
	 * @throws NoUpperAlphaException
	 * checks if password contains at least one upper case character
	 * 
	 */
	public static boolean hasUpperAlpha(java.lang.String password) throws NoUpperAlphaException{
		
		int upperAlphaCount = 0;
		
		for (int i = 0; i < password.length(); i++) {
			
			char neo = password.charAt(i);
			
			if(Character.isUpperCase(neo))
				upperAlphaCount++;
			
		}
		
		if(upperAlphaCount < 1)
			throw new NoUpperAlphaException();
		
		return true;
	}
	
	/**
	 * 
	 * @author boyd1
	 * @param password
	 * @return
	 * @throws NoLowerAlphaException
	 * checks if password has at least one lower case character 
	 * 
	 */
	public static boolean hasLowerAlpha(java.lang.String password) throws NoLowerAlphaException{
		
		int lowerAlphaCount = 0;
		
		for (int i = 0; i < password.length(); i++) {
			
			char neo = password.charAt(i);
			
			if(Character.isLowerCase(neo))
				lowerAlphaCount++;
			
		}
		
		if(lowerAlphaCount < 1)
			throw new NoLowerAlphaException();
		
		return true;
		
	}
	
	/**
	 * 
	 * @author boyd1
	 * @param password
	 * @return
	 * @throws NoDigitException
	 * checks if password has at least one digit
	 * 
	 */
	public static boolean hasDigit(java.lang.String password) throws NoDigitException{
		
		int digitCount = 0;
		
		for (int i = 0; i < password.length(); i++) {
			
			char neo = password.charAt(i);
			
			if(Character.isDigit(neo))
				digitCount++;
			
		}
		
		if(digitCount < 1)
			throw new NoDigitException();
		
		return true;
		
	}
	
	/**
	 * 
	 * @author boyd1
	 * @param password
	 * @return
	 * @throws NoSpecialCharacterException
	 * checks if password contains special characters
	 * 
	 */
	public static boolean hasSpecialChar(java.lang.String password) throws NoSpecialCharacterException{
		
		Pattern special = Pattern.compile("[a-zA-Z0-9]*");
		Matcher checker = special.matcher(password);
		
		if(checker.matches()) {
			throw new NoSpecialCharacterException();
		}
		
		return true;
	}
	
	/**
	 * 
	 * @author boyd1
	 * @param password
	 * @return
	 * @throws InvalidSequenceException
	 * checks if password contains more than 2 of the same character in the string in sequence
	 * 
	 */
	public static boolean NoSameCharInSequence(java.lang.String password) throws InvalidSequenceException{
		int invalidCounter = 0; 
		
		for (int i = 0; i < password.length(); i++) {
			int repeatingChar = 0;
			for(int j = i+1; j < password.length();j++) {
				
				if(password.charAt(i) == password.charAt(j)) {
					repeatingChar++;
				}else {
					break;
				}
			}
			i = i + repeatingChar;
			repeatingChar++;
			
			if (repeatingChar > 2)
				invalidCounter++;
			
		}
		
		if(invalidCounter > 0)
			throw new InvalidSequenceException();
		
		return true;
		
	}
	
	
	/**
	 * 
	 * @author boyd1
	 * @param password
	 * @return
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 * checks all requirements or a valid password
	 * 
	 */
	public static boolean isValidPassword(java.lang.String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException{
		
		if(!(isValidLength(password)))
			throw new LengthException();
		
		if(!(hasUpperAlpha(password)))
			throw new NoUpperAlphaException();
		
		if(!(hasLowerAlpha(password)))
			throw new NoLowerAlphaException();
		
		if (!(hasDigit(password)))
			throw new NoDigitException();
		
		if (!(hasSpecialChar(password)))
			throw new NoSpecialCharacterException();
		
		if (!(NoSameCharInSequence(password)))
			throw new InvalidSequenceException();
		
		return true;
		
	}
	
	/**
	 * 
	 * @author boyd1
	 * @param password
	 * @return
	 * checks if the password is a between 6 to nine characters 
	 * 
	 */
	public static boolean hasBetweenSixAndNineChars(java.lang.String password) {
		
		if(password.length() > 5 && password.length() < 10)
			return true;
		
		return false;
		
	}
	
	
	/**
	 * 
	 * @author boyd1
	 * @param password
	 * @return
	 * @throws WeakPasswordException
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 * checks for a weak password
	 * 
	 */
	public static boolean isWeakPassword(java.lang.String password) throws WeakPasswordException, LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException{
		
		if( hasBetweenSixAndNineChars(password) && isValidPassword(password))
			throw new WeakPasswordException();
	
		return false;
		
	}
	
	
	/**
	 * 
	 * @author boyd1
	 * @param passwords
	 * @return
	 * Checks an array list for invalid passwords
	 * 
	 */
	public static java.util.ArrayList<java.lang.String> getInvalidPasswords(java.util.ArrayList<java.lang.String> passwords){
		
		ArrayList <java.lang.String> invalidPasswords = new ArrayList<>();
		
		for(int i = 0; i < passwords.size(); i++) {
			
			try {
				if(isValidPassword(passwords.get(i))) {
					System.out.println("Password is valid");
				}
			} catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException
					| NoSpecialCharacterException | InvalidSequenceException e) {
				// TODO Auto-generated catch block
				invalidPasswords.add(i, passwords.get(i) + " " + e);
				System.out.println(e);
			}
			
		}
		
		
		return invalidPasswords;
	}

}
