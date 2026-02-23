import java.awt.*;
import javax.swing.*;

public class LibraryGUI {

    LibraryManager library = new LibraryManager();

    public LibraryGUI() {
        JFrame frame = new JFrame("Library Tracker System");
        frame.setSize(400, 500);
        frame.setLayout(new GridLayout(10, 1, 5, 5));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton addBookBtn = new JButton("Add Book");
        JButton addUserBtn = new JButton("Add User");
        JButton displayBooksBtn = new JButton("Display All Books");
        JButton displayUsersBtn = new JButton("Display All Users");
        JButton issueBookBtn = new JButton("Issue Book");
        JButton returnBookBtn = new JButton("Return Book");
        JButton searchBookBtn = new JButton("Search Book by Title");
        JButton showUserBooksBtn = new JButton("Show Books Taken by User");
        JButton refreshBtn = new JButton("Refresh Data");
        JButton exitBtn = new JButton("Exit");

        frame.add(addBookBtn);
        frame.add(addUserBtn);
        frame.add(displayBooksBtn);
        frame.add(displayUsersBtn);
        frame.add(issueBookBtn);
        frame.add(returnBookBtn);
        frame.add(searchBookBtn);
        frame.add(showUserBooksBtn);
        frame.add(refreshBtn);
        frame.add(exitBtn);

        // Add Book
        addBookBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Book ID"));
                String title = JOptionPane.showInputDialog("Enter Book Title");
                String author = JOptionPane.showInputDialog("Enter Author");
                library.addBook(new Book(id, title, author, false));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid Input!");
            }
        });

        // Add User
        addUserBtn.addActionListener(e -> {
            try {
                int userId = Integer.parseInt(JOptionPane.showInputDialog("Enter User ID"));
                String name = JOptionPane.showInputDialog("Enter User Name");
                String email = JOptionPane.showInputDialog("Enter Email");
                library.addUser(new User(userId, name, email));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid Input!");
            }
        });

        // Display All Books
        displayBooksBtn.addActionListener(e -> {
            library.displayAllBooksFromDB();
            JOptionPane.showMessageDialog(frame, "Books displayed in terminal.");
        });

        // Display All Users
        displayUsersBtn.addActionListener(e -> {
            library.displayAllUsers();
            JOptionPane.showMessageDialog(frame, "Users displayed in terminal.");
        });

        // Issue Book
        issueBookBtn.addActionListener(e -> {
            try {
                int bookId = Integer.parseInt(JOptionPane.showInputDialog("Enter Book ID"));
                int userId = Integer.parseInt(JOptionPane.showInputDialog("Enter User ID"));
                library.issueBookToUser(bookId, userId);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid Input!");
            }
        });

        // Return Book
        returnBookBtn.addActionListener(e -> {
            try {
                int bookId = Integer.parseInt(JOptionPane.showInputDialog("Enter Book ID"));
                library.returnBookFromUser(bookId);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid Input!");
            }
        });

        // Search Book by Title
        searchBookBtn.addActionListener(e -> {
            String title = JOptionPane.showInputDialog("Enter Book Title");
            library.searchBookByTitle(title);
        });

        // Show Books Taken by User
        showUserBooksBtn.addActionListener(e -> {
            try {
                int userId = Integer.parseInt(JOptionPane.showInputDialog("Enter User ID"));
                library.showBooksTakenByUser(userId);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid Input!");
            }
        });

        // Refresh Data
        refreshBtn.addActionListener(e -> {
            library.refreshFromDB();
            JOptionPane.showMessageDialog(frame, "Data refreshed from database!");
        });

        // Exit
        exitBtn.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new LibraryGUI();
    }
}