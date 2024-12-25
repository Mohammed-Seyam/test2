package librarysystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class AdminDashboard{
    public static void adminDashboard (Scanner input) throws IOException{
        while(true){
            System.out.println("\n=== Admin Dashboard === \n------------------------------------");
            System.out.println("1. Create a new book");
            System.out.println("2. Register a new user ");
            System.out.println("3. Order list ");
            System.out.println("4. Show all books ");

            int choice = input.nextInt();

            switch(choice){
                case 1:
                    createBook(input);
                    break;
                case 2:
                    registerUser(input);
                    break;  
                case 3:
                    showOrders();
                    break;
                case 4:
                    showBooks();
                    break; 
                default:
                    System.out.println("Choice is not found");
            }
        }
    }

    public static void createBook(Scanner input) throws IOException {
        System.out.println("Enter book details: ");
        System.out.println("Title: ");
        String title = input.nextLine();
        input.nextLine();
        System.out.println("Author: ");
        String author = input.nextLine();  
        System.out.println("Category: ");
        String category = input.nextLine();
        System.out.println("Price: ");
        double price = input.nextDouble();
        input.nextLine();
        System.out.println("Book code: ");
        String bookCode = input.nextLine();

        ArrayList<String> books = ReadAndWriteFile.readFile(Main.bookFile);
        if(ReadAndWriteFile.isItemExists(Main.bookFile , bookCode)){
            System.out.println("Book code already exists..");
        } else {
            int id = books.size()+1;
            String bookData = String.format(id+" , "+title+" , "+author+" , "+category+" , "+price+" , "+bookCode );
            ReadAndWriteFile.writrFile(Main.bookFile, bookData , true);
            System.out.println("Book added successfully");
        }  
    }

    public static void registerUser (Scanner input) throws IOException{
        System.out.println("Enter user details: ");
        System.out.println("Username: ");
        String username = input.nextLine();
        input.nextLine();
        System.out.println("Password: ");
        String password = input.nextLine();
        System.out.println("Role(admin / user): ");
        String role = input.nextLine();

        ArrayList<String> users = ReadAndWriteFile.readFile(Main.userFile);
        for (String line : users){
            if(line.contains(username)){
                System.out.println("Username already exists..");
            } else {
                int id = users.size()+1;   
                String userData = id + " , "+password+ " , "+role;
                ReadAndWriteFile.writrFile(Main.bookFile, userData , true);
                System.out.println("User registered successfully");
            }
        }
    }

    public static void showOrders() throws IOException{
        System.out.println("\n=== Orders list === ");
        ArrayList<String> orders = ReadAndWriteFile.readFile(Main.orderFile);
        for (String order : orders){
            System.out.println(order);
        }
    }

    public static void showBooks() throws IOException{
        System.out.println("\n=== Books list === ");
        ArrayList<String> books = ReadAndWriteFile.readFile(Main.bookFile);
        for (String book : books){
            System.out.println(book);
        }
    }
}
