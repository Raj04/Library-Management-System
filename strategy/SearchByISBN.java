package strategy;

import model.Book;

import java.util.*;

public class SearchByISBN implements SearchStrategy{
    @Override
    public List<Book> search(Map<String, Book> books, String query) {
        List<Book> results = new ArrayList<>();
        Book book = books.get(query);
        if (book != null) {
            results.add(book);
        }
        return results;
    }

}
