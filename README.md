User Management System (JDBC + MySQL)

 Project Overview

This project is a **User Management System** developed using **Java (JDBC)** and **MySQL**. It demonstrates how to perform database operations such as **Create, Read, Update, and Delete (CRUD)** using a structured and scalable approach.

The project follows the **DAO (Data Access Object) design pattern** and uses **Connection Pooling (HikariCP)** to improve performance and efficiency.

---

Features

*  Add new users
*  View user details
*  Update user information
*  Delete users
*  Secure queries using PreparedStatement
*  Optimized performance using connection pooling

---

# Technologies Used

* Java (Core Java, JDBC)
* MySQL Database
* HikariCP (Connection Pooling)
* Maven

---

# Project Structure

```
project/
 ├── model/
 │    └── User.java
 ├── dao/
 │    ├── UserDAO.java
 │    └── UserDAOImpl.java
 ├── util/
 │    └── DBConnection.java
 ├── main/
 │    └── MainApp.java
 └── pom.xml
```

---

 Setup Instructions

### 1️⃣ Clone the Repository

```
git clone https://github.com/your-username/user-management-jdbc.git
```

### 2️⃣ Create Database

```sql
CREATE DATABASE userdb;
USE userdb;
```

### 3️⃣ Create Table

```sql
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### 4️⃣ Configure Database

Update your database credentials in:

```
DBConnection.java
```

### 5️⃣ Run the Project

Run the main class:

```
MainApp.java
```

---

## 🔄 CRUD Operations

| Operation | Description         |
| --------- | ------------------- |
| Create    | Insert new user     |
| Read      | Fetch user(s)       |
| Update    | Modify user details |
| Delete    | Remove user         |

---

##  Performance Optimization

* Connection Pooling using HikariCP
* PreparedStatement for faster execution
* Indexing on email column

---

##  Architecture

This project follows a **layered architecture**:

* Presentation Layer → Main class
* DAO Layer → Database logic
* Database Layer → MySQL

---

##  Testing

* Insert user with valid data
* Check duplicate email constraint
* Retrieve user by ID
* Update user details
* Delete user

---

##  Security

* Prevents SQL Injection using PreparedStatement
* Supports input validation (can be extended)

---

##  Future Enhancements

* Web interface (JSP/Servlets)
* Hibernate integration
* Login & authentication system
* Password encryption

---


##  Author

Srivishnu

