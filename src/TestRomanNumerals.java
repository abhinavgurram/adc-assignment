

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.util.HashMap;

import org.junit.Test;


public class TestRomanNumerals {

	// File path
	String filePath = "";

	// Array to hold all roman numeral strings
	String[] romanNumerals = null;

	// Map to hold roman numerals and their values
	HashMap<String,Integer> map = null;

	// Rows in given matrix
	int rows = 1000;


	RomanNumerals roman = new RomanNumerals();

	/**
	 * Test exception is thrown for invalid files
	 * @throws FileNotFoundException
	 */
	@Test(expected = java.io.FileNotFoundException.class)
	public void testThrowsExceptionForInvalidFile() throws FileNotFoundException {
		roman.readFile(filePath, rows);
	}	

	/**
	 * Test a non-null matrix is created upon reading the file
	 */
	@Test
	public void testReadFile() {
		filePath = "../p089_roman.txt";
		try {
			romanNumerals = roman.readFile(filePath, rows);
			assertNotNull("Did not read values from text file",romanNumerals);
		} catch (FileNotFoundException e) {
			fail("Unable to read given file");
		}

	}

	/**
	 * Test a valid roman numeral map along with their numeric values is created
	 */
	@Test
	public void testShouldCreateMap() {
		map = roman.createMap();
		assertNotNull("Map cannot be null",map);
	}


	/**
	 * Test exception is thrown for invalid roman numerals passed
	 * @throws IllegalArgumentException
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testIntegerValueForInvalidRomanNumeral() {
		String invalidRomanNumeral = "AB";
		roman.calculateNumericValue(invalidRomanNumeral, roman.createMap());
	}


	/**
	 * Test correct numeric value is calculated for given roman numeral
	 */
	@Test
	public void testCalculateNumericValue() {
		int expectedValue = 8;
		int actualValue = roman.calculateNumericValue("VIII", roman.createMap());
		assertEquals("Incorrect integer value",expectedValue,actualValue);
	}


	/**
	 * Test exception is thrown for numeric values passed
	 * For eg: values cannot be greater than 5000 or less than 0
	 * @throws IllegalArgumentException
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testValidNumericValueProvidedToCalculateRomanNumeralLength() {
		int invalidInteger = 5198;
		roman.calculateRomanNumeralLength(invalidInteger);
	}


	/**
	 * Test correct minimal length is returned for given roman numeral
	 */
	@Test
	public void testGetRomanNumeralLength() {
		int valueOfRoman = 4998;
		int expectedValue = 12;
		int actualValue = roman.calculateRomanNumeralLength(valueOfRoman);
		assertEquals("Incorrect length returned",expectedValue,actualValue);
	}

	/**
	 * Test correct number of total characters saved is returned
	 */
	@Test
	public void testTotalCharsSaved() {
		String[] romanNumerals = {"IIII","VIIII"};
		int expectedValue = 5;
		int actualValue = roman.totalCharsSaved(romanNumerals);
		assertEquals("Incorrect value for number of characters saved", expectedValue,actualValue);
	}


	/**
	 * Test correct number of total characters saved is returned for single roman numerals
	 */
	@Test
	public void testTotalCharsSavedForSingleRomanNumerals() {
		String[] romanNumerals = {"I","V"};
		int expectedValue = 0;
		int actualValue = roman.totalCharsSaved(romanNumerals);
		assertEquals("Incorrect value for number of characters saved", expectedValue,actualValue);
	}


	/**
	 * Test exception is thrown for roman numerals with more than 4 same numerals
	 * For eg: MMMMM or DDDDD
	 * @throws IllegalArgumentException
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testNoMoreThanFourSameCharactersPresentInRomanNumeral() {
		String invalidRomanNumeral = "MMMMM";
		int integerValue = roman.calculateNumericValue(invalidRomanNumeral, roman.createMap());
		roman.calculateRomanNumeralLength(integerValue);
	}
}
