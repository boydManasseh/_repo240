
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {
	
	String password;
	String password1;
	String password2;
	String password3;
	String password4;

	@Before
	public void setUp() throws Exception {
		
		password = "Aabbcc24ddee+";
		password1 = "Abbccddee#";
		password2 = "dfg23";
		password3 = "tte(fG45jk";
		password4 = " Tah%dah2";
		
	}

	@After
	public void tearDown() throws Exception {
		
		password = null;
		password1 = null;
		password2 = null;
		password3 = null;
		password4 = null;
	
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 * @throws LengthException 
	 */
	@Test
	public void testIsValidPasswordTooShort() throws LengthException
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidLength(password));
		} catch (LengthException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 * @throws InvalidSequenceException 
	 * @throws NoSpecialCharacterException 
	 * @throws NoDigitException 
	 * @throws NoLowerAlphaException 
	 * @throws NoUpperAlphaException 
	 * @throws LengthException 
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha() throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(password2));
		} catch (LengthException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (NoUpperAlphaException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (NoLowerAlphaException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (NoDigitException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (NoSpecialCharacterException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (InvalidSequenceException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 * @throws InvalidSequenceException 
	 * @throws NoSpecialCharacterException 
	 * @throws NoDigitException 
	 * @throws NoLowerAlphaException 
	 * @throws NoUpperAlphaException 
	 * @throws LengthException 
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha() throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
		assertTrue(PasswordCheckerUtility.isValidPassword(password4));
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 * @throws WeakPasswordException 
	 * @throws InvalidSequenceException 
	 * @throws NoSpecialCharacterException 
	 * @throws NoDigitException 
	 * @throws NoLowerAlphaException 
	 * @throws NoUpperAlphaException 
	 * @throws LengthException 
	 */
	@Test
	public void testIsWeakPassword() throws WeakPasswordException, LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
		try {
			assertTrue(PasswordCheckerUtility.isWeakPassword(password4));
		} catch (WeakPasswordException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (LengthException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (NoUpperAlphaException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (NoLowerAlphaException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (NoDigitException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (NoSpecialCharacterException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (InvalidSequenceException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 * @throws InvalidSequenceException 
	 * @throws NoSpecialCharacterException 
	 * @throws NoDigitException 
	 * @throws NoLowerAlphaException 
	 * @throws NoUpperAlphaException 
	 * @throws LengthException 
	 */
	@Test
	public void testIsValidPasswordInvalidSequence() throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(password3));
		} catch (LengthException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (NoUpperAlphaException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (NoLowerAlphaException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (NoDigitException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (NoSpecialCharacterException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (InvalidSequenceException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 * @throws NoDigitException 
	 */
	@Test
	public void testIsValidPasswordNoDigit() throws NoDigitException
	{
		try {
			assertTrue(PasswordCheckerUtility.hasDigit(password2));
		} catch (NoDigitException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(password1));
		} catch (LengthException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (NoUpperAlphaException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (NoLowerAlphaException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (NoDigitException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (NoSpecialCharacterException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (InvalidSequenceException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		fail("Not implemented by student yet");
	}
	
}
