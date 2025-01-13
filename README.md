# Library Management System

#### How to Use

1. Clone the repository.
2. Run the `LibraryManagementSystem` main class to see the system in action.
3. Modify and extend the functionality as needed based on this structure.

#### Background

We are tasked with designing and implementing a Library Management System in Java. This system will help librarians manage books, patrons, and lending processes efficiently.

###### Book Management

- Implement a Book class with attributes such as title, author, ISBN, and publication year.
- Create a system to add, remove, and update books in the library inventory.
- Implement a search functionality to find books by title, author, or ISBN.

###### Patron Management

- Design a Patron class to represent library members.
- Implement functionality to add new patrons and update their information.
- Create a system to track patron borrowing history.

###### Lending Process

- Implement book checkout and return functionalities
- Inventory Management
- Keep track of available and borrowed books.

#### Design principles used here

- Single responsibility
- Open closed principle - search strategy
- Dependency Injection
- Interface segregation can be the `extended functionality` by extending SearchStrategy interface

#### Design patterns used here

- Factory design pattern- LibraryFactory which helps to create Book and Patron objects
- Strategy design pattern- Search by different parameters like ISBN, also title and author can be extended functionality
- Singleton pattern can be the `extended functionality` using loggers here.

### **Relationships Table**

Here’s a summary of the relationships in tabular form:

| **Entity** | **Relationship**   | **Target Entity** |
| ---------- | ------------------ | ----------------- |
| Library    | Manages            | Books             |
| Library    | Manages            | Patrons           |
| Library    | Handles            | Lending Process   |
| Book       | Belongs to         | Library           |
| Book       | Can be borrowed by | Patron            |
| Patron     | Belongs to         | Library           |
| Patron     | Borrows            | Books             |
| Library    | Tracks             | Book Availability |
| Library    | Tracks             | Patron Borrowing  |
| Library    | Manages            | Books             |
| Library    | Manages            | Patrons           |

###### Upcoming Features

- Notification service to the patrons regarding book availability for the books that they want to get notified on
- Recommendation service regarding books recommendation on the basis of similar interests
- Multi branch support for handling of multiple branches
