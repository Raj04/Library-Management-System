package model;
import java.util.*;
public class Patron {
    private final String name;
    private final String patronId;
    private final List<Book> borrowedBooks = new ArrayList<>();

    public Patron(String name, String patronId) {
        this.name = name;
        this.patronId = patronId;
    }

    public String getName() {
        return name;
    }

    public String getPatronId() {
        return patronId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

}
