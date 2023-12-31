package org.example.Lessons18_Hausaufgabe_16.lessons_20_hw16_LibrarryTest;

import java.util.Objects;

public class Book {
    private String title;
    private Author author;
    private String isbn;
    private int copies;

    public Book(String title, Author author, String isbn, int copies) {
        if (title == null || author == null || isbn == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.copies = copies;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        if (copies < 0) {
            throw new IllegalArgumentException("Copies cannot be negative");
        }
        this.copies = copies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}