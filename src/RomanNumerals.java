

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Driver class that calculates the number of characters
 * saved by writing a given roman numeral in its minimal form
 * @author abhinavgurram
 * @version 1.0
 * @since 10/20/2018
 *
 */
public final class RomanNumerals {
	public static void main(String[] args) throws FileNotFoundException {

		RomanNumerals roman = new RomanNumerals();
		AdcHelper adcHelper = new AdcHelper();

		// Read from given text file
		int rows = 1000;
		String filePath = "../p089_roman.txt";
		String [] romanNumerals  = null;

		// Capture start time
		adcHelper.captureStartTime();

		// Read matrix from given file
		romanNumerals = roman.readFile(filePath, rows);

		// Compute and print total characters saved
		int totalCharsSaved = 0;
		totalCharsSaved = roman.totalCharsSaved(romanNumerals);
		System.out.println("Total number of characters saved are:"+ totalCharsSaved);

		// Capture end time
		adcHelper.captureEndTime();

		// Print computation time
		adcHelper.printComputationTime();
	}

	/**
	 * Returns a linked hashmap with roman numerals and their corresponding integer values
	 * @return map - collection of roman numerals and values
	 */
	public HashMap<String,Integer> createMap(){
		// Use a linked hashmap to maintain creation order
		// For eg: we would like to check if given roman numeral starts with "CM"
		// before checking if it starts with "C"
		HashMap<String,Integer> map = new LinkedHashMap<String,Integer>();
		map.put("M", 1000);
		map.put("CM", 900);
		map.put("D",  500);
		map.put("CD", 400);
		map.put("C",  100);
		map.put("XC", 90);
		map.put("L",  50);
		map.put("XL", 40);
		map.put("X" , 10);
		map.put("IX", 9);
		map.put("V",  5);
		map.put("IV", 4);
		map.put("I" , 1);
		return map;
	}

	/**
	 * Reads the roman numerals presented in the file and returns them as an array of strings
	 * @param rows - number of rows
	 * @return array of romanNumerals
	 * @throws FileNotFoundException - when given file is not found
	 */
	public String[] readFile(String filePath,int rows) throws FileNotFoundException{
		String[] romanNumerals = new String[rows];
		Scanner sc = new Scanner(new BufferedReader(new FileReader(filePath)));
		while(sc.hasNextLine()) {
			for (int i=0; i< romanNumerals.length; i++) {
				String romanNumeral = sc.nextLine().trim();
				romanNumerals[i] = romanNumeral;
			}
		}
		sc.close();

		return romanNumerals;
	}

	/**
	 * For a given array of roman numeral strings calculates the number of characters saved altogether
	 * @param romanNumerals
	 * @return total number of characters saved  
	 */
	public int totalCharsSaved(String[] romanNumerals) {
		// Create a map of roman numbers with their corresponding integer values
		HashMap<String,Integer> map = createMap();

		int totalCharsSaved = 0;

		// For each roman numeral calculate their numeric value, length, and the number of characters saved
		for (String romanNumeral : romanNumerals) {
			int numericValueOfRomanNumeral = this.calculateNumericValue(romanNumeral,map);
			int lengthOfRomanNumeral = this.calculateRomanNumeralLength(numericValueOfRomanNumeral);
			int numberOfCharactersSaved = romanNumeral.length() - lengthOfRomanNumeral;
			totalCharsSaved += numberOfCharactersSaved;
		}
		return totalCharsSaved;
	}

	/**
	 * Calculates the numeric value for a given roman numeral
	 * @param romanNumeral
	 * @param map
	 * @return
	 */
	public int calculateNumericValue(String romanNumeral,HashMap<String,Integer> map) {

		int numericValue = 0;

		// Holds an entry that matches the roman numeral in the map
		Map.Entry<String, Integer> entry = null;

		// Loop until all characters in the given roman numeral have been accounted for 
		// and calculate the numeric value
		while (romanNumeral.length() > 0) {
			entry = isValid(map,romanNumeral);
			numericValue += entry.getValue();
			romanNumeral = romanNumeral.substring(entry.getKey().length());
		}

		return numericValue;
	}

	/**
	 * Returns an entry in the map if provided roman numeral is valid
	 * @param map of roman numerals with their values
	 * @param romanNumeral - the given roman numeral
	 * @return map entry - entry in the map whose key is at the beginning of given numeral
	 */
	public Map.Entry<String, Integer> isValid(HashMap<String,Integer> map,String romanNumeral) {
		for (Map.Entry<String, Integer> entry:map.entrySet()) { 
			String key = entry.getKey();
			if (romanNumeral.startsWith(key)) {
				return entry;
			}
		}
		// When invalid roman numeral is encountered, throw exception
		throw new IllegalArgumentException("Cannot parse Roman numeral");
	}

	/**
	 * Calculates the length of the roman numeral using its integer value
	 * @param numericValue - the numeric value of given roman numeral
	 * @return length of roman numeral
	 */
	public int calculateRomanNumeralLength(int numericValue) {
		int[] romanLengthsForSingleDigitNumbers = {0, 1, 2, 3, 2, 1, 2, 3, 4, 2};

		// Since only 4 same characters are allowed at a maximum,
		// The integer value cannot exceed 5000 nor be negative
		if (numericValue <= 0 || numericValue >= 5000)
			throw new IllegalArgumentException();

		int count = 0;

		// Since anything greater than or equal to 4000 includes 'MMMM'
		// that cannot be reduced to a 2-character form, increment count by 2
		// For eg: 4000 will be reduced to DIGIT_LENGTHS[4] = 2, but the actual
		// length is 4 since 'MMMM' = 4
		if (numericValue >= 4000)   
			count += 2;  

		while(numericValue!=0) {
			count += romanLengthsForSingleDigitNumbers[numericValue % 10];
			numericValue = numericValue/10;	
		}
		return count;
	}

}