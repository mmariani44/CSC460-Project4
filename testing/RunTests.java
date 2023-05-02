import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import queries.Queries;
import prog4.Prog4;

public class RunTests {

    private String username;
    private String password;

    public RunTests(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static void main(String[] args) {
        String username = args[0];
        String password = args[1];

        RunTests runTests = new RunTests(username, password);

        boolean allFlag = false;
        boolean queryFlag = false;
        boolean fileFlag = false;
        String testStr = "";

        for (int i = 2; i < args.length; i++) {
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
            runTests.runAllTests();
        } else if (queryFlag) {
            runTests.runQuery(testStr);
        } else if (fileFlag) {
            runTests.runTest(testStr);
        }
    }

    public void runAllTests() {
        for (int i = 0; i < 5; i++) {
            String query = "./testing/queries/query" + (i + 1);
            System.out.println("runAllTests" + query);
            runQuery(query);
        }

    }

    public void runQuery(String queryName) {
        File curFolder = new File(queryName);
        int numQueries = curFolder.listFiles().length;
        for (int i = 0; i < numQueries; i++) {
            this.runTest(queryName + "/test" + (int) (i + 1) + ".sql");
        }
    }

    public void runTest(String testName) {
        System.out.println("Running Test: " + testName);
        String[] path = testName.split("/");
        String queryFolder = path[3];
        String testNum = path[4];
        Prog4 prog4 = new Prog4(this.username, this.password);
        String query = "";
        String input = "";
        String date = "";
        String date1 = "";
        String date2 = "";
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        try {
            switch (queryFolder) {
                case "query1":
                    System.out.println("Enter clientId: ");
                    input = r.readLine();
                    int clientId = Integer.parseInt(input);
                    query = String.format(Queries.query1, clientId, clientId);
                    break;
                case "query2":
                    System.out.println("Enter date: ");
                    date = r.readLine();
                    query = String.format(Queries.query2, date, date);
                    break;
                case "query3":
                    System.out.println("Enter start date: ");
                    date = r.readLine();
                    query = String.format(Queries.query3, date, date);
                    break;
                case "query4":
                    System.out.println("Enter start date: ");
                    date1 = r.readLine();
                    System.out.println("Enter end date: ");
                    date2 = r.readLine();
                    query = String.format(Queries.query4, date1, date2);
                    break;
                case "query5":
                    // TODO: Insert params into the prepped query
                    query = Queries.query5;
                    break;
                default:
                    System.out.println("Invalid query number");
                    break;
            }
        } catch (IOException e) {
            System.err.println("Error reading input");
        }
        // TODO: Load parameters (if not query1)
        // TODO: call the appropriate query{num} function based on path

    }

}