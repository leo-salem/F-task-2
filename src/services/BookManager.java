package services;

import model.*;
import java.time.Year;
import java.util.*;

public class BookManager {
    private Map<String, Book> books = new HashMap<>();
    private MailService mailService = new MailService();
    private ShippingService shippingService = new ShippingService();

    public void add(Book book) {
        books.put(book.getIsbn(), book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void remove(int yearsDifference) {
        int currentYear = Year.now().getValue();

        if (books.isEmpty()) {
            System.out.println("No books to remove — inventory is empty.");
            return;
        }

        Iterator<Map.Entry<String, Book>> iterator = books.entrySet().iterator();
        int removedCount = 0;

        while (iterator.hasNext()) {
            Map.Entry<String, Book> entry = iterator.next();
            Book book = entry.getValue();
            int bookYear = book.getYearPublished();

            if (currentYear - bookYear > yearsDifference) {
                System.out.println("Removing old book: " + book.getTitle() +
                        ", Published in: " + book.getYearPublished());
                iterator.remove();
                removedCount++;
            }
        }

        if (removedCount == 0) {
            System.out.println("No books found older than " + yearsDifference + " years.");
        } else {
            System.out.println("Total books removed: " + removedCount);
        }
    }


    public void buy(String isbn, int quantity, String email, String address) {
        Book book = books.get(isbn);
        if (book == null) {
            System.out.println("Book with ISBN " + isbn + " not found.");
            return;
        }

        if (book instanceof PaperBook) {
            PaperBook pb = (PaperBook) book;
            try {
                if (quantity <= pb.getStock()) {
                    shippingService.add(pb);
                    System.out.println("Paper book with ISBN " + isbn + " will be delivered to: " + address);
                } else {
                    throw new IllegalArgumentException("Not enough stock available. Only " + pb.getStock() + " left.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else if (book instanceof EBook) {
            mailService.add(book);
            System.out.println("E-book with ISBN " + isbn + " will be sent to email: " + email);
        } else if (book instanceof DemoBook) {
            try {
                throw new UnsupportedOperationException("DemoBook cannot be purchased.");
            } catch (UnsupportedOperationException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Unknown book type.");
        }
    }
}
