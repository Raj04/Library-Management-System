import model.Book;
import model.Patron;
import strategy.SearchStrategy;

import java.util.*;
import java.util.logging.Logger;

public class LibraryManager {
    private final Map<String, Book> books = new HashMap<>();
    private final Map<String, Patron> patrons = new HashMap<>();
    private static final Logger logger = Logger.getLogger(LibraryManager.class.getName());
    private SearchStrategy searchStrategy;

    public void displayInventory() {
        books.values().forEach(book -> {
            if(book.isAvailable()){
                System.out.print(book.getTitle()+" ");
                System.out.print(book.getAuthor()+" ");
                System.out.println(book.getPublicationYear());
            }
        });
    }

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
        logger.info("Book added: " + book);
    }

    public void removeBook(String isbn) {
        Book removedBook = books.remove(isbn);
        if (removedBook != null) {
            logger.info("Book removed: " + removedBook);
        } else {
            logger.warning("Attempted to remove non-existent book with ISBN: " + isbn);
        }
    }

    public List<Book> searchBooks(String query) {
        if (searchStrategy == null) {
            throw new IllegalStateException("Search strategy not set");
        }
        return searchStrategy.search(books, query);
    }

    public void addPatron(Patron patron) {
        patrons.put(patron.getPatronId(), patron);
        logger.info("Patron added: " + patron);
    }

    public Patron getPatron(String patronId) {
        return patrons.get(patronId);
    }

    public void checkoutBook(String patronId, String isbn) {
        Patron patron = patrons.get(patronId);
        Book book = books.get(isbn);

        if (patron != null && book != null) {
            patron.borrowBook(book);
            books.remove(isbn);
            book.setAvailable(false);
            logger.info("Book checked out: " + book + " by patron: " + patron);
        } else {
            logger.warning("Checkout failed for patron: " + patronId + " and book ISBN: " + isbn);
        }
    }

    public void returnBook(String patronId, Book book) {
        Patron patron = patrons.get(patronId);
        if (patron != null && patron.getBorrowedBooks().contains(book)) {
            patron.returnBook(book);
            books.put(book.getIsbn(), book);
            book.setAvailable(true);
            logger.info("Book returned: " + book + " by patron: " + patron);
        } else {
            logger.warning("Return failed for patron: " + patronId + " and book: " + book);
        }
    }

}
