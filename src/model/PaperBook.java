package model;

import model.Book;

public class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, int yearPublished, double price, int stock) {
        super(isbn, title, yearPublished, price); // التحقق هنا
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

}
