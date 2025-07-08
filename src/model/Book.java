package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Book {
    protected String isbn;
    protected String title;
    protected int yearPublished;
    protected double price;

    public Book(String isbn, String title, int yearPublished, double price) {
        this.isbn = isbn;
        this.title = title;
        this.yearPublished = yearPublished;
        this.price = price;
        validate();
    }


    private void validate() {
        try {
            List<String> errors = new ArrayList<>();

            if (isbn == null || isbn.trim().isEmpty()) {
                errors.add("ISBN should not be empty.");
            } else if (!isbn.matches("[a-zA-Z0-9\\-]+")) {
                errors.add("ISBN must be in specific format");
            }

            if (title == null || title.trim().isEmpty()) {
                errors.add("Title should not be empty.");
            } else if (title.trim().length() < 2) {
                errors.add("Title is too short.");
            }

            int currentYear = LocalDate.now().getYear();
            if (yearPublished < 1200 || yearPublished > currentYear) {
                errors.add("Year published must be between 1200 and " + currentYear + ".");
            }

            if (price <= 0) {
                errors.add("Price should be greater than zero.");
            }

            if (!errors.isEmpty()) {
                throw new IllegalArgumentException("Invalid book data");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Validation failed:");
            if (isbn == null || isbn.trim().isEmpty()) {
                System.out.println("- ISBN should not be empty.");
            } else if (!isbn.matches("[a-zA-Z0-9\\-]+")) {
                System.out.println("- ISBN must be in specific format");
            }

            if (title == null || title.trim().isEmpty()) {
                System.out.println("- Title should not be empty.");
            } else if (title.trim().length() < 2) {
                System.out.println("- Title is too short.");
            }

            int currentYear = LocalDate.now().getYear();
            if (yearPublished < 1200 || yearPublished > currentYear) {
                System.out.println("- Year published must be between 1200 and " + currentYear + ".");
            }

            if (price <= 0) {
                System.out.println("- Price should be greater than zero.");
            }
        }
    }
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public double getPrice() {
        return price;
    }
}
