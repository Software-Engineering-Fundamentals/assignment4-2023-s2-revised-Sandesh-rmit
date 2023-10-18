
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    private Student student;
    private LibraryCard libraryCard;
    private Book book;

    @BeforeEach
    void initial(){
    this.student = new Student("Frederico", 3945006);
    Date issued = new Date();// get date of current time
    Date expiry = new Date();//get date after Date issued

    this.libraryCard = new LibraryCard(student, issued, expiry, 1011);
    this.book = new Book(125, "Harry Potter and the Chamber of Secrets", 1);
    
    }// initialising student info, issued/expiry dates of library card, libraryCard info, book info

    @Test
    void check_numBooks(){
        libraryCard.getBooks().add(new Book(1, "Book 1", 1));
        libraryCard.getBooks().add(new Book(2, "Book 2", 1));
        libraryCard.getBooks().add(new Book(3, "Book 3", 1));
        libraryCard.getBooks().add(new Book(4, "Book 4", 1));

        assertEquals(4, libraryCard.getBooks().size(), "Exceeded amount");

    }//test the number of books borrowed from a single libray card

    @Test
    void check_isBookBorrowed() throws IllegalBookIssueException{
        assertFalse(libraryCard.getBooks().contains(book),"This book is not issued on the library card");

        libraryCard.issueBook(book);

        assertTrue(libraryCard.getBooks().contains(book),"The same book is already issued on the library card");

    }//check if student is borrowing the same book

    @Test
    void check_cardValid(){
        assertTrue(libraryCard.getIssueDate().compareTo(libraryCard.getExpiryDate()) <= 0, 
        "Library card is valid" );

    }// checking if card is valid by comparing issue date and expiry date

    @Test
    void check_bookAvailable() throws IllegalBookIssueException{
        assertTrue(book.getStatus(), "Book is available");

        libraryCard.issueBook(book);

        assertFalse(book.getStatus(), "Book is not available");

    }// checking if getStatus() is storing and outputting the right information

    @Test
    void check_fineOnLibraryCard(){
        assertFalse(libraryCard.getFine() < 0, "No pending fines on this library card"); 

        libraryCard.setFine(5.5);

        assertTrue(libraryCard.getFine() > 0, "Pending fines are associated with this library card");

    }// checking if getfine() are storing and read properly
	
    @Test
    void check_demandLevel(){
        assertEquals(1, book.getDemand(), "Book is in high demand");

    }// checking for correct demand level

    @Test
    void getStudentId(){
        assertEquals(3945006, student.getId(), "Student ID is linked");

    }// checking if student number is read corrrectly

    @Test
    void getBookName(){
        assertEquals("Harry Potter and the Chamber of Secrets", book.getTitle(), "Correct book name");

    }// checking if the book name is read correctly

    @Test   
    void getBookId(){
        assertEquals(125, book.getID(), "Correct book ID");

    }//checking if Book ID is read correctly



}
