package org.example.Lessons18_Hausaufgabe_16.lessons_20_hw16_LibrarryTest;


import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Library {
    private Set<Book> books;
    private List<Author> authors;

    public Library() {
        this.books = new HashSet<>();
        this.authors = new ArrayList<>();
    }

    public Set<Book> getBooks() {
        return books;
    }

    public List<Author> getAuthors() {
        return authors;
    }
    //1.

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }

        books.add(book);

        if (!authors.contains(book.getAuthor())) {
            authors.add(book.getAuthor());
        }
    }

    //2.
    public void removeBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        books.remove(book);
    }

    //3.
    public List<Book> getBooksByAuthor(Author author) {
        if (author == null) {
            throw new IllegalArgumentException("Author cannot be null");
        }
        return books.stream().filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
    }

    //4.
    public List<Author> getAllAuthors() {
        return new ArrayList<>(authors);
    }

    //5.
    public Book findBookByISBN(String isbn) {
        if (isbn == null) {
            throw new IllegalArgumentException("ISBN- серийный номер - не может быть null!");
        }
        return books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst().orElse(null);
    }

    //6.
    public List<Book> searchBooksByTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("title не может быть null !!!");   //toLowerCase нижн регистр// toUpperCase -верхн рег//
        }
        return books.stream().filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase())).collect(Collectors.toList());
    }

    //7.
    public void addCopies(Book book, int additionalCopies) { // int кол-во копий
        if (book == null) {
            throw new IllegalArgumentException("Book can not be null !!! ");
        }
        if (!books.contains(book)) {
            throw new IllegalArgumentException("Book is not in the library");
        }
        System.out.println(book.getCopies());
        book.setCopies(book.getCopies() + additionalCopies);
        System.out.println(book.getCopies() + "After");
    }

    //8.
    public void lendBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book can not be null !!!");
        }
        if (!books.contains(book) || book.getCopies() <= 0) {
            throw new IllegalArgumentException("Book is not available");
        }
        book.setCopies(book.getCopies() - 1);
        // Positive
        // !books.contains(book)
        // book.getCopies() <= 0
        // book == null
    }
    //9.
    public void returnBook(Book book) {
        if (book == null){
            throw new IllegalArgumentException("Book can not be null !!!");
        }
        if (!books.contains(book)) {
            throw new IllegalArgumentException("Book is not from this library");
        }

        book.setCopies(book.getCopies() + 1);
        //Positive
        // if (book == null)
        // if (!books.contains(book))
    }
}