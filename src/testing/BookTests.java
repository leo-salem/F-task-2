package testing;

import model.*;
import services.*;
import services.BookManager;

public class BookTests {
    public void testValidation() {
        new EBook("", "", 1000, -10, "PDF");
        new PaperBook("!!", "A", 1300, 0, 5);
        System.out.println("\n------------------------------------");
        System.out.println("------------------------------------");
        System.out.println("------------------------------------\n");
    }

    public void testDemoBookBuy() {
        BookManager manager = new BookManager();
        DemoBook demo = new DemoBook("D001", "Demo Book", 2023, 100);
        manager.add(demo);
        manager.buy("D001", 1, "test@email.com", "Cairo");
        System.out.println("\n------------------------------------");
        System.out.println("------------------------------------");
        System.out.println("------------------------------------\n");
    }

    public void testPaperBookStock() {
        BookManager manager = new BookManager();
        PaperBook paper = new PaperBook("P001", "Java Book", 2019, 150, 2);
        manager.add(paper);
        manager.buy("P001", 5, "mail@email.com", "Giza");
        System.out.println("\n------------------------------------");
        System.out.println("------------------------------------");
        System.out.println("------------------------------------\n");
    }

    public void testEBookMailing() {
        BookManager manager = new BookManager();
        EBook ebook = new EBook("E001", "EBook Test", 2021, 120, "EPUB");
        manager.add(ebook);
        manager.buy("E001", 1, "me@mail.com", "");
        System.out.println("\n------------------------------------");
        System.out.println("------------------------------------");
        System.out.println("------------------------------------\n");
    }

    public void testRemoveOldBooks() {
        BookManager manager = new BookManager();
        PaperBook b1 = new PaperBook("111", "Old Book", 2010, 90, 3);
        EBook b2 = new EBook("222", "New Book", 2024, 100, "PDF");
        manager.add(b1);
        manager.add(b2);
        manager.remove(5);
        System.out.println("\n------------------------------------");
        System.out.println("------------------------------------");
        System.out.println("------------------------------------\n");
    }

    public void testDuplicateISBN() {
        BookManager manager = new BookManager();
        EBook ebook1 = new EBook("DUP001", "First Book", 2023, 100, "PDF");
        EBook ebook2 = new EBook("DUP001", "Second Book", 2024, 120, "EPUB");
        manager.add(ebook1);
        manager.add(ebook2);
        manager.buy("DUP001", 1, "test@dup.com", "");
        System.out.println("\n------------------------------------");
        System.out.println("------------------------------------");
        System.out.println("------------------------------------\n");
    }

    public void testEmptyEmailOrAddress() {
        BookManager manager = new BookManager();
        EBook ebook = new EBook("EMAIL01", "Email Book", 2023, 80, "PDF");
        PaperBook paper = new PaperBook("ADDR01", "Address Book", 2021, 90, 5);
        manager.add(ebook);
        manager.add(paper);
        manager.buy("EMAIL01", 1, "", "");
        manager.buy("ADDR01", 1, "me@x.com", "");
        System.out.println("\n------------------------------------");
        System.out.println("------------------------------------");
        System.out.println("------------------------------------\n");
    }

    public void testInvalidQuantity() {
        BookManager manager = new BookManager();
        PaperBook paper = new PaperBook("Q001", "Quantity Book", 2020, 150, 10);
        manager.add(paper);
        manager.buy("Q001", 0, "email@test.com", "Alex");
        manager.buy("Q001", -5, "email@test.com", "Alex");
        System.out.println("\n------------------------------------");
        System.out.println("------------------------------------");
        System.out.println("------------------------------------\n");
    }
    public void testRemoveFromEmptyManager() {
        BookManager manager = new BookManager();
        manager.remove(10);
        System.out.println("\n------------------------------------");
        System.out.println("------------------------------------");
        System.out.println("------------------------------------\n");
    }

}
