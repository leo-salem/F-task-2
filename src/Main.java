import testing.BookTests;

public class Main {
    public static void main(String[] args) {
        BookTests t = new BookTests();
        t.testValidation();
        t.testDemoBookBuy();
        t.testPaperBookStock();
        t.testEBookMailing();
        t.testRemoveOldBooks();
        t.testDuplicateISBN();
        t.testEmptyEmailOrAddress();
        t.testInvalidQuantity();
        t.testRemoveFromEmptyManager();
    }
}