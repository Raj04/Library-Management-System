import factory.LibraryFactory;
import model.Book;
import model.Patron;

import java.util.logging.Logger;

public class LibrarySystem {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(LibrarySystem.class.getName());

        LibraryManager libraryManager = new LibraryManager();

        // Add books to library using factory
        Book book1 = LibraryFactory.createBook("1984", "George Orwell", "1234567890", 1949);
        Book book2 = LibraryFactory.createBook("To Kill a Mockingbird", "Harper Lee", "0987654321", 1960);
        libraryManager.addBook(book1);
        libraryManager.addBook(book2);

        // Add patrons to library using factory
        Patron patron1 = LibraryFactory.createPatron("Alice", "P001");
        Patron patron2 = LibraryFactory.createPatron("Bob", "P002");
        libraryManager.addPatron(patron1);
        libraryManager.addPatron(patron2);

        libraryManager.displayInventory();

        // Checkout and return
        libraryManager.checkoutBook("P001", "1234567890");
        libraryManager.displayInventory();
        libraryManager.returnBook("P001", book1);

    }

}
