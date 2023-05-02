import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;
import java.util.Random;

public class HotelDatabaseGenerator {
    public static void main(String[] args) {
        try {
            File file = new File("insert.sql");
            PrintWriter writer = new PrintWriter(file);

            int numberOfClients = 10;
            int numberOfHotels = 5;
            int numberOfRooms = 25;
            int numberOfAmenities = 15;
            int numberOfRatings = 20;
            int numberOfEmployees = 20;
            int numberOfShifts = 50;

            Random random = new Random();

            writer.println("-- HotelClient Inserts --");
            for (int i = 1; i <= numberOfClients; i++) {
                String clientId = UUID.randomUUID().toString();
                String firstName = "First" + i;
                String lastName = "Last" + i;
                int membershipDiscount = random.nextInt(2);
                int creditDiscount = random.nextInt(2);
                int points = 0;
                int isStudent = random.nextInt(2);
                String membershipType = isStudent == 1 ? "student" : "regular";
                writer.printf("INSERT INTO HotelClient (clientId, firstName, lastName, membershipDiscount, creditDiscount, points, isStudent, membershipType) VALUES ('%s', '%s', '%s', %d, %d, %d, %d, '%s');\n", clientId, firstName, lastName, membershipDiscount, creditDiscount, points, isStudent, membershipType);
            }

            
            // ... Other table inserts ...

            writer.close();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
