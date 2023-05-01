import java.sql.*;

public class Prog4 {
    private String username;
    private String password;

    public static void main(String[] args) {

    }

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

        // TODO: Check with Arnav on how to grab the correct query (stored in obj)?
        final String query = // our test query
                "*** FETCH QUERY APPROPRIATELY ***";

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
