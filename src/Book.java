public class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    public Book(int id, String title, String author, boolean isIssued) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = isIssued;
    }

    public void display() {
        System.out.println("ID: " + id +
                ", Title: " + title +
                ", Author: " + author +
                ", Issued: " + isIssued);
    }
}