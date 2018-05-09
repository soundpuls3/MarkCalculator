/* CSC1021 Project 1
 * 
 * Author: Toby Io
 * 
 * Last Edit: 03/11/2017
 * 
 * Description: StudentChart.java is a class that draws a bar chart with provided data from Summary.java.
 */

public class StudentChart {
	public static void studentChart() {
		
		// X-axis
		Bar vertx = new Bar();
		vertx.makeVisible();
		vertx.changeSize(3, 500);
		vertx.moveVertical(-100);
		vertx.moveHorizontal(-50);
		vertx.changeColour(Colour.BLACK);
		
		// Y-axis
		Bar horiy = new Bar();
		horiy.makeVisible();
		horiy.changeSize(500, 3);
		horiy.moveVertical(240);
		horiy.moveHorizontal(-60);
		horiy.changeColour(Colour.BLACK);
		
		Bar bar_arr[] = new Bar[6];
		
		//Bars for each module mark calculated
		for (int i = 0; i < Summary.compute_arr.length; i++) {
			
			bar_arr[i] = new Bar();
			bar_arr[i].makeVisible();
			bar_arr[i].changeSize((int)(Summary.compute_arr[i]*2.7),30);
			bar_arr[i].moveVertical(-35 + (i*47));
			bar_arr[i].moveHorizontal(-47);
		//Bars Color Detection
			if(Summary.score_arr[i] == "Pass"){
		//First Class
				if(Summary.compute_arr[i] >= 70){
					
					bar_arr[i].changeColour(Colour.MAGENTA);
		//Normal Pass			
				}else{
					
					bar_arr[i].changeColour(Colour.GREEN);
				}
			}else{
		//Fail		
				if(Summary.score_arr[i] == "Fail"){
					
					bar_arr[i].changeColour(Colour.RED);
					
				}else{
		//Compensated Fail			
					bar_arr[i].changeColour(Colour.YELLOW);
				}
			}
				
		}
		return;
	}
}
