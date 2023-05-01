import java.util.Scanner;

public class Prog4 {

    public static void main(String[] args) {
    	
    	PromptUser();

    }

	private static void PromptUser() {
		
		// ask user what they want to do
		System.out.println(
				"Please select which operation you would like to perform by entering the labeled number:\n"
				+ "(1) Insert new record.\n"
				+ "(2) Delete existing record.\n"
				+ "(3) Update existing record.\n"
				+ "(4) Print customer's total bill.\n"
				+ "(5) Print all customers staying at this location.\n"
				+ "(6) Print the schedule of staff for a given week.\n"
				+ "(7) Print the average ratings of amenities within a two day range.\n"
				+ "(8) TBD\n"
				);
		
		Scanner scanner = new Scanner(System.in);
		
		
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
