package testing;

import java.io.File;
import java.sql.*;

public class RunTests {
    public static void main(String[] args) {
        String username = args[0];
        String password = args[1];

        boolean allFlag = false;
        boolean queryFlag = false;
        boolean fileFlag = false;
        String testStr = "";

        for (int i = 0; i < args.length; i++) {
            String arg = args[i].toLowerCase();
            if (arg.equals("--all")) {
                allFlag = true;
            } else if (arg.equals("--query")) {
                queryFlag = true;
                testStr = args[++i].toLowerCase();
                continue;

            } else if (arg.equals("--file")) {
                fileFlag = true;
                testStr = args[++i].toLowerCase();
                continue;
            } else {
                System.out.println("Unknown argument: " + arg);
            }
        }

        if (allFlag) {
            runAllTests();
        } else if (queryFlag) {
            runQuery(testStr);
        } else if (fileFlag) {
            runTest(testStr);
        }
    }

    public static void runAllTests() {
        for (int i = 0; i < 5; i++) {
            String query = "./testing/queries/query" + (i + 1);
            System.out.println("runAllTests" + query);
            runQuery(query);
        }

    }

    public static void runQuery(String queryName) {
        File curFolder = new File(queryName);
        int numQueries = curFolder.listFiles().length;
        for (int i = 0; i < numQueries; i++) {
            runTest(queryName + "/test" + (int) (i + 1) + ".sql");
        }
    }

    public static void runTest(String testName) {
        System.out.println("Running Test: " + testName);
    }

    public static void querySpecificOutputFunction(String username, String password) {

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

        final String query = // our test query
                "*** FETCH QUERY APPROPRIATELY ***"; // TODO: replace template

        // Sending the query to the DBMS, and displaying results
        Statement stmt = null;
        ResultSet answer = null;
        try {
            stmt = dbconn.createStatement();
            answer = stmt.executeQuery(query);
            if (answer != null) {

                System.out.println("\nThe results of the query [" + query
                        + "] are:\n");

                // Getting and printing column names
                ResultSetMetaData answermetadata = answer.getMetaData();
                for (int i = 1; i <= answermetadata.getColumnCount(); i++) {
                    System.out.print(answermetadata.getColumnName(i) + "\t");
                }
                System.out.println();

                // iterating through rows in answer
                while (answer.next()) {
                    System.out.println(answer.getString("sno") + "\t"
                            + answer.getInt("status")); // TODO: replace template
                }
            }
            System.out.println();

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
}