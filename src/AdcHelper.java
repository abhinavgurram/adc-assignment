

/**
 * A helper class to log, calculate and print the time taken for computation
 * @author abhinavgurram
 * @version 1.0
 * @since 10/21/2018
 */
public class AdcHelper {

	long startTime = 0;
	long endTime = 0;


	/**
	 * Gets current system time
	 * @return current system time
	 */
	public long getCurrentTime() {
		return System.currentTimeMillis();
	}


	/**
	 * Captures start time
	 * @return current system time
	 */
	public void captureStartTime() {
		this.startTime =  this.getCurrentTime();
	}

	/**
	 * Captures end time
	 * @return current system time
	 */
	public void captureEndTime() {
		this.endTime = this.getCurrentTime();
	}

	/**
	 * Calculates the time taken using the a start and end time
	 * @return time taken
	 */
	public long calcTimeTaken() {
		return this.endTime - this.startTime;

	}

	/**
	 * Prints the time taken in seconds and milliseconds
	 */
	public void printComputationTime() {
		long timeTaken = this.calcTimeTaken();
		long seconds = timeTaken / 1000;
		long milliseconds = timeTaken % 1000;
		System.out.format("Computation time: %ds %dms %n",seconds,milliseconds);
	}

}
