package org.example.HW_11_10_23LibraryManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LibraryManager {

    private List<Book> libraryCatalog;
    private List<LibraryUser> libraryUsers;

    public LibraryManager(List<Book> libraryCatalog, List<LibraryUser> libraryUsers) {
        this.libraryCatalog = libraryCatalog;
        this.libraryUsers = libraryUsers;
    }

    public List<LibraryUser> getLibraryUsers() {
        return libraryUsers;
    }

    public List<Book> getLibraryCatalog() {
        return libraryCatalog;
    }

    //1. Метод,который возвращает список доступных книг заданного жанра.
    public List<Book> listAvailableBooksByGenre(String genre) { //available books - доступные книги
        List<Book> list = libraryCatalog.stream()
                .filter(el -> el.getBookGenre().contains(genre))
                .filter(Book::isBookAvailable)
                .toList();
        return list;
    }

    //2. Метод,который возвращает множество адресов электронной почты пользователей, зарезервировавших книги.
    public Set<String> listUserEmailsWithReservedBooks() {
        Set<String> collect = libraryUsers.stream()
                .filter(el -> el.getUserBooksReserved() != null && !el.getUserBooksReserved().isEmpty())
                .map(LibraryUser::getUserEmail)
                .collect(Collectors.toSet());
        return collect;
    }

    //3.Метод, который добавляет новую книгу в библиотеку.
    public void addBookToLibrary(Book book) {
        List<Book> list1 = new ArrayList<>(libraryCatalog);
        list1.add(book);
        libraryCatalog = list1;
    }

    //4.: Метод, который удаляет книгу из библиотеки.
    public void removeBookFromLibrary(Book book) {
        List<Book> list1 = new ArrayList<>(libraryCatalog);
        list1.remove(book);
        libraryCatalog = list1;
    }

    //5.: Метод, который позволяет пользователю взять книгу в аренду.
    public void borrowBook(LibraryUser user, Book book) {
        for (Book book1 : libraryCatalog) {
            if (book1.equals(book)) {
                if (book.isBookAvailable()) {
                    for (LibraryUser user1 : libraryUsers) {
                        if (user1.equals(user)) {
                            List<Book> list1;
                            if (user1.getUserBooksBorrowed() == null) {
                                list1 = List.of(book);
                            } else {
                                list1 = user1.getUserBooksBorrowed();
                                list1.add(book);
                            }
                            user1.setUserBooksBorrowed(list1);
                            book.setBookAvailable(false);
                        }
                    }
                }
            }
        }
    }
    //6.: Метод, который позволяет пользователю зарезервировать книгу.
    public void reserveBook(LibraryUser user, Book book){
        for (Book book1 : libraryCatalog) {
            if (book1.equals(book)) {
                if (book.isBookAvailable()) {
                    for (LibraryUser user1 : libraryUsers) {
                        if (user1.equals(user)) {
                            List<Book> list1;
                            if (user1.getUserBooksReserved() == null) {
                                list1 = List.of(book);
                            } else {
                                list1 = user1.getUserBooksReserved();
                                list1.add(book);
                            }
                            user1.setUserBooksReserved(list1);
                            book.setBookAvailable(false);
                        }
                    }
                }
            }
        }

    }
}

