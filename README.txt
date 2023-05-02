Compilation and Execution Instructions:
1) Navigate to the main project directory and input the following command: 
	javac -cp /usr/lib/oracle/19.8/client64/lib/ojdbc8.jar:. prog4/.java
	javac -cp /usr/lib/oracle/19.8/client64/lib/ojdbc8.jar:. queries/.java
	java -cp /usr/lib/oracle/19.8/client64/lib/ojdbc8.jar:. prog4/Prog4.java user pass
2) Enter a number between 1 and 8 that corresponds to a statement that the program will generate based on user input
3) Input all required information as instructed by the program

Workload Distribution:
Mauricio: conceptual design, normalization analysis, testing, query parsing # put more stuff here
Arnav: Query writing, query testing, normalization analysis, conceptual design, front-end user input
Mason: conceptual design, created table classes for records, handled insert/delete/update queries, debugging/testing
