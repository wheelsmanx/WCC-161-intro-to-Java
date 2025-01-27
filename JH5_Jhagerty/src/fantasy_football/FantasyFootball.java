package fantasy_football;

import java.util.Scanner;

public class FantasyFootball {
	private int numberOfTeams; // Same as teamAverage.length.
	private int numberOfWeeks; // Same as weekAverage.length.
	private int[][] scores; // numberOfTeams rows and numberOfWeeks columns.
	private double[] weekAverage; // contains an entry for each week
	private double[] teamAverage; // contains an entry for each team
	private String[] teamName; // contains an entry for each team

	public void enterInData() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter number of teams:");
		numberOfTeams = keyboard.nextInt();
		System.out.println("Enter number of weeks:");
		numberOfWeeks = keyboard.nextInt();
		// ************** Fill in Code ***************
		// Allocate array memory for teamName to store the team names.
		String[] teamName = new String[numberOfTeams];
		// Allocate array memory for scores (2 dimensional array) to store a
		// score for each team for each week.
		int[][] scores = new int[numberOfTeams][numberOfWeeks];
		for(int i = 0; i < numberOfTeams; i++){
			for(int b = 0;b < numberOfWeeks; b++)
			{
			scores[i][b] = 1;
			//scores[week][teamnumber] = scoresTeams[teamnumber];
			}
		}
		for (int team = 0; team <= numberOfTeams+1; team++) {
			System.out.println("Enter team name");
			// ************* Fill in Code **************
			// Read in Team name and store it in teamName
			teamName[team] = keyboard.next();
			for (int week = 0; week <= numberOfWeeks+1; week++) {
				System.out.println("Enter score for team " + teamName[team]);
				System.out.println("on week number " + (week + 1));
				scores[week][team] = keyboard.nextInt();
				// ************ Fill in Code ***************
				// Read in a score and store it in the proper spot in the scores
				// array

			}
		}
	}

	public void fillTeamAverage() {
	double[] teamAverage = new double[numberOfTeams];
	double buffer = 0; 
	int counter = 0;
		for(int team = 0; team < teamAverage.length; team++){
			for(int week = 0; week < numberOfWeeks; week++){
			buffer = buffer + scores[week][team];
			counter++;
			}
			buffer = buffer / counter; 
			teamAverage[team] = buffer; 
			buffer = 0;
			counter = 0;
		}
	}
	

	public void fillWeekAverage() {
		double buffer = 0; 
		int counter = 0;
		double[] weekAverage = new double[numberOfWeeks];
		for (int week = 0; week < weekAverage.length; week++){
			for(int team = 0; team < numberOfTeams; team++){
				buffer = buffer + scores[week][team];
				counter++;
			}
			buffer = buffer/counter;
			weekAverage[week] = buffer;
			buffer = 0;
			counter = 0;
		}
		// *********** Fill in Code *************
		// Allocate memory for the weekAverage instance variable.
		// Each entry in this array will contain the average of
		// all teams for a given week.

	}

	public void display() {
		// ********* Fill in Code ****************
		// This method will print out the display that was shown above.
		// At this point all of the information can be found in the
		// private instance variables of the FantasyFootball class
		System.out.println("This is the number of teams ");
		System.out.println(numberOfTeams);
		System.out.println("This is the number of weeks.");
		System.out.println(numberOfWeeks);
		System.out.println("This is the Score Table ");
		for(int[] a : scores){
			System.out.println(a);
			for(int b : a){
				System.out.println(b);
			}
		}
		System.out.println("Weekly Averages ");
		for(double stuff : weekAverage){
			System.out.println(stuff);
		}
		System.out.println("team Averages ");
		for(double stuff : teamAverage){
			System.out.println(stuff);
		}
		System.out.println("Team Names");
		for(String stuff : teamName){
			System.out.println(stuff);
		}
	}

	public static void main(String[] args) {
		FantasyFootball f = new FantasyFootball();
		f.enterInData();
		f.fillTeamAverage();
		f.fillWeekAverage();
		f.display();
	}
}