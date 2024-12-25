
package librarysystem;

/**
 *
 * @author User
 */
import java.io.IOException;
/**
 *
 * @author User
 */
import java.util.*;



public class Main {
    static final String userFile = "user.txt";
    static final String bookFile = "book.txt";
    static final String orderFile = "order.txt";
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
          System.out.println("# Welcome to library system #");
          try{
              while(true){
                    System.out.println("\n === login in ===");
                    System.out.println("Enter username: ");
                    String username = input.nextLine();
                    System.out.println("Enter password: ");
                    String password = input.nextLine();
                    System.out.println("Enter role: ");
                    String role = input.nextLine();

                  if(role != null){  
                   if(role.equals("admin")){
                       AdminDashboard.adminDashboard( input);
                   }
                   else{
                       UserHome.userHome(username, input);
                   }
                  }
              }
          }catch(Exception error){
                      System.out.println("Error..");
                      
          }
    }
    
    private static String chickUser(String username , String password)throws IOException{
      ArrayList<String> users = ReadAndWriteFile.readFile(userFile);
       for(String user : users){
           String [] signal = user.split(",");
           if(signal[1].equals(username) && signal[2].equals(password)){
        return signal[3];
       }
       }
        return null;
    }
}
