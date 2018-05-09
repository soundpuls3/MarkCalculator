
/* CSC1021 Project 1
 * 
 * Author: Toby Io
 * 
 * Last Edit: 03/11/2017
 * 
 * Description: Summary.java is a class that lets the user input their marks, 
 * said marks would be sent to the MarkCalculator class,
 * then the course marks and exam marks will be calculated as computemarks and
 * send back to Summary.java to plot out a table and a bar chart usingthe method
 * studentSummary and studentChart respectively.
 */

import java.util.Scanner;

public class Summary {

	public static int course_exam_arr[][] = new int[6][2];
	public static int compute_arr[] = new int[6];
	
	public static String score_arr[] = new String[6];
	
	private static Scanner sc1;
	private static int computeresult = 0;
	private static int computemarks = 0;
	
	public static void studentSummary() {
		// Weight
		int weight_arr[] = { 50, 40, 100, 50, 20, 35 };

		// Input Course Name
		String tempString = null;
		int temp = 0;
		int num = 0;
		sc1 = new Scanner(System.in);

		//Storage of Data
		for (num = 0; num <= 5; num++) {

				System.out.println("===========================================================================");
				System.out.println("Insert Course Mark For CSC102" + (num + 1) + ":");
				
				//Invalid Input Detection
				tempString = sc1.nextLine();
				while(!tempString.matches("[0-9]{1,2}") && !tempString.matches("100")){
					
					System.out.println("Invalid Input.");
					System.out.println("===========================================================================");
					System.out.println("Insert Course Mark For CSC102" + (num + 1) + ":");
					
					tempString = sc1.nextLine();
					
			}
				temp = Integer.parseInt(tempString);
				course_exam_arr[num][0] = temp;
				
				if(num == 2) {
					//Avoiding Status Detection
					course_exam_arr[num][1] = 100;
				}else {
			
			System.out.println("===========================================================================");
			System.out.println("Insert Exam Mark For CSC102" + (num + 1) + ":");
			
			//Invalid Input Detection
			tempString = sc1.nextLine();
			
			while(!tempString.matches("[0-9]{1,2}") && !tempString.matches("100")){
				
				System.out.println("Invalid Input.");
				System.out.println("===========================================================================");
				System.out.println("Insert Exam Mark For CSC102" + (num + 1) + ":");
				
				tempString = sc1.nextLine();
				}

					
				temp = Integer.parseInt(tempString);
			course_exam_arr[num][1] = temp;
				}
		}
		
		System.out.println("===========================================================================");
		
		// Calculation of data
		for (int i = 0; i < course_exam_arr.length; i++) {
			
			int course = course_exam_arr[i][0];
			int exam = course_exam_arr[i][1];
			int weight = weight_arr[i];
			
			computemarks = MarkCalculator.computeMarks(course, exam, weight);
			
			score_arr[i] = MarkCalculator.score;
			compute_arr[i] = computemarks;
			
			computeresult = MarkCalculator.computeResult(computemarks);

		}
		//Status(Pass, Compensated Pass, Fail)
		switch (MarkCalculator.Status) {
		case (0):
			System.out.println("Status:");
			System.out.println("You passed year one!");
			break;
		case (1):
			System.out.println("Status:");
			System.out.println("You passed year one!(With Compensation)");
			break;
		case (2):
			System.out.println("Status:");
			System.out.println("You passed year one!(With Compensation)");
			break;
		default:
			System.out.println("Status:");
			System.out.println("You Failed Year One.");
		}
		
		//Graph of results
		System.out.println("===========================================================================");
		System.out.println("|Course\t|Course Mark\t|Exam Mark\t|Module Mark\t|Status\t\t" + "  |");
		
		for (int i = 0; i < compute_arr.length; i++) {
			if (i != 2) {
				if (score_arr[i].equals("Compensated Fail")) {
					System.out.println("|CSC102" + (i + 1) + "|" + course_exam_arr[i][0] + "\t\t|"
							           + course_exam_arr[i][1] + "\t\t|" + compute_arr[i] + "\t\t|" + score_arr[i] + " |");
				} else {
					System.out.println("|CSC102" + (i + 1) + "|" + course_exam_arr[i][0] + "\t\t|" + course_exam_arr[i][1]
									 + "\t\t|" + compute_arr[i] + "\t\t|" + score_arr[i] + "\t\t" + "  |");
				}

			} else {

				if (score_arr[i].equals("Compensated Fail")) {
					System.out.println("|CSC1023|" + course_exam_arr[i][0] + "\t\t|No Exam\t|" + compute_arr[i]
							           + "\t\t|" + score_arr[i] + " | ");
				} else {
					System.out.println("|CSC1023|" + course_exam_arr[i][0] + "\t\t|No Exam\t|" + compute_arr[i]
							           + "\t\t|" + score_arr[i] + "\t\t" + "  |");
				}
			}
		}
		System.out.println("===========================================================================");
		System.out.println("|Result\t|" + (computeresult / 6) + "\t\t|Credits\t|120 \t\t|" + "CompSci Bsc");
		System.out.println("===========================================================================");
		
		//Calls StudentChart method
		StudentChart.studentChart();
	}

	public static void main(String args[]){
		studentSummary();
	}
}