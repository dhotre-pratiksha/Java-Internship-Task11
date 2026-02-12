import java.io.*;
import java.util.Scanner;

public class UserDataStorage {

    private static final String FILE_NAME = "users.txt";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Email : ");
        String email = sc.nextLine();

        System.out.print("Enter Phone Number : ");
        String phone = sc.nextLine();

        File file = new File(FILE_NAME);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {

            if (!file.exists()) {
                file.createNewFile();
            }

            writer.write("Name : " + name);
            writer.newLine();
            writer.write("Email : " + email);
            writer.newLine();
            writer.write("Phone : " + phone);
            writer.newLine();
            writer.write("----------------------");
            writer.newLine();

            System.out.println("\nUser data saved successfully.");

        }
        catch (IOException e) {
            System.out.println("Error while writing to file : " + e.getMessage());
        }

        System.out.println("\nStored User Records :\n");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        }
        catch (IOException e) {
            System.out.println("Error while reading file : " + e.getMessage());
        }

        sc.close();
    }
}
