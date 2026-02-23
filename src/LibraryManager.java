import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class LibraryManager {

    ArrayList<Book> books = new ArrayList<>();
    HashMap<Integer, Book> bookMap = new HashMap<>();

    public LibraryManager() {
        loadBooksFromDB();
    }

    public void loadBooksFromDB() {
        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM books";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Book b = new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getBoolean("isIssued")
                );
                books.add(b);
                bookMap.put(b.id, b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refreshFromDB() {
        books.clear();
        bookMap.clear();
        loadBooksFromDB();
        System.out.println("Data refreshed from database!");
    }

    public void addBook(Book book) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO books VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, book.id);
            ps.setString(2, book.title);
            ps.setString(3, book.author);
            ps.setBoolean(4, book.isIssued);
            ps.executeUpdate();

            books.add(book);
            bookMap.put(book.id, book);
            System.out.println("Book added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayBooks() {
        for (Book b : books) {
            b.display();
        }
    }

    public void searchBook(int id) {
        if (bookMap.containsKey(id)) {
            bookMap.get(id).display();
        } else {
            System.out.println("Book not found.");
        }
    }

    public void searchBookByTitle(String title) {
        boolean found = false;
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                b.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found with this title.");
        }
    }

    public void displayAllBooksFromDB() {
        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM books";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Title: " + rs.getString("title") +
                        ", Author: " + rs.getString("author") +
                        ", Issued: " + rs.getBoolean("isIssued"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO users VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, user.userId);
            ps.setString(2, user.name);
            ps.setString(3, user.email);
            ps.executeUpdate();

            System.out.println("User added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void issueBookToUser(int bookId, int userId) {
        try {
            Book book = bookMap.get(bookId);
            if (book == null || book.isIssued) {
                System.out.println("Book not available.");
                return;
            }

            Connection con = DBConnection.getConnection();

            String updateBook = "UPDATE books SET isIssued = true WHERE id = ?";
            PreparedStatement ps1 = con.prepareStatement(updateBook);
            ps1.setInt(1, bookId);
            ps1.executeUpdate();

            String insertIssue = "INSERT INTO issued_books (bookId, userId) VALUES (?, ?)";
            PreparedStatement ps2 = con.prepareStatement(insertIssue);
            ps2.setInt(1, bookId);
            ps2.setInt(2, userId);
            ps2.executeUpdate();

            book.isIssued = true;
            System.out.println("Book issued successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void returnBookFromUser(int bookId) {
        try {
            Connection con = DBConnection.getConnection();

            String updateBook = "UPDATE books SET isIssued = false WHERE id = ?";
            PreparedStatement ps1 = con.prepareStatement(updateBook);
            ps1.setInt(1, bookId);
            ps1.executeUpdate();

            String updateIssue = "UPDATE issued_books SET returnDate = CURRENT_TIMESTAMP WHERE bookId = ? AND returnDate IS NULL";
            PreparedStatement ps2 = con.prepareStatement(updateIssue);
            ps2.setInt(1, bookId);
            ps2.executeUpdate();

            if (bookMap.containsKey(bookId)) {
                bookMap.get(bookId).isIssued = false;
            }

            System.out.println("Book returned successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayAllUsers() {
    try {
        Connection con = DBConnection.getConnection();
        String query = "SELECT * FROM users";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        System.out.println("\n===== ALL USERS =====");
        while (rs.next()) {
            System.out.println("User ID: " + rs.getInt("userId") +
                    ", Name: " + rs.getString("name") +
                    ", Email: " + rs.getString("email"));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    public void showBooksTakenByUser(int userId) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT b.id, b.title, b.author " +
                    "FROM issued_books ib " +
                    "JOIN books b ON ib.bookId = b.id " +
                    "WHERE ib.userId = ? AND ib.returnDate IS NULL";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            int count = 0;
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Title: " + rs.getString("title") +
                        ", Author: " + rs.getString("author"));
                count++;
            }

            System.out.println("Total Books Taken: " + count);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}