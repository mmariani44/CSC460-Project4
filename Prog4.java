import java.util.Scanner;

public class Prog4 {
	
    // interface for making the code less ugly. doesnt really matter, but better than having 8 if/elses
    interface CmdAction {
    	void cmd();
    }
    
    private static CmdAction[] cmdActions = new CmdAction[] {
    		new CmdAction() { public void cmd() { RecordInsertion(); } },
    		new CmdAction() { public void cmd() { RecordDeletion(); } },
    		new CmdAction() { public void cmd() { RecordUpdate(); } },
    		new CmdAction() { public void cmd() { PrintBill(); } },
    		new CmdAction() { public void cmd() { PrintAllGuests(); } },
    		new CmdAction() { public void cmd() { PrintAllSchedules(); } },
    		new CmdAction() { public void cmd() { PrintAverageRatings(); } },
    		new CmdAction() { public void cmd() { PrintOurChoice(); } },
    };

    
    
    public static void main(String[] args) {
    	
    	while (true) {
    		boolean promptAgain = PromptUser();
    		if (!promptAgain) {
    			break;
    		}
    	}
    	
    }
    
    
    
	private static boolean PromptUser() {
		
		// ask user what they want to do
		System.out.println(
				"Select which operation you would like to perform by entering the labeled number:\n"
				+ "(1) Insert new record.\n"
				+ "(2) Delete existing record.\n"
				+ "(3) Update existing record.\n"
				+ "(4) Print customer's total bill.\n"
				+ "(5) Print all customers staying at this location.\n"
				+ "(6) Print the schedule of staff for a given week.\n"
				+ "(7) Print the average ratings of amenities within a two day range.\n"
				+ "(8) TBD\n"
				);
		
		// collect user input and verify
		Scanner scanner = new Scanner(System.in);
		
		// check if quit command
		String input = scanner.nextLine().strip();
		if (input.equals("Q") || input.equals("q")) {
			return false;
		}
		
		// check if input is valid number and within bounds
		int cmdNumber = 0;
		try {			
			cmdNumber = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("Enter a valid number.");
			return true;
		}
		if (cmdNumber < 1 || cmdNumber > 8) {
			System.out.println("Enter a number between 1 and 8.");
			return true;
		}
		
		// setting the index to use for the command in the array
		cmdNumber -= 1;
		
		// do command based on user input
		cmdActions[cmdNumber].cmd();
		
		return true;
		
	}
	
	
	
	// ----------------------------------- THIS SECTION IS FOR TABLE UPDATES ----------------------------------- // 
	
	
	
	private static void RecordInsertion() {
		
	}
	
	
	
	private static void RecordDeletion() {
		
	}
	
	
	
	private static void RecordUpdate() {
		
	}
	
	
	
	// ----------------------------------- EVERYTHING BELOW IS FOR THE QUERIES ----------------------------------- //
	
	
	
	/*
	 * Print a current bill (total $) for a customer for their stay and all unpaid amenities
	 */
	private static void PrintBill() {
		
	}
	
	
	
	/*
	 * Given a certain date, output the customers that are currently staying at the hotel along with their room
	 * numbers. Order by room numbers and group by category of customer.
	 */
	private static void PrintAllGuests() {
		
	}
	
	
	
	/*
	 * 3. Print the schedule of staff given a week (input the start date of the week by the user). A schedule
	 * contains the list of staff members working that week and a staff member’s working hours (start and stop times).
	 */
	private static void PrintAllSchedules() {
		
	}
	
	
	
	/*
	 * Print the average ratings of different amenities recorded within the range of two dates(input by the user)
	 * and sort them in descending order
	 */
	private static void PrintAverageRatings() {
		
	}
	
	
	
	//TODO, this one will be changed depending on what we wan to do
	private static void PrintOurChoice() {
		
	}
	
}
