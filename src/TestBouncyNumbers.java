

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

public class TestBouncyNumbers {

	BouncyNumbers bouncyNumbers = new BouncyNumbers();

	/**
	 * Utility function to generate random numbers between given min and max range
	 * min and max inclusive
	 * @param min - minimum value of range
	 * @param max - maximum value of range
	 * @return random number in the given range
	 */
	public int generateRandomNumberInRange(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	/**
	 * Test a given number is bouncy
	 */
	@Test
	public void testIsBouncyNumber() {
		int numToCheck = 156234;
		assertTrue("Failed to identify a bouncy number",BouncyNumbers.isBouncyNumber(numToCheck));
	}

	/**
	 * Test a single digit number is not bouncy number
	 */
	@Test
	public void testBouncyNumberSingleDigit() {
		int singleDigitRandomNumber = generateRandomNumberInRange(0,9);
		assertFalse("Incorrectly identified single digit number"+ singleDigitRandomNumber + "as bouncy",BouncyNumbers.isBouncyNumber(singleDigitRandomNumber));
	}

	/**
	 * Test a single double number is not bouncy number
	 */
	@Test
	public void testBouncyNumberDoubleDigit() {
		int doubleDigitRandomNumber = generateRandomNumberInRange(10,99);
		assertFalse("Incorrectly identified double digit number"+ doubleDigitRandomNumber + "as bouncy",BouncyNumbers.isBouncyNumber(doubleDigitRandomNumber));
	}

	/**
	 * Test a given number that is increasing is not bouncy
	 */
	@Test
	public void testIsNotBouncyNumberIncreasing() {
		int numToCheck = 1234;
		assertFalse("Incorrectly identified a number as bouncy",BouncyNumbers.isBouncyNumber(numToCheck));
	}

	/**
	 * Test a given increasing number with repeating digits is not bouncy
	 */
	@Test
	public void testIsNotBouncyIncreasingNumberWithRepeatingDigits() {
		int numToCheck = 133345;
		assertFalse("Incorrectly identified a number as bouncy",BouncyNumbers.isBouncyNumber(numToCheck));
	}


	/**
	 * Test a given number that is decreasing is not bouncy
	 */
	@Test
	public void testIsNotBouncyNumberDecreasing() {
		int numToCheck = 4321;
		assertFalse("Incorrectly identified a number as bouncy",BouncyNumbers.isBouncyNumber(numToCheck));
	}



	/**
	 * Test a given decreasing number with repeating digits is not bouncy
	 */
	@Test
	public void testIsNotBouncyDecreasingNumberWithRepeatingDigits() {
		int numToCheck = 43331;
		assertFalse("Incorrectly identified a number as bouncy",BouncyNumbers.isBouncyNumber(numToCheck));
	}

	/**
	 * Test least number returned is correct for given proportion of bouncy numbers
	 */
	@Test
	public void testFindLeastNumForGivenProportion() {
		int expectedValue = 21780;
		int proportion = 90;
		assertEquals("Incorrect least number returned",expectedValue, bouncyNumbers.findLeastNumForGivenProportion(proportion));
	}

	/**
	 * Test a predefined number that is less than the actual least number for a given proportion is incorrect
	 */
	@Test
	public void testProvidedLeastNumberIsIncorrectForGivenPropertion() {
		int prevBouncyNumber = 21779;
		int proportion = 90;
		assertNotSame("Identifed least number is incorrect",prevBouncyNumber,bouncyNumbers.findLeastNumForGivenProportion(proportion));
	}	
}
