import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LibraryManager library = new LibraryManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== LIBRARY TRACKER (MYSQL) =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Display Books");
            System.out.println("4. Search Book by ID");
            System.out.println("5. Search Book by Title");
            System.out.println("6. Issue Book to User");
            System.out.println("7. Return Book from User");
            System.out.println("8. Show Books Taken by User");
            System.out.println("9. Refresh from Database");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(id, title, author, false));
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    library.addUser(new User(userId, name, email));
                    break;

                case 3:
                    library.displayBooks();
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    library.searchBook(sc.nextInt());
                    break;

                case 5:
                    sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    library.searchBookByTitle(sc.nextLine());
                    break;

                case 6:
                    System.out.print("Enter Book ID: ");
                    int bId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int uId = sc.nextInt();
                    library.issueBookToUser(bId, uId);
                    break;

                case 7:
                    System.out.print("Enter Book ID: ");
                    library.returnBookFromUser(sc.nextInt());
                    break;

                case 8:
                    System.out.print("Enter User ID: ");
                    library.showBooksTakenByUser(sc.nextInt());
                    break;

                case 9:
                    library.refreshFromDB();
                    break;

                case 10:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
            }
        }
    }
}