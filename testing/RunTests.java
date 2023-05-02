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
        Prog4 prog4 = new Prog4(this.username, this.password);
        switch (queryFolder) {
            case "query1":
                Prog4.testEntry(prog4, 1, testName);
                break;
            case "query2":
                Prog4.testEntry(prog4, 2, testName);
                break;
            case "query3":
                Prog4.testEntry(prog4, 3, testName);
                break;
            case "query4":
                Prog4.testEntry(prog4, 4, testName);
                break;
            case "query5":
                Prog4.testEntry(prog4, 5, testName);
                break;
            default:
                System.out.println("Invalid query number");
                break;
        }
    }
}