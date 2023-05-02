package prog4;

import java.io.BufferedReader;
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
            System.out.println("Enter a query number (1-5) or q to quit: ");
            try {
                input = reader.readLine();
            } catch (IOException e) {
                System.err.println("Error reading input");
                e.printStackTrace();
            }
            if (input == "q") {
                break;
            }
            int queryNum = Integer.parseInt(input);
            prog4.runQuery(queryNum);
        }
    }

    // ---------------------------------- MASON CODE -------------------------------------------- //


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
                        + "Or enter q to quit.");

        // collect user input and verify
        Scanner scanner = new Scanner(System.in);

        // check if quit command
        String input = scanner.nextLine().strip();
        scanner.close();
        if (input.equals("Q") || input.equals("q")) {
            return false;
        }

        // check if input is valid number and within bounds. if invalid, return and do
        // loop again
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

        // do command based on user input TODO this interface has been removed
        //cmdActions[cmdNumber].cmd();

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
        switch (input) {
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

                    Booking booking = new Booking(bookingArray[0].strip(), bookingArray[1].strip(),
                            bookingArray[2].strip(),
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

                    Rating rating = new Rating(Integer.parseInt(ratingArray[0].strip()), ratingArray[1].strip(),
                            ratingArray[2].strip());
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

                    Employee employee = new Employee(employeeArray[0].strip(), employeeArray[1].strip(),
                            employeeArray[2].strip(),
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

        switch (input) {
            case "client":
                sqlCmd.append("Client WHERE ");

                System.out.println("Specify the client you are deleting (Client ID): ");
                String clientId = scanner.nextLine();

                sqlCmd.append("clientId = " + clientId);

            case "booking":
                sqlCmd.append("Booking WHERE ");

                // prompt user
                System.out.println(
                        "Specify the booking you are deleting (Client ID, Hotel ID, Room ID, Start Date (yyyy-mm-dd)): ");
                String bookingInfo = scanner.nextLine();
                String[] bookingArray = bookingInfo.split(",");

                // build sql command
                sqlCmd.append("clientId = " + bookingArray[0].strip() + " AND hotelId = " + bookingArray[1].strip()
                        + " AND "
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

                sqlCmd.append(
                        "employeeId = " + employeeArray[0].strip() + " AND hotelId = " + employeeArray[1].strip());

            case "shift":
                sqlCmd.append("Shift WHERE ");

                System.out.println("Specify the shift you are deleting (Employee ID, Hotel ID, Start Date (yyyy-mm-dd hh:mm:ss)): ");
                String shiftInfo = scanner.nextLine();
                String[] shiftArray = shiftInfo.split(",");

                sqlCmd.append("employeeId = " + shiftArray[0].strip() + " AND hotelId = " + shiftArray[1].strip());

        }

        scanner.close();

        ExecuteSQLCommand(sqlCmd.toString());

    }

    
    // UPDATE Hotel._table_ SET _columnN_ = _valueN_, ... WHERE _primarykey(s)_ = _given_
    // this command is then sent off to the execute method.
    private static void RecordUpdate() {

        System.out.println("Specify the table you are updating: ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().strip().toLowerCase();
        
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE Hotel.");

        int i = 0;
        switch (input) {
            case "client":
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
                	
                	sb.append(col.strip() + " = " + clientValsArray[i].strip() + ", ");
                	
                	i++;
                }
                
                sb.deleteCharAt(sb.length()-2);		//remove comma from last item
                sb.append("WHERE " + "clientId = " + clientId);

            case "booking":
            	
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
                	
                	sb.append(col.strip() + " = " + bookingValsArray[i].strip() + ", ");
                	
                	i++;
                }
                
                sb.deleteCharAt(sb.length()-2);		//remove comma from last item
                sb.append("WHERE " + "clientId = " + bookingArray[0].strip() + " AND hotelId = " +  bookingArray[1].strip()
                		+ " AND roomId = " +  bookingArray[2].strip() + " AND startDate = " + bookingArray[0].strip());

            case "hotel":
            	
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
                	
                	sb.append(col.strip() + " = " + hotelValsArray[i].strip() + ", ");
                	
                	i++;
                }
                
                sb.deleteCharAt(sb.length()-2);		//remove comma from last item
                sb.append("WHERE " + "hotelId = " + hotelId);

            case "room":
            	
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
                	
                	sb.append(col.strip() + " = " + roomValsArray[i].strip() + ", ");
                	
                	i++;
                }
                
                sb.deleteCharAt(sb.length()-2);		//remove comma from last item
                sb.append("WHERE " + "roomId = " + roomArray[0].strip() + " AND hotelId = " +  roomArray[1].strip());             

            case "amenity":
            	
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
                	
                	sb.append(col.strip() + " = " + amenityValsArray[i].strip() + ", ");
                	
                	i++;
                }
                
                sb.deleteCharAt(sb.length()-2);		//remove comma from last item
                sb.append("WHERE " + "amenityId = " + amenityArray[0].strip() + " AND hotelId = " +  amenityArray[1].strip());   

            case "rating":
            	
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
                	
                	sb.append(col.strip() + " = " + ratingValsArray[i].strip() + ", ");
                	
                	i++;
                }
                
                sb.deleteCharAt(sb.length()-2);		//remove comma from last item
                sb.append("WHERE " + "ratingId = " + ratingId);

            case "employee":
            	
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
                	
                	sb.append(col.strip() + " = " + employeeValsArray[i].strip() + ", ");
                	
                	i++;
                }
                
                sb.deleteCharAt(sb.length()-2);		//remove comma from last item
                sb.append("WHERE " + "employeeId = " + employeeArray[0].strip() + " AND hotelId = " +  employeeArray[1].strip());

            case "shift":
            	
            	sb.append("Shift SET ");
            	
                System.out.println("Specify the shift you are updating (Employee ID, Hotel ID, Start Date (yyyy-mm-dd hh:mm:ss)): ");
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
                	
                	sb.append(col.strip() + " = " + shiftValsArray[i].strip() + ", ");
                	
                	i++;
                }
                
                sb.deleteCharAt(sb.length()-2);		//remove comma from last item
                sb.append("WHERE " + "employeeId = " + shiftArray[0].strip() + " AND hotelId = " +  shiftArray[1].strip()
                		+ " AND dateStart = " +  shiftArray[2].strip());
            	
        }

        scanner.close();

    }

   
    
    

    // TODO: Query parameters need sanitization?
    public void runQuery(int queryNum) {

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
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        try {
            switch (queryNum) {
                case 1:
                    System.out.println("Enter clientId: ");
                    input = r.readLine();
                    int clientId = Integer.parseInt(input);
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
                    // TODO: Insert params into the prepped query
                    query = Queries.query5;
                    break;
                default:
                    System.err.println("Invalid query number");
                    break;
            }
        } catch (IOException e) {
            System.err.println("Error reading input");

        }

        // Sending the query to the DBMS, and displaying results
        Statement stmt = null;
        ResultSet answer = null;
        try {
            stmt = dbconn.createStatement();
            answer = stmt.executeQuery(query);

            parseQuery1(answer);

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

    public void parseQuery1(ResultSet answer) {
        try {
            if (answer != null) {

                System.out.println("\nThe results of the query 1 are:\n");

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

    public void parseQuery2(ResultSet answer) {
        try {
            if (answer != null) {

                System.out.println("\nThe results of the query 2 are:\n");

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

    public void parseQuery3(ResultSet answer) {
        try {
            if (answer != null) {

                System.out.println("\nThe results of the query 3 are:\n");

                // Getting and printing column names
                ResultSetMetaData answermetadata = answer.getMetaData();
                for (int i = 1; i <= answermetadata.getColumnCount(); i++) {
                    System.out.print(answermetadata.getColumnName(i) + "\t");
                }
                System.out.println();

                // iterating through rows in answer
                // TODO: Output for this will be extra funky
                while (answer.next()) {
                    System.out.println(answer.getString("cost")); // TODO: replace template
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

    public void parseQuery4(ResultSet answer) {
        try {
            if (answer != null) {

                System.out.println("\nThe results of the query 4 are:\n");

                // Getting and printing column names
                ResultSetMetaData answermetadata = answer.getMetaData();
                for (int i = 1; i <= answermetadata.getColumnCount(); i++) {
                    System.out.print(answermetadata.getColumnName(i) + "\t");
                }
                System.out.println();

                // iterating through rows in answer
                while (answer.next()) {
                    System.out.println(answer.getString("average_rating"));
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

    public void parseQuery5(ResultSet answer) {
        try {
            if (answer != null) {

                System.out.println("\nThe results of the query 4 are:\n");

                // Getting and printing column names
                ResultSetMetaData answermetadata = answer.getMetaData();
                for (int i = 1; i <= answermetadata.getColumnCount(); i++) {
                    System.out.print(answermetadata.getColumnName(i) + "\t");
                }
                System.out.println();

                // iterating through rows in answer
                while (answer.next()) {
                    System.out.println(answer.getString("*** IMPLEMENENT ***")); // TODO: replace template
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

}
