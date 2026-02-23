🚀 Overview

The Library Tracker System is a Java-based application developed as part of a Data Structures and Algorithms (DSA) summer training project.
The system is implemented in two progressive versions:

Console-based version using core DSA concepts (ArrayList, HashMap)

Advanced version integrating MySQL via JDBC with a simple Swing GUI

The project demonstrates the application of DSA, Object-Oriented Programming (OOP), and Database Management concepts to simulate a real-world library management system.

🎯 Objectives

Apply core Data Structures in a practical application

Implement efficient searching and management of books

Provide persistent storage using MySQL

Design a modular and scalable system architecture

Demonstrate integration of DSA + DBMS + GUI

🧠 DSA Concepts Used
Data Structure	Usage	Complexity
ArrayList	Dynamic storage of books	O(1) amortized insert
HashMap	Fast lookup by Book ID	O(1) search
Linear Search	Search books by title	O(n)
Caching Layer	In-memory copy of DB data	Optimized runtime performance

The system loads database records into ArrayList and HashMap as an in-memory cache to reduce encouraging database queries.

🏗️ System Architecture
GUI / Console
      ↓
LibraryManager (DSA + Business Logic)
      ↓
MySQL Database (Persistent Storage)

Presentation Layer: Console & Swing GUI

Logic Layer: LibraryManager using DSA + JDBC

Database Layer: MySQL with normalized schema

💾 Database Design

The application uses a normalized relational database with three tables:

books(id, title, author, isIssued)

users(userId, name, email)

issued_books(issueId, bookId, userId, issueDate, returnDate)

This design enables tracking which user has taken which book and maintains issue-return history.

✨ Key Features

Add Books and Users

Issue & Return Books

Search Book by ID (HashMap)

Search Book by Title (Linear Search)

Display all Books and Users

Show books taken by a specific user

Refresh in-memory cache from database

GUI interface using Java Swing

Secure database credential handling via environment variables

🔐 Security Improvement

Database credentials are externalized using environment variables instead of being hardcoded, following secure coding practices.

Set environment variables (Windows):

setx DB_USER root
setx DB_PASSWORD your_mysql_password
🖥️ Technologies Used

Java (OOP + DSA)

JDBC (Database Connectivity)

MySQL (Relational Database)

Java Swing (GUI)

Git & GitHub (Version Control)

▶️ How to Run
1. Compile
javac -cp ".;mysql-connector-j-9.6.0.jar" src/*.java
2. Run Console Version
java -cp ".;mysql-connector-j-9.6.0.jar;src" Main
3. Run GUI Version
java -cp ".;mysql-connector-j-9.6.0.jar;src" LibraryGUI
🔍 Comparison: Console vs Advanced Version
Feature	Console Version	MySQL + GUI Version
Storage	In-memory (DSA)	Persistent (MySQL)
Interface	CLI	Swing GUI
User Tracking	No	Yes
Scalability	Limited	Real-world scalable
Data Persistence	No	Yes
📈 Future Enhancements

JTable-based GUI display

Overdue book tracking

Analytics (most borrowed books)

Web-based version using Spring Boot

📚 Learning Outcomes

This project demonstrates:

Practical application of Data Structures (ArrayList, HashMap)

Use of OOP pillars: Encapsulation, Abstraction, Polymorphism

JDBC integration with MySQL

Normalized database schema design

Layered system architecture

GUI development using Java Swing

👨‍💻 Author

Akshit Prashar
B.Tech Computer Science Engineering (3rd Year)
Summer Training Project – DSA with Java

📌 Conclusion

The Library Tracker System successfully integrates DSA, OOP, DBMS, and GUI concepts into a cohesive real-world application.
It highlights efficient searching using HashMap, dynamic storage using ArrayList, and scalable persistent storage using MySQL, demonstrating both theoretical and practical understanding of core computer science principles.