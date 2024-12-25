package librarysystem;

/**
 *
 * @author User
 */
public class Order {
     private int order_id ;
    private String username ;
    private String bookTitle ;
    private String bookCode ;

    public Order(int order_id, String username, String bookTitle, String bookCode) {
        this.order_id = order_id;
        this.username = username;
        this.bookTitle = bookTitle;
        this.bookCode = bookCode;
    }
}