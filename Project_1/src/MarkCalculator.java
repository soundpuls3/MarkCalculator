
/* CSC1021 Project 1
 * 
 * Author: Toby Io
 * 
 * Last Edit: 03/11/2017
 * 
 * Description: MarkCaluclator.java is a class that calculates the specified module mark.
 * 
 * computeMarks is a method that retrieves the course mark, weight and exam mark
 * to calculate a mark while checking it's score status to determine if a student passes or fails.
 * 
 * computeResult is a method that counts the total module mark and determines if the student can
 * get a compensated pass or not.
 */

public class MarkCalculator {

	public static int Status = 0;
	private static int i = 0;
	private static int computeresult = 0;

	public static String score = "Fail";

	public static int computeMarks(int course, int exam, int weight) {

		int computemarks_arr[] = new int[6];

		// Mark Calculation
		double computemarks = Math.ceil(((course * weight) + (exam * (100 - weight))) / 100);

		computemarks_arr[i] = (int) Math.ceil(computemarks);

		// Mark Status Detection
		if (exam >= 35 && course >= 35 && course <= 100 && exam <= 100) {
			score = "Pass";

			if (exam <= 39 || course <= 39) {
				score = "Compensated Fail";

				// If Course = CSC1022 , No Compensation
				if (i == 1) {
					score = "Fail";
				}
			}
		} else {
			score = "Fail";
		}

		i++;

		return (int) (computemarks);
	}

	public static int computeResult(int computemarks) {
		computeresult = computeresult + computemarks;

		if (score.equals("Compensated Fail")) {
			Status++;
		} else {
			if (score.equals("Fail")) {
				Status = 3; // status > 2, will be counted as fail
			}
		}

		return computeresult;

	}
}