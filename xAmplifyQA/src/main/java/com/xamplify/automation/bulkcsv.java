package com.xamplify.automation;



import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class bulkcsv {

    public static void main(String[] args) {
        String csvFile = "bulkfile.csv"; // This will be created in the project root

        // CSV Header
        String[] headers = { "FirstName", "LastName", "Company", "JobTitle", "Email",
                             "Address", "City", "State", "Zip", "Country", "Phone" };

        try (FileWriter writer = new FileWriter(csvFile)) {
            // Write headers
            writer.append(String.join(",", headers)).append("\n");

            // Generate 10,000 contacts
            for (int i = 1; i <= 10000; i++) {
                String[] contact = generateContact(i);
                writer.append(String.join(",", contact)).append("\n");
            }

            System.out.println("✅ CSV file created successfully: " + csvFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to create dummy contact data
    private static String[] generateContact(int index) {
        Random rand = new Random();

        String firstName = "FirstName" + index;
        String lastName = "LastName" + index;
        String company = "Company" + index;
        String jobTitle = "QA Engineer";
        String email = "Guser" + index + "@gmail.com";
        String address = (100 + rand.nextInt(900)) + " Elm Street";
        String city = "City" + (index % 50);
        String state = "ST";
        String zip = String.format("%05d", 10000 + rand.nextInt(89999));
        String country = "USA";
        String phone = "9" + String.format("%09d", rand.nextInt(1000000000));

        return new String[] { firstName, lastName, company, jobTitle, email, address, city, state, zip, country, phone };
    }
}
