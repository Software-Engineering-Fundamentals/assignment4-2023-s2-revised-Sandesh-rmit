
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Date;

/**
 *  Implement and test {Programme.addStudent } that respects the considtion given the assignment specification
 * NOTE: You are expected to verify that the constraints to borrow a new book from a library
 *
 * Each test criteria must be in an independent test method .
 *
 * Initialize the test object with "setting" method.
 */
public class IssueBook {

    @BeforeEach
    void initial(){
    Student student = new Student("Smith hf", 10);
    Date issued = new Date();
    Date expiry = new Date();

    LibraryCard libraryCard = new LibraryCard(student, issued, expiry, 3945006);
    Book book = new Book(1, "Lupin", 1);
    }

    @Test
    void check_numBooks(){
        assertEquals(4, libraryCard.borrowed.size());

    }

    // @Test
    // void check_isBookBorrowed(){

    // }

    // @Test
    // void check_cardValid(){

    // }

    // @Test
    // void check_bookAvailable(){

    // }

    // @Test
    // void check_Fine(){

    // }
	
}
