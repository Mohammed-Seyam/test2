package librarysystem;

/**
 *
 * @author User
 */
public class Book {
    private int id ;
    private String title ;
    private String author ;
    private String category ;
    private double  price ;
    private int bookCode ;
    
    public Book (int id ,String title ,String author ,String category ,double  price ,int bookCode){
        this.id = id ;
        this.title = title ;
        this.author = author ;
        this.category = category ;
        this.price = price ;
        this.bookCode = bookCode;
    }
}