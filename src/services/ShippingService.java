package services;

import java.util.ArrayList;
import java.util.List;
import model.Book;

public class ShippingService {
    private List<Book> shippedBooks = new ArrayList<>();

    public void add(Book book) {
        shippedBooks.add(book);
        System.out.println("PaperBook added to ShippingService: " + book.getTitle());
    }
}
