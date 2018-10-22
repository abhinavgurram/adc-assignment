

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;

import org.junit.Test;

public class TestTwoWaysPathSum {

	// File path
	String filePath = "";

	// Number of rows and columns
	int numRows = 80;
	int numCols = 80;

	// A 2-D matrix to holds values in text file
	int [][] matrix = null;


	TwoWaysPathSum tws = new TwoWaysPathSum();


	/**
	 * Test throws exception while trying to read an invalid file
	 * @throws FileNotFoundException
	 */
	@Test(expected = java.io.FileNotFoundException.class)
	public void testThrowExceptionForInvalidFile() throws FileNotFoundException {
		tws.readFile(numRows, numCols, filePath);
	}	

	/**
	 * Test valid file is read correctly by verifying the matrix is not null
	 */
	@Test
	public void testReadValidFile() {
		filePath = "../p081_matrix.txt";
		try {
			matrix = tws.readFile(numRows, numCols, filePath);
			assertNotNull("Did not read values from text file",matrix);
		} catch (FileNotFoundException e) {
			fail("Unable to read given file");
		}

	}

	/**
	 * Test correct minimum path sum returned for a given matrix
	 */
	@Test
	public void testGetMinPathSum() {
		int testMatrix[][] = {
				{131,673,234,103,18},
				{201,96,342,965,150},
				{630,803,746,422,111},
				{537,699,497,121,956},
				{805,732,524,37,331}
		};
		int rows = testMatrix.length;
		int cols = testMatrix[0].length;
		int expectedValue = 2427;
		int actualValue = tws.getMinPathSum(testMatrix,rows,cols);
		assertEquals("Incorrect sum returned",expectedValue,actualValue);
	}

	/**
	 * Test correct minimum path sum returned for a given matrix containing two paths of same values
	 */
	@Test
	public void testGetMinPathSumWithTwoPathsOfSameValues() {
		int testMatrix[][] = {
				{1,3,1},
				{1,5,1},
				{3,1,1}
		};
		int rows = testMatrix.length;
		int cols = testMatrix[0].length;
		int expectedValue = 7;
		int actualValue = tws.getMinPathSum(testMatrix,rows,cols);
		assertEquals("Incorrect sum returned",expectedValue,actualValue);
	}

}
