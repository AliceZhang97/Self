import java.util.ArrayList;
import java.util.Scanner;

public class ScheduleActivity {

	public static void main(String[] args) {
		String result = "";
		
		//get the number of tests
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of tests (<=100):");
		int num = scan.nextInt();
		
		//for each test, get the number of activities
		for (int i = 0; i < num; i++) {
			Scanner scan1 = new Scanner(System.in);
			System.out.println("Enter the number of activities:");
			int numActivity = scan1.nextInt();
			
			//create an array to represent the time map
			boolean[] timeMap = new boolean[22];
			for (int p = 0; p < timeMap.length; p++) {
				timeMap[p] = false;
			}
			
			int count = 0;
			
			//get the time interval of each activity and fill in the list
			ArrayList<String> list = new ArrayList<String>();
			for (int j = 0; j < numActivity; j++) {
				Scanner scan2 = new Scanner(System.in);
				System.out.println("Enter the time interval for the activity:");
				String test = scan2.nextLine();		
				list.add(test);
			}

			//for each time interval of the list
			for (int k = 0; k < list.size(); k++) {
				String[] timeInterval = list.get(k).split(" ");
				int start = Integer.parseInt(timeInterval[0]);
				int end = Integer.parseInt(timeInterval[1]);
				
				//cover the time interval of this activity, not available
				int q;
				for (q = start; q < end + 1; q++) {
					if (timeMap[q] == true) {
						break;
					}
				}
				if (q == end + 1) {
					for (int p = start; p < end + 1; p++) {
						timeMap[p] = true;
					}
					count++;
				}
			}
			result = result + count + "\n";			
		}
		System.out.println(result);
	}

}
