package services;

import java.util.ArrayList;
import java.util.List;
import model.Book;

public class MailService {
    private List<Book> emailBooks = new ArrayList<>();

    public void add(Book book) {
        emailBooks.add(book);
        System.out.println("E-Book added to MailService: " + book.getTitle());
    }
}
