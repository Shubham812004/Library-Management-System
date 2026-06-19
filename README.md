# Library Management System (Java + JDBC + MySQL)

## Overview

A console-based Library Management System developed using Java, JDBC, and MySQL. The application allows librarians to manage books, members, and book issue/return operations through a menu-driven interface.

## Technologies Used

- Java
- JDBC
- MySQL
- Eclipse IDE
- Git & GitHub

## Features

### Book Management
- Add Book
- View All Books
- Search Book by ID
- Search Book by Title
- Search Book by Author
- Delete Book

### Member Management
- Add Member
- View All Members
- Search Member by ID
- Delete Member

### Book Issue Management
- Issue Book
- Return Book
- View Issued Books
- View Books Issued By Member

### Reports
- Count Total Books
- Count Total Members
- Count Total Issued Books

## Database Design

### Books Table

| Column | Data Type |
|----------|----------|
| book_id | INT |
| title | VARCHAR(100) |
| author | VARCHAR(100) |

### Members Table

| Column | Data Type |
|----------|----------|
| member_id | INT |
| member_name | VARCHAR(100) |

### Issued Books Table

| Column | Data Type |
|----------|----------|
| issue_id | INT |
| book_id | INT |
| member_id | INT |

## SQL Concepts Used

- CRUD Operations
- WHERE Clause
- LIKE Operator
- COUNT Aggregate Function
- INNER JOIN
- Foreign Keys
- Relational Database Design

## JDBC Concepts Practiced

- JDBC Driver
- Database Connection
- PreparedStatement
- ResultSet
- executeQuery()
- executeUpdate()
- Exception Handling
- Resource Management

## Project Structure

```text
LibraryManagementSystem
│
├── DBConnection.java
│
├── Book.java
├── BookDAO.java
│
├── Members.java
├── MemberDAO.java
│
├── IssuedBook.java
├── IssuedBookDAO.java
│
└── Main.java
```

## Sample Menu

```text
===== LIBRARY MANAGEMENT SYSTEM =====

1. Add Book
2. View Books
3. Search Book By ID
4. Search Book By Title
5. Search Book By Author
6. Delete Book

7. Add Member
8. View Members
9. Search Member By ID
10. Delete Member

11. Issue Book
12. Return Book
13. View Issued Books
14. View Books Issued By Member

15. Count Books
16. Count Members
17. Count Issued Books

18. Exit
```

## Learning Outcomes

Through this project, I gained practical experience in:

- Object-Oriented Programming (OOP)
- JDBC Connectivity
- MySQL Database Operations
- SQL Joins
- Foreign Key Constraints
- Menu-Driven Application Development
- Multi-Table Database Design
- Git and GitHub Version Control

## Author

**Shubham Shankargouda**

GitHub: https://github.com/Shubham812004