// import java.sql.Connection;
// import java.sql.DriverManager;

// public class DBConnection {

//     public static Connection getConnection() {
//         try {
//             String url = "jdbc:mysql://localhost:3306/library_db";
//             String user = "root";
//             String password = "Abhi@165"; // change if different

//             Connection con = DriverManager.getConnection(url, user, password);
//             System.out.println("Connected to MySQL successfully!");
//             return con;

//         } catch (Exception e) {
//             System.out.println("Database connection failed!");
//             e.printStackTrace();
//             return null;
//         }
//     }
// }

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/library_db";
            String user = System.getenv("DB_USER");
            String password = System.getenv("DB_PASSWORD");

            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MySQL successfully!");
            return con;

        } catch (Exception e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
            return null;
        }
    }
}