/**
 * Finds the least number for which the proportion of bouncy numbers is exactly 99%
 * @author abhinavgurram
 * @version 1.0
 * @since 10/20/2018
 */
public class BouncyNumbers{
	public static void main(String args[]) {

		BouncyNumbers bouncyNumbers = new BouncyNumbers();

		AdcHelper adcHelper = new AdcHelper();

		// Proportion % of the bouncy numbers being tested for
		int proportion = 99;

		// Capture start time
		adcHelper.captureStartTime();

		// Compute and print least number
		int leastNum = bouncyNumbers.findLeastNumForGivenProportion(proportion);
		System.out.println("The least number is: "+leastNum);

		// Capture end time
		adcHelper.captureEndTime();

		// Print computation time
		adcHelper.printComputationTime(); 
	}

	/**
	 * Returns the least number below which there are a provided proportion of bouncy numbers
	 * @param proportion - % of numbers which are bouncy
	 * @return least number - the least number
	 */
	public int findLeastNumForGivenProportion(int proportion) {

		int bouncyNumberCount = 0;

		// Start from 100 since there are no bouncy numbers below 100
		int num = 100;

		// Loop until you find a number upto which 99% of the numbers are bouncy 
		while(true) {
			if(isBouncyNumber(num))
				bouncyNumberCount++;
			if(bouncyNumberCount * 100 == num * proportion)
				return num;
			num++;
		}
	}

	/**
	 * Determines if given number is bouncy or not
	 * @param num - the number to check if bouncy
	 * @return is given number a bouncy number 
	 */
	public static boolean isBouncyNumber(int num) {

		// Flags to determine if given number is increasing or decreasing
		boolean increasing = false;
		boolean decreasing = false;

		// Get last digit of number
		int lastDigit = num % 10;

		// Remove last digit
		num /= 10;

		// Loop while number is non-zero
		while (num != 0) {

			int digit = num % 10; 

			// Check if digit is greater than last digit
			// If true, this is a decreasing number
			if (digit > lastDigit)
				decreasing = true;

			// Check if digit is greater than last digit
			// If true, this is an increasing number
			else if (digit < lastDigit)
				increasing = true;

			// Update last digit
			lastDigit = digit;

			// Remove last digit
			num /= 10;
		}
		// If number is both increasing and decreasing, it is bouncy
		return increasing && decreasing;
	}

}
