🚀 Library Tracker System (Java • DSA • MySQL • Swing GUI)






📚 A complete Library Management System demonstrating Data Structures + OOP + DBMS + GUI in a real-world scalable design.

✨ Project Highlights

🔍 Fast search using HashMap (O(1))

📦 Dynamic storage using ArrayList

💾 Persistent storage using MySQL + JDBC

🖥️ Interactive interface with Java Swing GUI

👤 Tracks which user issued which book

🔐 Secure DB credentials via environment variables

🧠 Core Concept: DSA + DBMS Integration

This project shows how Data Structures power application logic while MySQL ensures data persistence.

GUI / Console
      ↓
LibraryManager (DSA + Business Logic)
      ↓
MySQL Database (Persistent Storage)
🎯 Objectives

Apply DSA concepts in a real application

Implement efficient book search & management

Provide scalable database-backed storage

Demonstrate clean OOP-based architecture

🧱 DSA Concepts Applied
Data Structure	Usage	Complexity
📚 ArrayList	Dynamic storage of books	O(1) amortized
⚡ HashMap	Fast lookup by Book ID	O(1)
🔎 Linear Search	Search books by title	O(n)
🧠 Cache Layer	In-memory DB copy	Optimized runtime
🗄️ Database Schema
books(id, title, author, isIssued)
users(userId, name, email)
issued_books(issueId, bookId, userId, issueDate, returnDate)

✔ Normalized relational schema
✔ Tracks book issue/return history
✔ Supports multi-user management

🖥️ Features
📘 Book Management

Add new books

Search by ID & Title

Display all books

Issue / Return books

👤 User Management

Add users

Track issued books per user

Show active borrow records

🧩 Advanced Functionalities

GUI-based interaction (Swing)

Real-time DB refresh

Persistent storage using MySQL

🔄 Two Versions Implemented
Feature	Console Version	MySQL + GUI Version
Storage	In-memory (DSA)	Persistent (MySQL)
Interface	CLI	Swing GUI
Scalability	Limited	Real-world scalable
User Tracking	❌	✅
Data Persistence	❌	✅
🔐 Secure Configuration

Database credentials are not hardcoded.
They are managed using environment variables:

setx DB_USER root
setx DB_PASSWORD your_mysql_password
⚙️ Tech Stack

☕ Java (OOP + DSA)

🗄️ MySQL (Relational Database)

🔗 JDBC (Connectivity Layer)

🖥️ Swing (GUI)

🛠️ Git & GitHub (Version Control)

▶️ How to Run
1️⃣ Compile
javac -cp ".;mysql-connector-j-9.6.0.jar" src/*.java
2️⃣ Run Console Version
java -cp ".;mysql-connector-j-9.6.0.jar;src" Main
3️⃣ Run GUI Version
java -cp ".;mysql-connector-j-9.6.0.jar;src" LibraryGUI
📈 Future Enhancements

📊 JTable-based GUI tables

⏰ Overdue book tracking

📉 Borrow analytics (most issued books)

🌐 Web version using Spring Boot

🎓 Learning Outcomes

✔ Applied ArrayList & HashMap in real system
✔ Implemented Encapsulation, Abstraction, Polymorphism
✔ Designed normalized DB schema
✔ Integrated JDBC with MySQL
✔ Built layered software architecture

👨‍💻 Author

Akshit Prashar
🎓 B.Tech Computer Science Engineering (3rd Year)
📚 Summer Training Project – DSA with Java

🏁 Conclusion

This project successfully integrates Data Structures, OOP, DBMS, and GUI into a cohesive real-world application, demonstrating efficient search operations, scalable architecture, and persistent data management.