import java.util.ArrayList;

class Book {
    String title;
    String author;
    String isbn;

    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    void displayBook() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("----------------------");
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    Book searchByTitle(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is empty");
        } else {
            for (Book b : books) {
                b.displayBook();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Library library = new Library();

        Book b1 = new Book("Java Basics", "James Gosling", "ISBN001");
        Book b2 = new Book("Python Guide", "Guido van Rossum", "ISBN002");

        library.addBook(b1);
        library.addBook(b2);

        System.out.println("\nAll Books in Library:");
        library.displayAllBooks();

        System.out.println("\nSearching for a book by title:");
        Book result = library.searchByTitle("Java Basics");

        if (result != null) {
            System.out.println("Book found:");
            result.displayBook();
        } else {
            System.out.println("Book not found");
        }
    }
}
