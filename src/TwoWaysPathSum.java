

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Driver class for finding minimum path sum
 * for a given matrix to go from start to end
 * index by only moving to the right and down 
 * @author abhinavgurram
 * @version 1.0
 * @since 10/20/2018
 */

public final class TwoWaysPathSum {
	public static void main(String args[]) throws Exception {

		// Number of rows and columns in the text file
		int numRows = 80;
		int numCols = 80;

		// Matrix that holds values by reading from txt file
		int [][] matrix = null;

		TwoWaysPathSum twoWaysPathSum = new TwoWaysPathSum();

		AdcHelper adcHelper = new AdcHelper();

		// Minimum path sum
		int minimumPathSum = 0;

		// Capture start time
		adcHelper.captureStartTime();

		// Read data from the file
		String filePath = "../p081_matrix.txt";
		matrix = twoWaysPathSum.readFile(numRows,numCols,filePath);

		// Calculate and print the minimum path sum
		minimumPathSum = twoWaysPathSum.getMinPathSum(matrix,numRows,numCols);
		System.out.println("The minimum path sum is: "+minimumPathSum);

		// Capture end time
		adcHelper.captureEndTime();

		// Print computation time
		adcHelper.printComputationTime();
	}

	/**
	 * Reads the provided p081_matrix.txt file and returns the values as a 2-D matrix
	 * @param numRows
	 * @param numCols
	 * @param filePath
	 * @return 2-D matrix of values
	 * @throws FileNotFoundException
	 */
	public int[][] readFile( int numRows, int numCols,String filePath) throws FileNotFoundException {

		// Initialize matrix using numRows and numCols
		int[][] matrix = new int[numRows][numCols];

		// Read file
		Scanner sc = new Scanner(new BufferedReader(new FileReader(filePath)));

		while(sc.hasNextLine()) {
			for (int i=0; i< numRows; i++) {
				// Split at ',' to get individual values
				String[] line = sc.nextLine().trim().split(",");
				for (int j=0; j< numCols; j++) {    
					matrix[i][j] = Integer.parseInt(line[j]);
				}
			}
		}

		// Close the scanner object
		sc.close();

		return matrix;
	}


	/**
	 * Calculate the minimum path sum from start to end in a given matrix
	 * @param matrix - input 2-D matrix
	 * @param numRows - number of rows
	 * @param numCols - number of columns
	 * @return last value in new matrix containing sum of paths at each index
	 */
	public int getMinPathSum(int[][] matrix,int numRows, int numCols) {

		// Additional array that holds the sum of minimum path at each point 
		// in the matrix
		int[][] sumMatrix = new int[numRows][numCols];

		// Calc sum for indexes in first row
		int sum = 0;
		for(int i = 0; i<numRows;i++){
			sumMatrix[i][0] = matrix[i][0] + sum;
			sum = sumMatrix[i][0];
		}

		// Calc sum for indexes in first column
		sum = 0;
		for(int i = 0; i<numCols;i++){
			sumMatrix[0][i] = matrix[0][i] + sum;
			sum = sumMatrix[0][i];
		}

		// Calculate sum at remaining indexes by comparing top and left
		// and adding it to the current value
		sum = sumMatrix[0][0];
		for(int i = 1; i<numRows;i++){
			for(int j = 1;j<numCols;j++){
				sumMatrix[i][j] = matrix[i][j] + Math.min(sumMatrix[i-1][j], sumMatrix[i][j-1]);
			}
		}

		// Return value at last index
		return sumMatrix[numRows-1][numCols-1];
	}
}
