package factory;

import model.Book;
import model.Patron;

public class LibraryFactory {
    public static Book createBook(String title, String author, String isbn, int publicationYear) {
        return new Book(title, author, isbn, publicationYear);
    }

    public static Patron createPatron(String name, String patronId) {
        return new Patron(name, patronId);
    }

}
