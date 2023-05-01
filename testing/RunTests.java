package testing;

import java.io.File;

public class RunTests {
    public static void main(String[] args) {
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
        for (int i = 0; i < 4; i++) {
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
}