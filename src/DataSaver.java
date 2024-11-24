import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        String continueInput;

        do {
            System.out.println("Enter First Name: ");
            String firstName = scanner.nextLine();

            System.out.println("Enter Last Name: ");
            String lastName = scanner.nextLine();

            System.out.println("Enter ID Number (6 digits): ");
            String idNumber = scanner.nextLine();

            System.out.println("Enter Email: ");
            String email = scanner.nextLine();

            System.out.println("Enter Year of Birth (4 digits): ");
            String yearOfBirth = scanner.nextLine();

            String record = firstName + "," + lastName + "," + idNumber + "," + email + "," + yearOfBirth;
            records.add(record);

            System.out.println("Do you want to enter another record? (yes/no): ");
            continueInput = scanner.nextLine();

        } while (continueInput.equalsIgnoreCase("yes"));

        System.out.println("Enter the name of the CSV file to save (include .csv): ");
        String fileName = scanner.nextLine();

        try (FileWriter writer = new FileWriter("src/" + fileName)) {
            for (String record : records) {
                writer.write(record + "\n");
            }
            System.out.println("Records successfully saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}