import java.sql.Date;
import java.sql.Timestamp;
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
				+ "Or enter q to quit."
				);
		
		// collect user input and verify
		Scanner scanner = new Scanner(System.in);
		
		// check if quit command
		String input = scanner.nextLine().strip();
		scanner.close();
		if (input.equals("Q") || input.equals("q")) {
			return false;
		}
		
		// check if input is valid number and within bounds. if invalid, return and do loop again
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
		
		// do the loop again
		return true;
		
	}
	
	private static void ExecuteSQLCommand(String cmd) {
		
		
		
	}
	
	
	
	// ----------------------------------- THIS SECTION IS FOR TABLE UPDATES ----------------------------------- // 
	
	
	
	private static void RecordInsertion() {
		
		// prompt user
		System.out.println("Specify the table you are inserting into:");
		Scanner scanner = new Scanner(System.in);		
		String input = scanner.nextLine().strip().toLowerCase();
		
		// 
		StringBuilder sqlCmd = new StringBuilder();
		sqlCmd.append("INSERT INTO Hotel.");
		String cols = "";
		String values = "";
		
		// depending on user input, add entry to that table
		switch(input) {
			case "client":
				
				sqlCmd.append("Client ");
				
				System.out.println("Enter client first name:");
				String firstName = scanner.nextLine().strip().toLowerCase().strip();
				System.out.println("Enter client last name:");
				String lastName = scanner.nextLine().strip().toLowerCase().strip();
				try {
					Client client = new Client(firstName, lastName);
					cols = client.GetFields();
					values = client.toString();
				} catch (Exception e) {
					System.out.println("Error creating entry.");
				}
				
			case "booking":
				
				sqlCmd.append("Booking ");
				
				System.out.println("Enter Booking information in a comma seperated list as such:\n"
						+ "Client ID, Hotel ID, Room ID, Start Date (yyyy-mm-dd), End Date(yyyy-mm-dd)");
				String bookingInfo = scanner.nextLine();
				String[] bookingArray = bookingInfo.split(",");
				try {
					
					Booking booking = new Booking(bookingArray[0].strip(), bookingArray[1].strip(), bookingArray[2].strip(), 
							Date.valueOf(bookingArray[3].strip()), Date.valueOf(bookingArray[4].strip()));
					cols = booking.GetFields();
					values = booking.toString();
					
				} catch (Exception e) {
					System.out.println("Error creating entry.");
				}
				
			case "hotel":
				
				sqlCmd.append("Hotel ");
				
				System.out.println("Enter Hotel name");
				String hotelName = scanner.nextLine();
				try {
					
					Hotel hotel = new Hotel(hotelName);
					cols = hotel.GetFields();
					values = hotel.toString();
					
				} catch (Exception e) {
					System.out.println("Error creating entry.");
				}
				
			case "room":
				
				sqlCmd.append("Room ");
				
				System.out.println("Enter Room information in a comma seperated list as such:\n"
						+ "Hotel ID, Room Rate");
				String roomInfo = scanner.nextLine();
				String[] roomArray = roomInfo.split(",");
				try {
					
					Room room = new Room(roomArray[0].strip(), Float.parseFloat(roomArray[1].strip()));
					cols = room.GetFields();
					values = room.toString();
					
				} catch (Exception e) {
					System.out.println("Error creating entry.");
				}
				
			case "amenity":
				
				sqlCmd.append("Amenity ");
				
				System.out.println("Enter Amenity information in a comma seperated list as such:\n"
						+ "Hotel ID, Amenity Name");
				String amenityInfo = scanner.nextLine();
				String[] amenityArray = amenityInfo.split(",");
				try {
					
					Amenity amenity = new Amenity(amenityArray[0].strip(), amenityArray[1].strip());
					cols = amenity.GetFields();
					values = amenity.toString();
					
				} catch (Exception e) {
					System.out.println("Error creating entry.");
				}
				
			case "rating":
				
				sqlCmd.append("Rating ");
				
				System.out.println("Enter Rating information in a comma seperated list as such:\n"
						+ "Rating, Comments, Amenity ID");
				String ratingInfo = scanner.nextLine();
				String[] ratingArray = ratingInfo.split(",");
				try {
					
					Rating rating = new Rating(Integer.parseInt(ratingArray[0].strip()), ratingArray[1].strip(), ratingArray[2].strip());
					cols = rating.GetFields();
					values = rating.toString();
					
				} catch (Exception e) {
					System.out.println("Error creating entry.\n");
				}
				
			case "employee":
				
				sqlCmd.append("Employee ");
				
				System.out.println("Enter Employee information in a comma seperated list as such:\n"
						+ "Hotel ID, First Name, Last Name, Duty, Wage");
				String employeeInfo = scanner.nextLine();
				String[] employeeArray = employeeInfo.split(",");
				try {
					
					Employee employee = new Employee(employeeArray[0].strip(), employeeArray[1].strip(), employeeArray[2].strip(), 
							employeeArray[3].strip(), Float.parseFloat(employeeArray[4].strip()));
					cols = employee.GetFields();
					values = employee.toString();
				
				} catch (Exception e) {
					System.out.println("Error creating entry.\n");
				}
				
			case "shift":
				
				sqlCmd.append("Shift ");
				
				System.out.println("Enter Shift information in a comma seperated list as such:\n"
						+ "Employee ID, Start Date/Time (yyyy-mm-dd hh:mm:ss), End Date/Time (yyyy-mm-dd hh:mm:ss)");
				String shiftInfo = scanner.nextLine();
				String[] shiftArray = shiftInfo.split(",");
				try {
					
					Shift shift = new Shift(shiftArray[0].strip(), Timestamp.valueOf(shiftArray[1].strip()), Timestamp.valueOf(shiftArray[2].strip()));
					cols = shift.GetFields();
					values = shift.toString();
				
				} catch (Exception e) {
					System.out.println("Error creating entry.\n");
				}
				
		}
		
		
		scanner.close();
		
		sqlCmd.append("(" + cols + ")");
		sqlCmd.append("VALUES (" + values + ")");
		
		ExecuteSQLCommand(sqlCmd.toString());

	}
	
	
	
	private static void RecordDeletion() {

		// prompt user
		System.out.println("Specify the table you are deleting from:");
		Scanner scanner = new Scanner(System.in);		
		String input = scanner.nextLine().strip().toLowerCase();
		
		// 
		StringBuilder sqlCmd = new StringBuilder();
		sqlCmd.append("DELETE FROM Hotel.");
		String cols = "";
		String values = "";
		
		switch(input) {
			case "client":
				sqlCmd.append("Client WHERE ");
				
				System.out.println("Specify the client you are deleting (Client ID): ");
				String clientId = scanner.nextLine();
				
				sqlCmd.append("clientId = " + clientId);

			case "booking":
				sqlCmd.append("Booking WHERE ");
				
				// prompt user
				System.out.println("Specify the booking you are deleting (Client ID, Hotel ID, Room ID, Start Date (yyyy-mm-dd)): ");
				String bookingInfo = scanner.nextLine();
				String[] bookingArray = bookingInfo.split(",");

				// build sql command
				sqlCmd.append("clientId = " + bookingArray[0].strip() + " AND hotelId = " + bookingArray[1].strip() + " AND "
						+ "roomId = " + bookingArray[2].strip() + " AND startDate = " + bookingArray[3].strip());
				
			case "hotel":
				sqlCmd.append("Hotel WHERE ");
				
				System.out.println("Specify the hotel you are deleting (Hotel ID): ");
				String hotelId = scanner.nextLine();
				
				sqlCmd.append("hotelId = " + hotelId);
				
			case "room":
				sqlCmd.append("Room WHERE ");
				
				System.out.println("Specify the room you are deleting (Room ID, Hotel ID): ");
				String roomInfo = scanner.nextLine();
				String[] roomArray = roomInfo.split(",");
				
								
				sqlCmd.append("roomId = " + roomArray[0].strip() + " AND hotelId = " + roomArray[1].strip());
				
			case "amenity":
				sqlCmd.append("Amenity WHERE ");
				
				System.out.println("Specify the amenity you are deleting (Amenity ID, Hotel ID): ");
				String amenityInfo = scanner.nextLine();
				String[] amenityArray = amenityInfo.split(",");
								
				sqlCmd.append("amenityId = " + amenityArray[0].strip() + " AND hotelId = " + amenityArray[1].strip());
				
			case "rating":
				sqlCmd.append("Rating WHERE ");
				
				System.out.println("Specify the rating you are deleting (Rating ID): ");
				String ratingId = scanner.nextLine();
				
				sqlCmd.append("ratingId = " + ratingId);
				
			case "employee":
				sqlCmd.append("Employee WHERE ");
				
				System.out.println("Specify the employee you are deleting (Employee ID, Hotel ID): ");
				String employeeInfo = scanner.nextLine();
				String[] employeeArray = employeeInfo.split(",");
								
				sqlCmd.append("employeeId = " + employeeArray[0].strip() + " AND hotelId = " + employeeArray[1].strip());
				
			case "shift":
				sqlCmd.append("Shift WHERE ");
				
				System.out.println("Specify the employee you are deleting (Employee ID, Hotel ID): ");
				String shiftInfo = scanner.nextLine();
				String[] shiftArray = shiftInfo.split(",");
								
				sqlCmd.append("employeeId = " + shiftArray[0].strip() + " AND hotelId = " + shiftArray[1].strip());
				
		}
		
		scanner.close();
		
		ExecuteSQLCommand(sqlCmd.toString());
		
	}
	
	
	
	private static void RecordUpdate() {
		
		System.out.println("Specify the table you are updating: ");
		
		Scanner scanner = new Scanner(System.in);		
		String input = scanner.nextLine().strip().toLowerCase();
		
		switch(input) {
			case "client":

			case "booking":
				
			case "hotel":
				
			case "room":
				
			case "amenity":
				
			case "rating":
				
			case "employee":
				
			case "shift":
		}
		
		scanner.close();
		
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
