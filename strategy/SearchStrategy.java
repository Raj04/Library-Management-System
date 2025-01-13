package strategy;

import model.Book;

import java.util.*;

public interface SearchStrategy {
    List<Book> search(Map<String, Book> books, String query);
}
