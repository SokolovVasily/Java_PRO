package org.example.Lessons18_Hausaufgabe_16.lessons_20_hw16_LibrarryTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LibraryTest {
    private final Library library = new Library();
    private final Author author = new Author("Vasily", 40);
    private final Book book = createBook();

    private Book createBook() {
        return new Book("Anna Karenina Pro", author, "300523", 1_000);
    }

    //вызываем каждый раз
    @BeforeEach
    void setUp() {
        library.addBook(book);

    }

    //1.
    @Test
    void addBookPositiveAddBookTest() {
        library.addBook(book);
        Assertions.assertEquals(1, library.getBooks().size()); //Equals = ;
        // все методы либо тру или фоллс
    }

    @Test
    void addBookPositiveAddAuthorTest() {
        library.addBook(book);
        Assertions.assertEquals(1, library.getAuthors().size());
    }

    @Test
    void addBookIllegalArgumentExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> library.addBook(null));
    }

    //2.
    @Test
    void removeBookPositiveTest() {
        library.removeBook(book);
        Assertions.assertEquals(0, library.getBooks().size());
    }

    @Test
    void removeBookIllegalArgumentExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> library.removeBook(null));
    }

    //3.
    @Test
    void getBooksByAuthorPositiveTest() {
        Assertions.assertEquals(1, library.getBooksByAuthor(author).size());
    }

    @Test
    void getBooksByAuthorIllegalArgumentExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> library.getBooksByAuthor(null));
    }

    //4.
    @Test
    void getAllAuthorsPositiveTest() {
        Assertions.assertEquals(1, library.getAllAuthors().size());
    }

    /**
     * Этот тест проверяет чтобы список не возвращал null!!
     */
    @Test
    void getAllAuthorsReturnNotNullTest() {
        library.removeBook(book);
        Assertions.assertNotNull(library.getAllAuthors());
    }

    //5.
    @Test
    void findBookByISBNPositiveTest() {
        Assertions.assertEquals(book, library.findBookByISBN("300523"));
    }

    @Test
    void findBookByISBNIllegalArgumentExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> library.findBookByISBN(null));

    }

    //6.
    @Test
    void searchBooksByTitlePositiveTest() {
        Assertions.assertEquals(1, library.searchBooksByTitle("Anna Karenina Pro").size());
    }

    @Test
    void searchBooksByTitleIllegalArgumentExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> library.searchBooksByTitle(null));

    }

    //7.
    @Test
    void addCopiesPositiveTest() {
        library.addCopies(book, 20);
        Assertions.assertEquals(1020, book.getCopies());
    }

    @Test
    void addCopiesIllegalArgumentExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> library.addCopies(null,20));
    }
    @Test
    void addCopiesIllegalArgumentExceptionBooksNotContainBookTest() {
        Book book1 = Mockito.mock(Book.class);
        Assertions.assertThrows(IllegalArgumentException.class,()->library.addCopies(book1,20));
    }
    //8.
    @Test
    public void lendBookPositiveTest() {
        library.lendBook(book);
        Assertions.assertEquals(999,book.getCopies()); //ожидаемое //где проверить,происходит
    }
    @Test
    public void lendBookIllegalArgumentExceptionBooksNotContainBookTest() {
        Book book1 = Mockito.mock(Book.class);
        Assertions.assertThrows(IllegalArgumentException.class,()-> library.lendBook(book1));
    }
    @Test
    public void lendBookIllegalArgumentExceptionNotAvailableCopiesTest() {
        book.setCopies(0);
        Assertions.assertThrows(IllegalArgumentException.class,()-> library.lendBook(book));
    }
    @Test
    public void lendBookIllegalArgumentExceptionBookIsNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class,() -> library.lendBook(null));
    }

    //9.
    @Test
    public void returnBookPositiveTest() {
        library.returnBook(book);
      Assertions.assertEquals(1001,book.getCopies());
    }
    @Test
    public void returnBookIsNullExceptionTest(){
        Assertions.assertThrows(IllegalArgumentException.class,()->library.returnBook(null));
    }
    @Test
    public void returnBookIllegalArgumentExceptionBookIsNotContainTest(){
        Book book1 = Mockito.mock(Book.class);
        Assertions.assertThrows(IllegalArgumentException.class, ()-> library.returnBook(book1));
    }
}
