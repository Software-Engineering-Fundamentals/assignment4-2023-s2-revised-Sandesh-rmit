
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Library Card associated with the Student 
 */
public class LibraryCard {
    //Card id 
    private int ID;

    //Issue Date of the Card
    private Date IssueDate;

    // Expiry Date of the Card
   private Date ExpiryDate;

    //Number of books borrowed

    List<Book> borrowed = new ArrayList<Book>();

    // Fine asscoaited with the card
    private double fine;

    //Details about the cardholder
    private Student student;




    public LibraryCard(Student student, Date IssueDate, Date ExpiryDate, int ID) {
        this.student = student;
        this.IssueDate = IssueDate;
	    this.ExpiryDate = ExpiryDate;
	    this.ID = ID;
    }


    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }


    public Date getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(Date IssueDate) {
        this.IssueDate = IssueDate;
    }

    public Date getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(Date ExpiryDate) {
        this.ExpiryDate = ExpiryDate;
    }

    
    public List<Book> getBooks() {
        return borrowed;
    }

    /**
     * Issue a new book
     * @param Book: book to borrow 
     * @return true if the book is successfully borrowed, false otherwise
     * @throws IllegalBookIssueException
     */

    public boolean issueBook(Book book) throws IllegalBookIssueException{
        if(borrowed.size() > 4){
            return false;
        }//number of books

        if(borrowed.contains(book)){
            throw new IllegalBookIssueException("Book is already issued out");
        }//if books is issued

        if(this.ExpiryDate.compareTo(this.IssueDate) < 0){
            return false;
        }//library card expiry

        if(book.getStatus() == false){
            return false;
        }//book availability

        if(fine > 0){
            return false;
        }//fine on book?
        
        // if constrains is met 
        int demand = book.getDemand(); // get demand of book to get return date (3 or 15 days)

        if(demand == 1){
            book.setDays(3);
        }else{
            book.setDays(15);
        }
        
        book.setStatus(true); // initially book is available
        borrowed.add(book);// add book to list to ensure this library card cant borrow the same book until returned
        book.setStatus(false); // not available after borrowing the book


    	return true;
    }


}
