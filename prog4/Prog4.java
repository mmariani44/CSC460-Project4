package prog4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

import queries.Queries;

public class Prog4 {
    private String username;
    private String password;

    public Prog4(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static void main(String[] args) {
        Prog4 prog4 = new Prog4(args[0], args[1]);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        while (input != "q") {
            System.out.println("Select which operation you would like to perform by entering the labeled number:\n"
                    + "(1) Print customer's total bill.\n"
                    + "(2) Print all customers staying at this location.\n"
                    + "(3) Print the schedule of staff for a given week.\n"
                    + "(4) Print the average ratings of amenities within a two day range.\n"
                    + "(5) Print total revenue between two dates.\n"
                    + "(6) Insert new record.\n"
                    + "(7) Delete existing record.\n"
                    + "(8) Update existing record.\n"
                    + "Or enter q to quit.");
            try {
                input = reader.readLine();
            } catch (IOException e) {
                System.err.println("Error reading input");
                e.printStackTrace();
            }
            if (input.equals("q") || input.equals("Q")) {
                break;
            }
            int queryNum = Integer.parseInt(input);
            prog4.runQuery(queryNum, null);
        }
    }

    // ---------------------------------- MASON CODE
    // -------------------------------------------- //

    public static void testEntry(Prog4 prog, int queryNum, String testFile) {
        prog.runQuery(queryNum, testFile);
    }

    // ----------------------------------- THIS SECTION IS FOR TABLE UPDATES
    // ----------------------------------- //

    private String RecordInsertion() {

        // prompt user
        System.out.println("Specify the table you are inserting into:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().strip().toLowerCase();

        //
        StringBuilder sqlCmd = new StringBuilder();
        sqlCmd.append("INSERT INTO Hotel");
        String cols = "";
        String values = "";

        // depending on user input, add entry to that table
        if (input.toLowerCase().equals("client")) {
            sqlCmd.append("Client ");

            System.out.println("Enter client first name:");
            String firstName = scanner.nextLine().strip().toLowerCase().strip();
            System.out.println("Enter client last name:");
            String lastName = scanner.nextLine().strip().toLowerCase().strip();
            try {
                Client client = new Client(firstName, lastName);
                cols = Client.GetFields();
                values = client.toString();
            } catch (Exception e) {
                System.out.println("Error creating entry.");
            }
        }
        else if (input.toLowerCase().equals("booking")) {
        	
            sqlCmd.append("Booking ");

            System.out.println("Enter Booking information in a comma seperated list as such:\n"
                    + "Client ID, Hotel ID, Room ID, Start Date (yyyy-mm-dd), End Date(yyyy-mm-dd)");
            String bookingInfo = scanner.nextLine();
            String[] bookingArray = bookingInfo.split(",");
            try {

                Booking booking = new Booking(bookingArray[0].strip(), bookingArray[1].strip(),
                        bookingArray[2].strip(),
                        Date.valueOf(bookingArray[3].strip()), Date.valueOf(bookingArray[4].strip()));
                cols = Booking.GetFields();
                values = booking.toString();

            } catch (Exception e) {
                System.out.println("Error creating entry.");
            }
        	
        }
        else if (input.toLowerCase().equals("hotel")) {
        	
            sqlCmd.append("Hotel ");

            System.out.println("Enter Hotel name");
            String hotelName = scanner.nextLine();
            try {

                Hotel hotel = new Hotel(hotelName);
                cols = Hotel.GetFields();
                values = hotel.toString();

            } catch (Exception e) {
                System.out.println("Error creating entry.");
            }
        	
        }
        
        else if (input.toLowerCase().equals("room")) {
        	
            sqlCmd.append("Room ");

            System.out.println("Enter Room information in a comma seperated list as such:\n"
                    + "Hotel ID, Room Rate");
            String roomInfo = scanner.nextLine();
            String[] roomArray = roomInfo.split(",");
            try {

                Room room = new Room(roomArray[0].strip(), Float.parseFloat(roomArray[1].strip()));
                cols = Room.GetFields();
                values = room.toString();

            } catch (Exception e) {
                System.out.println("Error creating entry.");
            }
            
        }
        
        else if (input.toLowerCase().equals("room")) {
        	
            sqlCmd.append("Amenity ");

            System.out.println("Enter Amenity information in a comma seperated list as such:\n"
                    + "Hotel ID, Amenity Name, Price");
            String amenityInfo = scanner.nextLine();
            String[] amenityArray = amenityInfo.split(",");
            try {

                Amenity amenity = new Amenity(amenityArray[0].strip(), amenityArray[1].strip(),
                        Float.parseFloat(amenityArray[2].strip()));
                cols = Amenity.GetFields();
                values = amenity.toString();

            } catch (Exception e) {
                System.out.println("Error creating entry.");
            }
            
        }
        
        else if (input.toLowerCase().equals("rating")) {
        	
            sqlCmd.append("Rating ");

            System.out.println("Enter Rating information in a comma seperated list as such:\n"
                    + "Rating, Comments, Amenity ID");
            String ratingInfo = scanner.nextLine();
            String[] ratingArray = ratingInfo.split(",");
            try {

                Rating rating = new Rating(Integer.parseInt(ratingArray[0].strip()), ratingArray[1].strip(),
                        ratingArray[2].strip());
                cols = rating.GetFields();
                values = rating.toString();

            } catch (Exception e) {
                System.out.println("Error creating entry.\n");
            }
            
        }
        
        else if (input.toLowerCase().equals("employee")) {
        	
            sqlCmd.append("Employee ");

            System.out.println("Enter Employee information in a comma seperated list as such:\n"
                    + "Hotel ID, First Name, Last Name, Duty, Wage");
            String employeeInfo = scanner.nextLine();
            String[] employeeArray = employeeInfo.split(",");
            try {

                Employee employee = new Employee(employeeArray[0].strip(), employeeArray[1].strip(),
                        employeeArray[2].strip(),
                        employeeArray[3].strip(), Float.parseFloat(employeeArray[4].strip()));
                cols = Employee.GetFields();
                values = employee.toString();

            } catch (Exception e) {
                System.out.println("Error creating entry.\n");
            }
        	
        }
        
        else if (input.toLowerCase().equals("shift")) {
        	
            sqlCmd.append("Shift ");

            System.out.println("Enter Shift information in a comma seperated list as such:\n"
                    + "Employee ID, Start Date/Time (yyyy-mm-dd hh:mm:ss), End Date/Time (yyyy-mm-dd hh:mm:ss)");
            String shiftInfo = scanner.nextLine();
            String[] shiftArray = shiftInfo.split(",");
            try {

                Shift shift = new Shift(shiftArray[0].strip(), Timestamp.valueOf(shiftArray[1].strip()),
                        Timestamp.valueOf(shiftArray[2].strip()));
                cols = shift.GetFields();
                values = shift.toString();

            } catch (Exception e) {
                System.out.println("Error creating entry.\n");
            }
        	
        }

        scanner.close();

        sqlCmd.append("(" + cols + ")");
        sqlCmd.append(" VALUES (" + values + ")");

        return sqlCmd.toString();
    }

    private String RecordDeletion() {

        // prompt user
        System.out.println("Specify the table you are deleting from:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().strip().toLowerCase();

        //
        StringBuilder sqlCmd = new StringBuilder();
        sqlCmd.append("DELETE FROM Hotel");

        
        
        if (input.toLowerCase().equals("client")) {
            sqlCmd.append("Client WHERE ");

            System.out.println("Specify the client you are deleting (Client ID): ");
            String clientId = scanner.nextLine();

            sqlCmd.append("clientId = '" + clientId + "'");
        }
        else if (input.toLowerCase().equals("booking")) {
            sqlCmd.append("Booking WHERE ");

            // prompt user
            System.out.println(
                    "Specify the booking you are deleting (Client ID, Hotel ID, Room ID, Start Date (yyyy-mm-dd)): ");
            String bookingInfo = scanner.nextLine();
            String[] bookingArray = bookingInfo.split(",");

            // build sql command
            sqlCmd.append("clientId = '" + bookingArray[0].strip() + "' AND hotelId = '" + bookingArray[1].strip()
                    + "' AND "
                    + "roomId = '" + bookingArray[2].strip() + "' AND startDate = '" + bookingArray[3].strip() + "'");
        }
        else if (input.toLowerCase().equals("hotel")) {
            sqlCmd.append("Hotel WHERE ");

            System.out.println("Specify the hotel you are deleting (Hotel ID): ");
            String hotelId = scanner.nextLine();

            sqlCmd.append("hotelId = '" + hotelId + "'");
        }
        else if (input.toLowerCase().equals("room")) {
            sqlCmd.append("Room WHERE ");

            System.out.println("Specify the room you are deleting (Room ID, Hotel ID): ");
            String roomInfo = scanner.nextLine();
            String[] roomArray = roomInfo.split(",");

            sqlCmd.append("roomId = '" + roomArray[0].strip() + "' AND hotelId = '" + roomArray[1].strip() + "'");
        }
        else if (input.toLowerCase().equals("amenity")) {
            sqlCmd.append("Amenity WHERE ");

            System.out.println("Specify the amenity you are deleting (Amenity ID, Hotel ID): ");
            String amenityInfo = scanner.nextLine();
            String[] amenityArray = amenityInfo.split(",");

            sqlCmd.append("amenityId = '" + amenityArray[0].strip() + "' AND hotelId = '" + amenityArray[1].strip() + "'");
        }
        else if (input.toLowerCase().equals("rating")) {
            sqlCmd.append("Rating WHERE ");

            System.out.println("Specify the rating you are deleting (Rating ID): ");
            String ratingId = scanner.nextLine();

            sqlCmd.append("ratingId = '" + ratingId + "'");
        }
        else if (input.toLowerCase().equals("employee")) {
            sqlCmd.append("Employee WHERE ");

            System.out.println("Specify the employee you are deleting (Employee ID, Hotel ID): ");
            String employeeInfo = scanner.nextLine();
            String[] employeeArray = employeeInfo.split(",");

            sqlCmd.append(
                    "employeeId = '" + employeeArray[0].strip() + "' AND hotelId = '" + employeeArray[1].strip() + "'");
        }
        else if (input.toLowerCase().equals("shift")) {
            sqlCmd.append("Shift WHERE ");

            System.out.println(
                    "Specify the shift you are deleting (Employee ID, Hotel ID, Start Date (yyyy-mm-dd hh:mm:ss)): ");
            String shiftInfo = scanner.nextLine();
            String[] shiftArray = shiftInfo.split(",");

            sqlCmd.append("employeeId = '" + shiftArray[0].strip() + "' AND hotelId = '" + shiftArray[1].strip() + "'");
        }

        scanner.close();

        return sqlCmd.toString();
    }

    private boolean checkCols(String col) {
    	if (col.strip().substring(col.length()-2).equals("Id") ||
    			col.strip().substring(col.length()-4).equals("Name") ||
            	col.strip().substring(col.length()-4).equals("Type") ||
            	col.strip().substring(col.length()-8).equals("comments") ||
            	col.strip().substring(col.length()-4).equals("name") ||
            	col.strip().substring(col.length()-4).equals("duty") ) {
    		return true;
        }
    	return false;
    }
    
    // UPDATE Hotel_table_ SET _columnN_ = _valueN_, ... WHERE _primarykey(s)_ =
    // _given_
    // this command is then sent off to the execute method.
    private String RecordUpdate() {

        System.out.println("Specify the table you are updating: ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().strip().toLowerCase();

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE Hotel");

        int i = 0;
        
        
        if (input.toLowerCase().equals("client")) {
            sb.append("Client SET ");

            System.out.println("Specify the client you are updating (Client ID): ");
            String clientId = scanner.nextLine();

            System.out.println("Specify the columns you are updating in a comma seperated list as such: \n"
                    + Client.GetFields());
            String clientCols = scanner.nextLine();
            String[] clientColsArray = clientCols.split(",");

            System.out.println("Give the data for each column in a comma seperated list:");
            String clientVals = scanner.nextLine();
            String[] clientValsArray = clientVals.split(",");

            // loop of columnN = valueN, ...
            for (String col : clientColsArray) {

            	if (checkCols(col.strip())) {
            		sb.append(col.strip() + " = '" + clientValsArray[i].strip() + "', ");
            	}
            	else {
            		sb.append(col.strip() + " = " + clientValsArray[i].strip() + ", ");
            	}

                i++;
            }

            sb.deleteCharAt(sb.length() - 2); // remove comma from last item
            sb.append("WHERE " + "clientId = '" + clientId + "'");
        }
        else if (input.toLowerCase().equals("booking")) {
            sb.append("Booking SET ");

            System.out.println(
                    "Specify the booking you are updating (Client ID, Hotel ID, Room ID, Start Date (yyyy-mm-dd)): ");
            String bookingInfo = scanner.nextLine();
            String[] bookingArray = bookingInfo.split(",");

            System.out.println("Specify the columns you are updating in a comma seperated list as such: \n"
                    + Booking.GetFields());
            String bookingCols = scanner.nextLine();
            String[] bookingColsArray = bookingCols.split(",");

            System.out.println("Give the data for each column in a comma seperated list:");
            String bookingVals = scanner.nextLine();
            String[] bookingValsArray = bookingVals.split(",");

            // loop of columnN = valueN, ...
            for (String col : bookingColsArray) {
            	
            	if (checkCols(col.strip())) {
            		sb.append(col.strip() + " = '" + bookingValsArray[i].strip() + "', ");
            	}
            	else {
                    sb.append(col.strip() + " = " + bookingValsArray[i].strip() + ", ");
            	}

                i++;
            }

            sb.deleteCharAt(sb.length() - 2); // remove comma from last item
            sb.append("WHERE " + "clientId = " + bookingArray[0].strip() + " AND hotelId = "
                    + bookingArray[1].strip()
                    + " AND roomId = '" + bookingArray[2].strip() + "' AND startDate = " + bookingArray[0].strip());
        }
        else if (input.toLowerCase().equals("hotel")) {
            sb.append("Hotel SET ");

            System.out.println("Specify the hotel you are updating (Hotel ID): ");
            String hotelId = scanner.nextLine();

            System.out.println("Specify the columns you are updating in a comma seperated list as such: \n"
                    + Hotel.GetFields());
            String hotelCols = scanner.nextLine();
            String[] hotelColsArray = hotelCols.split(",");

            System.out.println("Give the data for each column in a comma seperated list:");
            String hotelVals = scanner.nextLine();
            String[] hotelValsArray = hotelVals.split(",");

            // loop of columnN = valueN, ...
            for (String col : hotelColsArray) {

            	if (checkCols(col.strip())) {
            		sb.append(col.strip() + " = '" + hotelValsArray[i].strip() + "', ");
            	}
            	
            	else {
            		sb.append(col.strip() + " = " + hotelValsArray[i].strip() + ", ");
            	}
            	
                i++;
            }

            sb.deleteCharAt(sb.length() - 2); // remove comma from last item
            sb.append("WHERE " + "hotelId = '" + hotelId + "'");
        }
        else if (input.toLowerCase().equals("room")) {
            sb.append("Room SET ");

            System.out.println("Specify the room you are updaing (Room ID, Hotel ID): ");
            String roomInfo = scanner.nextLine();
            String[] roomArray = roomInfo.split(",");

            System.out.println("Specify the columns you are updating in a comma seperated list as such: \n"
                    + Booking.GetFields());
            String roomCols = scanner.nextLine();
            String[] roomColsArray = roomCols.split(",");

            System.out.println("Give the data for each column in a comma seperated list:");
            String roomVals = scanner.nextLine();
            String[] roomValsArray = roomVals.split(",");

            // loop of columnN = valueN, ...
            for (String col : roomColsArray) {

            	if (checkCols(col.strip())) {
            		sb.append(col.strip() + " = '" + roomValsArray[i].strip() + "', ");
            	}
            	
            	else {
            		sb.append(col.strip() + " = " + roomValsArray[i].strip() + ", ");
            	}

                i++;
            }

            sb.deleteCharAt(sb.length() - 2); // remove comma from last item
            sb.append("WHERE " + "roomId = '" + roomArray[0].strip() + "' AND hotelId = '" + roomArray[1].strip() + "'");
        }
        else if (input.toLowerCase().equals("amenity")) {
            sb.append("Amenity SET ");

            System.out.println("Specify the amenity you are updating (Amenity ID, Hotel ID): ");
            String amenityInfo = scanner.nextLine();
            String[] amenityArray = amenityInfo.split(",");

            System.out.println("Specify the columns you are updating in a comma seperated list as such: \n"
                    + Booking.GetFields());
            String amenityCols = scanner.nextLine();
            String[] amenityColsArray = amenityCols.split(",");

            System.out.println("Give the data for each column in a comma seperated list:");
            String amenityVals = scanner.nextLine();
            String[] amenityValsArray = amenityVals.split(",");

            // loop of columnN = valueN, ...
            for (String col : amenityColsArray) {

            	if (checkCols(col.strip())) {
            		sb.append(col.strip() + " = '" + amenityValsArray[i].strip() + "', ");
            	}
            	
            	else {
            		sb.append(col.strip() + " = " + amenityValsArray[i].strip() + ", ");
            	}

                i++;
            }

            sb.deleteCharAt(sb.length() - 2); // remove comma from last item
            sb.append("WHERE " + "amenityId = '" + amenityArray[0].strip() + "' AND hotelId = '"
                    + amenityArray[1].strip() + "'");
        }
        else if (input.toLowerCase().equals("rating")) {
            sb.append("Rating SET ");

            System.out.println("Specify the rating you are updating (Rating ID): ");
            String ratingId = scanner.nextLine();

            System.out.println("Specify the columns you are updating in a comma seperated list as such: \n"
                    + Client.GetFields());
            String ratingCols = scanner.nextLine();
            String[] ratingColsArray = ratingCols.split(",");

            System.out.println("Give the data for each column in a comma seperated list:");
            String ratingVals = scanner.nextLine();
            String[] ratingValsArray = ratingVals.split(",");

            // loop of columnN = valueN, ...
            for (String col : ratingColsArray) {
            	
            	if (checkCols(col.strip())) {
            		sb.append(col.strip() + " = '" + ratingValsArray[i].strip() + "', ");
            	}

            	else {
            		sb.append(col.strip() + " = " + ratingValsArray[i].strip() + ", ");
            	}

                i++;
            }

            sb.deleteCharAt(sb.length() - 2); // remove comma from last item
            sb.append("WHERE " + "ratingId = '" + ratingId + "'");
        }
        else if (input.toLowerCase().equals("employee")) {
            sb.append("Employee SET ");

            System.out.println("Specify the employee you are updating (Employee ID, Hotel ID): ");
            String employeeInfo = scanner.nextLine();
            String[] employeeArray = employeeInfo.split(",");

            System.out.println("Specify the columns you are updating in a comma seperated list as such: \n"
                    + Booking.GetFields());
            String employeeCols = scanner.nextLine();
            String[] employeeColsArray = employeeCols.split(",");

            System.out.println("Give the data for each column in a comma seperated list:");
            String employeeVals = scanner.nextLine();
            String[] employeeValsArray = employeeVals.split(",");

            // loop of columnN = valueN, ...
            for (String col : employeeColsArray) {

            	if (checkCols(col.strip())) {
            		sb.append(col.strip() + " = '" + employeeValsArray[i].strip() + "', ");
            	}
            	
            	sb.append(col.strip() + " = " + employeeValsArray[i].strip() + ", ");

                i++;
            }

            sb.deleteCharAt(sb.length() - 2); // remove comma from last item
            sb.append("WHERE " + "employeeId = '" + employeeArray[0].strip() + "' AND hotelId = '"
                    + employeeArray[1].strip() + "'");
        }
        else if (input.toLowerCase().equals("shift")) {
            sb.append("Shift SET ");

            System.out.println(
                    "Specify the shift you are updating (Employee ID, Hotel ID, Start Date (yyyy-mm-dd hh:mm:ss)): ");
            String shiftInfo = scanner.nextLine();
            String[] shiftArray = shiftInfo.split(",");

            System.out.println("Specify the columns you are updating in a comma seperated list as such: \n"
                    + Booking.GetFields());
            String shiftCols = scanner.nextLine();
            String[] shiftColsArray = shiftCols.split(",");

            System.out.println("Give the data for each column in a comma seperated list:");
            String shiftVals = scanner.nextLine();
            String[] shiftValsArray = shiftVals.split(",");

            // loop of columnN = valueN, ...
            for (String col : shiftColsArray) {
            	
            	if (checkCols(col.strip())) {
            		sb.append(col.strip() + " = '" + shiftValsArray[i].strip() + "', ");
            	}

            	else {
            		sb.append(col.strip() + " = " + shiftValsArray[i].strip() + ", ");
            	}

                i++;
            }

            sb.deleteCharAt(sb.length() - 2); // remove comma from last item
            sb.append("WHERE " + "employeeId = '" + shiftArray[0].strip() + "' AND hotelId = '" + shiftArray[1].strip()
                    + "' AND dateStart = " + shiftArray[2].strip());
        }

        scanner.close();
        
        System.out.println("printing query: " + sb.toString());
        
        return sb.toString();
    }
    
    
    
    
    
    
    
    
    

    // ----------------------------------- EVERYTHING BELOW IS FOR THE QUERIES
    // ----------------------------------- //

    // TODO: Query parameters need sanitization?
    public void runQuery(int queryNum, String testFile) {

        final String oracleURL = // Magic lectura -> aloe access spell
                "jdbc:oracle:thin:@aloe.cs.arizona.edu:1521:oracle";

        // load the (Oracle) JDBC driver by initializing its base
        // class, 'oracle.jdbc.OracleDriver'.
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("*** ClassNotFoundException:  "
                    + "Error loading Oracle JDBC driver.  \n"
                    + "\tPerhaps the driver is not on the Classpath?");
            System.exit(-1);
        }

        // make and return a database connection to the user's
        // Oracle database
        Connection dbconn = null;
        try {
            dbconn = DriverManager.getConnection(oracleURL, username, password);
        } catch (SQLException e) {
            System.err.println("*** SQLException:  "
                    + "Could not open JDBC connection.");
            System.err.println("\tMessage:   " + e.getMessage());
            System.err.println("\tSQLState:  " + e.getSQLState());
            System.err.println("\tErrorCode: " + e.getErrorCode());
            System.exit(-1);
        }

        String query = "";
        String input = "";
        String date = "";
        String date1 = "";
        String date2 = "";
        BufferedReader r = null;
        if (testFile == null) {
            r = new BufferedReader(new InputStreamReader(System.in));
        } else {
            try {
                r = new BufferedReader(new FileReader(testFile));
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + testFile);
                e.printStackTrace();
            }
        }
        try {
            switch (queryNum) {
                case 1:
                    System.out.println("Enter clientId: ");
                    input = r.readLine();
                    String clientId = input;
                    query = String.format(Queries.query1, clientId, clientId);
                    break;
                case 2:
                    System.out.println("Enter date: ");
                    date = r.readLine();
                    query = String.format(Queries.query2, date, date);
                    break;
                case 3:
                    System.out.println("Enter start date: ");
                    date = r.readLine();
                    query = String.format(Queries.query3, date, date);
                    break;
                case 4:
                    System.out.println("Enter start date: ");
                    date1 = r.readLine();
                    System.out.println("Enter end date: ");
                    date2 = r.readLine();
                    query = String.format(Queries.query4, date1, date2);
                    break;
                case 5:
                    query = Queries.query5;
                    System.out.println("Enter hotel id: ");
                    String hotel_id = r.readLine();
                    System.out.println("Enter start date: ");
                    date1 = r.readLine();
                    System.out.println("Enter end date: ");
                    date2 = r.readLine();
                    query = String.format(Queries.query5, hotel_id, date1, date2);
                    break;
                case 6:
                    query = RecordInsertion();
                    break;
                case 7:
                    query = RecordDeletion();
                    break;
                case 8:
                    query = RecordUpdate();
                    break;
                default:
                    System.err.println("Invalid query number");
                    break;
            }
        } catch (IOException e) {
            System.err.println("Error reading input");

        }
        
        // print current query
        System.out.println("Executing SQL Statement: " + query);
        
        // Sending the query to the DBMS, and displaying results
        Statement stmt = null;
        ResultSet answer = null;
        int rowsChanged = 0;
        try {
            stmt = dbconn.createStatement();
            if (queryNum < 6) {
                answer = stmt.executeQuery(query);
            } else {
                rowsChanged = stmt.executeUpdate(query);
            }

            switch (queryNum) {
                case 1:
                    parseQuery1(answer, query);
                    break;
                case 2:
                    parseQuery2(answer, query);
                    break;
                case 3:
                    parseQuery3(answer, query);
                    break;
                case 4:
                    parseQuery4(answer, query);
                    break;
                case 5:
                    parseQuery5(answer, query);
                    break;
                case 6:
                    parseQuery6(rowsChanged, query);
                    break;
                case 7:
                    parseQuery7(rowsChanged, query);
                    break;
                case 8:
                    parseQuery8(rowsChanged, query);
                    break;
                default:
                    System.err.println("Invalid query number");
                    break;
            }

            // Shutting down DBMS.
            stmt.close();
            dbconn.close();

        } catch (SQLException e) {

            System.err.println("*** SQLException:  "
                    + "Could not fetch query results.");
            System.err.println("\tMessage:   " + e.getMessage());
            System.err.println("\tSQLState:  " + e.getSQLState());
            System.err.println("\tErrorCode: " + e.getErrorCode());
            System.exit(-1);

        }

    }

    public void parseQuery1(ResultSet answer, String query) {
        try {
            if (answer != null) {

                System.out.println("\nThe results of the query [" + query + "] are:\n");

                // Getting and printing column names
                ResultSetMetaData answermetadata = answer.getMetaData();
                for (int i = 1; i <= answermetadata.getColumnCount(); i++) {
                    System.out.print(answermetadata.getColumnName(i) + "\t");
                }
                System.out.println();

                // iterating through rows in answer
                while (answer.next()) {
                    System.out.println(answer.getString("cost"));
                }
            }
            System.out.println();
        } catch (SQLException e) {

            System.err.println("*** SQLException:  "
                    + "Could not fetch query results.");
            System.err.println("\tMessage:   " + e.getMessage());
            System.err.println("\tSQLState:  " + e.getSQLState());
            System.err.println("\tErrorCode: " + e.getErrorCode());
            System.exit(-1);

        }
    }

    public void parseQuery2(ResultSet answer, String query) {
        try {
            if (answer != null) {

                System.out.println("\nThe results of the query [" + query + "] are:\n");

                // Getting and printing column names
                ResultSetMetaData answermetadata = answer.getMetaData();
                for (int i = 1; i <= answermetadata.getColumnCount(); i++) {
                    System.out.print(answermetadata.getColumnName(i) + "\t");
                }
                System.out.println();

                // iterating through rows in answer
                while (answer.next()) {
                    System.out.println(answer.getString("firstName") + "\t" + answer.getString("lastName") + "\t"
                            + answer.getString("roomId"));
                }
            }
            System.out.println();
        } catch (SQLException e) {

            System.err.println("*** SQLException:  "
                    + "Could not fetch query results.");
            System.err.println("\tMessage:   " + e.getMessage());
            System.err.println("\tSQLState:  " + e.getSQLState());
            System.err.println("\tErrorCode: " + e.getErrorCode());
            System.exit(-1);

        }
    }

    public void parseQuery3(ResultSet answer, String query) {
        try {
            if (answer != null) {

                System.out.println("\nThe results of the query [" + query + "] are:\n");

                // Getting and printing column names
                ResultSetMetaData answermetadata = answer.getMetaData();
                for (int i = 1; i <= answermetadata.getColumnCount(); i++) {
                    System.out.print(answermetadata.getColumnName(i) + "\t");
                }
                System.out.println();

                // iterating through rows in answer
                while (answer.next()) {
                    System.out.println(answer.getString("he.firstName") + "\t" + answer.getString("he.lastName")
                            + "\t" + answer.getString("hs.dateStart") + "\t" + answer.getString("hs.dateEnd"));
                }
            }
            System.out.println();
        } catch (SQLException e) {

            System.err.println("*** SQLException:  "
                    + "Could not fetch query results.");
            System.err.println("\tMessage:   " + e.getMessage());
            System.err.println("\tSQLState:  " + e.getSQLState());
            System.err.println("\tErrorCode: " + e.getErrorCode());
            System.exit(-1);

        }
    }

    public void parseQuery4(ResultSet answer, String query) {
        try {
            if (answer != null) {

                System.out.println("\nThe results of the query [" + query + "] are:\n");

                // Getting and printing column names
                ResultSetMetaData answermetadata = answer.getMetaData();
                for (int i = 1; i <= answermetadata.getColumnCount(); i++) {
                    System.out.print(answermetadata.getColumnName(i) + "\t");
                }
                System.out.println();

                // iterating through rows in answer
                while (answer.next()) {
                    System.out.println(answer.getString("average_rating"));
                    System.out.println(answer.getString("amenityName") + "\t" + answer.getString("avg_rating"));
                }
            }
            System.out.println();
        } catch (SQLException e) {

            System.err.println("*** SQLException:  "
                    + "Could not fetch query results.");
            System.err.println("\tMessage:   " + e.getMessage());
            System.err.println("\tSQLState:  " + e.getSQLState());
            System.err.println("\tErrorCode: " + e.getErrorCode());
            System.exit(-1);

        }
    }

    public void parseQuery5(ResultSet answer, String query) {
        try {
            if (answer != null) {

                System.out.println("\nThe results of the query [" + query + "] are:\n");

                // Getting and printing column names
                ResultSetMetaData answermetadata = answer.getMetaData();
                for (int i = 1; i <= answermetadata.getColumnCount(); i++) {
                    System.out.print(answermetadata.getColumnName(i) + "\t");
                }
                System.out.println();

                // iterating through rows in answer
                while (answer.next()) {
                    System.out.println(answer.getString("roomRevenue") + "\t" + answer.getString("hotelId")
                            + "\t" + answer.getString("name") + "\t" + answer.getString("roomRevenue") +
                            "\t" + answer.getString("amenityRevenue"));
                }
            }
            System.out.println();
        } catch (SQLException e) {

            System.err.println("*** SQLException:  "
                    + "Could not fetch query results.");
            System.err.println("\tMessage:   " + e.getMessage());
            System.err.println("\tSQLState:  " + e.getSQLState());
            System.err.println("\tErrorCode: " + e.getErrorCode());
            System.exit(-1);

        }
    }

    public void parseQuery6(int rowsChanged, String query) {
        System.out.println("\nThe query [" + query + "] inserted " + rowsChanged + ": rows\n");
        // TODO: More detail about which table it was added to???
    }

    public void parseQuery7(int rowsChanged, String query) {
        System.out.println("\nThe query [" + query + "] deleted " + rowsChanged + ": rows\n");
        // TODO: More detail about which table it was added to???
    }

    public void parseQuery8(int rowsChanged, String query) {
        System.out.println("\nThe query [" + query + "] updated " + rowsChanged + ": rows\n");
        // TODO: More detail about which table it was added to???
    }

}
