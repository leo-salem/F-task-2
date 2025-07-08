package model;

public class EBook extends Book {
    private String fileType;

    public EBook(String isbn, String title, int yearPublished, double price, String fileType) {
        super(isbn, title, yearPublished, price);
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }
}

