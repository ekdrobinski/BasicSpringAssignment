# Basic Spring Application - Book / Author Records

This is a basic Spring application that simulates a library that contains only books and authors. It provides CRUD (Create, Read, Update, Delete) functionality for managing Books and Authors using Spring MVC and Spring Data JPA.

## Requirements

To successfully run this project, following dependencies are needed:

- Java Development Kit (JDK)
- Spring Web
- Thymeleaf
- Spring Data JPA

## Setup Instructions

1. Clone the repository from GitHub: https://github.com/ekdrobinski/SimpleSpringApplication.git
2. Open the project in an IDE.
3. Build the project using Maven.
4. Configure your database connection in the `application.properties` file.
5. Run the application and open on the local server.

### Data Models

The application includes two data models: Book and Author.

- **Book**: Represents a book with the following properties:
    - id (Long): The unique identifier for the book.
    - title (String): The title of the book.
    - author (Author): The author of the book.

- **Author**: Represents an author with the following properties:
    - id (Long): The unique identifier for the author.
    - name (String): The name of the author.
    - books (List<Book>): The list of books written by the author.

### CRUD Operations

The application provides CRUD operations for managing Books and Authors.

- **Book Operations**:
    - Create: Add a new book to the library system.
    - Read: View book details and information.
    - Update: Modify existing book information.
    - Delete: Remove a book from the library system.

- **Author Operations**:
    - Create: Add a new author to the library system.
    - Read: View author details and information.
    - Update: Modify existing author information.
    - Delete: Remove an author from the library system.

### Views

Thymeleaf templates are used to create the following views for both Books and Authors:

- List: Displays a list of all books/authors.
- Create: Allows users to add a new book/author.
- Update: Enables users to edit existing book/author information.
- Delete: Allows users to delete a book/author.

## Testing

After running the application, open a web browser and access the application at `http://localhost:8080`, where `8080` is the port number specified in your configuration.

Ensure the following functionality works correctly by navigating the page (navigating back to the homepage after completing each step):

1. Create a new author. 
2. Create a new book and select its author. 
3. Proceed to create authors and books in that order.
4. View the list of all books and authors.
5. Navigate using the homepage to edit authors and books.
6. View the list of all books and authors to ensure edits remain. 
7. Delete books and authors from the system.
8. View the list of books / authors to ensure specified books / authors were deleted.



