package librarysystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import librarysystem.ReadAndWriteFile;

/**
 *
 * @author User
 */
public class UserHome {
    public static void userHome (String username ,Scanner input) throws IOException{
        while(true){
            System.out.println("\n=== User Home ===\n------------------------------------");
            System.out.println("1. Buy a book");
            System.out.println("2. my cart");
            System.out.println("3. Show all books");
            System.out.println("4. Search for a book ");
            
            int choice = input.nextInt();
            
            switch(choice){
                case 1:
                    buyBook( username , input  );
                        break;
                        
                 case 2:
                    showCart( username);   
                         break;
                         
                 case 3:
                    showBooks( );   
                         break;
                 case 4:
                    searchBook(username);   
                         break;
                                    
                 default :
                     System.out.println("Invalid choice");
            }
        }
    }
    
    public static void buyBook(String username ,Scanner input) throws IOException{
        System.out.println("Enter book code: ");
        String bookCode = input.nextLine();
        input.nextLine();
        ArrayList <String> books = ReadAndWriteFile.readFile(Main.bookFile);
        for (String line : books){
            String [] signal = line.split(",");
            if(signal[4].equals(bookCode)){
                int orderId = ReadAndWriteFile.readFile(Main.orderFile).size()+1;
                String orderData = String.format(orderId + " , "+ username + " , "+signal[0]+ " , "+bookCode);
                ReadAndWriteFile.writrFile("orders.txt", orderData , true);
                System.out.println(" Book bought successfully");
                break;
            }
        } 
        System.out.println("Book not found");
    }
   
    public static void showCart(String user) throws IOException{
        System.out.println("\n=== Your Cart === ");
        ArrayList<String> orders = ReadAndWriteFile.readFile(Main.orderFile);
        for (String order : orders){
            String [] signal = order.split(",");
            Object username = null;
            if(!signal[1].equals(username)){
            } else {
                System.out.println(order);
            }
        }
    }
    
    public static void showBooks() throws IOException{
        System.out.println("\n=== Your Cart === ");
        ArrayList<String> books = ReadAndWriteFile.readFile(Main.bookFile);
        for (String book : books){
            System.out.println(book);
        }
    }
            
    public static ArrayList < String > searchBook(String fileName){
        Scanner input = new Scanner(System.in);
        System.out.println("\n=== search by === ");
        System.out.println("- title"); 
        System.out.println("- author ");
        System.out.println("- category ");
        System.out.println("- book code ");
        
        System.out.println("Enter your choice");
        String choice = input.nextLine().toLowerCase();
        input.nextLine();
        
        System.out.println("Enter search term: ");
        String searchTerm = input.nextLine();
        ArrayList < String > matchingBook = new ArrayList <>();
            
        try{
            ArrayList < String > books = ReadAndWriteFile.readFile(fileName);
            for(String book : books){
                String [] bookDetails = book.split(",");
                switch (choice){
                    case "title":
                        if(bookDetails[1].equalsIgnoreCase(searchTerm)){
                            matchingBook.add(book);
                            break;
                        }
                    case "author":
                        if(bookDetails[2].equalsIgnoreCase(searchTerm)){
                            matchingBook.add(book);
                            break;
                        }
                    case "category":
                        if(bookDetails[3].equalsIgnoreCase(searchTerm)){
                            matchingBook.add(book);
                            break;
                        }
                    case "bookcode":
                        if(bookDetails[5].equalsIgnoreCase(searchTerm)){
                            matchingBook.add(book);
                            break;
                        }
                    default :
                        System.out.println("Invalid choice");
                }    
            }
            if(matchingBook.isEmpty()){
                System.out.println("No books found matching the search term..");
            } else {
                System.out.println("Matching books: ");
                for(String book : matchingBook){
                    System.out.println(book);
                }
            }
        } catch(Exception error){
            System.out.println("Error reading books file.."+error.getMessage());
        }
        return null;
    }  
}
